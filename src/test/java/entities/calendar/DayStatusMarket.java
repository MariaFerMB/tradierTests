package entities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DayStatusMarket {

    @JsonProperty("date")
    protected String date;
    @JsonProperty("status")
    protected String status;
    @JsonProperty("description")
    protected String description;

    @JsonProperty("premarket")
    protected RangeTime preMarket;
    @JsonProperty("open")
    protected RangeTime open;
    @JsonProperty("postmarket")
    protected RangeTime postMarket;

}
