package entities.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Security {

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("exchange")
    private String exchange;

    @JsonProperty("type")
    private String type;

    @JsonProperty("description")
    private String description;

}
