import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanPOSTRawText {
    @Test
    void postRawTextShouldReturnCorrectResponse() {
        String data = "{\n    \"test\": \"value\"\n}";
        given()
                .contentType(ContentType.TEXT)
                .body(data)
                .when()
                .post("http://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(data));
    }
}
