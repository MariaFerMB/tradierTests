package entities.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Securities {

    @JsonProperty("security")
    private List<Security> security;
}
