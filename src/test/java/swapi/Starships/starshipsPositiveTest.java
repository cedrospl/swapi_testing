package swapi.Starships;

import base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

public class starshipsPositiveTest extends BaseTest {

    @Test
    public void readAllStarship() {

        Response response = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + STARSHIPS_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat(json.getString("count")).isEqualTo("37");
    }

    @Test
    public void readOneStarship() {

        Response response = given()
                .spec(reqSpec)
                .pathParam("id", "32")
                .when()
                .get(BASE_URL + STARSHIPS_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat(json.getString("name")).isEqualTo("Droid control ship");
        assertThat(json.getString("cost_in_credits")).isEqualTo("unknown");
        assertThat(json.getString("crew")).isEqualTo("175");
        assertThat(json.getString("consumables")).isEqualTo("500 days");
    }
}
