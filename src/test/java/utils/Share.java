package utils;

import java.util.HashMap;
import java.util.Map;

public class Share {

    private static String token;
    private static ThreadLocal<Map<String,Object>> shareMaps = ThreadLocal.withInitial(HashMap::new);

    public Share(){

    }

    public static String getToken() {
        if(token==null){
             token = new ReadAuthenticationToken().readToken();
        }
        return token;
    }
    public static void setShare(String key, Object value){
        ((Map)shareMaps.get()).put(key, value);
    }
}
