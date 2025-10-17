import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class AuthIntegrationTest {
    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost:4004"; //api-gateway address
    }
    //we should get a valid token with OK status code
    @Test
    public void shouldReturnOKWithValidToken() {
        // 1. arrange
        // 2. act
        // 3. assert
        String loginPayload = """
          {
            "email": "testuser@test.com",
            "password": "password123"
          }
        """;

        Response response = given() // 1. arrange
                .contentType("application/json")
                .body(loginPayload)
                .when() // 2. act
                .post("/auth/login")
                .then() // 3. assert
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .response();
        System.out.println("Generated Token: " + response.jsonPath().getString("token") );
    }

    @Test
    public void shouldReturnUnauthorizedOnInvalidLogin() {
        // 1. arrange
        // 2. act
        // 3. assert
        String loginPayload = """
          {
            "email": "invalid_user@test.com",
            "password": "wrongpassword"
          }
        """;

         given() // 1. arrange
                .contentType("application/json")
                .body(loginPayload)
                .when() // 2. act
                .post("/auth/login")
                .then() // 3. assert
                .statusCode(401);

    }
}
