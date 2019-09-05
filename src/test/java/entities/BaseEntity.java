package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseEntity {

    @JsonProperty("volume")
    protected long volume;
    @JsonProperty("high")
    protected double high;
    @JsonProperty("low")
    protected double low;
    @JsonProperty("open")
    protected double open;
    @JsonProperty("close")
    protected String close;

}
