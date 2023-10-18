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
        body.put("Email", "userRenuco111@parcial.com");
        body.put("FullName", "usuario");
        body.put("Password", "PassW0rd");

        requestInfo.setUrl("https://todo.ly/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("FullName", equalTo(body.get("FullName")));

        int idUser1 = response.then().extract().path("Id");
        System.out.println("id es: " + idUser1);

        requestInfo.setUrl("https://todo.ly/api/user/"+idUser1+".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).body("Email", equalTo(body.get("Email")));


        body.clear();
        body.put("Email", "userRenuco222@parcial.com");
        body.put("FullName", "usuario");
        body.put("Password", "PassW0rd");

        requestInfo.setUrl("https://todo.ly/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("FullName", equalTo(body.get("FullName")));

        int idUser2 = response.then().extract().path("Id");
        System.out.println("id es: " + idUser2);

        requestInfo.setUrl("https://todo.ly/api/user/"+idUser2+".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).body("Email", equalTo(body.get("Email")));


        body.clear();
        body.put("Email", "userRenuco333@parcial.com");
        body.put("FullName", "usuario");
        body.put("Password", "PassW0rd");

        requestInfo.setUrl("https://todo.ly/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("FullName", equalTo(body.get("FullName")));

        int idUser3 = response.then().extract().path("Id");
        System.out.println("id es: " + idUser3);


        requestInfo.setUrl("https://todo.ly/api/user/"+idUser3+".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).body("Email", equalTo(body.get("Email")));


        body.clear();
        body.put("Email", "userRenuco444@parcial.com");
        body.put("FullName", "usuario");
        body.put("Password", "PassW0rd");

        requestInfo.setUrl("https://todo.ly/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("FullName", equalTo(body.get("FullName")));

        int idUser4 = response.then().extract().path("Id");
        System.out.println("id es: " + idUser4);


        requestInfo.setUrl("https://todo.ly/api/user/"+idUser4+".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).body("Email", equalTo(body.get("Email")));




    }


}
