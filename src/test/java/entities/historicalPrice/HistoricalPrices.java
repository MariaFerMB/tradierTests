package entities.historicalPrice;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.chains.Chain;
import lombok.Data;

import java.util.List;

@Data
public class HistoricalPrices {

    @JsonProperty("day")
    private List<HistoricalPrice> day;


}
