package com.example.m1.githubreader.utils;

/**
 * Created by M1 on 23.08.2016.
 */
public final class UserCredManager {

    private static UserCredManager mUserCredManager;
    private static String sUserAuthHeader;

    public static UserCredManager getInstance() {
        if (mUserCredManager == null) {
            mUserCredManager = new UserCredManager();
        }
        return mUserCredManager;
    }

    public String getUserAuthHeader() {
        return sUserAuthHeader;
    }

    public void setUserAuthHeader(String userAuthHeader) {
        sUserAuthHeader = userAuthHeader;
    }
}
