package steps;

import cucumber.api.java.en.When;
import entities.chains.ChainsResponse;
import entities.expirationDate.ExpirationDateResponse;
import entities.historicalPrice.HistoryResponse;
import entities.quotes.QuoteResponse;
import entities.strikes.StrikesResponse;
import entities.timeSales.TimeSalesResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.EntityMapper;
import helpers.RequestBuilder;
import utils.ResponseFactory;

import java.io.IOException;

import static org.apache.http.HttpStatus.SC_OK;

public class APISteps {

    private static final String MARKETS_QUOTES = "markets/quotes";
    private static final String MARKETS_OPTIONS_CHAINS = "markets/options/chains";
    private static final String MARKETS_OPTIONS_STRIKES = "markets/options/strikes";
    private static final String MARKETS_OPTIONS_EXPIRATIONS = "markets/options/expirations";
    private static final String MARKETS_HISTORY = "markets/history";
    private static final String MARKETS_MARKETS_TIME_SALES = "markets/timesales";

    @When("I request for ([^\"]*) symbols$")
    public void theUserRequestForASymbols(String symbols) throws IOException {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_QUOTES)
                .addParam("symbols", symbols)
                .getRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, QuoteResponse.class, "quotesResponds");
    }

    @When("I request for the option chain of ([^\"]*) and the ([^\"]*) as expiration date")
    public void iRequestForASymbolAndTheExpirationDateChain(String symbol, String date) throws IOException {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_OPTIONS_CHAINS)
                .addParam("symbol", symbol)
                .addParam("expiration", date)
                .getRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, ChainsResponse.class, "optionChainResponds");
    }

    @When("I request for the options strikes of ([^\"]*) and the ([^\"]*) as expiration chain")
    public void iRequestForTheOptionsStrikesOfSymbolAndTheDateExpirationChain(String symbol, String date) throws IOException {

        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_OPTIONS_STRIKES)
                .addParam("symbol", symbol)
                .addParam("expiration", date)
                .getRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, StrikesResponse.class, "optionsStrikesResponds");
    }

    @When("I request for the expiration dates of ([^\"]*)")
    public void iRequestForTheExpirationDatesOfSymbol(String symbol) throws IOException {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_OPTIONS_EXPIRATIONS)
                .addParam("symbol", symbol)
                .getRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, ExpirationDateResponse.class, "optionsExpirationDateResponds");
    }

    @When("I request for the historical pricing of ([^\"]*) security")
    public void iRequestForTheHistoricalPricingOfSymbolSecurity(String symbol) throws IOException {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_HISTORY)
                .addParam("symbol", symbol)
                .getRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, HistoryResponse.class, "historicalPriceResponds");
    }

    @When("I request for the time and sales of ([^\"]*) security")
    public void iRequestForTheTimeAndSalesOfSymbolSecurity(String symbol) throws IOException {

        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_MARKETS_TIME_SALES)
                .addParam("symbol", symbol)
                .getRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, TimeSalesResponse.class, "timeSalesResponds");
    }
}
