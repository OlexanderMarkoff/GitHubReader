package com.example.m1.githubreader.view.activities;

import android.os.Bundle;

import com.example.m1.githubreader.R;
import com.example.m1.githubreader.app.Constants;
import com.example.m1.githubreader.presenter.BasePresenter;
import com.example.m1.githubreader.presenter.UserRepoPresenter;
import com.example.m1.githubreader.view.interfaces.ReposView;

/**
 * Created by Markov O on 29.09.16.
 */

public class UserRepoActivity extends BaseRepoActivity<UserRepoPresenter> implements ReposView {


    @Override
    protected void setUI(Bundle savedInstanceState) {
        if (getIntent() != null && getIntent().hasExtra(Constants.ARG_SEARCH_STRING)) {
            mEdtSearch.setText(getIntent().getStringExtra(Constants.ARG_SEARCH_STRING));
            setTitle(getIntent().getStringExtra(Constants.ARG_SEARCH_STRING));
        }
        super.setUI(savedInstanceState);
    }

    @Override
    protected UserRepoPresenter getNeededPresenter() {
        return (UserRepoPresenter) BasePresenter.PresenterManager.getPresenter(UserRepoPresenter.class);
    }

    @Override
    public void setTitle(String title) {
        mTxtTitle.setText(getString(R.string.title_user_repos) + " " + title);
    }

}
