package entities;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Result {

    @JsonProperty("quotes")
    private Quotes quotes;

    public Quotes getQuotes() {
        return quotes;
    }
}
