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
        List<Quote> qoutes= Share.getShare("qoutes");
        List<Quote> quoteRespondes = Share.getShare("qoutesResponse");
        assertThat(qoutes.get(0).getSymbol(), equalTo(quoteRespondes.get(0).getSymbol()));

    }


}
