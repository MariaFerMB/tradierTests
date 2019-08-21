package steps;

import cucumber.api.java.en.Then;
import entities.Quote;
import utils.Share;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertSteps {
    @Then("the page show the symbols that he ask")
    public void thePageShowTheSymbolsThatHeAsk(){
        List<Quote> quotes= Share.getShare("qoutes");
        List<Quote> quoteRespondes = Share.getShare("qoutesResponse");

        for (int i =0; i<quotes.size();i++)
        assertThat(quotes.get(i).getSymbol(), equalTo(quoteRespondes.get(i).getSymbol()));
    }
}
