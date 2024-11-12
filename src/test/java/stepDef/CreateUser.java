package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.createUserPage;

import java.util.UUID;


public class CreateUser {

   private final createUserPage createUserPage = pages.createUserPage.getInstance();
    Response res;


    @And("input the body request :")
    public void inputTheBodyRequest(String bodyRequest) {
        String dynamicEmail = "user_"+ UUID.randomUUID().toString().substring(0,8) + "@xyuu.com";
        bodyRequest = bodyRequest.replace("{email}", dynamicEmail);
        System.out.println("Dynamic Email: " + dynamicEmail);
        createUserPage.inputTheBodyRequest(bodyRequest);
    }

    @When("send a post request")
    public void sendAPostRequest() {
        createUserPage.sendPostRequest();
    }


    @Then("status code is equals {int}")
    public void statusCodeIsEquals(int statusCode) {
        createUserPage.statusCode(statusCode);
    }

    public createUserPage getCreateUserPage() {
        return createUserPage;
    }


}
