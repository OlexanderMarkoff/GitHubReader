package com.example.m1.githubreader.model.api;

import com.example.m1.githubreader.model.data.GitHubRepo;
import com.example.m1.githubreader.model.data.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

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

    @GET("/users/{userName}/repos")
    Call<List<GitHubRepo>>
    getUserRepos(@Header("Authorization")String authorization, @Path("userName") String userName );
}
