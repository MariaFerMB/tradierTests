package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class ResponseHelper {

    public static Response getResponse(RequestSpecification requestSpecification, String param,String paramValue){


        Response response = given().header("Authorization", "Bearer "+ Share.getToken())
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

}
