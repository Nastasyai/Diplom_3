package Configuration;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pagesObject.Environment;

import static io.restassured.RestAssured.given;
public class ConfigApi {
    public static RequestSpecification requestSpec() {
        return  given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(Environment.BASE_URL);
    }
}