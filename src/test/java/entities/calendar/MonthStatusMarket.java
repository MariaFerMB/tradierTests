package entities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MonthStatusMarket {

    @JsonProperty("month")
    protected int month;
    @JsonProperty("year")
    protected int year;
    @JsonProperty("days")
    protected DaysStatusMarket days;


}
