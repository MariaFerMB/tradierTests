package steps;

import cucumber.api.java.en.When;
import entities.QuoteResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RequestBuilder;
import utils.ResponseHelper;

import java.io.IOException;

public class APISteps {

    private static final String MARKETS = "markets";
    private static final String WHACHLIST = "wachlist";

    @When("I request for ([^\"]*) symbols$")
    public  void theUserRequestForASymbols(String id)throws IOException {
        RequestBuilder requestBuilder = new RequestBuilder(MARKETS+"/quotes");

        RequestSpecification requestSpecification =requestBuilder.getRequestSpecification();
        Response response = ResponseHelper.getResponse(requestSpecification,"symbols", id);
        ResponseHelper.maper(response, QuoteResponse.class,"quotesResponds");

//        ObjectMapper mapper2  = new ObjectMapper();
//        QuoteResponse quotes = mapper2.readValue(response.getBody().asString(), QuoteResponse.class);
//        Share.setShare("employeeResponse",quotes);
    }
}
