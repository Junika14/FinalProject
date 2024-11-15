package pages;

import helper.EndpointList;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.EndpointList.setUrl;
import static helper.Models.getListUsers;
import static org.assertj.core.api.Assertions.assertThat;

public class getList {

    Response res;
    private static getList instanceStatus;
    private String url;

    public static getList getInstance() {
        if (instanceStatus == null) {
            instanceStatus = new getList();
        }
        return instanceStatus;
    }

    public void resetResponse(){
        res=null;
    }

    public void setResponse(Response response){
        res=response;
    }
    public void giveTheValidUrl( String endpoint, String ID){
        this.url = setUrl(endpoint, ID);
        //System.out.println("URL yang disetel: " + this.url);
     }

    public void hitApiGetAllUsers(){
        res= getListUsers(url);
        if(res!=null){
            System.out.println("Response Body: " + res.getBody().asString());
        }else{
            System.out.println("Response Body is null");
        }

    }
    public void validationStatusCodeIsEquals( int statusCode){
        if(res!=null){
            assertThat(res.getStatusCode()).isEqualTo(statusCode);
        }else{
            System.out.println("Response status code is null");
        }
    }
    public void validationResponseBodyGetListUsers(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id).isNotNull().isNotEmpty();
        assertThat(name).isNotNull().isNotEmpty();
        assertThat(email).isNotNull().isNotEmpty();
        assertThat(gender).isNotNull().isNotEmpty()
                .allMatch(g -> g.equals("male") || g.equals("female"));

        assertThat(status).isNotNull().isNotEmpty()
                .allMatch(s -> s.equals("active") || s.equals("inactive"));
    }
    public void validationResponseJsonWithJSONSchema( String filename){
        File file = Utility.getJSONSchema(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));

    }
}
