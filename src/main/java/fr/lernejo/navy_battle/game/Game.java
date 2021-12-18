package fr.lernejo.navy_battle.game;

public class Game {

    private final String selfId;
    private final String opponentId;
    private final String opponentUrl;

    public Game(final String selfId, final String opponentId, final String opponentUrl) {
        this.selfId = selfId;
        this.opponentId = opponentId;
        this.opponentUrl = opponentUrl;
    }

    public String getSelfId() {
        return selfId;
    }

    public String getOpponentId() {
        return opponentId;
    }

    public String getOpponentUrl() {
        return opponentUrl;
    }
}
