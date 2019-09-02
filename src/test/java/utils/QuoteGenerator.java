package utils;

import entities.chains.Chain;
import entities.quotes.Quote;

public class QuoteGenerator {

    public static  Quote generateQuote(String symbol){
        Quote quote = new Quote();
        quote.setSymbol(symbol);
        return quote;
    }

    public static Chain generateOption(String symbol, String expirationDate){
        Chain chain = new Chain();
        chain.setRootSymbol(symbol);
        chain.setExpirationDate(expirationDate);
        return chain;
    }



}
