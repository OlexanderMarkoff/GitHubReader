package com.example.m1.githubreader.presenter;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.example.m1.githubreader.R;
import com.example.m1.githubreader.app.GitHubReaderApp;
import com.example.m1.githubreader.model.api.APIHelper;
import com.example.m1.githubreader.model.data.GitHubUser;
import com.example.m1.githubreader.utils.Base64EncodeDecodeHelper;
import com.example.m1.githubreader.utils.UserCredManager;
import com.example.m1.githubreader.view.activities.MyReposActivity;
import com.example.m1.githubreader.view.interfaces.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.m1.githubreader.app.Constants.CODE_LIMIT;
import static com.example.m1.githubreader.app.Constants.CODE_OK;
import static com.example.m1.githubreader.app.Constants.CODE_UNAUTHORIZED;

/**
 * Created by Markov O on 26.09.16.
 */

public final class LoginPresenter extends BasePresenter<LoginView> implements Callback<GitHubUser> {

    private String mLoginData = "";
    private String mPassData = "";

    protected LoginPresenter() {
    }

    @Override
    public void onClick(View v) {

        if (TextUtils.isEmpty(view.getLogin()) || TextUtils.isEmpty(view.getPassword())) {
            view.showInfoDialog(R.string.title_error, R.string.title_empty_fields);
            return;
        }
        if (!GitHubReaderApp.isNetworkAvailable()) {
            view.showInfoDialog(R.string.title_error, R.string.title_no_inet_connection);
            return;
        }
        view.showProgressDialog();
        UserCredManager.getInstance().setUserAuthHeader("Basic "
                + Base64EncodeDecodeHelper.encode(view.getLogin()
                + ":" + view.getPassword()));

        APIHelper.authorization(this);

    }

    @Override
    public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
        view.hideProgressDialog();
        if (response.code() == CODE_OK) {
            Intent intent = new Intent(GitHubReaderApp.getAppContext(), MyReposActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            GitHubReaderApp.getAppContext().startActivity(intent);
            PresenterManager.removePresenter(this);
            view = null;

        } else if (response.code() == CODE_UNAUTHORIZED) {
            view.showInfoDialog(R.string.title_error, R.string.title_unauthorized);
        } else if (response.code() == CODE_LIMIT) {
            view.showInfoDialog(R.string.title_error, R.string.title_connection_limit);
        } else {
            view.showInfoDialog(GitHubReaderApp.getAppContext().getString(R.string.title_error), response.message());
        }

    }

    @Override
    public void onFailure(Call<GitHubUser> call, Throwable t) {
        view.hideProgressDialog();
        view.showInfoDialog(R.string.title_error, R.string.title_request_error);
    }

    @Override
    public void saveData() {
        if (view == null) {
            return;
        }
        mLoginData = view.getLogin();
        mPassData = view.getPassword();
    }

    @Override
    public void restoreData() {
        view.setLogin(mLoginData);
        view.setPassword(mPassData);
    }

}
