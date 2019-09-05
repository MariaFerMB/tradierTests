package entities.quotes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Quotes {

    @JsonProperty("quote")
    private List<Quote> quote;
}
