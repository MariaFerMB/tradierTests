package entities.strikes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StrikesResponse {

    @JsonProperty("strikes")
    private Strikes strikes;

}
