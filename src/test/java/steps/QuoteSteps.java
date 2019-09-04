package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import entities.chains.Chain;
import entities.quotes.Quote;
import utils.EntityGenerator;
import utils.Share;

import java.util.ArrayList;
import java.util.List;

public class QuoteSteps {


    @Given("I have a quote of ([^\"]*) securities$")
    public void iHaveAQuoteOfASymbols(String symbols) {
        String[] symbolsArray = symbols.split(",");
        List<Quote> quotes = new ArrayList<>();
        for (String symbol : symbolsArray) {
            Quote quote = EntityGenerator.generateQuote(symbol);
            quotes.add(quote);
        }
        Share.setShare("quotes", quotes);
    }


    @And("I have a option chain of ([^\"]*) with expiration date: ([^\"]*)")
    public void iHaveAOptionChainOfSymbolWithExpirationDateDate(String symbol, String date) {
        Chain chain = EntityGenerator.generateChainOption(symbol, date);
        Share.setShare("optionChain", chain);
    }
}
