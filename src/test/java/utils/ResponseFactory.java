package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseFactory {

    public static Response getResponse(String type,RequestSpecification requestSpecification, int statusCode){
        Response response =null;
        switch (type) {
            case "get":
                 response =ResponseHelper.buildGetResponse(requestSpecification,statusCode);
                break;
            case "post":
                response =ResponseHelper.buildPostResponse(requestSpecification,statusCode);
                break;
            case "put":
                response =ResponseHelper.buildPutResponse(requestSpecification,statusCode);
                break;
            case "delete":
                response =ResponseHelper.buildDeleteResponse(requestSpecification,statusCode);
                break;
        }
        return response;

    }

}
