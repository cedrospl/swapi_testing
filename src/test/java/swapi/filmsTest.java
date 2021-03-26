package swapi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class filmsTest {

    @Test
    public void readAllFilms(){

        Response response = given()
                .when()
                .get("https://swapi.py4e.com/api/films")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        System.out.println(json.prettyPrint());
        List<String> episodesNumber = json.getList("results.episode_id");
        Assertions.assertThat(episodesNumber.size()).isEqualTo(7);
    }
}
