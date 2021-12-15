package fr.lernejo.navy_battle;

import java.io.IOException;

public class Launcher {
    public static void main(final String[] args) {
        if (args.length < 1) {
            System.err.println("Missing port");
            System.exit(1);
            return;
        }
        final int port;
        try {
            port = Integer.parseInt(args[0]);
        } catch (final NumberFormatException e) {
            System.err.println("Port must be a number");
            System.exit(1);
            return;
        }
        if (args.length > 1) {
            System.err.println("Too much arguments");
            System.exit(1);
            return;
        }

        try {
            new Api(port);
            System.out.println("Listening on port " + port + "...");
        } catch (final IOException e) {
            System.err.println("Error on API Start");
            e.printStackTrace();
            System.exit(2);
            return;
        }
    }
}
