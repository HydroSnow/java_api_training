package fr.lernejo.navy_battle.game;

import fr.lernejo.navy_battle.game.board.Board;

public class Game {

    private final String selfId;
    private final String opponentId;
    private final String opponentUrl;

    private final Board selfBoard = new Board();
    private final Board opponentBoard = new Board();

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
