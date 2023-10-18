package practice;

import factoryRequest.FactoryRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import todoLyTest.TestBase;
import todoLyTest.TestBaseToken;

import static org.hamcrest.Matchers.equalTo;

public class UserTest extends TestBaseToken {

    @Test
    public void createUser(){
        JSONObject body = new JSONObject();
        body.put("Email", "userRenuco1@user.com");
        body.put("FullName", "usuario");
        body.put("Password", "PassW0rd");

        requestInfo.setUrl("https://todo.ly/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("FullName", equalTo(body.get("FullName")));

        int idUser = response.then().extract().path("Id");
        System.out.println("id es: " + idUser);
    }
    @Test
    public void createProject(){
       // re
    }


}
