package entities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RangeTime {

    @JsonProperty("start")
    protected String start;
    @JsonProperty("end")
    protected String end;
}
