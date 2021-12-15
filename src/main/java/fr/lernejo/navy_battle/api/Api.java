package fr.lernejo.navy_battle.api;

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
        this.server.setExecutor(Executors.newSingleThreadExecutor());
        this.server.bind(new InetSocketAddress(port), 0);
        this.server.start();
    }

    public void createContext(final String path, final ApiHandler handler) {
        this.server.createContext(path, exchange -> {
            int status;
            String body;
            try {
                final ApiResponse response = handler.handle(exchange);
                status = response.getStatus();
                body = response.getBody();
            } catch (final Exception e) {
                e.printStackTrace();
                status = 500;
                body = "Internal Server Error";
            }
            final byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(status, bytes.length);
            try (final OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        });
    }
}
