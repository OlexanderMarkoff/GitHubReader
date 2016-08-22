package com.example.m1.githubreader.app;

import android.app.Application;
import android.content.Context;

import com.example.m1.githubreader.utils.NetworkHelper;

/**
 * Created by M1 on 22.08.2016.
 */
public class GitHubReaderApp extends Application {

    private static Context sAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static boolean isNetworkAvailable() {
        return NetworkHelper.isNetworkAvailable(sAppContext);
    }
}
