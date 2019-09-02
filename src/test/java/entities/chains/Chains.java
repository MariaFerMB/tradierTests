package entities.chains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Chains {

    @JsonProperty("chain")
    private List<Chain> chain;
}
