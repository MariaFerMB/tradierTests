package entities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CalendarResponse {

    @JsonProperty("calendar")
    private MonthStatusMarket calendar;
}
