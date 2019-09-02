package utils;

import entities.options.Option;
import entities.quotes.Quote;

public class QuoteGenerator {

    public static  Quote generateQuote(String symbol){
        Quote quote = new Quote();
        quote.setSymbol(symbol);
        return quote;
    }

    public static Option generateOption(String symbol, String expirationDate){
        Option option = new Option();
        option.setRootSymbol(symbol);
        option.setExpirationDate(expirationDate);
        return option;
    }



}
