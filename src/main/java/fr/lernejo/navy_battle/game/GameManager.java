package fr.lernejo.navy_battle.game;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameManager {

    private final String endpoint;
    private final Map<String, Game> games;

    public GameManager(final String endpoint) {
        this.endpoint = endpoint;
        this.games = new HashMap<>();
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public Game getGame(final String identifier) {
        return this.games.get(identifier);
    }

    public Game createGame(final String opponentId, final String opponentUrl) {
        final String selfId = UUID.randomUUID().toString();
        if (this.games.containsKey(selfId)) {
            throw new IllegalStateException("Created game identifier already exists");
        }
        final Game game = new Game(selfId, opponentId, opponentUrl);
        System.out.println("Created game " + game.getSelfId() + "@" + this.endpoint + " on " + game.getOpponentId() + "@" + game.getOpponentUrl());
        this.games.put(selfId, game);
        return game;
    }
}
