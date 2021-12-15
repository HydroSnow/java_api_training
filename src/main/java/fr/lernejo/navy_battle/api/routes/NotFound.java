package fr.lernejo.navy_battle.api.routes;

import com.sun.net.httpserver.HttpExchange;
import fr.lernejo.navy_battle.api.ApiHandler;
import fr.lernejo.navy_battle.api.ApiResponse;

public class NotFound implements ApiHandler {
    @Override
    public ApiResponse handle(HttpExchange exchange) {
        return new ApiResponse(404, "Not Found");
    }
}
