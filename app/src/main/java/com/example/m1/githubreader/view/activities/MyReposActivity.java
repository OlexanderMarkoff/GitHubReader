package com.example.m1.githubreader.view.activities;

import android.os.Bundle;

import com.example.m1.githubreader.R;
import com.example.m1.githubreader.presenter.BasePresenter;
import com.example.m1.githubreader.presenter.MyRepoPresenter;
import com.example.m1.githubreader.view.interfaces.ReposView;

/**
 * Created by M1 on 23.08.2016.
 */
public final class MyReposActivity extends BaseRepoActivity<MyRepoPresenter> implements ReposView {


    @Override
    protected void setUI(Bundle savedInstanceState) {
        super.setUI(savedInstanceState);
        mTxtTitle.setText(R.string.title_my_repos);
    }

    @Override
    protected MyRepoPresenter getNeededPresenter() {
        return (MyRepoPresenter) BasePresenter.PresenterManager.getPresenter(MyRepoPresenter.class);
    }

}
