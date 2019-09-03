package entities.timeSales;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.BaseEntity;
import lombok.Data;

@Data
public class DataTime extends BaseEntity {

    @JsonProperty("time")
    private String time;
    @JsonProperty("timestamp")
    private long timestamp;
    @JsonProperty("price")
    private double price;
    @JsonProperty("vwap")
    private double vwap;

}
