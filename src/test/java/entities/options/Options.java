package entities.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.quotes.Quote;
import lombok.Data;

import java.util.List;

@Data
public class Options {

    @JsonProperty("option")
    private List<Option> option;
}
