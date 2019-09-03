package entities.expirationDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExpirationDateResponse {

    @JsonProperty("expirations")
    private ExpirationDates expirationsDate;

}
