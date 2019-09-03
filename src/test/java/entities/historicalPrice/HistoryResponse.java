package entities.historicalPrice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HistoryResponse {

    @JsonProperty("history")
    private HistoricalPrices history;
}
