package com.example.m1.githubreader.api;

import com.example.m1.githubreader.data.GitHubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by Markov O on 22.08.16.
 */
public interface APIHelperInterface {

    @Headers({ "Accept:application/vnd.github.v3+json"})
//    @POST(CalledMethods.AUTORIZATION)
    @GET("/user")
    Call<APIHelper.GlobalDataResponse<GitHubUser>>
    authorization(@Header("Authorization")String authorization);
}
