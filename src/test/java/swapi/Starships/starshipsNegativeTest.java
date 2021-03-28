package swapi.Starships;

import base.BaseTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class starshipsNegativeTest extends BaseTest {

    @Test
    public void addNewStarshipWithoutBody() {
        given()
                .spec(reqSpec)
                .when()
                .post(BASE_URL + STARSHIPS_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void update1StarshipWithoutBody() {
        given()
                .spec(reqSpec)
                .pathParam("id", 37)
                .when()
                .put(BASE_URL + STARSHIPS_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }

    @Test
    public void update2StarshipWithoutBody() {
        given()
                .spec(reqSpec)
                .pathParam("id", 21)
                .when()
                .patch(BASE_URL + STARSHIPS_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }

    @Test
    public void deleteExistingStarship() {
        given()
                .spec(reqSpec)
                .pathParam("id", 1)
                .when()
                .delete(BASE_URL + STARSHIPS_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }
}
