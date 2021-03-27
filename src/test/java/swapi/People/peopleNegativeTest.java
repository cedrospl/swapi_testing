package swapi.People;

import base.BaseTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class peopleNegativeTest extends BaseTest {

    @Test
    public void addNewFilmWithoutBody() {
        given()
                .spec(reqSpec)
                .when()
                .post(BASE_URL + PEOPLE_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void update1FilmWithoutBody() {
        given()
                .spec(reqSpec)
                .when()
                .put(BASE_URL + PEOPLE_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void update2FilmWithoutBody() {
        given()
                .spec(reqSpec)
                .when()
                .patch(BASE_URL + PEOPLE_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void deleteExistingFilm() {
        given()
                .spec(reqSpec)
                .pathParam("id", 5)
                .when()
                .delete(BASE_URL + PEOPLE_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }
}
