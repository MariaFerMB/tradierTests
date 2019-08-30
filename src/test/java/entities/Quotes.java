package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Quotes {

    @JsonProperty("quote")
    private List<Quote> quote;

    public List<Quote> getQuote() {
        return quote;
    }
}
