package fr.lernejo.navy_battle.api.routes;

import fr.lernejo.navy_battle.api.ApiResponse;
import fr.lernejo.navy_battle.game.Game;
import fr.lernejo.navy_battle.game.strategy.ComputerPlayer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.UUID;

public class ApiGameFireRouteTest {

    private Game game;
    private ApiGameFireRoute route;

    @Before
    public void setUp() {
        this.game = new Game(UUID.randomUUID().toString(), "localhost:8080", new ComputerPlayer());
        this.route = new ApiGameFireRoute(this.game, () -> {});
    }

    @Test
    public void test_404() {
        final ApiResponse response = this.route.handle("POST", new HashMap<>(), null);
        Assert.assertEquals(response.getStatus(), 404);
        Assert.assertEquals(response.getBody(), "Not Found: Method Not Allowed");
    }

    @After
    public void tearDown() {
        this.game = null;
        this.route = null;
    }
}
