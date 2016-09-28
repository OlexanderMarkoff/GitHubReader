package com.example.m1.githubreader.presenter;

import android.content.Intent;
import android.view.View;

import com.example.m1.githubreader.R;
import com.example.m1.githubreader.app.GitHubReaderApp;
import com.example.m1.githubreader.model.api.APIHelper;
import com.example.m1.githubreader.model.data.GitHubRepo;
import com.example.m1.githubreader.presenter.enums.ReposType;
import com.example.m1.githubreader.utils.ReposListManager;
import com.example.m1.githubreader.view.activities.ReposActivity;
import com.example.m1.githubreader.view.interfaces.Loadable;
import com.example.m1.githubreader.view.interfaces.ReposView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.m1.githubreader.app.Constants.ARG_REPOS_TYPE;
import static com.example.m1.githubreader.app.Constants.ARG_SEARCH_STRING;
import static com.example.m1.githubreader.app.Constants.CODE_LIMIT;
import static com.example.m1.githubreader.app.Constants.CODE_OK;

/**
 * Created by Markov O on 28.09.16.
 */

public class ReposPresenter extends BasePresenter<ReposView> implements Callback<List<GitHubRepo>>, Loadable {


    private ReposType mType = ReposType.MY;

    @Override
    public void onClick(View v) {
        if (mType.equals(ReposType.MY)) {
            Intent intent = new Intent(GitHubReaderApp.getAppContext(), ReposActivity.class);
            intent.putExtra(ARG_REPOS_TYPE, ReposType.USER);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(ARG_SEARCH_STRING, view.getSearchString());
            GitHubReaderApp.getAppContext().startActivity(intent);
        } else {
            view.showProgressDialog();
            APIHelper.getUserRepos(view.getSearchString(), this);
        }
    }

    @Override
    public void saveData() {

    }

    @Override
    public void restoreData() {

    }

    @Override
    public void loadData(ReposType type) {
        if (mType.equals(ReposType.MY)) {
            APIHelper.getMyRepos(this);
        }

    }

    @Override
    public boolean isSubscribed(ReposView view) {
        return false;
    }

    @Override
    public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
        view.hideProgressDialog();
        if (response.code() == CODE_OK) {
            if (mType.equals(ReposType.MY)) {
                ReposListManager.getInstance().setMyRepos(response.body());
            } else if (mType.equals(ReposType.USER)) {
                view.setTitle(GitHubReaderApp.getAppContext().getString(R.string.title_user_repos) + " " + view.getSearchString());
                ReposListManager.getInstance().setOtherUserRepos(response.body());
            }

            view.setList(response.body());

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
}
