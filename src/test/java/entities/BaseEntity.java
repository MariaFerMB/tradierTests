package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseEntity {

    @JsonProperty("symbol")
    protected String symbol;
    @JsonProperty("description")
    protected String description;
    @JsonProperty("exch")
    protected String exch;
    @JsonProperty("type")
    protected String type;
    @JsonProperty("last")
    protected double last;
    @JsonProperty("change")
    protected double change;
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
    @JsonProperty("bid")
    protected double bid;
    @JsonProperty("ask")
    protected double ask;
    @JsonProperty("change_percentage")
    protected double  changePercentage;
    @JsonProperty("average_volume")
    protected long averageVolume;
    @JsonProperty("last_volume")
    protected long lastVolume;
    @JsonProperty("trade_date")
    protected long tradeDate;
    @JsonProperty("prevclose")
    protected double prevClose;
    @JsonProperty("week_52_high")
    protected double week52High;
    @JsonProperty("week_52_low")
    protected double week52Low;
    @JsonProperty("bidsize")
    protected int bidSize;
    @JsonProperty("bidexch")
    protected String bidExch;
    @JsonProperty("bid_date")
    protected long  bidDate;
    @JsonProperty("asksize")
    protected int askSize;
    @JsonProperty("askexch")
    protected String askExch;
    @JsonProperty("ask_date")
    protected long askDate;

}
