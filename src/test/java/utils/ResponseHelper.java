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

    public static Response buildGetResponse(RequestSpecification requestSpecification){
        Response response= requestSpecification
                .get();
        response =getResponse(response);
        return response;
    }


    public static Response buildPostResponse(RequestSpecification requestSpecification){
        Response response = requestSpecification
                .post();
        response =getResponse(response);
        return response;
    }

    public static Response buildPutResponse(RequestSpecification requestSpecification){
        Response response = requestSpecification
                .put();
        response =getResponse(response);
        return response;
    }

    public static Response buildDeleteResponse(RequestSpecification requestSpecification){
        Response response = requestSpecification
                .delete();
        response =getResponse(response);
        return response;
    }

    private static Response getResponse(Response response){
        return response
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .response();
    }





    public static void map(Response response,Class entity, String key) throws IOException {
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
        String x = response.getBody().asString();
        Share.setShare(key,mapper.readValue(response.getBody().asString(), entity));

    }





}
