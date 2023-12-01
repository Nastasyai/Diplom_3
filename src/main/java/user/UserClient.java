package user;

import Configuration.ConfigApi;
import io.restassured.response.ValidatableResponse;
import pagesObject.Environment;

import java.util.Map;

public class UserClient extends ConfigApi {

    public static ValidatableResponse create(User user) {
        return requestSpec()
                .body(user)
                .when()
                .post(Environment.USER_CREATE)
                .then().log().all();
    }

    public static ValidatableResponse delete(String accessToken) {
        return requestSpec()
                .headers(Map.of("Authorization", accessToken))
                .when()
                .delete(Environment.USER_DELETE)
                .then().log().body();
    }


}