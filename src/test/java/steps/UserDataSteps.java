package steps;

import cucumber.api.java.en.Given;
import entities.Quote;
import utils.QuoteGenerator;
import utils.ReadAuthenticationToken;
import utils.Share;

import java.util.*;

public class UserDataSteps {

    @Given("The user have a access token$")
    public  void theUserHaveAccessToken(){
        ReadAuthenticationToken token = new ReadAuthenticationToken();
        Share.setToken();
    }

    @Given("I have a quote of ([^\"]*) symbols$")
    public  void iHaveAQuoteOfASymbols(String symbol){
        String[] symbols = symbol.split(",");
        List<Quote> qoutes = new ArrayList<>();
        for (int i = 0;i<symbols.length;i++){
            Quote qoute = QuoteGenerator.generateQoute(symbols[i]);
            qoutes.add(qoute);
        }
        Share.setShare("qoutes",qoutes);

    }



}
