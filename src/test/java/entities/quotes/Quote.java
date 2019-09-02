package entities.quotes;


import com.fasterxml.jackson.annotation.JsonProperty;
import entities.BaseEntity;
import lombok.Data;

@Data
public class Quote extends BaseEntity {

    @JsonProperty("root_symbols")
    protected String rootSymbols;



}
