package helper;

public class EndpointList {

    public static String setUrl;
    public static final String HOST_URL = "https://gorest.co.in/public/v2/";


    public static String setUrl(String url, String ID) {
        String endpointUrl;
        switch (url) {
            case "GET_USERS":
                endpointUrl = HOST_URL + "users";
                break;
            case "CREATE_USER":
                endpointUrl = HOST_URL + "users";
                break;
            case "UPDATE_USER":
                endpointUrl = HOST_URL + "users/" + ID;
                break;
            case "DELETE_USER":
            case "GET_USERS_BYID":
                endpointUrl = HOST_URL + "users/" + ID;
                break;
            default:
                System.out.println("url not valid ");
                return null;
        }
        return endpointUrl;
    }
}
