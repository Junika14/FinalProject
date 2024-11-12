package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.DeleteUserPage;
import pages.UpdateUserPage;
import pages.createUserPage;
import pages.getList;

public class GetListApi {


     private final getList getList = pages.getList.getInstance();
     private final createUserPage  createUserPage = pages.createUserPage.getInstance();
     private final DeleteUserPage  deleteUserPage = pages.DeleteUserPage.getInstance();



    @Given("give the valid url {string}")
    public void giveTheValidUrl(String url) {
        switch (url) {
            case "GET_USERS":
                getList.giveTheValidUrl(url, null);
                break;
            case "CREATE_USER":
                createUserPage.theValidUrl(url, null);
                break;
            default:
                System.out.println("Invalid URL");
                break;
        }
    }

    @And("hit api get all users")
    public void hitApiGetAllUsers() {
        getList.hitApiGetAllUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
        switch (status_code) {
            case 201:
                createUserPage.statusCode(status_code);
                break;
            case 200:
            case 204:
                getList.validationStatusCodeIsEquals(status_code);
                break;
            default:
                System.out.println("Invalid status code");
                break;
        }

    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        getList.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        getList.validationResponseJsonWithJSONSchema(filename);
    }
}
