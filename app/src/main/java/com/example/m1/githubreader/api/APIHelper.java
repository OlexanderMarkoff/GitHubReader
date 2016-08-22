package com.example.m1.githubreader.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
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

    public static class GlobalDataResponse<T> {
        public int error;
        public String message;
        public int status;
        public T data;
    }

    private static <T> Callback<GlobalDataResponse<T>> checkRetrofitResponse(
            final Callback<GlobalDataResponse<T>> incomingCallback) {
        return new Callback<GlobalDataResponse<T>>() {
            @Override
            public void onResponse(Call<GlobalDataResponse<T>> call, retrofit2.Response<GlobalDataResponse<T>> response) {
                if (response == null || response.body() == null) {
                    incomingCallback.onFailure(call, new Throwable("SERVER ERROR"));
                } else if (response.body().data != null && response.body().error == 0
                        && response.body().status == 1) {
                    incomingCallback.onResponse(call, response);
                    android.util.Log.i("Retrofit", "successful");
                } else {
                    incomingCallback.onFailure(call, new Throwable(response.body().message));
                    android.util.Log.i("Retrofit", "failure");
                }
            }

            @Override
            public void onFailure(Call<GlobalDataResponse<T>> call, Throwable t) {
                incomingCallback.onFailure(call, t);
                android.util.Log.i("Retrofit", "failure");
            }
        };
    }

    /**
     * @param login
     * @param password
     */

    public static void authorization(String login, String password, Callback<GlobalDataResponse<Void>> callback) {

    }

}
