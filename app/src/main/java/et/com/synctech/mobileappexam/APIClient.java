package et.com.synctech.mobileappexam;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static String BASE_URL="https://dummy.restapiexample.com/api/v1/";
    public static Retrofit retrofit=null;

    public static Retrofit getClient(){

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
