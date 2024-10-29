package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.createUser;



public class CreateUser {

    createUser createUser;
    Response res;


    public CreateUser() {
        createUser = new createUser();
    }
    @And("input the body request :")
    public void inputTheBodyRequest(String bodyRequest) {
        createUser.inputTheBodyRequest(bodyRequest);
    }

    @When("send a post request")
    public void sendAPostRequest() {
        createUser.sendPostRequest();
    }

}
