package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class RequestBuilder {

    private RequestSpecBuilder requestSpecification;

    public RequestBuilder(String basPath) {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://sandbox.tradier.com/v1/")
                .setAccept(ContentType.JSON)
                .setBasePath(basPath);
    }

    public  RequestBuilder request(String baseUri,String basePath) throws IOException {

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setAccept(ContentType.JSON)
                .setBasePath(basePath)
                .build();

        return this;
    }

}
