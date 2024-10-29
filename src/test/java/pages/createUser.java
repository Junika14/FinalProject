package pages;

import helper.EndpointList;
import helper.Models;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.EndpointList.setUrl;
import static helper.Models.setupHeaders;

public class createUser {

    private Response response;
    private RequestSpecification request;
    // private String setUrl;


    public void theValidUrl(String url){
        EndpointList.setUrl(url);
    }

    public void inputTheBodyRequest(String requestBody) {
        request = setupHeaders();
        JSONObject requestJSON = new JSONObject(requestBody);
        request.body(requestJSON.toString());
        System.out.println(request);
    }

    public void sendPostRequest() {
        response = request.post(EndpointList.setUrl);
        // System.out.println("ini urlnyaaa" + setUrl);
        System.out.println(response.body().asString());
    }
    public void statusCode(int statusCode) {
       // response.then().statusCode(statusCode);
    }
}
