package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class ResponseHelper {

    private static ObjectMapper mapper  = new ObjectMapper();

    public static Response getResponse(RequestSpecification requestSpecification, String param,String paramValue){
        Response response;
        response = given().header("Authorization", "Bearer "+ Share.token)
                .queryParam(param, paramValue)
                .spec(requestSpecification)
                .get()
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .response();
        return response;
    }

    public static void maper(Response response,Class clas, String key) throws IOException {
        Share.setShare(key,mapper.readValue(response.getBody().asString(), clas));

    }





}
