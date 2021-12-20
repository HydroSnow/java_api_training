package fr.lernejo.navy_battle.api.routes;

import fr.lernejo.navy_battle.api.ApiResponse;
import fr.lernejo.navy_battle.game.GameManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class ApiGameFireRouteTest {

    private GameManager manager;
    private ApiGameFireRoute route;

    @Before
    public void setUp() {
        this.manager = new GameManager("localhost:8080");
        this.route = new ApiGameFireRoute(this.manager);
    }

    @Test
    public void test_404() {
        final ApiResponse response = this.route.handle("POST", new HashMap<>(), null);
        Assert.assertEquals(response.getStatus(), 404);
        Assert.assertEquals(response.getBody(), "Not Found: Method Not Allowed");
    }

    @After
    public void tearDown() {
        this.manager = null;
        this.route = null;
    }
}
