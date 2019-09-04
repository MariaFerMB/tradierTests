package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.apache.http.HttpStatus.SC_OK;

 class ResponseHelper {

    static Response buildGetResponse(RequestSpecification requestSpecification,int statusCode){
        Response response= requestSpecification
                .get();
        response =getResponse(response,statusCode);
        return response;
    }


    static Response buildPostResponse(RequestSpecification requestSpecification,int statusCode){
        Response response = requestSpecification
                .post();
        response =getResponse(response,statusCode);
        return response;
    }

    static Response buildPutResponse(RequestSpecification requestSpecification,int statusCode){
        Response response = requestSpecification
                .put();
        response =getResponse(response,statusCode);
        return response;
    }

    static Response buildDeleteResponse(RequestSpecification requestSpecification,int statusCode){
        Response response = requestSpecification
                .delete();
        response =getResponse(response,statusCode);
        return response;
    }

    private static Response getResponse(Response response,int statusCode){
        return response
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .response();
    }
}
