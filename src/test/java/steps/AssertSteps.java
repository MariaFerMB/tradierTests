package steps;

import cucumber.api.java.en.Then;
import entities.options.Option;
import entities.options.OptionsResponse;
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

    @Then("the page show the different options chain for the")
    public void thePageShowTheDifferentOptionsChainForThe() {
        Option option = Share.getShare("option");
        List<Option> optionsResponds = ((OptionsResponse)Share.getShare("optionResponds")).getOptions().getOption();
        for (Option responds :optionsResponds){

            // funcion que compare las 2 cosas
            assertThat(responds.getRootSymbol(),equalTo(option.getRootSymbol()));
            assertThat(responds.getExpirationDate(),equalTo(option.getExpirationDate()));
        }

    }
}
