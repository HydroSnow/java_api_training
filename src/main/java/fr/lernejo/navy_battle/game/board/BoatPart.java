package fr.lernejo.navy_battle.game.board;

public class BoatPart {

    private final Boat boat;
    private boolean valid = true;

    public BoatPart(final Boat boat) {
        this.boat = boat;
    }

    public Boat getBoat() {
        return boat;
    }

    public boolean isValid() {
        return valid;
    }

    public void fire() {
        this.valid = false;
    }
}
