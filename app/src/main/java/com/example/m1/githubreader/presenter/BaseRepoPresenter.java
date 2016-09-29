package com.example.m1.githubreader.presenter;

import android.text.TextUtils;
import android.view.View;

import com.example.m1.githubreader.R;
import com.example.m1.githubreader.app.GitHubReaderApp;
import com.example.m1.githubreader.model.data.GitHubRepo;
import com.example.m1.githubreader.view.interfaces.LoginView;
import com.example.m1.githubreader.view.interfaces.ReposView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.m1.githubreader.app.Constants.CODE_LIMIT;
import static com.example.m1.githubreader.app.Constants.CODE_OK;

/**
 * Created by Markov O on 29.09.16.
 */

public abstract class BaseRepoPresenter extends BasePresenter<ReposView> implements Callback<List<GitHubRepo>> {

    protected final List<GitHubRepo> mRepos = new ArrayList<>();

    protected String query;

    @Override
    public void subscribe(ReposView view) {
        super.subscribe(view);
        query = this.view.getSearchString();
        if (mRepos.isEmpty()) {
            loadData();
        } else {
            view.setList(mRepos);
        }
    }

    protected abstract void loadData();

    @Override
    public void onClick(View v) {
        query = view.getSearchString();

        if (TextUtils.isEmpty(query)) {
            view.showInfoDialog(R.string.title_error, R.string.title_query_field_empty);
        }
    }

    @Override
    public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
        view.hideProgressDialog();
        mRepos.clear();
        mRepos.addAll(response.body());
        if (response.code() == CODE_OK) {
            view.setList(mRepos);
        } else if (response.code() == CODE_LIMIT) {
            view.showInfoDialog(R.string.title_error, R.string.title_connection_limit);
        } else {
            view.showInfoDialog(GitHubReaderApp.getAppContext().getString(R.string.title_error), response.message());
        }


    }

    @Override
    public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
        view.hideProgressDialog();
        view.showInfoDialog(R.string.title_error, R.string.title_request_error);
    }

    @Override
    public void saveData() {
        query = view.getSearchString();
    }

    @Override
    public void restoreData() {
        view.setSearchString(query);
        view.setTitle(query);
    }

    public boolean isSubscribed(LoginView view) {
        return view.equals(this.view);
    }
}
