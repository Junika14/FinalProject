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

    public void giveTheValidUrl( String url){
        setUrl(url);
     }

    public void hitApiGetAllUsers(){
        res= getListUsers(setUrl);
        System.out.println(res);
        System.out.println("Response Body: " + res.getBody().asString());

    }
    public void validationStatusCodeIsEquals( int statusCode){
        assertThat(res.getStatusCode()).isEqualTo(statusCode);
        //System.out.println(res.getBody());

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
