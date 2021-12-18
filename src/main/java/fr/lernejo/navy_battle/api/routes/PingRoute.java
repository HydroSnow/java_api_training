package fr.lernejo.navy_battle.api.routes;

import com.google.gson.JsonElement;
import fr.lernejo.navy_battle.api.ApiHandler;
import fr.lernejo.navy_battle.api.ApiResponse;

public class PingRoute implements ApiHandler {

    @Override
    public ApiResponse handle(final String method, final JsonElement requestBodyElement) {
        if (method.equals("GET")) {
            return new ApiResponse(200, "Pong!");
        } else {
            return new ApiResponse(404, "Not Found: Method Not Allowed");
        }
    }
}
