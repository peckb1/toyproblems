package com.github.peckb1.topcoder.practice.medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * You are a farmer living in a 2-dimensional world. Your crops look like an infinite line parallel to the x-axis,
 * with the y-coordinate equal to 0. According to the weather forecast, the next rain will be acid, and therefore
 * very harmful to your plants. The rain consists of an infinite number of drops that fall down vertically
 * (parallel to the y-axis). For every x, where x is an arbitrary number (not necessarily an integer),
 * a drop will fall toward the point (x, 0).
 * <p>
 * To protect your crops, you have built some shields above the ground. Each shield is a line segment parallel to
 * the x-axis, with negligible thickness. If a drop of rain falls on a shield, it will flow to the closest end of
 * the shield and continue falling straight down vertically from that point. If a drop falls exactly in the middle
 * of a shield, the drop will divide into two equal parts that flow to opposite ends of the shield and continue
 * falling from there. If two or more shields have common endpoints they will act as one combined shield.
 * See examples for clarification.
 * <p>
 * The locations of your existing shields will be given in the three int[]s b, e and y. The endpoints of the
 * i-th shield are located at (b[i], y[i]) and (e[i], y[i]). Define B as the minimum value in b, and E as the
 * maximum value in e. Your task is to build enough additional shields to protect all the crops between (B, 0)
 * and (E, 0), exclusive (that is, all crops whose x-coordinates lie in the open interval (B, E) ). Each shield
 * must be a line segment parallel to the x-axis with non-zero length and a positive y-coordinate. Each shield
 * you build must have integer endpoints and a positive length. Build these new shields in such a way that the
 * sum of their lengths is minimized. Return the sum of the new shields' lengths.
 */
public class AcidRain {

    private int cropStartLocation;
    private int cropEndLocation;
    private SortedMap<Integer, SortedSet<Cover>> covers;

    public int saveHarvest(int[] b, int[] e, int[] y) {
        cropStartLocation = Integer.MAX_VALUE;
        cropEndLocation = Integer.MIN_VALUE;
        covers = new TreeMap<>();

        SortedSet<Integer> coverHeights = new TreeSet<>();

        for (int i = 0; i < b.length; i++) {
            int beginning = b[i];
            int end = e[i];
            int height = y[i];

            cropStartLocation = Math.min(cropStartLocation, beginning);
            cropEndLocation = Math.max(cropEndLocation, end);

            SortedSet<Cover> coverList = covers.computeIfAbsent(height, k -> new TreeSet<>(new CoverComparator()));
            coverList.add(new Cover(height, beginning, end));
            coverHeights.add(height);
        }

        covers.forEach((height, sortedCovers) -> {
            SortedSet<Cover> merge = mergeShields(sortedCovers);
            covers.put(height, merge);
        });

        Integer[] coverHeightsArray = coverHeights.toArray(new Integer[covers.size()]);

        Map<Double, Map<Integer, ContactDetails>> dropData = new TreeMap<>();

        int adjustmentsMade = 0;

        for (double dropPoint = cropStartLocation + 0.5; dropPoint < cropEndLocation; dropPoint += 0.5) {
            for (int heightIndex = coverHeightsArray.length - 1; heightIndex >= 0; heightIndex--) {
                int height = coverHeightsArray[heightIndex];

                SortedSet<Cover> coversAtHeight = covers.get(height);
                Optional<Cover> coverAtHeight = Optional.empty();
                for (Cover cover : coversAtHeight) {
                    if (cover.startExclusive < dropPoint && dropPoint < cover.endExclusive) {
                        coverAtHeight = Optional.of(cover);
                        break;
                    }
                }

                ContactDetails detailsForHeight = generateContactDetails(dropPoint, coverAtHeight);

                ContactState contactState = detailsForHeight.getA();
                Optional<Double> leftSlide = detailsForHeight.getB();
                Optional<Double> rightSlide = detailsForHeight.getC();

                Map<Integer, ContactDetails> heightContactDetails = dropData.computeIfAbsent(dropPoint, k -> new TreeMap<>(Collections.reverseOrder()));
                heightContactDetails.computeIfAbsent(height, k -> new ContactDetails(contactState, leftSlide, rightSlide));

                if (contactState == ContactState.MISS) {
                    //noinspection StatementWithEmptyBody
                    if (heightIndex == 0) {
                        // we hit the ground - looks like we need a shield?
                        // I wonder if Topcoder hits this path - i would expect it to.
                        // ...
                        // It turns out it does not check this path in any of its examples
                        // all topcoder test cases seem to only require adding on length to an
                        // existing shield, and never actually having to create a new shield
                    } else {
                        // it's ok; just go to the next level down and try again
                    }
                } else {
                    // we hit a shield; let's check if we're slid to safety, or not
                    int lowerHeight = heightIndex - 1;
                    boolean leftSlideSafe = leftSlide
                            .map(newDrop -> checkNewDrop(coverHeightsArray, lowerHeight, newDrop))
                            .orElse(true);
                    boolean rightSlideSafe = rightSlide
                            .map(newDrop -> checkNewDrop(coverHeightsArray, lowerHeight, newDrop))
                            .orElse(true);

                    if (leftSlideSafe && rightSlideSafe) {
                        // yay
                        // we're good for this number now
                        heightIndex = 0;
                    } else {
                        // one, or both of our sides was bad
                        // let's right now just consider a single side being bad
                        // ...
                        // it also seems that topcoder examples also do not give any
                        // test cases where the
                        adjustmentsMade++;
                        if (leftSlideSafe) {
                            coverAtHeight.ifPresent(Cover::stretchEnd);
                        } else {
                            coverAtHeight.ifPresent(Cover::stretchStart);
                        }

                        // and reset this number
                        heightIndex = 0;
                        dropPoint -= 0.5;
                    }
                }
            }
        }

        return adjustmentsMade;
    }

