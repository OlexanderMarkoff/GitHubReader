package com.example.m1.githubreader.presenter;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.example.m1.githubreader.app.GitHubReaderApp;
import com.example.m1.githubreader.model.api.APIHelper;
import com.example.m1.githubreader.view.activities.UserRepoActivity;

import static com.example.m1.githubreader.app.Constants.ARG_SEARCH_STRING;

/**
 * Created by Markov O on 28.09.16.
 */

public class MyRepoPresenter extends BaseRepoPresenter {

    @Override
    protected void loadData() {
        APIHelper.getMyRepos(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        if (!TextUtils.isEmpty(query)) {
            Intent intent = new Intent(GitHubReaderApp.getAppContext(), UserRepoActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(ARG_SEARCH_STRING, view.getSearchString());
            GitHubReaderApp.getAppContext().startActivity(intent);
        }
    }

}
