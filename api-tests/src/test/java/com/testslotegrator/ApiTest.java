package com.testslotegrator;

import com.testslotegrator.client.AuthenticationApiClient;
import com.testslotegrator.client.PlayersApiClient;
import com.testslotegrator.model.Credentials;
import com.testslotegrator.model.Player;
import com.testslotegrator.model.PlayerProfile;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiTest {

    private static String accessToken;
    private static Integer playerId;
    private static Integer anotherPlayerId;
    private static String authenticationToken;
    private static Player player;
    private static Credentials credentials;
    private static AuthenticationApiClient authenticationApiClient;
    private static PlayersApiClient playersApiClient;

    @BeforeAll
    public static void setUp() {
        authenticationApiClient = new AuthenticationApiClient();
        playersApiClient = new PlayersApiClient();
        player = new Player();
        credentials = new Credentials(player);
    }

    @Test
    @DisplayName("Get a guest token")
    @Order(1)
    public void getGuestTokenTest() {
        ValidatableResponse getTokenResponse = authenticationApiClient.getToken();

        assertAll(
                () -> assertEquals(200, getTokenResponse.extract().statusCode()),
                () -> assertNotNull(getTokenResponse.extract().body().path("access_token"))
        );

        accessToken = getTokenResponse.extract().body().path("access_token");
    }

    @Test
    @DisplayName("Register a player")
    @Order(2)
    void registerPlayerTest() {
        ValidatableResponse registrationResponse = playersApiClient.registerPlayer(accessToken, player);

        assertAll(
                () -> assertEquals(201, registrationResponse.extract().statusCode()),
                () -> assertNotNull(registrationResponse.extract().body().as(PlayerProfile.class))
        );

        playerId = registrationResponse.extract().body().path("id");
    }

    @Test
    @DisplayName("Log in under the created player")
    @Order(3)
    void playerLoginTest() {
        ValidatableResponse authenticationResponse = authenticationApiClient.authenticate(credentials);

        assertAll(
                () -> assertEquals(200, authenticationResponse.extract().statusCode()),
                () -> assertNotNull(authenticationResponse.extract().body().path("access_token"))
        );

        authenticationToken = authenticationResponse.extract().body().path("access_token");
    }

    @Test
    @DisplayName("Request player profile data")
    @Order(4)
    void getProfileData() {
        ValidatableResponse getDataResponse = playersApiClient.getPlayerProfile(authenticationToken, playerId);

        assertAll(
                () -> assertEquals(200, getDataResponse.extract().statusCode()),
                () -> assertNotNull(getDataResponse.extract().body().as(PlayerProfile.class))
        );
    }

    @Test
    @DisplayName("Request another player profile data")
    @Order(5)
    void getAnotherProfileData() {
        anotherPlayerId = playerId - 1;
        ValidatableResponse getAnotherDataResponse = playersApiClient.getPlayerProfile(authenticationToken, anotherPlayerId);
        assertEquals(404, getAnotherDataResponse.extract().statusCode());
    }
}
