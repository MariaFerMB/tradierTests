package entities.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SecurityResponse {

    @JsonProperty("securities")
    private Securities securities;
}
