package fr.lernejo.navy_battle.game;

import java.util.HashMap;
import java.util.Map;

public class GameManager {

    private final String selfUrl;
    private final Map<String, Game> games;

    public GameManager(final String selfUrl) {
        this.selfUrl = selfUrl;
        this.games = new HashMap<>();
    }

    public String getSelfUrl() {
        return this.selfUrl;
    }

    public Game getGame(final String identifier) {
        return this.games.get(identifier);
    }

    public Game createGame(final GameBuilder builder) {
        final String selfId = builder.getSelfId();
        if (this.games.containsKey(selfId)) {
            throw new IllegalStateException("Created game identifier already exists");
        }
        final Game game = builder.build();
        this.games.put(selfId, game);
        System.out.println("Created game " + game.getSelfId() + "@" + this.selfUrl + " on " + game.getOpponentId() + "@" + game.getOpponentUrl());
        return game;
    }
}
