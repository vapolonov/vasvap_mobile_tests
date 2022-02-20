package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {
    public static String videoUrl(String sessionId) {

        BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);

        String username = browserstackConfig.username();
        String password = browserstackConfig.password();
        String videoUrl = browserstackConfig.videoUrl();

        return given()
                .auth().basic(username, password)
                .when()
                .get(videoUrl + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}