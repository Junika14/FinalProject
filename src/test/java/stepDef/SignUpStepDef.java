package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SignUpPage;

import java.util.UUID;

import static helper.Utility.driver;

public class SignUpStepDef {

    private SignUpPage signUpPage= new SignUpPage(driver);
    private String dynamicUsername;

    @Given("the user in on the main page")
    public void theUserInOnTheMainPage() {
        signUpPage.openMainPage();

    }

    @And("the user click {string} menu")
    public void theUserClickMenu(String nameButton) {
        signUpPage.userClickMenu(nameButton);
        System.out.println(nameButton);
    }

    @And("the user input username dynamic")
    public void theUserInputUsernameDynamic() {
        dynamicUsername = "user_" + UUID.randomUUID().toString().substring(0,8);
        signUpPage.enterUserName(dynamicUsername);
    }
    @And("the user input password {string}")
    public void theUserInputPassword(String password) {
        signUpPage.enterPassword(password);
    }

    @When("the user click the {string} button")
    public void theUserClickTheButton(String buttonType) {
        signUpPage.clickOnSignIn(buttonType);
    }


    @Then("Successful sign up message appear {string}")
    public void successfulSignUpMessageAppear(String message) {
        signUpPage.messagePromp(message);
    }


    @And("the user input username already registered {string}")
    public void theUserInputUsernameAlreadyRegistered(String alreadyUser) {
        signUpPage.enterUserName(alreadyUser);
    }

    @And("the user input the registered username {string} and password {string}")
    public void theUserInputTheRegisteredUsernameAndPassword(String username, String password) {
        signUpPage.loginUser(username, password);
    }

    @Then("user navigate to home page")
    public void userNavigateToHomePage() {
        signUpPage.inHomePage();
    }

    @Then("the message error appear {string}")
    public void theMessageErrorAppear(String errorMessage) {
        signUpPage.messagePromp(errorMessage);
    }
}
