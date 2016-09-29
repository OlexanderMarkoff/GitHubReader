package com.example.m1.githubreader.view.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.m1.githubreader.R;
import com.example.m1.githubreader.app.GitHubReaderApp;
import com.example.m1.githubreader.model.data.GitHubRepo;
import com.example.m1.githubreader.presenter.BaseRepoPresenter;
import com.example.m1.githubreader.view.adapters.ReposAdapter;
import com.example.m1.githubreader.view.interfaces.ReposView;

import java.util.List;

/**
 * Created by Markov O on 29.09.16.
 */

public abstract class BaseRepoActivity<T extends BaseRepoPresenter> extends GitHubReaderActivity<T> implements ReposView {
    protected TextView mTxtTitle;
    protected EditText mEdtSearch;
    protected Button mBtnSearch;
    protected ListView mListView;
    protected ReposAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_repos);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initUI() {
        mTxtTitle = (TextView) findViewById(R.id.txt_title);
        mEdtSearch = (EditText) findViewById(R.id.edt_search);
        mBtnSearch = (Button) findViewById(R.id.btn_search);
        mListView = (ListView) findViewById(R.id.list_repos);
    }

    @Override
    protected void setUI(Bundle savedInstanceState) {
        mBtnSearch.setOnClickListener(this);
        showProgressDialog();
    }

    @Override
    public String getSearchString() {
        return mEdtSearch.getText().toString();
    }

    @Override
    public void setSearchString(String query) {
        mEdtSearch.setText(query);
    }

    @Override
    public void setList(List<GitHubRepo> repos) {
        if (mAdapter == null) {
            mAdapter = new ReposAdapter(GitHubReaderApp.getAppContext(), repos);
            mListView.setAdapter(mAdapter);
        } else {
            mAdapter.update(repos);
        }
    }

    @Override
    public void setTitle(String title) {
        mTxtTitle.setText(title);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    public void onBackPressed() {
        BaseRepoPresenter.PresenterManager.removePresenter(mPresenter);
        super.onBackPressed();
    }
}
