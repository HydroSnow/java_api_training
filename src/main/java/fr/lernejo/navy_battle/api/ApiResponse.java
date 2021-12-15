package fr.lernejo.navy_battle.api;

public class ApiResponse {

    private final int status;
    private final String body;

    public ApiResponse(final int status, final String body) {
        this.status = status;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }
}
