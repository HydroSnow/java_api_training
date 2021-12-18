package fr.lernejo.navy_battle.api.routes;

import com.google.gson.JsonElement;
import fr.lernejo.navy_battle.api.ApiHandler;
import fr.lernejo.navy_battle.api.ApiResponse;
import fr.lernejo.navy_battle.game.GameManager;

import java.util.Map;

public class ApiGameFireRoute implements ApiHandler {

    private final GameManager manager;

    public ApiGameFireRoute(final GameManager manager) {
        this.manager = manager;
    }

    @Override
    public ApiResponse handle(final String method, final Map<String, String> queryParams, final JsonElement requestBodyElement) {
        if (method.equals("GET")) {

            return new ApiResponse(202, queryParams);
        } else {
            return new ApiResponse(404, "Not Found: Method Not Allowed");
        }
    }
}
