package com.games.ranking;

import com.games.ranking.api.models.entity.MatchEntity;
import com.games.ranking.api.models.entity.PlayerEntity;
import com.games.ranking.api.models.request.MatchRequest;
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
class MatchEndpointTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private MatchRepository repository;

    @Before
    public void setUp() {

        this.prepararPlayers();
    }


    @Test
    public void postMatchTest() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
            MatchRequest matchRequest = MatchRequest.builder()
                    .game("Truco")
                    .winner(1L)
                    .loser(2L)
                    .build();
            RestAssured.given().basePath("rest/v1/matches")
                    .port(port)
                    .body(matchRequest)
                    .contentType(ContentType.JSON)
                    .when()
                    .post()
                    .then()
                    .statusCode(200);
        }




    @Test
    public void getMatchesTest() {
        RestAssured.given().basePath("rest/v1/matches")
                .port(port)
                .accept(ContentType.JSON)
                .when()
                    .get()
                .then()
                .statusCode(200);
    }

    @Test
    public void putMatchTest() {
        List<MatchEntity> matchEntity = repository.findAll();
        List<PlayerEntity> playerEntities = playerRepository.findAll();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        MatchRequest matchRequest = MatchRequest.builder()
                .game("RPG")
                .winner(playerEntities.get(0).getId())
                .loser(playerEntities.get(1).getId())
                .build();
        RestAssured.given().basePath("rest/v1/matches/"+matchEntity.get(0).getId())
                .port(port)
                .body(matchRequest)
                .contentType(ContentType.JSON)
                .when()
                    .put()
                .then()
                    .statusCode(200);
    }

    @Test
    public void getMatchesByIdTest() {
        List<MatchEntity> matchEntity = repository.findAll();
        RestAssured.given().basePath("rest/v1/matches/"+matchEntity.get(0).getId())
                .port(port)
                .accept(ContentType.JSON)
                .when()
                    .get()
                .then()
                    .statusCode(200);
    }

    @Test
    public void deleteMatchesByIdTest() {
        List<MatchEntity> matchEntity = repository.findAll();
        RestAssured.given().basePath("rest/v1/matches/"+matchEntity.get(0).getId())
                .port(port)
                .accept(ContentType.JSON)
                .when()
                .delete()
                .then()
                .statusCode(200);
    }
    private void prepararPlayers() {
        PlayerEntity player = new PlayerEntity();
        player.setName("Sergio");
        playerRepository.save(player);

        PlayerEntity player2 = new PlayerEntity();
        player2.setName("Giulia");
        playerRepository.save(player2);

    }
}
