package entities.chains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChainsResponse {

    @JsonProperty("options")
    private Chains chains;
}
