package steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.When;
import entities.Quote;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RequestBuilder;
import utils.ResponseHelper;
import utils.Share;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class APISteps {

    @When("the user request for ([^\"]*) symbols$")
    public  void theUserRequestForASymbols(String id)throws IOException {
        RequestBuilder requestBuilder = new RequestBuilder("markets/quotes");
        RequestSpecification requestSpecification =requestBuilder.getRequestSpecification();
        Response response = ResponseHelper.getResponse(requestSpecification,"symbols", id);


        List<String> x = response.path("quotes.quote");
        TypeReference<List<Quote>> typeReference = new TypeReference<List<Quote>>() {};
        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writeValueAsString(x);
        List<Quote> qoutes = mapper.readValue(jsonArray, typeReference);
        Share.setShare("qoutesResponse",qoutes);

    }
}
