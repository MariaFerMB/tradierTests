package entities;

import com.fasterxml.jackson.annotation.JsonProperty;


public class QuoteResponse {

    @JsonProperty("quotes")
    private Quotes quotes;

    public Quotes getQuotes() {
        return quotes;
    }
}
