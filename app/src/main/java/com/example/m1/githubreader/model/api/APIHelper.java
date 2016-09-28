package com.example.m1.githubreader.model.api;

import com.example.m1.githubreader.model.data.GitHubRepo;
import com.example.m1.githubreader.model.data.GitHubUser;
import com.example.m1.githubreader.utils.UserCredManager;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
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

    public static void authorization( Callback<GitHubUser> callback) {
        mRestService.authorization(UserCredManager.getInstance().getUserAuthHeader()).enqueue(callback);
    }

    public  static  void getMyRepos(Callback<List<GitHubRepo>> callback) {
        mRestService.getMyRepos(UserCredManager.getInstance().getUserAuthHeader()).enqueue(callback);
    }

    public  static  void getUserRepos(String userName, Callback<List<GitHubRepo>> callback) {
        mRestService.getUserRepos(UserCredManager.getInstance().getUserAuthHeader(), userName).enqueue(callback);
    }
}
