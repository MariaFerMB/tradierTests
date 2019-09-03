package entities.strikes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Strikes {

    @JsonProperty("strike")
    private List strike;
}
