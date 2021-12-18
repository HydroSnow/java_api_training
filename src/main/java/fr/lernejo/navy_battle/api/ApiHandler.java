package fr.lernejo.navy_battle.api;

import com.google.gson.JsonElement;

public interface ApiHandler {

    ApiResponse handle(final String method, final JsonElement requestBodyElement);
}
