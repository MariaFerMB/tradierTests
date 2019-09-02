package entities.chains;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.BaseEntity;
import lombok.Data;

@Data
public class Chain extends BaseEntity {

    @JsonProperty("underlying")
    private String underlying;

    @JsonProperty("strike")
    private double strike;

    @JsonProperty("open_interest")
    private int openInterest;

    @JsonProperty("contract_size")
    private int contractSize;

    @JsonProperty("expiration_date")
    private String expirationDate;

    @JsonProperty("expiration_type")
    private String expirationType;

    @JsonProperty("option_type")
    private String optionType;

    @JsonProperty("root_symbol")
    protected String rootSymbol;


}
