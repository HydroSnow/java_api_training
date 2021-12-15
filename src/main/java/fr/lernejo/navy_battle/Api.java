package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

public class Api implements HttpHandler {

    final HttpServer server;

    public Api(final int port) throws IOException {
        this.server = HttpServer.create();
        this.server.createContext("/", this);
        this.server.setExecutor(Executors.newSingleThreadExecutor());
        this.server.bind(new InetSocketAddress(port), 0);
        this.server.start();
    }

    @Override
    public void handle(final HttpExchange exchange) throws IOException {
        final String response = "Hello, world!";
        final byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(200, bytes.length);
        final OutputStream out = exchange.getResponseBody();
        out.write(bytes);
        out.close();
    }
}
