package entities.clock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClockResponse {

    @JsonProperty("clock")
    private Clock clock;
}
