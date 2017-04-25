package com.github.peckb1.topcoder.practice.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ActivateGame is played on a rectangular grid with N rows and M columns. The rows are numbered 0 to N-1 from
 * top to bottom, and the columns are numbered 0 to M-1 from left to right. A number is assigned to each cell.
 * <p>
 * The game is played as follows. Initially, only the top-left cell (row 0, column 0) is activated, and your score
 * is zero. Then, on each turn, you choose one activated cell and one non-activated cell which is vertically or
 * horizontally adjacent to that cell. The absolute difference between the numbers assigned to those two cells is
 * added to your score, and the non-activated cell becomes activated. This is repeated until all the
 * cells have been activated.
 * <p>
 * You are given a grid. The j-th character of the i-th element of grid represents the number assigned to the
 * cell at row i, column j. Characters are mapped to numbers as follows:
 * <p>
 * '0' - '9' corresponds to 0 - 9
 * 'a' - 'z' corresponds to 10 - 35
 * 'A' - 'Z' corresponds to 36 - 61
 * <p>
 * Return the maximum possible score you can achieve.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class ActivateGame {

    public int findMaxScore(String[] grid) {
        int numColumns = grid.length;
        int numRows = grid[0].length();

        Game game = new Game(numColumns, numRows);

        for (int column = 0; column < numColumns; column++) {
            for (int row = 0; row < numRows; row++) {

                char cellValue = grid[column].charAt(row);
                if (48 <= cellValue && cellValue <= 57) {
                    // [0-9]
                    game.setCell(column, row, cellValue - 48);
                } else if (97 <= cellValue && cellValue <= 122) {
                    // [a-z]
                    game.setCell(column, row, cellValue - 97 + 10);
                } else {
                    // [A-Z]
                    game.setCell(column, row, cellValue - 65 + 36);
                }
            }
        }

        Map<Cell, List<Cell>> activeCellMap = new HashMap<>();

        // set our state to base
        int value = 0;
        int currentColumn = 0;
        int currentRow = 0;
        Cell first = game.rows.get(currentRow).cells.get(currentColumn);
        first.activate();
        activeCellMap.put(first, getNeighbors(game, numRows, numColumns, currentRow, currentColumn));

        int currentActiveCells = 1;
        while (currentActiveCells < numColumns * numRows) {

            Cell bestCell = null;
            int bestDelta = -1;
            for (Entry<Cell, List<Cell>> entry : activeCellMap.entrySet()) {
                Cell cell = entry.getKey();
                List<Cell> neighbors = entry.getValue();

                if (!neighbors.isEmpty()) {
                    Cell bestNeighbor = neighbors.get(0);
                    int delta = Math.abs(bestNeighbor.value - cell.value);
                    if (!bestNeighbor.isActive() && delta >= bestDelta) {
                        bestDelta = delta;
                        bestCell = cell;
                    }
                }
            }

            if (bestCell != null) {
                List<Cell> bestCellNeighbors = activeCellMap.get(bestCell);
                Cell nextCell = bestCellNeighbors.get(0);
                bestCellNeighbors.remove(0);
                nextCell.activate();
                activeCellMap.put(nextCell, getNeighbors(game, numRows, numColumns, nextCell.getRow(), nextCell.getColumn()));
                currentActiveCells++;

                value += bestDelta;

            } else {
                currentActiveCells = numColumns * numRows;
            }
        }

        return value;
    }

    private List<Cell> getNeighbors(Game game, int numRows, int numColumns, int currentRow, int currentColumn) {
        List<Cell> cells = new ArrayList<>();

        // left
        if (0 <= currentColumn - 1) {
            Cell cell = game.rows.get(currentRow).cells.get(currentColumn - 1);
            if (!cell.isActive()) {
                cells.add(cell);
            }
        }

        // right
        if (currentColumn + 1 < numColumns) {
            Cell cell = game.rows.get(currentRow).cells.get(currentColumn + 1);
            if (!cell.isActive()) {
                cells.add(cell);
            }
        }

        // top
        if (0 <= currentRow - 1) {
            Cell cell = game.rows.get(currentRow - 1).cells.get(currentColumn);
            if (!cell.isActive()) {
                cells.add(cell);
            }
        }

        // bottom
        if (currentRow + 1 < numRows) {
            Cell cell = game.rows.get(currentRow + 1).cells.get(currentColumn);
            if (!cell.isActive()) {
                cells.add(cell);
            }
        }

        Cell me = game.rows.get(currentRow).cells.get(currentColumn);

        cells.sort(((cell01, cell02) -> {
            Integer delta1 = Math.abs(cell01.value - me.value);
            Integer delta2 = Math.abs(cell02.value - me.value);
            return delta2.compareTo(delta1);
        }));

        return cells;
    }

    private enum CellState {
        ACTIVATED, UNACTIVATED
    }

    private class Game {

        private final List<Row> rows;

        private Game(int numColumns, int numRows) {
            rows = new ArrayList<>(numRows);
            for (int r = 0; r < numRows; r++) {
                rows.add(r, new Row(numColumns));
            }
        }

        @Override
        public String toString() {
            return rows.toString();
        }

        private void setCell(int column, int row, int c) {
            rows.get(row).cells.add(column, new Cell(c, row, column));
        }
    }

    private class Row {
        private final List<Cell> cells;

        private Row(int numColumns) {
            cells = new ArrayList<>(numColumns);
        }

        @Override
        public String toString() {
            return cells.toString();
        }
    }

    private class Cell {

        private final int value;
        private final int row;
        private final int column;

        private CellState state;

        private Cell(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
            this.state = CellState.UNACTIVATED;
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", value, state);
        }

        private void activate() {
            this.state = CellState.ACTIVATED;
        }

        private boolean isActive() {
            return state == CellState.ACTIVATED;
        }

        private int getRow() {
            return row;
        }

        private int getColumn() {
            return column;
        }
    }
}
