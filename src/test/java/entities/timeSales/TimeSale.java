package entities.timeSales;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TimeSale {

    @JsonProperty("data")
    private List<DataTime> data;


}
