package fr.lernejo.navy_battle.api.routes;

import com.google.gson.JsonElement;
import fr.lernejo.navy_battle.api.ApiHandler;
import fr.lernejo.navy_battle.api.ApiResponse;
import fr.lernejo.navy_battle.game.GameManager;

public class ApiGameStartRoute implements ApiHandler {

    private final GameManager manager;

    public ApiGameStartRoute(final GameManager manager) {
        this.manager = manager;
    }

    @Override
    public ApiResponse handle(final String method, final JsonElement requestBody) {
        if (method.equals("POST")) {
            return new ApiResponse(200, "AAAAAAAAAAAAAAAAAa");
        } else {
            return new NotFoundRoute().handle(method, requestBody);
        }
    }
}
