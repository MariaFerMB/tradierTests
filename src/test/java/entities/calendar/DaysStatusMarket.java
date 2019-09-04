package entities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DaysStatusMarket {

    @JsonProperty("day")
    private List<DayStatusMarket> day;

}
