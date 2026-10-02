import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanPUTRequestTest {
    @Test
    void putRequestShouldReturnCorrectResponse() {
        String data = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT)
                .body(data)
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(data));
    }
}
