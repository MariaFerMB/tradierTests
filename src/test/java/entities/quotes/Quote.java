package entities.quotes;


import com.fasterxml.jackson.annotation.JsonProperty;
import entities.BaseQuoteEntity;
import lombok.Data;

@Data
public class Quote extends BaseQuoteEntity {

    @JsonProperty("root_symbols")
    protected String rootSymbols;



}
