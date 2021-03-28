package swapi.Species;

import base.BaseTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class speciesNegativeTest extends BaseTest {

    @Test
    public void addNewSpeciesWithoutBody() {
        given()
                .spec(reqSpec)
                .when()
                .post(BASE_URL + SPECIES_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void update1SpeciesWithoutBody() {
        given()
                .spec(reqSpec)
                .pathParam("id", 14)
                .when()
                .put(BASE_URL + SPECIES_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }

    @Test
    public void update2SpeciesWithoutBody() {
        given()
                .spec(reqSpec)
                .pathParam("id", 37)
                .when()
                .patch(BASE_URL + SPECIES_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }

    @Test
    public void deleteExistingSpecies() {
        given()
                .spec(reqSpec)
                .pathParam("id", 5)
                .when()
                .delete(BASE_URL + SPECIES_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }
}
