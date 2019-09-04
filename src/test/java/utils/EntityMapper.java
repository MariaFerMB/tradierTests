package utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.IOException;

public class EntityMapper {
    private static ObjectMapper mapper  = new ObjectMapper();

    public static void map(Response response, Class entity, String key) throws IOException {
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
        String x = response.getBody().asString();
        Share.setShare(key,mapper.readValue(response.getBody().asString(), entity));
    }
}
