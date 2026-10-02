import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanPATCHRequestTest {
    @Test
    void patchRequestShouldReturnCorrectResponse (){
        String data = "This is expected to be sent back as part of response body.";
        given ()
                .contentType(ContentType.TEXT)
                .body(data)
                .when()
                .patch("https://postman-echo.com/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(data));
    }
}
