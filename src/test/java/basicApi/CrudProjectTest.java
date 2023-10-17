package basicApi;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CrudProjectTest {

    @Test
    public void createUpdateReadDeleteProject(){
        JSONObject bodyProject = new JSONObject();
        bodyProject.put("Content", "Rene Rengel RestAssured json");
        bodyProject.put("Icon", "6");

        Response response = given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .body(bodyProject.toString())
                .log()
                .all()
        .when()
                .post("https://todo.ly/api/projects.json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo("Rene Rengel RestAssured json"))
                .body("Icon", equalTo(6));


        int idProject = response.then().extract().path("Id");
        System.out.println("Id: " + idProject);

        // update
        bodyProject.put("Content", "JSON Update");
        response=given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .body(bodyProject.toString())
                .log()
                .all().
                when()
                .put("https://todo.ly/api/projects/"+idProject+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")))
                .body("Icon", equalTo(6));

        // read
        response=given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .log()
                .all().
                when()
                .get("https://todo.ly/api/projects/"+idProject+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")))
                .body("Icon", equalTo(6));


        // delete
        response=given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .log()
                .all().
                when()
                .delete("https://todo.ly/api/projects/"+idProject+".json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")))
                .body("Deleted", equalTo(true))
                .body("Icon", equalTo(6));
    }


}
