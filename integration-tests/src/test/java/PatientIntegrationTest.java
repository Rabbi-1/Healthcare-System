import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PatientIntegrationTest {
    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost:4004";
    }
    @Test
    public void shouldReturnPatientsWithValidToken () {
        String loginPayload = """
          {
            "email": "testuser@test.com",
            "password": "password123"
          }
        """;

        String token = given() // 1. arrange
                .contentType("application/json")
                .body(loginPayload)
                .when() // 2. act
                .post("/auth/login")
                .then() // 3. assert
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("token");

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("api/patients")
                .then()
                .statusCode(200)
                .body("patients", notNullValue());
    }
}
