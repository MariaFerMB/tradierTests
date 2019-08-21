package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadAuthenticationToken {

   // private String token;


    public ReadAuthenticationToken(){
//        if (token.equals("")){
//            readToken();
//        }
    }

    public String readToken(){
        String respond =null;

        try {
            InputStream fileInput = new FileInputStream("src/test/resources/token.properties");
            Properties prop = new Properties();
            prop.load(fileInput);
            respond = prop.getProperty("token");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respond;

    }







}
