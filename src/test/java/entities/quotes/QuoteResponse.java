package entities.quotes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QuoteResponse {

    @JsonProperty("quotes")
    private Quotes quotes;
}
