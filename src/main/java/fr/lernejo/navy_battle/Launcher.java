package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.api.Api;
import fr.lernejo.navy_battle.api.routes.ApiGameStartRoute;
import fr.lernejo.navy_battle.api.routes.NotFoundRoute;
import fr.lernejo.navy_battle.api.routes.PingRoute;
import fr.lernejo.navy_battle.game.GameManager;

import java.io.IOException;

public class Launcher {
    public static void main(final String[] args) {
        // check if port argument present
        if (args.length < 1) {
            System.err.println("Missing port");
            System.exit(1);
            return;
        }
        final int port;
        // parse port argument
        try {
            port = Integer.parseInt(args[0]);
        } catch (final NumberFormatException e) {
            System.err.println("Port must be a number");
            System.exit(1);
            return;
        }

        // check if too much arguments
        if (args.length > 1) {
            System.err.println("Too much arguments");
            System.exit(1);
            return;
        }

        final GameManager manager = new GameManager();

        // create api
        final Api api;
        try {
            api = new Api(port);
        } catch (final IOException e) {
            System.err.println("Error on API Start");
            e.printStackTrace();
            System.exit(2);
            return;
        }
        api.createContext("/", new NotFoundRoute());
        api.createContext("/ping", new PingRoute());
        api.createContext("/api/game/start", new ApiGameStartRoute(manager));
        System.out.println("Listening on port " + port + "...");
    }
}
