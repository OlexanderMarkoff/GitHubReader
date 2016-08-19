package com.example.m1.githubreader.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Markov O on 19.08.16.
 */
public abstract class GitHubReaderActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        setUI(savedInstanceState);
    }

    protected abstract void initUI();
    protected abstract void setUI(Bundle savedInstanceState);
}
