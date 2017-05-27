package com.github.peckb1.projecteuler.p011to020;

import java.math.BigInteger;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

/**
 * In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
 * <p>
 * 08 02 22 97 38 15 00 40  00  75  04  05  07 78 52 12 50 77 91 08
 * 49 49 99 40 17 81 18 57  60  87  17  40  98 43 69 48 04 56 62 00
 * 81 49 31 73 55 79 14 29  93  71  40  67  53 88 30 03 49 13 36 65
 * 52 70 95 23 04 60 11 42  69  24  68  56  01 32 56 71 37 02 36 91
 * 22 31 16 71 51 67 63 89  41  92  36  54  22 40 40 28 66 33 13 80
 * 24 47 32 60 99 03 45 02  44  75  33  53  78 36 84 20 35 17 12 50
 * 32 98 81 28 64 23 67 10 (26) 38  40  67  59 54 70 66 18 38 64 70
 * 67 26 20 68 02 62 12 20  95 (63) 94  39  63 08 40 91 66 49 94 21
 * 24 55 58 05 66 73 99 26  97  17 (78) 78  96 83 14 88 34 89 63 72
 * 21 36 23 09 75 00 76 44  20  45  35 (14) 00 61 33 97 34 31 33 95
 * 78 17 53 28 22 75 31 67  15  94  03  80  04 62 16 14 09 53 56 92
 * 16 39 05 42 96 35 31 47  55  58  88  24  00 17 54 24 36 29 85 57
 * 86 56 00 48 35 71 89 07  05  44  44  37  44 60 21 58 51 54 17 58
 * 19 80 81 68 05 94 47 69  28  73  92  13  86 52 17 77 04 89 55 40
 * 04 52 08 83 97 35 99 16  07  97  57  32  16 26 26 79 33 27 98 66
 * 88 36 68 87 57 62 20 72  03  46  33  67  46 55 12 32 63 93 53 69
 * 04 42 16 73 38 25 39 11  24  94  72  18  08 46 29 32 40 62 76 36
 * 20 69 36 41 72 30 23 88  34  62  99  69  82 67 59 85 74 04 36 16
 * 20 73 35 29 78 31 90 01  74  31  49  71  48 86 81 16 23 57 05 54
 * 01 70 54 71 83 51 54 69  16  92  33  48  61 43 52 01 89 19 67 48
 * <p>
 * The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
 * <p>
 * What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
 */
public class Problem11 {

    public BigInteger directionalProduct(int[][] grid, int adjacencyValue) {
        final Map<Cell, Products> productsMap = new HashMap<>();
        BigInteger max = ZERO;

        productsMap.clear();
        int N = grid.length;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                Cell cell = new Cell(col, row);
                Products products = productsMap.computeIfAbsent(cell, k -> new Products());

                for (Direction direction : EnumSet.allOf(Direction.class)) {
                    Optional<Cell> endCellOptional = findEndCell(grid, cell, adjacencyValue, direction);
                    if (endCellOptional.isPresent()) {
                        Cell endCell = endCellOptional.get();

                        BigInteger product = calculateProduct(productsMap, grid, cell, endCell, direction);
                        products.setProduct(direction, product);

                        max = max.max(product);
                    }
                }
            }
        }

        return max;
    }

    private static BigInteger calculateProduct(Map<Cell, Products> productsMap, int[][] grid, Cell startCell, Cell endCell, Direction direction) {
        Direction reverseDirection = reverse(direction);
        Optional<BigInteger> calculatedProduct = ofNullable(productsMap.get(endCell))
                .flatMap(products -> products.getProduct(reverseDirection));

        if (calculatedProduct.isPresent()) {
            return calculatedProduct.get();
        }

        BigInteger product = valueOf(grid[startCell.row][startCell.col]);

        int c1 = startCell.col;
        int r1 = startCell.row;
        int c2 = endCell.col;
        int r2 = endCell.row;

        while (c1 != c2 || r1 != r2) {
            if (c1 < c2) {
                c1++;
            }
            if (c2 < c1) {
                c1--;
            }
            if (r1 < r2) {
                r1++;
            }
            if (r2 < r1) {
                r1--;
            }
            product = product.multiply(valueOf(grid[r1][c1]));
        }

        return product;
    }

    private static Direction reverse(Direction direction) {
        switch (direction) {
            case UL:
                return Direction.LR;
            case UC:
                return Direction.LC;
            case UR:
                return Direction.LL;
            case CL:
                return Direction.CR;
            case CR:
                return Direction.CL;
            case LL:
                return Direction.UR;
            case LC:
                return Direction.UC;
            case LR:
                return Direction.UL;
            default:
                throw new IllegalStateException();
        }
    }

    private static Optional<Cell> findEndCell(int[][] grid, Cell cell, int adjacencyValue, Direction direction) {
        final int indexDifference = adjacencyValue - 1;
        final int endCol;
        final int endRow;

        switch (direction) {
            case UL:
                endCol = cell.col - indexDifference;
                endRow = cell.row - indexDifference;
                break;
            case UC:
                endCol = cell.col;
                endRow = cell.row - indexDifference;
                break;
            case UR:
                endCol = cell.col + indexDifference;
                endRow = cell.row - indexDifference;
                break;
            case CL:
                endCol = cell.col - indexDifference;
                endRow = cell.row;
                break;
            case CR:
                endCol = cell.col + indexDifference;
                endRow = cell.row;
                break;
            case LL:
                endCol = cell.col - indexDifference;
                endRow = cell.row + indexDifference;
                break;
            case LC:
                endCol = cell.col;
                endRow = cell.row + indexDifference;
                break;
            case LR:
                endCol = cell.col + indexDifference;
                endRow = cell.row + indexDifference;
                break;
            default:
                throw new IllegalStateException();
        }

        if (0 <= endCol && endCol < grid.length) {
            if (0 <= endRow && endRow < grid.length) {
                return of(new Cell(endCol, endRow));
            }
        }

        return empty();
    }

    private enum Direction {
        UL, UC, UR,
        CL,/**/ CR,
        LL, LC, LR
    }

    private static final class Cell {
        private final int row;
        private final int col;

        private Cell(int col, int row) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Cell cell = (Cell) o;

            return row == cell.row && col == cell.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", col, row);
        }
    }

    private static class Products {
        Map<Direction, BigInteger> productMap;

        private Products() {
            this.productMap = new HashMap<>();
        }

        private void setProduct(Direction direction, BigInteger product) {
            this.productMap.put(direction, product);
        }

        private Optional<BigInteger> getProduct(Direction direction) {
            return ofNullable(productMap.get(direction));
        }
    }
}
