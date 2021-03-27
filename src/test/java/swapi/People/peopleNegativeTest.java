package swapi.People;

import base.BaseTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class peopleNegativeTest extends BaseTest {

    @Test
    public void addNewPersonWithoutBody() {
        given()
                .spec(reqSpec)
                .when()
                .post(BASE_URL + PEOPLE_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void update1PersonWithoutBody() {
        given()
                .spec(reqSpec)
                .pathParam("id", 38)
                .when()
                .put(BASE_URL + PEOPLE_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }

    @Test
    public void update2PersonWithoutBody() {
        given()
                .spec(reqSpec)
                .pathParam("id", 42)
                .when()
                .patch(BASE_URL + PEOPLE_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }

    @Test
    public void deleteExistingPerson() {
        given()
                .spec(reqSpec)
                .pathParam("id", 24)
                .when()
                .delete(BASE_URL + PEOPLE_ENDPOINT + "{id}")
                .then()
                .statusCode(HttpStatus.SC_MOVED_PERMANENTLY);
    }
}
