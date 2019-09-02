package steps;

import cucumber.api.java.en.Then;
import entities.Quote;
import entities.QuoteResponse;
import utils.Share;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertSteps {
    @Then("the page show the symbols that he ask")
    public void thePageShowTheSymbolsThatHeAsk(){
        List<Quote> quotes= Share.getShare("quotes");
        List<Quote> quoteResponds = ((QuoteResponse)Share.getShare("quotesResponds")).getQuotes().getQuote();

        for (int i =0; i<quotes.size();i++)
        assertThat(quotes.get(i).getSymbol(), equalTo(quoteResponds.get(i).getSymbol()));
    }
}
