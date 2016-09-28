package com.example.m1.githubreader.view.interfaces;

/**
 * Created by Markov O on 26.09.16.
 */

public interface Dialogable {

    void showInfoDialog(String title, String content);

    void showInfoDialog(int title, int content);

    void showProgressDialog();

    void hideProgressDialog();
}
