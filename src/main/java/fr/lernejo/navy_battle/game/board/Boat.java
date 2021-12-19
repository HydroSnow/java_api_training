package fr.lernejo.navy_battle.game.board;

import java.util.Arrays;

public class Boat {

    private final int length;
    private final BoatPart[] parts;

    public Boat(final int length) {
        // boat status
        if (length < 2) {
            throw new IllegalArgumentException("Boat is too short");
        }
        if (length > 5) {
            throw new IllegalArgumentException("Boat is too long");
        }
        this.length = length;
        this.parts = new BoatPart[this.length];
        for (int a = 0; a < this.parts.length; a++) {
            this.parts[a] = new BoatPart(this);
        }
    }

    public int getLength() {
        return this.length;
    }

    public BoatPart[] getParts() {
        // copy array
        return Arrays.stream(this.parts).toArray(BoatPart[]::new);
    }

    public boolean isValid() {
        for (final BoatPart part : this.parts) {
            if (part.isValid()) {
                return true;
            }
        }
        return false;
    }
}
