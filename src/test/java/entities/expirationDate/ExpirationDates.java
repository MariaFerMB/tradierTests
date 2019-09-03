package entities.expirationDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExpirationDates {

    @JsonProperty("date")
    private List<String> date;
}
