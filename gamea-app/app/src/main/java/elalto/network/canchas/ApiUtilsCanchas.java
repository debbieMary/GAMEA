package elalto.network.canchas;


public class ApiUtilsCanchas {

    private ApiUtilsCanchas(){
    };


    public static final String API_URL = "https://api-game-bo.herokuapp.com/";

    public static ApiServiceCanchas getCanchasService(){
        return RetrofitClientCanchas.getClient(API_URL).create(ApiServiceCanchas.class);
    }

}
