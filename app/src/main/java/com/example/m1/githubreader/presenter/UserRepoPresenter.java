package com.example.m1.githubreader.presenter;

import android.text.TextUtils;
import android.view.View;

import com.example.m1.githubreader.model.api.APIHelper;

/**
 * Created by Markov O on 29.09.16.
 */

public class UserRepoPresenter extends BaseRepoPresenter {


    @Override
    protected void loadData() {
        APIHelper.getUserRepos(query, this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        if (!TextUtils.isEmpty(query)) {
            this.view.showProgressDialog();
            query = this.view.getSearchString();
            this.view.setTitle(query);
            loadData();
        }
    }


}
