package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quotes {
    private String symbol;
    private String description;
    private String exch;
    private String type;
    private double last;
    private double change;
    private int volume;
    private double open;
    private double high;
    private double low;
    private String close;
    private double bid;
    private String ask;
    @JsonProperty("change_percentage")
    private double  changePercentage;
    @JsonProperty("average_volume")
    private int averageVolume;
    @JsonProperty("last_volume")
    private int lastVolume;
    @JsonProperty("trade_date")
    private int tradeDate;
    private double prevclose;
    @JsonProperty("week_52_high")
    private double week52High;
    @JsonProperty("week_52_low")
    private double week52Low;
    private int bidsize;
    private String bidexch;
    private int  bid_date;
    private int asksize;
    private String askexch;
    @JsonProperty("ask_date")
    private int askDate;
    @JsonProperty("root_symbols")
    private String rootSymbols;


}
