package fr.lernejo.navy_battle.api.routes;

import com.sun.net.httpserver.HttpExchange;
import fr.lernejo.navy_battle.api.ApiHandler;
import fr.lernejo.navy_battle.api.ApiResponse;

public class Ping implements ApiHandler {
    @Override
    public ApiResponse handle(final HttpExchange exchange) {
        if (exchange.getRequestMethod().equals("GET")) {
            return new ApiResponse(200, "Pong!");
        } else {
            return new ApiResponse(405, "Method Not Allowed");
        }
    }
}
