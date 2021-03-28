package swapi.Planets;

import base.BaseTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class planetsNegativeTest extends BaseTest {

    @Test
    public void addNewPlanetWithoutBody() {
        given()
                .spec(reqSpec)
                .when()
                .post(BASE_URL + PLANETS_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void update1PlanetWithoutBody() {
        given()
                .spec(reqSpec)
                .pathParam("id", 55)
                .when()
                .put(BASE_URL + PLANETS_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }

    @Test
    public void update2PlanetWithoutBody() {
        given()
                .spec(reqSpec)
                .pathParam("id", 13)
                .when()
                .patch(BASE_URL + PLANETS_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }

    @Test
    public void deleteExistingPlanet() {
        given()
                .spec(reqSpec)
                .pathParam("id", 7)
                .when()
                .delete(BASE_URL + PLANETS_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }
}
