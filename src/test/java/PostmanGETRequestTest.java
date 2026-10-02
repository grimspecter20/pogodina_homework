import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanGETRequestTest {
    @Test
    void getRequestShouldReturnCorrectResponse() {
        given()
                .when()
                .get("http://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
                .statusCode(200);
    }
}
