package steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.When;
import entities.Quotes;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RequestBuilder;
import utils.Share;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class APISteps {

    @When("the user request for ([^\"]*) symbols$")
    public  void theUserRequestForASymbols(String id)throws IOException {
        RequestBuilder requestBuilder = new RequestBuilder("markets/quotes");
        RequestSpecification requestSpecification =requestBuilder.getRequestSpecification();
        Response response = given().header("Authorization", "Bearer "+ Share.getToken())
                .queryParam("symbols", id)
                .spec(requestSpecification)
                .get()
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .response();
        ObjectMapper mapper = new ObjectMapper();
       //TypeReference<List<Quotes>> typeReference = new TypeReference<List<Quotes>>() {};
        //List<Quotes> quotes= mapper.readValue(response.getBody().asString(), typeReference);
       // Share.setShare("employeeResponse", quotes.get(0));

    }
}
