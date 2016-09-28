package com.example.m1.githubreader.presenter;

import android.view.View;

import com.example.m1.githubreader.view.interfaces.GiHubReaderView;

/**
 * Created by Markov O on 26.09.16.
 */

public interface Presenter<T extends GiHubReaderView> {

    void subscribe(T view);

    void onClick(View view);

    void saveData();

    void restoreData();

    boolean isSubscribed(T view);
}
