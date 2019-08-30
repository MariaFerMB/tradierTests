package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadAuthenticationToken {

    private static final String TOKEN_FILE = "src/test/resources/token.properties";

    static String readToken(){
        String respond ="";

        try {
            InputStream fileInput = new FileInputStream(TOKEN_FILE);
            Properties prop = new Properties();
            prop.load(fileInput);
            respond = prop.getProperty("token");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respond;

    }







}
