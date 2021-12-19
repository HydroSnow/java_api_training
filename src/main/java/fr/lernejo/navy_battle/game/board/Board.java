package fr.lernejo.navy_battle.game.board;

public class Board {

    public static final int HORIZONTAL_SIZE = 10;
    public static final int VERTICAL_SIZE = 10;

    private final CellStatus[][] board;

    public Board(final CellStatus defaultStatus) {
        this.board = new CellStatus[HORIZONTAL_SIZE][VERTICAL_SIZE];
        for (int x = 0; x < HORIZONTAL_SIZE; x++) {
            for (int y = 0; y < VERTICAL_SIZE; y++) {
                this.board[x][y] = defaultStatus;
            }
        }
    }

    public CellStatus getCellStatus(final CellCoordinates coordinates) {
        return this.board[coordinates.getX()][coordinates.getY()];
    }

    public void setCellStatus(final CellCoordinates coordinates, final CellStatus status) {
        this.board[coordinates.getX()][coordinates.getY()] = status;
    }
}
