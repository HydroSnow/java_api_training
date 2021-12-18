package fr.lernejo.navy_battle.game;

import java.util.UUID;

public class GameBuilder {

    private final String selfId;
    private String opponentId;
    private String opponentUrl;

    public GameBuilder() {
        this.selfId = UUID.randomUUID().toString();
    }

    public String getSelfId() {
        return selfId;
    }

    public void setOpponentId(String opponentId) {
        this.opponentId = opponentId;
    }

    public void setOpponentUrl(String opponentUrl) {
        this.opponentUrl = opponentUrl;
    }

    Game build() {
        if (this.opponentId == null) {
            throw new IllegalStateException("Opponent ID is not set");
        }
        if (this.opponentUrl == null) {
            throw new IllegalStateException("Opponent URL is not set");
        }
        return new Game(this.selfId, this.opponentId, this.opponentUrl);
    }
}
