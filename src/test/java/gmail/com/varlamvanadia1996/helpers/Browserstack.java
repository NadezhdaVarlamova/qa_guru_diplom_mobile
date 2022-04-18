package gmail.com.varlamvanadia1996.helpers;

import gmail.com.varlamvanadia1996.config.Credentials;

import static io.restassured.RestAssured.given;

public class Browserstack {
    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(Credentials.config.user(), Credentials.config.key())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
