package utils;

import entities.Quote;

public class QuoteGenerator {

    public static  Quote generateQoute(String symbol){
        Quote quote = new Quote();
        quote.setSymbol(symbol);
        return quote;
    }


}
