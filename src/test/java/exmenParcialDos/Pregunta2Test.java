package exmenParcialDos;

import factoryRequest.FactoryRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import todoLyTest.TestBase;

import static org.hamcrest.Matchers.equalTo;

public class Pregunta2Test extends TestBase {

    @Test
    public void createUsers(){
        JSONObject body = new JSONObject();
        body.put("Email", "userRenuco1@parcial.com");
        body.put("FullName", "usuario");
        body.put("Password", "PassW0rd");

        requestInfo.setUrl("https://todo.ly/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("FullName", equalTo(body.get("FullName")));

        int idUser1 = response.then().extract().path("Id");
        System.out.println("id es: " + idUser1);

        JSONObject body = new JSONObject();
        body.put("Email", "userRenuco2@parcial.com");
        body.put("FullName", "usuario");
        body.put("Password", "PassW0rd");

        requestInfo.setUrl("https://todo.ly/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("FullName", equalTo(body.get("FullName")));

        int idUser2 = response.then().extract().path("Id");
        System.out.println("id es: " + idUser2);


        JSONObject body = new JSONObject();
        body.put("Email", "userRenuco3@parcial.com");
        body.put("FullName", "usuario");
        body.put("Password", "PassW0rd");

        requestInfo.setUrl("https://todo.ly/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("FullName", equalTo(body.get("FullName")));

        int idUser3 = response.then().extract().path("Id");
        System.out.println("id es: " + idUser3);


        JSONObject body = new JSONObject();
        body.put("Email", "userRenuco4@parcial.com");
        body.put("FullName", "usuario");
        body.put("Password", "PassW0rd");

        requestInfo.setUrl("https://todo.ly/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("FullName", equalTo(body.get("FullName")));

        int idUser4 = response.then().extract().path("Id");
        System.out.println("id es: " + idUser4);






    }
}
