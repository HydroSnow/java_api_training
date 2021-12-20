package fr.lernejo.navy_battle.api.routes;

import fr.lernejo.navy_battle.api.ApiResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class NotFoundRouteTest {

    @Test
    public void test() {
        final NotFoundRoute route = new NotFoundRoute();
        final ApiResponse response = route.handle("GET", new HashMap<>(), null);
        Assert.assertEquals(response.getStatus(), 404);
        Assert.assertEquals(response.getBody(), "Not Found");
    }
}
