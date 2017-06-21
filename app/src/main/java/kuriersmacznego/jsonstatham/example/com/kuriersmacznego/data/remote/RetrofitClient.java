package kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// https://code.tutsplus.com/tutorials/sending-data-with-retrofit-2-http-client-for-android--cms-27845

public class RetrofitClient {

    public static final String MULE_TEST_URL = "http://10.0.2.2:8081/mule/";
    public static final String MULE_LOCATION_URL = "http://10.0.2.2:8081/mule/";

    private static APIService apiService = null;


    public static APIService getClient(String baseUrl) {
        if (apiService==null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = retrofit.create(APIService.class);

        }
        return apiService;
    }
}

// https://code.tutsplus.com/tutorials/sending-data-with-retrofit-2-http-client-for-android--cms-27845