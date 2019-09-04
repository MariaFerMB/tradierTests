package helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.Share;

import static io.restassured.RestAssured.given;


public class RequestBuilder {

    private RequestSpecification requestSpecification;

    public RequestBuilder(String basPath) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://sandbox.tradier.com/v1")
                .setAccept(ContentType.JSON)
                .setBasePath(basPath);
        requestSpecification = requestSpecBuilder.build();
    }


    public RequestBuilder addParam(String param, Object paramValue) {
        requestSpecification.queryParam(param, paramValue);
        return this;
    }

    private void init() {
        requestSpecification = given()
                .header("Authorization", "Bearer " + Share.token)
                .spec(requestSpecification);
    }

    public RequestSpecification getRequestSpecification() {
        init();
        return requestSpecification;
    }


}
