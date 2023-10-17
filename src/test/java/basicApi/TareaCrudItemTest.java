package basicApi;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TareaCrudItemTest {

    @Test
    public void createUpdateReadDeleteItem(){
        JSONObject bodyProject = new JSONObject();
        bodyProject.put("Content", "Rene Rengel Item");

        Response response = given()
                .auth()
                .preemptive()
                .basic("r.rengel99@gmail.com", "renuc0pata")
                .body(bodyProject.toString())
                .log()
                .all()
                .when()
                .post("https://todo.ly/api/items.json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo("Rene Rengel Item"));



        int idItem = response.then().extract().path("Id");
        System.out.println("Id: " + idItem);

        // update
        bodyProject.put("Checked", true);
        response=given()
                .auth()
                .preemptive()
                .basic("r.rengel99@gmail.com", "renuc0pata")
                .body(bodyProject.toString())
                .log()
                .all().
                when()
                .put("https://todo.ly/api/items/"+idItem+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo("Rene Rengel Item"));


        // read
        response=given()
                .auth()
                .preemptive()
                .basic("r.rengel99@gmail.com", "renuc0pata")
                .log()
                .all().
                when()
                .get("https://todo.ly/api/items/"+idItem+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo("Rene Rengel Item"));



        // delete
        response=given()
                .auth()
                .preemptive()
                .basic("r.rengel99@gmail.com", "renuc0pata")
                .log()
                .all().
                when()
                .delete("https://todo.ly/api/items/"+idItem+".json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo("Rene Rengel Item"))
                .body("Deleted", equalTo(true));

    }
}
