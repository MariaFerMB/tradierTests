package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import entities.chains.ChainsResponse;
import entities.quotes.QuoteResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RequestBuilder;
import utils.ResponseFactory;
import utils.ResponseHelper;

import java.io.IOException;

public class APISteps {

    private static final String MARKETS = "markets";
    private static final String WHACHLIST = "wachlist";

    @When("I request for ([^\"]*) symbols$")
    public  void theUserRequestForASymbols(String symbols)throws IOException {

        RequestSpecification requestSpecification = new RequestBuilder(MARKETS+"/quotes").
                addParam("symbols",symbols)
                .getRequestSpecification();

        Response response = ResponseFactory.getResponse("get",requestSpecification);
        ResponseHelper.map(response, QuoteResponse.class,"quotesResponds");

    }

    @When("I request for ([^\"]*) and the ([^\"]*) expiration chain")
    public void iRequestForASymbolAndTheExpirationDateChain(String symbol, String date) throws IOException {

        RequestSpecification requestSpecification = new RequestBuilder(MARKETS+"/chains/chains")
                .addParam("symbol",symbol)
                .addParam("expiration",date)
                .getRequestSpecification();

        Response response = ResponseHelper.buildGetResponse(requestSpecification);
        ResponseHelper.map(response, ChainsResponse.class,"optionResponds");




    }
}
