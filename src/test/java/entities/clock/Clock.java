package entities.clock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Clock {
    @JsonProperty("date")
    protected String date;
    @JsonProperty("description")
    protected String description;
    @JsonProperty("state")
    protected String state;
    @JsonProperty("timestamp")
    protected long timestamp;
    @JsonProperty("next_change")
    protected String nextChange;
    @JsonProperty("next_state")
    protected String nextState;

}
