package pages;

import helper.EndpointList;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.UUID;

import static helper.EndpointList.setUrl;
import static helper.Models.setupHeaders;


public class UpdateUserPage {

    private static UpdateUserPage instance;
    private Response response;
    private RequestSpecification request;
    private String url;

    public static UpdateUserPage getInstance() {
        if (instance == null) {
            instance = new UpdateUserPage();
        }
        return instance;
    }
    public void urlUpdateUser(String endpoint, String ID){
        this.url = EndpointList.setUrl(endpoint,ID);
        //System.out.println("URL SET" + this.url);
    }
    public void setTheRequestBodyUpdate(String body){
        request = setupHeaders();
        JSONObject requestJSON = new JSONObject(body);
        System.out.println(body);
        if(request != null){
            request.body(requestJSON.toString());
        }else{
            System.out.println("request is null");
        }

    }
    public void sendPutRequest(){
        if(request != null){
            this.response = request.put(url);
        }else{
            System.out.println("Request is null");
        }
    }
    public Response getResponse(){
        if (response ==null){
            System.out.println("Response is null");
        }
        return response;
    }

}
