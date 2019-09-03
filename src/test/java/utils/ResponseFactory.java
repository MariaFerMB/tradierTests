package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseFactory {

    public static Response getResponse(String type,RequestSpecification requestSpecification){
        Response response =null;
        switch (type) {
            case "get":
                 response =ResponseHelper.buildGetResponse(requestSpecification);
                break;
            case "post":
                response =ResponseHelper.buildPostResponse(requestSpecification);
                break;
            case "put":
                response =ResponseHelper.buildPutResponse(requestSpecification);
                break;
            case "delete":
                response =ResponseHelper.buildDeleteResponse(requestSpecification);
                break;
        }
        return response;

    }




}
