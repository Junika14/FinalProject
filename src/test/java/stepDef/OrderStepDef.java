package stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OrderPage;

import java.util.Map;

import static helper.Utility.driver;

public class OrderStepDef {

    private OrderPage orderPage ;

    public OrderStepDef() {
       this.orderPage = new OrderPage(driver);
    }


    @Given("the user already logged with username {string} and password {string}")
    public void theUserAlreadyLoggedWithUsernameAndPassword(String username, String password) {
        orderPage.login(username, password);
    }

    @And("the user clicks the item")
    public void theUserClicksTheItem() {
        orderPage.clicksItem();

    }

    @And("the user clicks {string} button")
    public void theUserClicksButton(String buttonName) {
        orderPage.addtoCart(buttonName);
    }

    @Then("the message appear {string}")
    public void theMessageAppear(String message) {
        orderPage.messageCart(message);
    }

    @And("the user clicks {string} menu")
    public void theUserClicksMenu(String arg0) {
        orderPage.cartMenu();
    }

    @And("the user inputs place order form with details:")
    public void theUserInputsPlaceOrderFormWithDetails( DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap(String.class, String.class);
        orderPage.fillOrderForm(formData);
        //System.out.println(formData);
    }

    @Then("the Id order appear")
    public void theIdOrderAppear() {
        orderPage.orderSucces();
    }
}
