package utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.IOException;

public class EntityMapper {
    private static final ObjectMapper mapper  = new ObjectMapper();

    public static void map(Response response, Class entity, String key){
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
        try {
            String x = response.getBody().asString();
            Share.setShare(key,mapper.readValue(response.getBody().asString(), entity));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
