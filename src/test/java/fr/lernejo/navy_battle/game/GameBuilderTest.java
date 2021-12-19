package fr.lernejo.navy_battle.game;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class GameBuilderTest {

    @Test
    public void testA1() {
        final GameBuilder builder = new GameBuilder();
        final String selfId = builder.getSelfId();
        final String opponentId = UUID.randomUUID().toString();
        final String opponentUrl = "http://localhost:8081";
        builder.setOpponentId(opponentId);
        builder.setOpponentUrl(opponentUrl);
        Assert.assertEquals(builder.getSelfId(), selfId);
        final Game game = builder.build();
        Assert.assertEquals(game.getSelfId(), selfId);
        Assert.assertEquals(game.getOpponentId(), opponentId);
        Assert.assertEquals(game.getOpponentUrl(), opponentUrl);
    }
}
