package com.games.ranking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
 class ResumeEndpointTest {

    @LocalServerPort
    private int port;


    @Test
    public void getResumeTest() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.given().basePath("rest/v1/resume")
                .port(port)
                .accept(ContentType.JSON)
                .when()
                    .get()
                .then()
                    .statusCode(200);
    }

}
