package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseEntity {

    @JsonProperty("volume")
    protected long volume;
    @JsonProperty("open")
    protected double open;
    @JsonProperty("high")
    protected double high;
    @JsonProperty("low")
    protected double low;
    @JsonProperty("close")
    protected String close;


}
