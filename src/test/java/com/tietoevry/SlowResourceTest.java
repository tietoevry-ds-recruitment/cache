package com.tietoevry;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class SlowResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/compute/user/1")
          .then()
             .statusCode(200);
    }
}
