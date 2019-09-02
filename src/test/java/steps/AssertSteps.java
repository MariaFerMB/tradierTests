package steps;

import cucumber.api.java.en.Then;
import entities.chains.Chain;
import entities.chains.ChainsResponse;
import entities.quotes.Quote;
import entities.quotes.QuoteResponse;
import utils.Share;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertSteps {
    @Then("the page show the symbols that I ask")
    public void thePageShowTheSymbolsThatHeAsk(){
        List<Quote> quotes= Share.getShare("quotes");
        List<Quote> quoteResponds = ((QuoteResponse)Share.getShare("quotesResponds")).getQuotes().getQuote();

        for (int i =0; i<quotes.size();i++)
        assertThat(quotes.get(i).getSymbol(), equalTo(quoteResponds.get(i).getSymbol()));
    }

    @Then("the page show the different chains chain for the")
    public void thePageShowTheDifferentOptionsChainForThe() {
        Chain chain = Share.getShare("chain");
        List<Chain> optionsResponds = ((ChainsResponse)Share.getShare("optionResponds")).getChains().getChain();
        for (Chain responds :optionsResponds){

            // funcion que compare las 2 cosas
            assertThat(responds.getRootSymbol(),equalTo(chain.getRootSymbol()));
            assertThat(responds.getExpirationDate(),equalTo(chain.getExpirationDate()));
        }

    }
}
