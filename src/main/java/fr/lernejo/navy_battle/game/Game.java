package fr.lernejo.navy_battle.game;

import fr.lernejo.navy_battle.game.board.Board;
import fr.lernejo.navy_battle.game.board.CellStatus;

public class Game {

    private final String selfId;
    private final String opponentId;
    private final String opponentUrl;

    private final Board selfBoard = new Board(CellStatus.EMPTY);
    private final Board opponentBoard = new Board(CellStatus.UNKNOWN);

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
