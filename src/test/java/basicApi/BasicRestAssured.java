package basicApi;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BasicRestAssured {

    /*
    * given() --> config > headers, params, body, auth
    * when () --> method (post, put, get, delete) > url path
    * then() --> Response code, msg, body, headers
    * */

    @Test
    public void createProjectByApi(){
        given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .body("{\n" +
                        "    \"Content\": \"Rene Rengel RestAssured\",\n" +
                        "    \"Icon\": 6\n" +
                        "}")
                .log()
                .all()
                .when()
                .post("https://todo.ly/api/projects.json")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo("Rene Rengel RestAssured"))
                .body("Icon", equalTo(6));

    }

    @Test
    public void createProjectByApiWithJson(){
        JSONObject bodyProject = new JSONObject();
        bodyProject.put("Content", "Rene Rengel RestAssured json");
        bodyProject.put("Icon", "6");

        given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .body(bodyProject.toString())
                .log()
                .all()
                .when()
                .post("https://todo.ly/api/projects.json")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo("Rene Rengel RestAssured json"))
                .body("Icon", equalTo(6));

    }

}
