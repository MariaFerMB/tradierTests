package utils;

import entities.Quote;

public class QuoteGenerator {

    public static  Quote generateQuote(String symbol){
        Quote quote = new Quote();
        quote.setSymbol(symbol);
        return quote;
    }
}
