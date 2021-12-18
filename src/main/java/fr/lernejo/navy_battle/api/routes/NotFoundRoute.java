package fr.lernejo.navy_battle.api.routes;

import com.google.gson.JsonElement;
import fr.lernejo.navy_battle.api.ApiHandler;
import fr.lernejo.navy_battle.api.ApiResponse;

public class NotFoundRoute implements ApiHandler {

    @Override
    public ApiResponse handle(final String method, final JsonElement requestBodyElement) {
        return new ApiResponse(404, "Not Found");
    }
}