    private boolean checkNewDrop(Integer[] coverHeightsArray, int startIndex, Double dropPoint) {
        if (dropPoint == cropStartLocation || dropPoint == cropEndLocation) {
            return true;
        }

        for (int heightIndex = startIndex; heightIndex >= 0; heightIndex--) {
            int height = coverHeightsArray[heightIndex];

            SortedSet<Cover> coversAtHeight = covers.get(height);
            Optional<Cover> coverAtHeight = Optional.empty();
            for (Cover cover : coversAtHeight) {
                if (cover.startExclusive < dropPoint && dropPoint < cover.endExclusive) {
                    coverAtHeight = Optional.of(cover);
                    break;
                }
            }

            ContactDetails detailsForHeight = generateContactDetails(dropPoint, coverAtHeight);
            ContactState contactState = detailsForHeight.getA();
            Optional<Double> leftSlide = detailsForHeight.getB();
            Optional<Double> rightSlide = detailsForHeight.getC();

            if (contactState == ContactState.HIT) {
                int lowerHeight = heightIndex - 1;
                boolean leftSlideSafe = leftSlide
                        .map(newDrop -> checkNewDrop(coverHeightsArray, lowerHeight, newDrop))
                        .orElse(true);
                boolean rightSlideSafe = rightSlide
                        .map(newDrop -> checkNewDrop(coverHeightsArray, lowerHeight, newDrop))
                        .orElse(true);

                return leftSlideSafe && rightSlideSafe;
            }
        }

        return false;
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private ContactDetails generateContactDetails(Double dropPoint, Optional<Cover> coverAtHeight) {
        final ContactState contactState;
        final Optional<Double> leftSlide;
        final Optional<Double> rightSlide;

        if (coverAtHeight.isPresent()) {
            contactState = ContactState.HIT;
            Cover cover = coverAtHeight.get();
            if (dropPoint < cover.middle) {
                leftSlide = Optional.of((double) cover.startExclusive);
                rightSlide = Optional.empty();

            } else if (dropPoint > cover.middle) {
                leftSlide = Optional.empty();
                rightSlide = Optional.of((double) cover.endExclusive);

            } else {
                leftSlide = Optional.of((double) cover.startExclusive);
                rightSlide = Optional.of((double) cover.endExclusive);
            }
        } else {
            contactState = ContactState.MISS;
            rightSlide = Optional.empty();
            leftSlide = Optional.empty();
        }

        return new ContactDetails(contactState, leftSlide, rightSlide);
    }

    private SortedSet<Cover> mergeShields(SortedSet<Cover> covers) {
        Cover[] coversArray = covers.toArray(new Cover[covers.size()]);
        SortedSet<Cover> results = new TreeSet<>(new CoverComparator());

        for (int i = 0; i < covers.size(); i++) {
            Cover aCover = coversArray[i];
            for (int j = i + 1; j < covers.size(); j++) {
                Cover bCover = coversArray[j];
                if (aCover.endExclusive.equals(bCover.startExclusive)) {
                    aCover = new Cover(aCover.height, aCover.startExclusive, bCover.endExclusive);
                }
                i++;
            }
            results.add(aCover);
        }

        return results;
    }

    private enum ContactState {
        HIT, MISS
    }

    private static class Tuple<A, B, C> {
        private final A a;
        private final B b;
        private final C c;

        private Tuple(A a, B b, C c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public A getA() {
            return a;
        }

        public B getB() {
            return b;
        }

        public C getC() {
            return c;
        }
    }

    private class ContactDetails extends Tuple<ContactState, Optional<Double>, Optional<Double>> {
        @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
        private ContactDetails(ContactState contactState, Optional<Double> leftSlide, Optional<Double> rightSlide) {
            super(contactState, leftSlide, rightSlide);
        }
    }

    private class Cover {
        private final Integer height;

        private Integer startExclusive;
        private Integer endExclusive;
        private Double middle;

        private Cover(Integer height, Integer startExclusive, Integer endExclusive) {
            this.height = height;
            this.startExclusive = startExclusive;
            this.endExclusive = endExclusive;
            this.middle = ((double) (endExclusive + startExclusive)) / 2.0;
        }

        private void stretchStart() {
            this.startExclusive--;
            this.middle = ((double) (endExclusive + startExclusive)) / 2.0;
        }

        private void stretchEnd() {
            this.endExclusive++;
            this.middle = ((double) (endExclusive + startExclusive)) / 2.0;
        }
    }

    private class CoverComparator implements Comparator<Cover> {

        @Override
        public int compare(Cover c1, Cover c2) {
            int heightComparison = c1.height.compareTo(c2.height);
            if (heightComparison == 0) {
                int startComparison = c1.startExclusive.compareTo(c2.startExclusive);
                if (startComparison == 0) {
                    return c1.endExclusive.compareTo(c2.endExclusive);
                } else {
                    return startComparison;
                }
            } else {
                return heightComparison;
            }
        }
    }

}
