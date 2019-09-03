package entities.timeSales;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class TimeSalesResponse {

    @JsonProperty("series")
    private TimeSale series;

}
