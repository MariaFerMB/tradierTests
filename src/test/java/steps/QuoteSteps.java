package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import entities.quotes.Quote;
import utils.QuoteGenerator;
import utils.Share;

import java.util.ArrayList;
import java.util.List;

public class QuoteSteps {


    @Given("I have a quote of ([^\"]*)$")
    public  void iHaveAQuoteOfASymbols(String symbols){
        String[] symbolsArray = symbols.split(",");
        List<Quote> quotes = new ArrayList<>();
        for (String symbol: symbolsArray){
            Quote quote = QuoteGenerator.generateQuote(symbol);
            quotes.add(quote);
        }
        Share.setShare("quotes",quotes);
    }

    @And("I have a chain chain of ([^\"]*) with expiration date: ([^\"]*)")
    public void iHaveAOptionChainOfAAPL(String symbol, String expirationData) {

        Share.setShare("chain",QuoteGenerator.generateOption(symbol,expirationData));

    }
}
