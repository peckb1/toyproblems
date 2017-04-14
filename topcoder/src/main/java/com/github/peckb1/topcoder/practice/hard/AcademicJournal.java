package com.github.peckb1.topcoder.practice.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * In any field of research, there are many journals to which one can submit an article for publication.
 * <p>
 * One criterion that is commonly used to choose between journals is the impact factor, a measure of the
 * importance of a journal and the papers that are published there.
 * <p>
 * The impact factor of a journal is defined as the average number of citations each paper in that journal
 * receives from papers in other journals.
 * <p>
 * Citations from papers in the same journal are not counted in order to prevent its editors from inflating
 * their impact factor by preferentially accepting papers that cite other papers in their journal.
 * <p>
 * Although impact factors are not a fair way to judge the quality of research, they do provide a quantitative
 * method for comparing journals to each other.
 * <p>
 * Write a class AcademicJournal with a method rankByImpact that takes a papers, a collection of published papers from
 * which to calculate impact factors, and returns a with the journal names sorted in decreasing order by impact factor.
 * <p>
 * Each element of papers contains the information for a single paper, and is formatted with the name of the paper's
 * journal (consisting of only uppercase English characters and spaces), followed by a period, followed by zero or more
 * integers specifying the zero-based indices of the papers it cites.
 * <p>
 * The citation indices contain no extra leading zeroes, and are separated from each other and from the period
 * character by single spaces.
 * <p>
 * If there is a tie in the impact factors, the journal with more papers comes first in the return value.
 * <p>
 * If there is still a tie, the journal with the lexicographically earlier name comes first.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AcademicJournal {

    public String[] rankByImpact(String[] encodedPapers) {
        List<Paper> papers = Arrays.stream(encodedPapers)
                .map(this::toPaper)
                .collect(Collectors.toList());

        Map<Journal, JournalData> journalDataMap = new LinkedHashMap<>();
        papers.forEach(paper -> {
            Journal journal = paper.journal;

            JournalData journalData = journalDataMap.computeIfAbsent(journal, journalKey -> new JournalData());

            List<Citation> newCitations = Arrays.stream(paper.papersWeCite)
                    .map(index -> new Citation(journal, papers.get(index).journal))
                    .filter(Citation::notSelfCitation)
                    .distinct()
                    .collect(Collectors.toList());

            journalData.addMagazine();
            journalData.addCitations(newCitations);
        });

        journalDataMap.forEach((journal, journalData) -> journalData.getCitations().forEach(citation -> {
            JournalData data = journalDataMap.get(citation.toJournal);
            data.addCitation();
        }));

        List<String> sortedJournals = journalDataMap.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    JournalData jd1 = e1.getValue();
                    JournalData jd2 = e2.getValue();
                    Integer factor1 = jd1.getInwardCitationCount() / jd1.getMagazineCount();
                    Integer factor2 = jd2.getInwardCitationCount() / jd2.getMagazineCount();
                    int compareTo = factor2.compareTo(factor1);

                    if (compareTo == 0) {
                        return e1.getKey().journal.compareTo(e2.getKey().journal);
                    } else {
                        return compareTo;
                    }
                })
                .map(Entry::getKey)
                .map(j -> j.journal)
                .collect(Collectors.toList());

        return sortedJournals.toArray(new String[sortedJournals.size()]);
    }

    private Paper toPaper(String encodedPaper) {
        String[] paperSplit = encodedPaper.split("\\.");
        String journal = paperSplit[0];
        String[] papersWeCite;

        if (paperSplit.length == 2) {
            String citationList = paperSplit[1].trim();
            papersWeCite = citationList.split(" ");
        } else {
            papersWeCite = new String[0];
        }

        return new Paper(journal, papersWeCite);
    }

    private class Paper {
        private final Journal journal;
        private final Integer[] papersWeCite;

        private Paper(String journal, String[] papersWeCite) {
            this.journal = new Journal(journal);
            this.papersWeCite = Arrays.stream(papersWeCite)
                    .map(indexString -> Integer.parseInt(indexString.trim()))
                    .collect(Collectors.toList())
                    .toArray(new Integer[papersWeCite.length]);
        }

        @Override
        public String toString() {
            return String.format("{%s -> %s}", this.journal, Arrays.toString(this.papersWeCite));
        }
    }

    private class Journal {
        private final String journal;

        private Journal(String journal) {
            this.journal = journal;
        }

        @Override
        public String toString() {
            return journal;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Journal journal1 = (Journal) o;

            return journal != null ? journal.equals(journal1.journal) : journal1.journal == null;
        }

        @Override
        public int hashCode() {
            return journal != null ? journal.hashCode() : 0;
        }
    }

    private class Citation {
        private final Journal fromJournal;
        private final Journal toJournal;

        private Citation(Journal fromJournal, Journal toJournal) {
            this.fromJournal = fromJournal;
            this.toJournal = toJournal;
        }

        @Override
        public String toString() {
            return String.format("(%s --> %s)", fromJournal, toJournal);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Citation citation = (Citation) o;

            return (fromJournal != null ? fromJournal.equals(citation.fromJournal) : citation.fromJournal == null) && (toJournal != null ? toJournal.equals(citation.toJournal) : citation.toJournal == null);
        }

        @Override
        public int hashCode() {
            int result = fromJournal != null ? fromJournal.hashCode() : 0;
            result = 31 * result + (toJournal != null ? toJournal.hashCode() : 0);
            return result;
        }

        private boolean notSelfCitation() {
            return !fromJournal.equals(toJournal);
        }
    }

    private class JournalData {
        private final List<Citation> outwardCitations = new ArrayList<>();
        private int magazineCount = 0;
        private int inwardCitationCount = 0;

        @Override
        public String toString() {
            return String.format(" %s/%s -> %s", inwardCitationCount, magazineCount, outwardCitations);
        }

        private void addMagazine() {
            magazineCount++;
        }

        private void addCitations(List<Citation> newCitations) {
            outwardCitations.addAll(newCitations);
        }

        private void addCitation() {
            this.inwardCitationCount++;
        }

        private int getMagazineCount() {
            return magazineCount;
        }

        private List<Citation> getCitations() {
            return outwardCitations;
        }

        private int getInwardCitationCount() {
            return inwardCitationCount;
        }
    }
}
