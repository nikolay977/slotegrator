package com.testslotegrator.client;

import com.testslotegrator.model.Credentials;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationApiClient extends ApiClient {

    private static String BASIC_AUTH_NAME = "front_2d6b0a8391742f5d789d7d915755e09e";
    private static String BASIC_AUTH_PASS = "";
    private static String OATH2_TOKEN = "/oauth2/token";

    public ValidatableResponse getToken() {
        Map<String, String> params = new HashMap<>();
        params.put("scope", "guest:default");
        params.put("grant_type", "client_credentials");

        return given().urlEncodingEnabled(true)
                .spec(getRequestSpecification(params))
                .auth().preemptive()
                .basic(BASIC_AUTH_NAME, BASIC_AUTH_PASS)
                .when()
                .post(OATH2_TOKEN)
                .then()
                .log().all();
    }

    public ValidatableResponse authenticate(Credentials credentials) {
        return given().urlEncodingEnabled(true)
                .spec(getRequestSpecification())
                .auth().preemptive()
                .basic(BASIC_AUTH_NAME, BASIC_AUTH_PASS)
                .log().all()
                .body(credentials)
                .when()
                .post(OATH2_TOKEN)
                .then()
                .log().all();
    }
}
