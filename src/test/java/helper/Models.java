package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Models {

    public static RequestSpecification request;
    public static RequestSpecification setupHeaders(){
        return  RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer b3fe00faffe8a167f40c2e589b909ac94889ffefaa58fbe9025f7dc67032f070");
    }

    public static Response getListUsers(String endpoint){
        request = setupHeaders();
        return request.when().get(endpoint);
    }




}
