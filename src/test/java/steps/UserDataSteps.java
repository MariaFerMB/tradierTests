package steps;

import cucumber.api.java.en.Given;
import utils.ReadAuthenticationToken;
import utils.Share;


public class UserDataSteps {

    @Given("The user have a access token$")
    public  void theUserHaveAccessToken(){
        ReadAuthenticationToken token = new ReadAuthenticationToken();
        Share.setToken();
    }





}
