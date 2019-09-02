package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class RequestBuilder {

    private RequestSpecification requestSpecification;

    public RequestBuilder(String basPath) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://sandbox.tradier.com/v1")
                .setAccept(ContentType.JSON)
                .setBasePath(basPath);
        requestSpecification =requestSpecBuilder.build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
    public void addParam(String param, Object paramValue){
        requestSpecification.queryParam(param,paramValue);
    }






}
