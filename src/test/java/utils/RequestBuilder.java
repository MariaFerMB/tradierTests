package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

    private RequestSpecBuilder requestSpecBuilder;

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    private RequestSpecification requestSpecification;

    public RequestBuilder(String basPath) {
        requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://sandbox.tradier.com/v1")
                .setAccept(ContentType.JSON)
                .setBasePath(basPath);
        requestSpecification =requestSpecBuilder.build();
    }
}
