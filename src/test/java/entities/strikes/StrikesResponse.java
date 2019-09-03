package entities.strikes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StrikesResponse {

    @JsonProperty("strikes")
    private Strikes strikes;

}
