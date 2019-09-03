package entities.historicalPrice;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.BaseEntity;
import lombok.Data;

@Data
public class HistoricalPrice extends BaseEntity {

    @JsonProperty("date")
    protected String date;

}
