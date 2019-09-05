package steps;

import cucumber.api.java.en.When;
import entities.calendar.CalendarResponse;
import entities.chains.ChainsResponse;
import entities.clock.ClockResponse;
import entities.expirationDate.ExpirationDateResponse;
import entities.historicalPrice.HistoryResponse;
import entities.quotes.QuoteResponse;
import entities.security.SecurityResponse;
import entities.strikes.StrikesResponse;
import entities.timeSales.TimeSalesResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.EntityMapper;
import helpers.RequestBuilder;
import utils.ResponseFactory;
import utils.Share;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;

public class APISteps {

    private static final String MARKETS = "markets/";
    private static final String MARKETS_QUOTES = MARKETS + "quotes";
    private static final String MARKETS_OPTIONS_CHAINS = MARKETS + "options/chains";
    private static final String MARKETS_OPTIONS_STRIKES = MARKETS + "options/strikes";
    private static final String MARKETS_OPTIONS_EXPIRATIONS = MARKETS + "options/expirations";
    private static final String MARKETS_HISTORY = MARKETS + "history";
    private static final String MARKETS_TIME_SALES = MARKETS + "timesales";
    private static final String MARKETS_CLOCK = MARKETS + "clock";
    private static final String MARKETS_CALENDAR = MARKETS + "calendar";
    private static final String MARKETS_SEARCH = MARKETS + "search";
    private static final String MARKETS_LOOKUP = MARKETS + "lookup";

    @When("I request for the quotes that have ([^\"]*) symbols$")
    public void theUserRequestForASymbols(String symbols) {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_QUOTES)
                .addParam("symbols", symbols)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, QuoteResponse.class, "quotesResponds");
    }

    @When("I request for quotes without symbols parameter")
    public void iRequestForQuotesWithoutSymbolsParameter() {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_QUOTES)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_BAD_REQUEST);
        Share.setShare("invalidQuotesResponse", response.getBody().asString());

    }

    @When("I request for the option chain of ([^\"]*) and the ([^\"]*) as expiration date")
    public void iRequestForASymbolAndTheExpirationDateChain(String symbol, String date) {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_OPTIONS_CHAINS)
                .addParam("symbol", symbol)
                .addParam("expiration", date)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, ChainsResponse.class, "optionChainResponds");
    }

    @When("I request for the options strikes of ([^\"]*) and the ([^\"]*) as expiration chain")
    public void iRequestForTheOptionsStrikesOfSymbolAndTheDateExpirationChain(String symbol, String date) {

        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_OPTIONS_STRIKES)
                .addParam("symbol", symbol)
                .addParam("expiration", date)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, StrikesResponse.class, "optionsStrikesResponds");
    }

    @When("I request for the expiration dates of ([^\"]*)")
    public void iRequestForTheExpirationDatesOfSymbol(String symbol) {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_OPTIONS_EXPIRATIONS)
                .addParam("symbol", symbol)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, ExpirationDateResponse.class, "optionsExpirationDateResponds");
    }

    @When("I request for the historical pricing of ([^\"]*) security")
    public void iRequestForTheHistoricalPricingOfSymbolSecurity(String symbol) {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_HISTORY)
                .addParam("symbol", symbol)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, HistoryResponse.class, "historicalPriceResponds");
    }

    @When("I request for the historical pricing with ([^\"]*) as start date and ([^\"]*) as end date of ([^\"]*) security")
    public void requestForTheHistoricalPricingWithStartAndAsEndDateOfSecurity(String startDate, String endDate, String symbol) {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_HISTORY)
                .addParam("symbol", symbol)
                .addParam("start", startDate)
                .addParam("end", endDate)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, HistoryResponse.class, "intervalHistoricalPriceResponds");
    }

    @When("I request for the time and sales of ([^\"]*) security")
    public void iRequestForTheTimeAndSalesOfSymbolSecurity(String symbol) {

        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_TIME_SALES)
                .addParam("symbol", symbol)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, TimeSalesResponse.class, "timeSalesResponds");
    }

    @When("I request for the clock")
    public void iRequestForTheClock() {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_CLOCK)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, ClockResponse.class, "clockResponds");
    }

    @When("I request for the market calendar")
    public void iRequestForTheMarketCalendar() {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_CALENDAR)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, CalendarResponse.class, "calendarResponds");
    }

    @When("I request for the market calendar with {int} as month and {int} as year")
    public void iRequestForTheMarketCalendarWithAsMonthAndAsYear(int month, int year) {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_CALENDAR)
                .addParam("month", month)
                .addParam("year", year)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, CalendarResponse.class, "specificCalendarResponds");
    }

    @When("I request for the securities using the key word: ([^\"]*) for the description")
    public void iRequestForTheSecuritiesUsingTheKeyWord(String keyWord) {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_SEARCH)
                .addParam("q", keyWord)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, SecurityResponse.class, "securityDescriptionResponds");
    }

    @When("I request for the securities using the key word: ([^\"]*) for the symbol")
    public void iRequestForTheSecuritiesUsingTheKeyWordAlphabetForTheSymbol(String keyWord) {
        RequestSpecification requestSpecification = new RequestBuilder(MARKETS_LOOKUP)
                .addParam("q", keyWord)
                .buildRequestSpecification();

        Response response = ResponseFactory.getResponse("get", requestSpecification, SC_OK);
        EntityMapper.map(response, SecurityResponse.class, "securitySymbolResponds");
    }


}
