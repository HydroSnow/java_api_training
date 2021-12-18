package fr.lernejo.navy_battle.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import fr.lernejo.navy_battle.game.Game;
import fr.lernejo.navy_battle.game.GameBuilder;
import fr.lernejo.navy_battle.game.GameManager;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Client {

    private final Gson gson = new Gson();
    private final GameManager manager;

    public Client(final GameManager manager) {
        this.manager = manager;
    }

    public void startGame(final String opponentUrl) throws IOException, InterruptedException {
        System.out.println("Starting game with " + opponentUrl);

        final GameBuilder builder = new GameBuilder();

        final Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", builder.getSelfId());
        requestBody.put("url", this.manager.getSelfUrl());
        requestBody.put("message", "I will crush you!");
        final String requestJson = this.gson.toJson(requestBody);

        final HttpRequest postRequest = HttpRequest.newBuilder()
            .uri(URI.create(opponentUrl + "/api/game/start"))
            .POST(HttpRequest.BodyPublishers.ofString(requestJson))
            .build();

        final HttpClient client = HttpClient.newHttpClient();
        final HttpResponse<String> response = client.send(postRequest, HttpResponse.BodyHandlers.ofString());

        final String responseJson = response.body();
        final JsonObject responseBody = this.gson.fromJson(responseJson, JsonObject.class);
        final String responseId = responseBody.get("id").getAsString();
        final String responseUrl = responseBody.get("url").getAsString();
        final String responseMessage = responseBody.get("message").getAsString();

        builder.setOpponentId(responseId);
        builder.setOpponentUrl(responseUrl);
        final Game game = this.manager.createGame(builder);
        System.out.println("Message from " + game.getOpponentId() + ": " + responseMessage);
    }
}
