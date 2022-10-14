package com.testslotegrator.client;

import com.testslotegrator.model.Player;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class PlayersApiClient extends ApiClient {

    private static String PLAYERS = "/players";

    public ValidatableResponse registerPlayer(String accessToken, Player player) {
        return given().urlEncodingEnabled(true)
                .spec(getRequestSpecification())
                .header("Authorization", "Bearer " + accessToken)
                .body(player)
                .log().all()
                .when()
                .post(PLAYERS)
                .then()
                .log().all();
    }

    public ValidatableResponse getPlayerProfile(String accessToken, int playerId) {
        return given().urlEncodingEnabled(true)
                .spec(getRequestSpecification())
                .header("Authorization", "Bearer " + accessToken)
                .log().all()
                .when()
                .get(PLAYERS + "/" + playerId)
                .then()
                .log().all();
    }
}
