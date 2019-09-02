package steps;

import cucumber.api.java.en.When;
import entities.options.OptionsResponse;
import entities.quotes.QuoteResponse;
import io.restassured.response.Response;
import utils.RequestBuilder;
import utils.ResponseHelper;

import java.io.IOException;

public class APISteps {

    private static final String MARKETS = "markets";
    private static final String WHACHLIST = "wachlist";

    @When("I request for ([^\"]*) symbols$")
    public  void theUserRequestForASymbols(String symbols)throws IOException {

        RequestBuilder requestBuilder = new RequestBuilder(MARKETS+"/quotes");
        requestBuilder.addParam("symbols",symbols);

        Response response = ResponseHelper.getResponse(requestBuilder.getRequestSpecification());
        ResponseHelper.map(response, QuoteResponse.class,"quotesResponds");

    }

    @When("I request for ([^\"]*) and the ([^\"]*) expiration chain")
    public void iRequestForASymbolAndTheExpirationDateChain(String symbol, String date) throws IOException {

        RequestBuilder requestBuilder = new RequestBuilder(MARKETS+"/options/chains");
        requestBuilder.addParam("symbol",symbol);
        requestBuilder.addParam("expiration",date);

        Response response = ResponseHelper.getResponse(requestBuilder.getRequestSpecification());
        ResponseHelper.map(response, OptionsResponse.class,"optionResponds");




    }
}
