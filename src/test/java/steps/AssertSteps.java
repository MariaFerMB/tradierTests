package steps;

import cucumber.api.java.en.Then;
import entities.calendar.CalendarResponse;
import entities.calendar.MonthStatusMarket;
import entities.chains.Chain;
import entities.chains.ChainsResponse;
import entities.clock.Clock;
import entities.clock.ClockResponse;
import entities.expirationDate.ExpirationDates;
import entities.expirationDate.ExpirationDateResponse;
import entities.historicalPrice.HistoricalPrice;
import entities.historicalPrice.HistoricalPrices;
import entities.historicalPrice.HistoryResponse;
import entities.quotes.Quote;
import entities.quotes.QuoteResponse;
import entities.strikes.Strikes;
import entities.strikes.StrikesResponse;
import entities.timeSales.DataTime;
import entities.timeSales.TimeSale;
import entities.timeSales.TimeSalesResponse;
import utils.DateCompare;
import utils.Share;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertSteps {
    @Then("the page show the quotes for the securities that I asked")
    public void thePageShowTheSymbolsThatHeAsk() {
        List<Quote> quotes = Share.getShare("quotes");
        List<Quote> quoteResponds = ((QuoteResponse) Share.getShare("quotesResponds")).getQuotes().getQuote();

        for (int i = 0; i < quotes.size(); i++)
            assertThat(quotes.get(i).getSymbol(), equalTo(quoteResponds.get(i).getSymbol()));
    }

    @Then("the page show the different options chain for the specific security symbol and expiration date")
    public void thePageShowTheDifferentOptionsChainForTheSpecificSecuritySymbolAndExpirationDate() {
        Chain chain = Share.getShare("optionChain");
        List<Chain> optionsResponds = ((ChainsResponse) Share.getShare("optionChainResponds")).getChains().getChain();
        for (Chain responds : optionsResponds) {
            assertThat(responds.getRootSymbol(), equalTo(chain.getRootSymbol()));
            assertThat(responds.getExpirationDate(), equalTo(chain.getExpirationDate()));
        }
    }

    @Then("the page show the options strikes prices for the specific security symbol and expiration date")
    public void thePageShowTheOptionsStrikesPricesForTheSpecificSecuritySymbolAndExpirationDate() {
        Strikes strikes = ((StrikesResponse) Share.getShare("optionsStrikesResponds")).getStrikes();
        for (Object strike : strikes.getStrike()) {
            assertThat(strike, instanceOf(Double.TYPE));
        }
    }

    @Then("the page show expiration dates for the specific security symbol")
    public void thePageShowExpirationDatesForTheSpecificSecuritySymbol() {
        ExpirationDates expirationDates = ((ExpirationDateResponse) Share.getShare("optionsExpirationDateResponds"))
                .getExpirationsDate();
        for (String expirationDate : expirationDates.getDate()) {
            assertThat(DateCompare.isAfterOrEqual(expirationDate), is(true));
        }


    }

    @Then("the page show prices from past days")
    public void thePageShowPricesFromPastDays() {
        HistoricalPrices historicalPrices = ((HistoryResponse) Share.getShare("historicalPriceResponds"))
                .getHistory();
        for (HistoricalPrice historicalPrice : historicalPrices.getDay()) {
            assertThat(DateCompare.isBeforeOrEqual(historicalPrice.getDate()), is(true));
        }
    }

    @Then("the page show time and sales from current day")
    public void thePageShowPricesTimeAndSalesFromCurrentDay() {
        TimeSale timeSale = ((TimeSalesResponse) Share.getShare("timeSalesResponds"))
                .getSeries();
        for (DataTime dataTime : timeSale.getData()) {
            assertThat(DateCompare.isEqualForDateTime(dataTime.getTime()), is(true));
        }
    }

    @Then("the page show information about current date market status")
    public void thePageShowInformationAboutCurrentDateMarketStatus() {

        Clock clock = ((ClockResponse) Share.getShare("clockResponds")).getClock();
        assertThat(DateCompare.isEqual(clock.getDate()),is(true));
    }

    @Then("the page show market calendar about current month and year")
    public void thePageShowMarketCalendarAboutCurrentMonthAndYear() {
        LocalDate currentDate = LocalDate.now();

        MonthStatusMarket market = ((CalendarResponse) Share.getShare("calendarResponds")).getCalendar();
        assertThat(market.getYear(),is(currentDate.getYear()));
        assertThat(market.getMonth(),is(currentDate.getMonthValue()));
    }
}
