package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

public class Api {

    final HttpServer server;

    public Api(final int port) throws IOException {
        this.server = HttpServer.create();
        this.server.createContext("/", exchange -> {
            final String body = "No route for " + exchange.getRequestMethod() + " " + exchange.getRequestURI().getPath();
            final byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(404, bytes.length);
            try (final OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        });
        this.server.createContext("/ping", exchange -> {
            final String body = "Pong!";
            final byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, bytes.length);
            try (final OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        });
        this.server.setExecutor(Executors.newSingleThreadExecutor());
        this.server.bind(new InetSocketAddress(port), 0);
        this.server.start();
    }
}
