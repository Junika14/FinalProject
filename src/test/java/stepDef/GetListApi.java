package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.createUser;
import pages.getList;

public class GetListApi {


    getList getList;
    createUser  createUser;
    public GetListApi() {
        getList = new getList();
        createUser = new createUser();
    }

    @Given("give the valid url {string}")
    public void giveTheValidUrl(String url) {
        switch (url) {
            case "GET_USERS":
                getList.giveTheValidUrl(url);
                break;
            case "CREATE_USER":
                createUser.theValidUrl(url);
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
            case 200:
                getList.validationStatusCodeIsEquals(status_code);
                break;
            case 201:
                createUser.statusCode(status_code);
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
