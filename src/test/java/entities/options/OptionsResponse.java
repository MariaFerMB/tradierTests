package entities.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.quotes.Quotes;
import lombok.Data;

@Data
public class OptionsResponse {

    @JsonProperty("options")
    private Options options;
}
