package com.example.m1.githubreader.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.m1.githubreader.R;
import com.example.m1.githubreader.api.APIHelper;
import com.example.m1.githubreader.app.GitHubReaderApp;
import com.example.m1.githubreader.data.GitHubUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.m1.githubreader.app.Constants.ARG_LOGIN;
import static com.example.m1.githubreader.app.Constants.ARG_PASSWORD;
import static com.example.m1.githubreader.app.Constants.ARG_WRONG_PASS;
import static com.example.m1.githubreader.app.Constants.CODE_LIMIT;
import static com.example.m1.githubreader.app.Constants.CODE_OK;
import static com.example.m1.githubreader.app.Constants.CODE_UNAUTHORIZED;

/**
 * Created by M1 on 18.08.2016.
 */
public class LoginActivity extends GitHubReaderActivity {

    final static String LOG_TAG = LoginActivity.class.getSimpleName();

    private EditText mEdtLogin;
    private EditText mEdtPassword;
    private TextView mTxtWrongPassword;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initUI() {
        mEdtLogin = (EditText) findViewById(R.id.edt_login);
        mEdtPassword = (EditText) findViewById(R.id.edt_password);
        mTxtWrongPassword = (TextView) findViewById(R.id.txt_wrong_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
    }

    @Override
    protected void setUI(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mEdtLogin.setText(savedInstanceState.getString(ARG_LOGIN) != null ? savedInstanceState.getString(ARG_LOGIN) : "");
            mEdtPassword.setText(savedInstanceState.getString(ARG_PASSWORD) != null ? savedInstanceState.getString(ARG_PASSWORD) : "");
            mTxtWrongPassword.setVisibility(savedInstanceState.getBoolean(ARG_WRONG_PASS) ? View.VISIBLE : View.GONE);
        }
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ARG_LOGIN, mEdtLogin.getText().toString());
        outState.putString(ARG_PASSWORD, mEdtPassword.getText().toString());
        outState.putBoolean(ARG_WRONG_PASS, mTxtWrongPassword.getVisibility() == View.VISIBLE);
    }

    @Override
    public void onClick(View view) {

        if (TextUtils.isEmpty(mEdtLogin.getText().toString()) || TextUtils.isEmpty( mEdtPassword.getText().toString())) {
            showInfoDialog(R.string.title_error, R.string.title_empty_fields);
            return;
        }
        if (!GitHubReaderApp.isNetworkAvailable()) {
            showInfoDialog(R.string.title_error, R.string.title_no_inet_connection);
            return;
        }

        APIHelper.authorization(mEdtLogin.getText().toString(), mEdtPassword.getText().toString(), new Callback<APIHelper.GlobalDataResponse<GitHubUser>>() {
            @Override
            public void onResponse(Call<APIHelper.GlobalDataResponse<GitHubUser>> call, Response<APIHelper.GlobalDataResponse<GitHubUser>> response) {

                if (response.code() == CODE_OK) {

                } else if (response.code() == CODE_UNAUTHORIZED) {
                    showInfoDialog(R.string.title_error, R.string.title_unauthorized);
                }  else if (response.code() == CODE_LIMIT) {
                    showInfoDialog(R.string.title_error, R.string.title_connection_limit);
                } else  {
                    showInfoDialog(getString(R.string.title_error), response.message());
                }
            }

            @Override
            public void onFailure(Call<APIHelper.GlobalDataResponse<GitHubUser>> call, Throwable t) {
                showInfoDialog(R.string.title_error, R.string.title_request_error);
            }
        });
    }
}
