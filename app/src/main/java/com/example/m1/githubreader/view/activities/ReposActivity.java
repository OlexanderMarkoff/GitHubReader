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
import com.example.m1.githubreader.presenter.BasePresenter;
import com.example.m1.githubreader.presenter.ReposPresenter;
import com.example.m1.githubreader.presenter.enums.ReposType;
import com.example.m1.githubreader.view.adapters.ReposAdapter;
import com.example.m1.githubreader.view.interfaces.ReposView;

import java.util.List;

/**
 * Created by M1 on 23.08.2016.
 */
public final class ReposActivity extends GitHubReaderActivity<ReposPresenter> implements ReposView {

    final static String LOG_TAG = ReposActivity.class.getSimpleName();

    private TextView mTxtTitle;
    private EditText mEdtSearch;
    private Button mBtnSearch;
    private ListView mListView;
    private ReposAdapter mAdapter;

    private List<GitHubRepo> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_repos);
        super.onCreate(savedInstanceState);

//        if (savedInstanceState != null) {
//            mType = (ReposType) savedInstanceState.getSerializable(Constants.ARG_REPOS_TYPE);
//            mEdtSearch.setText(savedInstanceState.getString(ARG_SEARCH_STRING) != null ? savedInstanceState.getString(ARG_SEARCH_STRING) : "");
//
//            if (mType.equals(ReposType.MY)) {
//                mDataList = ReposListManager.getInstance().getMyRepos();
//            } else {
//                mTxtTitle.setText(getString(R.string.title_user_repos) + " " + savedInstanceState.getString(Constants.ARG_SEARCH_STRING));
//                mDataList = ReposListManager.getInstance().getOtherUserRepos();
//            }
//
//            mAdapter = new ReposAdapter(GitHubReaderApp.getAppContext(), mDataList);
//            mListView.setAdapter(mAdapter);
//        }
//
//        if (getIntent() != null && getIntent().hasExtra(Constants.ARG_REPOS_TYPE) && mDataList == null) {
//            mType = (ReposType) getIntent().getSerializableExtra(Constants.ARG_REPOS_TYPE);
//            showProgressDialog();
//            if (mType.equals(ReposType.MY)) {
//                APIHelper.getMyRepos(this);
//            } else if (mType.equals(ReposType.USER)) {
//                mEdtSearch.setText(getIntent().getStringExtra(Constants.ARG_SEARCH_STRING));
//                mTxtTitle.setText(getString(R.string.title_user_repos) + " " + getIntent().getStringExtra(Constants.ARG_SEARCH_STRING));
//                APIHelper.getUserRepos(getIntent().getStringExtra(Constants.ARG_SEARCH_STRING), this);
//            }
//        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putSerializable(Constants.ARG_REPOS_TYPE, mType);
//        outState.putString(Constants.ARG_SEARCH_STRING, mEdtSearch.getText().toString());
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
        mTxtTitle.setText(R.string.title_my_repos);
        mBtnSearch.setOnClickListener(this);
        showProgressDialog();
        mPresenter.loadData(ReposType.MY);
    }


//    @Override
//    public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
//        hideProgressDialog();
//        if (response.code() == CODE_OK) {
//
//            if (mAdapter == null) {
//                mAdapter = new ReposAdapter(GitHubReaderApp.getAppContext(), response.body());
//                mListView.setAdapter(mAdapter);
//            } else {
//                mAdapter.update(response.body());
//            }
//            if (mType.equals(ReposType.MY)) {
//                ReposListManager.getInstance().setMyRepos(response.body());
//            } else if (mType.equals(ReposType.USER)) {
//                mTxtTitle.setText(getString(R.string.title_user_repos) + " " + mEdtSearch.getText().toString());
//                ReposListManager.getInstance().setOtherUserRepos(response.body());
//            }
//            mDataList = response.body();
//
//        } else if (response.code() == CODE_LIMIT) {
//            showInfoDialog(R.string.title_error, R.string.title_connection_limit);
//        } else {
//            showInfoDialog(getString(R.string.title_error), response.message());
//        }
//    }
//
//    @Override
//    public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
//        hideProgressDialog();
//    }

    @Override
    protected ReposPresenter getNeededPresenter() {
        return (ReposPresenter) BasePresenter.PresenterManager.getPresenter(ReposPresenter.class);
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
}
