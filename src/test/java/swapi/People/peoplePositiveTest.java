package swapi.People;

import base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

public class peoplePositiveTest extends BaseTest {

    @Test
    public void readAllPeople() {

        Response response = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + PEOPLE_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat(json.getString("count")).isEqualTo("87");
    }

    @Test
    public void readOnePerson() {

        Response response = given()
                .spec(reqSpec)
                .pathParam("id", "55")
                .when()
                .get(BASE_URL + PEOPLE_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat(json.getString("name")).isEqualTo("Adi Gallia");
        assertThat(json.getString("birth_year")).isEqualTo("unknown");
        assertThat(json.getString("gender")).isEqualTo("female");
    }
}
