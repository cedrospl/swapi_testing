package swapi.Vehicles;

import base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

public class vehiclesPositiveTest extends BaseTest {

    @Test
    public void readAllVehicles() {

        Response response = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + VEHICLES_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat(json.getString("count")).isEqualTo("39");
    }

    @Test
    public void readOneVehicle() {

        Response response = given()
                .spec(reqSpec)
                .pathParam("id", "19")
                .when()
                .get(BASE_URL + VEHICLES_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat(json.getString("name")).isEqualTo("AT-ST");
        assertThat(json.getString("model")).isEqualTo("All Terrain Scout Transport");
        assertThat(json.getString("cost_in_credits")).isEqualTo("unknown");
        assertThat(json.getString("length")).isEqualTo("2");
        assertThat(json.getString("vehicle_class")).isEqualTo("walker");
    }
}
