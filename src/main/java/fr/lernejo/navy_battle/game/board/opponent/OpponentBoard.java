package fr.lernejo.navy_battle.game.board.opponent;

import fr.lernejo.navy_battle.game.board.CellCoordinates;

public class OpponentBoard {

    public enum Cell {
        UNKNOWN,
        EMPTY,
        HIT,
        SUNK
    }

    private final Cell[][] grid;

    public OpponentBoard() {
        this.grid = new Cell[CellCoordinates.HORIZONTAL_SIZE][CellCoordinates.VERTICAL_SIZE];
        for (int x = 0; x < CellCoordinates.HORIZONTAL_SIZE; x++) {
            for (int y = 0; y < CellCoordinates.VERTICAL_SIZE; y++) {
                this.grid[x][y] = Cell.UNKNOWN;
            }
        }
    }

    public Cell getCell(final CellCoordinates coordinates) {
        return grid[coordinates.getX()][coordinates.getY()];
    }

    public void setCell(final CellCoordinates coordinates, final Cell cell) {
        grid[coordinates.getX()][coordinates.getY()] = cell;
    }
}