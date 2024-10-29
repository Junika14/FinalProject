package helper;

public class EndpointList {

    public  static String setUrl;
    public static final String HOST_URL = "https://gorest.co.in/public/v2/";



    public static void setUrl(String url) {
        switch (url){
            case "GET_USERS":
                setUrl = HOST_URL + "users";
                break;
            case "CREATE_USER":
                setUrl = HOST_URL + "users";
                break;
            default:
                System.out.println("url not valid ");
                break;
        }
        System.out.println("setUrl: " + setUrl);
    }
}
