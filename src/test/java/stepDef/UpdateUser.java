package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.UpdateUserPage;
import pages.getList;

import java.util.UUID;

public class UpdateUser {

    private UpdateUserPage updateUserPage = UpdateUserPage.getInstance();
    private final getList listInstance = getList.getInstance();
    private String userId;
    private String urlId;


    @Given("give the valid url {string} with id user {string}")
    public void giveTheValidUrlWithIdUser(String url, String ID) {
        this.urlId=url;
        this.userId = ID;
        updateUserPage.urlUpdateUser(urlId, userId);
    }

    @And("input the body request update :")
    public void inputTheBodyRequestUpdate(String body) {
        String dynamicEmail = "user_"+ UUID.randomUUID().toString().substring(0,8) + "@xyuu.com";
        body = body.replace("{email}",dynamicEmail);
        updateUserPage.setTheRequestBodyUpdate(body);

    }

    @When("send put request")
    public void sendPutRequest() {
        updateUserPage.sendPutRequest();
        Response response = updateUserPage.getResponse();
        listInstance.setResponse(response);
    }

}
