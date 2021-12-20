package fr.lernejo.navy_battle.api.routes;

import fr.lernejo.navy_battle.api.ApiResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class PingRouteTest {

    @Test
    public void test() {
        final PingRoute route = new PingRoute();
        final ApiResponse response1 = route.handle("GET", new HashMap<>(), null);
        Assert.assertEquals(response1.getStatus(), 200);
        Assert.assertEquals(response1.getBody(), "Pong!");
        final ApiResponse response2 = route.handle("POST", new HashMap<>(), null);
        Assert.assertEquals(response2.getStatus(), 404);
        Assert.assertEquals(response2.getBody(), "Not Found: Method Not Allowed");
    }
}
