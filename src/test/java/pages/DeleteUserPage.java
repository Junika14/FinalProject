package pages;

import helper.EndpointList;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static helper.EndpointList.setUrl;
import static helper.Models.setupHeaders;

public class DeleteUserPage {
    private static DeleteUserPage instance;
    private Response response;
    private RequestSpecification request;
    private String url; // Simpan URL


    public static DeleteUserPage getInstance() {
    if (instance == null) {
        instance = new DeleteUserPage();
    }
    return instance;
    }

    public void urlDeleteUser(String endpoint, String ID){
        this.url = setUrl(endpoint, ID);
        System.out.println("URL yang disetel: " + this.url);
    }

    public void sendDeleteRequest(){
        request = setupHeaders();
        if(request == null){
            System.out.println("Request is not set up properly");
            return;
        }
        if(url != null && !url.isEmpty()){
            response = request.delete(url);
            System.out.println("DELETE request sent to:" + url);
            System.out.println("Delete Status Code: " + response.getStatusCode());
        }else{
            System.out.println("Delete request url is empty");
        }
    }

    public Response getResponse() {
        if(response == null){
            System.out.println("Response is null");
        }
        return response;
    }
    public Response sendGetUserRequest(String ID) {
        if (ID == null || ID.isEmpty()) {
            System.out.println("ID is empty");
            return null;
        }
        request = setupHeaders();
        if(request == null){
            System.out.println("Request is null");
            return null;
        }
        String url = setUrl("GET_USERS_BYID", ID);
        if (url != null && !url.isEmpty()) {
            System.out.println("GET REQUEST URL ID:" + url);
            Response getUserResponse = request.get(url);
            System.out.println("GET Response Status Code: " + getUserResponse.getStatusCode());
            System.out.println("GET Response Body: " + getUserResponse.getBody().asString());
            return getUserResponse;
        } else {
            System.out.println("GET request is empty");
            return null;
        }

    }
}
