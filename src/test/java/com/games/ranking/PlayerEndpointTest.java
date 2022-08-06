package com.games.ranking;

import com.games.ranking.api.models.entity.PlayerEntity;
import com.games.ranking.api.models.request.PlayerRequest;
import com.games.ranking.api.repository.MatchRepository;
import com.games.ranking.api.repository.PlayerRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlayerEndpointTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private MatchRepository matchRepository;

    @Before
    public void setUp() {
        prepararDados();
    }


    @Test
    public void postPlayersTest() {
        PlayerRequest playerRequest = PlayerRequest.builder()
                .name("Sergio Holovati")
                .age(26)
                .gender("Male")
                .build();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.given().basePath("rest/v1/players")
                .port(port)
                .body(playerRequest)
                .contentType(ContentType.JSON)
                .when()
                     .post()
                .then()
                        .statusCode(200);
    }

    @Test
    public void getPlayersTest() {
        RestAssured.given().
                basePath("rest/v1/players")
                .port(port)
                .accept(ContentType.JSON)
                .when()
                    .get()
                .then()
                    .statusCode(200);
    }

    @Test
    public void editPlayersTest() {
        List<PlayerEntity> player = repository.findAll();
        PlayerRequest playerRequest = PlayerRequest.builder()
                .name("Benjamin Holovati")
                .age(26)
                .gender("Male")
                .build();
        given().body(playerRequest)
                .basePath("rest/v1/players/"+player.get(0).getId())
                .port(port)
                .body(playerRequest)
                .contentType(ContentType.JSON)
                .when()
                .put()
                .then()
                .statusCode(200);
    }

    @Test
    public void getPlayersByIdTest() {
        RestAssured.given().
        basePath("rest/v1/players/1")
                .port(port)
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    private void prepararDados() {
        PlayerEntity player = new PlayerEntity();
        player.setName("Sergio");
        repository.save(player);

        PlayerEntity player2 = new PlayerEntity();
        player2.setName("Giulia");
        repository.save(player2);
    }

}