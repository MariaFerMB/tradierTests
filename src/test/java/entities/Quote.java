package entities;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Quote {
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("description")
    private String description;
    @JsonProperty("exch")
    private String exch;
    @JsonProperty("type")
    private String type;
    @JsonProperty("last")
    private double last;
    @JsonProperty("change")
    private double change;
    @JsonProperty("volume")
    private long volume;
    @JsonProperty("open")
    private double open;
    @JsonProperty("high")
    private double high;
    @JsonProperty("low")
    private double low;
    @JsonProperty("close")
    private String close;
    @JsonProperty("bid")
    private double bid;
    @JsonProperty("ask")
    private double ask;
    @JsonProperty("change_percentage")
    private double  changePercentage;
    @JsonProperty("average_volume")
    private long averageVolume;
    @JsonProperty("last_volume")
    private long lastVolume;
    @JsonProperty("trade_date")
    private long tradeDate;
    @JsonProperty("prevclose")
    private double prevclose;
    @JsonProperty("week_52_high")
    private double week52High;
    @JsonProperty("week_52_low")
    private double week52Low;
    @JsonProperty("bidsize")
    private long bidsize;
    @JsonProperty("bidexch")
    private String bidexch;
    @JsonProperty("bid_date")
    private long  bidDate;
    @JsonProperty("asksize")
    private long asksize;
    @JsonProperty("askexch")
    private String askexch;
    @JsonProperty("ask_date")
    private long askDate;
    @JsonProperty("root_symbols")
    private String rootSymbols;



}
