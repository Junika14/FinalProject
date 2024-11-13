package pages;

import helper.EndpointList;
import helper.Models;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.EndpointList.setUrl;
import static helper.Models.setupHeaders;
import static org.assertj.core.api.Assertions.assertThat;

public class createUserPage {

    private static createUserPage instace;
    private Response response;
    private RequestSpecification request;
    private Boolean requestSent=false;
    private String url;
    //private String userId;


    private createUserPage() {}

    public static createUserPage getInstance() {
        if (instace == null) {
            instace = new createUserPage();
        }
        return instace;
    }
    public void theValidUrl(String endpoint, String ID){
        this.url = EndpointList.setUrl(endpoint, null);
        System.out.println("URL: " + this.url);
    }

    public void inputTheBodyRequest(String requestBody) {
        request = setupHeaders();
        JSONObject requestJSON = new JSONObject(requestBody);
        if(request != null){
            request.body(requestJSON.toString());
        }else{
            System.out.println("Request Body is null");
        }

    }

    public Response sendPostRequest() {
        if(request != null){
            this.response = request.post(url);
            System.out.println(this.response.asString());
            System.out.println(this.response.getStatusCode());
            requestSent=true;
        }else{
            System.out.println("Request is null");
        }
        return response;

    }
    public void statusCode(int statusCode) {
        if(!requestSent){
            System.out.println("Request not sent");
            sendPostRequest();
        }
            int actualStatusCode = response.getStatusCode();
            System.out.println("expected status code: " + statusCode );
            System.out.println("actual status code: " + response);
            System.out.println(response.asString());
            assertThat(actualStatusCode).isEqualTo(statusCode);
    }

    public String saveUserId(){
        return response.jsonPath().getString("id");
    }

}
