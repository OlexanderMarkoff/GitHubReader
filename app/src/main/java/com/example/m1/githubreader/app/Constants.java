package com.example.m1.githubreader.app;

/**
 * Created by Markov O on 19.08.16.
 */
public interface Constants {

    //login activity
    String ARG_LOGIN = "arg_login";
    String ARG_PASSWORD = "arg_password";
    String ARG_WRONG_PASS = "arg_wrong_password";

    String TITLE_EMPTY = "";
    String BASE_64_PATTERN = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";

    //Response code
    int CODE_OK = 200;
    int CODE_UNAUTHORIZED = 401;
    int CODE_LIMIT = 403;
}
