package entities.historicalPrice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HistoricalPrices {

    @JsonProperty("day")
    private List<HistoricalPrice> day;


}
