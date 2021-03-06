package swapi.Films;

import base.BaseTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class filmsNegativeTest extends BaseTest {

    @Test
    public void addNewFilmWithoutBody() {
        given()
                .spec(reqSpec)
                .when()
                .post(BASE_URL + FILMS_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void update1FilmWithoutBody() {
        given()
                .spec(reqSpec)
                .pathParam("id", 3)
                .when()
                .put(BASE_URL + FILMS_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }

    @Test
    public void update2FilmWithoutBody() {
        given()
                .spec(reqSpec)
                .pathParam("id", 2)
                .when()
                .patch(BASE_URL + FILMS_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }

    @Test
    public void deleteExistingFilm() {
        given()
                .spec(reqSpec)
                .pathParam("id", 1)
                .when()
                .delete(BASE_URL + FILMS_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }
}
