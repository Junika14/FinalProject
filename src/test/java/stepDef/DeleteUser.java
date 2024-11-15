package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.DeleteUserPage;
import pages.createUserPage;
import pages.getList;

public class DeleteUser {

    private final DeleteUserPage deleteUserPage= DeleteUserPage.getInstance();
    private final getList listInstance = getList.getInstance();
    String userId = createUserPage.getInstance().saveUserId();
    private String urlId;


    @Given("give the valid url {string} with valid {string}")
    public void giveTheValidUrlWithValid(String endpoint, String ID) {
        // userId = ID;
        urlId = endpoint;
        deleteUserPage.urlDeleteUser(endpoint,userId);
        //System.out.println("URL dan ID yang disetel untuk DELETE: " + urlId + " dengan ID: " + userId);
    }
    @When("send delete request")
    public void sendDeleteRequest() {
        deleteUserPage.sendDeleteRequest();
        Response response = deleteUserPage.getResponse();
        listInstance.setResponse(response);
        //System.out.println("Response setelah delete: " + (response != null ? response.getStatusCode() : "null"));

    }

    @And("validate that user is deleted")
    public void validateThatUserIsDeleted() {
        Response getUserResponse = deleteUserPage.sendGetUserRequest(userId); // Coba ambil kembali user
        listInstance.setResponse(getUserResponse);
        listInstance.validationStatusCodeIsEquals(404);
        //System.out.println("Response setelah validasi: " + (getUserResponse != null ? getUserResponse.getStatusCode() : "null"));
    }


}
