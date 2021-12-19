package fr.lernejo.navy_battle.game.board;

public class CellCoordinates {

    private final int x;
    private final int y;

    public CellCoordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(final Object other) {
        if (other instanceof CellCoordinates otherCoordinates) {
            return (this.x == otherCoordinates.x) && (this.y == otherCoordinates.y);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return x + y;
    }

    @Override
    public String toString() {
        return "CellCoordinates<" + this.x + ", " + this.y + ">";
    }
}
