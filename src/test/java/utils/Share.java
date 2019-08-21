package utils;

public class Share {

    private static String token;

    public Share(){

    }

    public static String getToken() {
        if(token==null){
             token = new ReadAuthenticationToken().readToken();
        }
        return token;
    }
}
