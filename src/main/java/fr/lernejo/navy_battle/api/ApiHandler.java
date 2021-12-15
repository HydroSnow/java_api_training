package fr.lernejo.navy_battle.api;

import com.sun.net.httpserver.HttpExchange;

public interface ApiHandler {
    ApiResponse handle(final HttpExchange exchange);
}
