package steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.When;
import entities.Result;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RequestBuilder;
import utils.ResponseHelper;
import utils.Share;

import java.io.IOException;

public class APISteps {

    public static final String MARKETS = "markets";
    public static final String WHACHLIST = "wachlist";

    @When("the user request for ([^\"]*) symbols$")
    public  void theUserRequestForASymbols(String id)throws IOException {
        RequestBuilder requestBuilder = new RequestBuilder(MARKETS+"/quotes");

        RequestSpecification requestSpecification =requestBuilder.getRequestSpecification();
        Response response = ResponseHelper.getResponse(requestSpecification,"symbols", id);
        ResponseHelper.maper(response,Result.class,"quotesResponds");

//        ObjectMapper mapper2  = new ObjectMapper();
//        Result quotes = mapper2.readValue(response.getBody().asString(), Result.class);
//        Share.setShare("employeeResponse",quotes);
    }
}
