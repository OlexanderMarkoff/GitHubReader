package com.example.m1.githubreader.api;

import com.rejasupotaro.octodroid.GitHub;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Markov O on 22.08.16.
 */
public class APIHelper {

    final static String LOG_TAG = APIHelper.class.getSimpleName();

    private final static String ROOT_API_URL = "https://api.github.com/";

    private static final Retrofit mRestAdapter;
    private static final APIHelperInterface mRestService;


    static {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        mRestAdapter = new Retrofit.Builder()
                .baseUrl(ROOT_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okClient)
                .build();
        mRestService = mRestAdapter.create(APIHelperInterface.class);
    }

    public static void login () {
        GitHub.client().authorization("username", "password");
    }
}
