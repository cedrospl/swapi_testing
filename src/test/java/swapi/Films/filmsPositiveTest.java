package swapi.Films;

import base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

public class filmsPositiveTest extends BaseTest {

    @Test
    public void readAllFilms() {

        Response response = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + FILMS_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        List<String> episodesNumber = json.getList("results.episode_id");
        assertThat(episodesNumber.size()).isEqualTo(7);
    }

    @Test
    public void readOneFilm() {

        Response response = given()
                .spec(reqSpec)
                .pathParam("id", "5")
                .when()
                .get(BASE_URL + FILMS_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat(json.getString("title")).isEqualTo("Attack of the Clones");
        assertThat(json.getString("release_date")).isEqualTo("2002-05-16");
    }
}
