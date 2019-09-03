package steps;

import cucumber.api.java.en.Then;
import entities.chains.Chain;
import entities.chains.ChainsResponse;
import entities.expirationDate.ExpirationDates;
import entities.expirationDate.ExpirationDateResponse;
import entities.quotes.Quote;
import entities.quotes.QuoteResponse;
import entities.strikes.Strikes;
import entities.strikes.StrikesResponse;
import utils.Share;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertSteps {
    @Then("the page show the quotes for the securities that I asked")
    public void thePageShowTheSymbolsThatHeAsk(){
        List<Quote> quotes= Share.getShare("quotes");
        List<Quote> quoteResponds = ((QuoteResponse)Share.getShare("quotesResponds")).getQuotes().getQuote();

        for (int i =0; i<quotes.size();i++)
        assertThat(quotes.get(i).getSymbol(), equalTo(quoteResponds.get(i).getSymbol()));
    }


    @Then("the page show the different options chain for the specific security symbol and expiration date")
    public void thePageShowTheDifferentOptionsChainForTheSpecificSecuritySymbolAndExpirationDate() {
        Chain chain = Share.getShare("optionChain");
        List<Chain> optionsResponds = ((ChainsResponse)Share.getShare("optionChainResponds")).getChains().getChain();
        for (Chain responds :optionsResponds){

            // funcion que compare las 2 cosas
            assertThat(responds.getRootSymbol(),equalTo(chain.getRootSymbol()));
            assertThat(responds.getExpirationDate(),equalTo(chain.getExpirationDate()));
        }
    }

    @Then("the page show the options strikes prices for the specific security symbol and expiration date")
    public void thePageShowTheOptionsStrikesPricesForTheSpecificSecuritySymbolAndExpirationDate() {
        Strikes strikes =((StrikesResponse)Share.getShare("optionsStrikesResponds")).getStrikes();
        for(Object strike:strikes.getStrike()){
            assertThat(strike,instanceOf(Double.TYPE));
        }
    }

    @Then("the page show expiration dates for the specific security symbol")
    public void thePageShowExpirationDatesForTheSpecificSecuritySymbol() {
        ExpirationDates expirationDates =((ExpirationDateResponse)Share.getShare("optionsExpirationDateResponds"))
                .getExpirationsDate();
        for(String expirationDate:expirationDates.getDate()){
            assertThat(expirationDate.split("-").length,is(3));
        }


    }
}
