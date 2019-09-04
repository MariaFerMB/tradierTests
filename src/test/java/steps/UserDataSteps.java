package steps;

import cucumber.api.java.en.Given;
import utils.Share;


public class UserDataSteps {

    @Given("I have a developer access token$")
    public void theUserHaveAccessToken() {
        Share.setToken();
    }

}
