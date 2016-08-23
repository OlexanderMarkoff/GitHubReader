package com.example.m1.githubreader.api;

import com.example.m1.githubreader.data.GitHubRepo;
import com.example.m1.githubreader.data.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by Markov O on 22.08.16.
 */
public interface APIHelperInterface {

    @Headers({ "Accept:application/vnd.github.v3+json"})
    @GET("/user")
    Call<GitHubUser>
    authorization(@Header("Authorization")String authorization);

    @GET("/user/repos")
    Call<List<GitHubRepo>>
    getMyRepos(@Header("Authorization")String authorization);
}
