package utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class ResponseHelper {

    private static ObjectMapper mapper  = new ObjectMapper();

    public static Response getResponse(RequestSpecification requestSpecification){
        Response response;
        response = given().header("Authorization", "Bearer "+ Share.token)
                .spec(requestSpecification)
                .get()
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .response();

        return response;
    }


    public static void map(Response response,Class entity, String key) throws IOException {
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
        String x = response.getBody().asString();
        Share.setShare(key,mapper.readValue(response.getBody().asString(), entity));

    }





}
