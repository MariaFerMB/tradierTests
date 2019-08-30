package steps;

import cucumber.api.java.en.Given;
import entities.Quote;
import utils.QuoteGenerator;
import utils.Share;

import java.util.ArrayList;
import java.util.List;

public class QuoteSteps {


    @Given("I have a quote of ([^\"]*) symbols$")
    public  void iHaveAQuoteOfASymbols(String arg){
        String[] symbols = arg.split(",");
        List<Quote> quotes = new ArrayList<>();
        for (String symbol: symbols){
            Quote quote = QuoteGenerator.generateQuote(symbol);
            quotes.add(quote);
        }
        Share.setShare("quotes",quotes);

    }
}
