package swapi.Species;

import base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

public class speciesPositiveTest extends BaseTest {

    @Test
    public void readAllSpecies() {

        Response response = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + SPECIES_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat(json.getString("count")).isEqualTo("37");
    }

    @Test
    public void readOneSpecies() {

        Response response = given()
                .spec(reqSpec)
                .pathParam("id", "11")
                .when()
                .get(BASE_URL + SPECIES_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat(json.getString("name")).isEqualTo("Neimodian");
        assertThat(json.getString("skin_colors")).isEqualTo("grey, green");
        assertThat(json.getString("language")).isEqualTo("Neimoidia");
        assertThat(json.getString("average_lifespan")).isEqualTo("unknown");
    }
}
