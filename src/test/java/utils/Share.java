package utils;

import java.util.HashMap;
import java.util.Map;

public class Share {

    static String token;
    private static ThreadLocal<Map<String,Object>> shareMaps = ThreadLocal.withInitial(HashMap::new);


    public static void setToken(){
        if(token==null){
            token = ReadAuthenticationToken.readToken();
        }
    }
    public static void setShare(String key, Object value){
        ((Map)shareMaps.get()).put(key, value);
    }

    public static <T>T getShare(String key){
        return (T)((Map)shareMaps.get()).get(key);
    }
}
