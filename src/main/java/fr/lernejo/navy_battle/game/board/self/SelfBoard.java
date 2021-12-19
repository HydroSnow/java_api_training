package fr.lernejo.navy_battle.game.board.self;

import fr.lernejo.navy_battle.game.board.CellCoordinates;

import java.util.ArrayList;
import java.util.List;

public class SelfBoard {

    private final List<Boat> boats;
    private final BoatPart[][] grid;

    public SelfBoard() {
        this.boats = new ArrayList<>();
        this.grid = new BoatPart[CellCoordinates.HORIZONTAL_SIZE][CellCoordinates.VERTICAL_SIZE];
        for (int x = 0; x < CellCoordinates.HORIZONTAL_SIZE; x++) {
            for (int y = 0; y < CellCoordinates.VERTICAL_SIZE; y++) {
                this.grid[x][y] = null;
            }
        }
    }

    public enum Direction {
        HORIZONTAL,
        VERTICAL
    }

    public boolean canPlaceBoat(final CellCoordinates coordinates, final Direction direction, final Boat boat) {
        if (direction == Direction.HORIZONTAL) {
            // board limit overlap check
            if (coordinates.getX() + boat.getLength() > CellCoordinates.HORIZONTAL_SIZE) {
                return false;
            }

            // boat overlap check
            final int y = coordinates.getY();
            for (int x = coordinates.getX(); x < coordinates.getX() + boat.getLength(); x++) {
                if (this.grid[x][y] != null) {
                    return false;
                }
            }

            return true;

        } else if (direction == Direction.VERTICAL) {
            // board limit overlap check
            if (coordinates.getY() + boat.getLength() > CellCoordinates.VERTICAL_SIZE) {
                return false;
            }

            // boat overlap check
            final int x = coordinates.getX();
            for (int y = coordinates.getY(); y < coordinates.getY() + boat.getLength(); y++) {
                if (this.grid[x][y] != null) {
                    return false;
                }
            }

            return true;

        } else {
            throw new IllegalArgumentException("Direction is neither horizontal nor vertical");
        }
    }

    public void addBoat(final CellCoordinates coordinates, final Direction direction, final Boat boat) {
        if (!canPlaceBoat(coordinates, direction, boat)) {
            throw new IllegalArgumentException("Cannot place boat here");
        }

        if (direction == Direction.HORIZONTAL) {
            // add boat to list
            this.boats.add(boat);

            // add boat to grid
            final BoatPart[] parts = boat.getParts();
            final int y = coordinates.getY();
            int partIndex = 0;
            for (int x = coordinates.getX(); x < coordinates.getX() + boat.getLength(); x++) {
                this.grid[x][y] = parts[partIndex++];
            }

        } else if (direction == Direction.VERTICAL) {
            // add boat to list
            this.boats.add(boat);

            // add boat to grid
            final BoatPart[] parts = boat.getParts();
            final int x = coordinates.getX();
            int partIndex = 0;
            for (int y = coordinates.getY(); y < coordinates.getY() + boat.getLength(); y++) {
                this.grid[x][y] = parts[partIndex++];
            }

        } else {
            throw new IllegalArgumentException("Direction is neither horizontal nor vertical");
        }
    }

    public enum Fire {
        MISS,
        HIT,
        SUNK
    }

    public Fire fire(final CellCoordinates coordinates) {
        final BoatPart part = this.grid[coordinates.getX()][coordinates.getY()];
        if (part != null) {
            part.fire();
            if (part.getBoat().isValid()) {
                return Fire.HIT;
            } else {
                return Fire.SUNK;
            }
        } else {
            return Fire.MISS;
        }
    }

    public boolean isValid() {
        for (final Boat boat : this.boats) {
            if (boat.isValid()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Self board:\n");

        str.append("/");
        str.append("-".repeat(CellCoordinates.VERTICAL_SIZE));
        str.append("\\\n");

        for (int y = 0; y < CellCoordinates.VERTICAL_SIZE; y++) {
            str.append("|");
            for (int x = 0; x < CellCoordinates.HORIZONTAL_SIZE; x++) {
                if (this.grid[x][y] == null) {
                    str.append(" ");
                } else if (this.grid[x][y].isValid()) {
                    str.append("#");
                } else {
                    str.append("=");
                }
            }
            str.append("|\n");
        }

        str.append("\\");
        str.append("-".repeat(CellCoordinates.VERTICAL_SIZE));
        str.append("/");

        return str.toString();
    }
}
