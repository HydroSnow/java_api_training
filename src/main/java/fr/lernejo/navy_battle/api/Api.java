package fr.lernejo.navy_battle.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.concurrent.Executors;

public class Api {

    private final Gson gson = new Gson();
    private final HttpServer server;

    public Api(final int port) throws IOException {
        this.server = HttpServer.create();
        this.server.setExecutor(Executors.newSingleThreadExecutor());
        this.server.bind(new InetSocketAddress(port), 0);
        this.server.start();
    }

    public void createContext(final String path, final ApiHandler handler) {
        this.server.createContext(path, exchange -> {
            int status;
            Object responseBody;
            try {
                final String method = exchange.getRequestMethod();
                final JsonElement requestBody;
                try (final InputStream is = exchange.getRequestBody()) {
                    final Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
                    requestBody = this.gson.fromJson(reader, JsonElement.class);
                }
                final ApiResponse response = handler.handle(method, requestBody);
                status = response.getStatus();
                responseBody = response.getBody();
            } catch (final JsonSyntaxException e) {
                status = 400;
                responseBody = "Bad Request";
            } catch (final Exception e) {
                e.printStackTrace();
                status = 500;
                responseBody = "Internal Server Error";
            }
            final String json = this.gson.toJson(responseBody);
            final byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().put("Content-Type", Collections.singletonList("application/json"));
            exchange.sendResponseHeaders(status, bytes.length);
            try (final OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        });
    }
}
