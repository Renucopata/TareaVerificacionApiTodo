package exmenParcialDos;

import config.Configuration;
import factoryRequest.FactoryRequest;
import factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.json.JSONObject;

import org.junit.jupiter.api.Test;
import todoLyTest.TestBaseToken;


import java.util.Base64;

import static org.hamcrest.Matchers.equalTo;

public class Pregunta1Test {

    RequestInfo requestInfo = new RequestInfo();
    Response response;
    JSONObject body = new JSONObject();




    @Test
    public void verifyPregunta1()  {

        //Crear User

        body.clear();
        body.put("Email", "RenucoParcial@parcial.com");
        body.put("Password", "12345");
        body.put("FullName", "RenucoParcial");
        requestInfo.setUrl(Configuration.host+"api/user.json").setBody(body.toString());
        response = FactoryRequest.make("post").send(requestInfo);
        response.then()
                .log().all()
                .statusCode(200)
                .body("Email", equalTo(body.get("Email")))
                .body("FullName", equalTo(body.get("FullName")));

        // Get token

        String credential= "RenucoParcial@parcial.com:12345";
        requestInfo.setHeaders("Authorization","Basic "+ Base64.getEncoder().encodeToString(credential.getBytes()).toString());
        requestInfo.setUrl(Configuration.host + "/api/authentication/token.json");
        response = FactoryRequest.make("get").send(requestInfo);
        String token =response.then().extract().path("TokenString");

        response.then().log().all().body("TokenString", equalTo(token));



    }

}
