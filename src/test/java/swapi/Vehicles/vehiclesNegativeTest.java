package swapi.Vehicles;

import base.BaseTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class vehiclesNegativeTest extends BaseTest {

    @Test
    public void addNewVehicleWithoutBody() {
        given()
                .spec(reqSpec)
                .when()
                .post(BASE_URL + VEHICLES_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void update1VehicleWithoutBody() {
        given()
                .spec(reqSpec)
                .pathParam("id", 18)
                .when()
                .put(BASE_URL + VEHICLES_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }

    @Test
    public void update2VehicleWithoutBody() {
        given()
                .spec(reqSpec)
                .pathParam("id", 3)
                .when()
                .patch(BASE_URL + VEHICLES_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }

    @Test
    public void deleteExistingVehicle() {
        given()
                .spec(reqSpec)
                .pathParam("id", 39)
                .when()
                .delete(BASE_URL + VEHICLES_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }
}
