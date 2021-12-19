package fr.lernejo.navy_battle.game;

import fr.lernejo.navy_battle.game.board.opponent.OpponentBoard;
import fr.lernejo.navy_battle.game.board.self.Boat;
import fr.lernejo.navy_battle.game.board.self.SelfBoard;
import fr.lernejo.navy_battle.game.strategy.ComputerPlayer;
import fr.lernejo.navy_battle.game.strategy.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String selfId;
    private final String opponentId;
    private final String opponentUrl;

    private final SelfBoard selfBoard;
    private final OpponentBoard opponentBoard;

    public Game(final String selfId, final String opponentId, final String opponentUrl) {
        this.selfId = selfId;
        this.opponentId = opponentId;
        this.opponentUrl = opponentUrl;

        this.selfBoard = new SelfBoard();
        this.opponentBoard = new OpponentBoard();

        final Player player = new ComputerPlayer();
        final List<Boat> boats = new ArrayList<>();
        boats.add(new Boat(2));
        boats.add(new Boat(3));
        boats.add(new Boat(3));
        boats.add(new Boat(4));
        boats.add(new Boat(5));
        player.placeBoats(boats, this.selfBoard);
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

    public SelfBoard getSelfBoard() {
        return selfBoard;
    }

    public OpponentBoard getOpponentBoard() {
        return opponentBoard;
    }
}
