package swapi.Planets;

import base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

public class planetsPositiveTest extends BaseTest {

    @Test
    public void readAllPlanets() {

        Response response = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + PLANETS_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat(json.getString("count")).isEqualTo("61");
    }

    @Test
    public void readOnePlanet() {

        Response response = given()
                .spec(reqSpec)
                .pathParam("id", "49")
                .when()
                .get(BASE_URL + PLANETS_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat(json.getString("name")).isEqualTo("Dorin");
        assertThat(json.getString("gravity")).isEqualTo("1");
        assertThat(json.getString("population")).isEqualTo("unknown");
    }
}
