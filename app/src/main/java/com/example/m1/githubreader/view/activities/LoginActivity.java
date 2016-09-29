package com.example.m1.githubreader.view.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.m1.githubreader.R;
import com.example.m1.githubreader.presenter.BasePresenter;
import com.example.m1.githubreader.presenter.LoginPresenter;
import com.example.m1.githubreader.view.interfaces.LoginView;

/**
 * Created by M1 on 18.08.2016.
 */
public class LoginActivity extends GitHubReaderActivity<LoginPresenter> implements LoginView {

    private EditText mEdtLogin;
    private EditText mEdtPassword;
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
        mBtnLogin = (Button) findViewById(R.id.btn_login);
    }

    @Override
    protected void setUI(Bundle savedInstanceState) {
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public String getLogin() {
        return mEdtLogin.getText().toString();
    }

    @Override
    public void setLogin(String login) {
        mEdtLogin.setText(login);
    }

    @Override
    public String getPassword() {
        return mEdtPassword.getText().toString();
    }

    @Override
    public void setPassword(String password) {
        mEdtPassword.setText(password);
    }

    @Override
    protected LoginPresenter getNeededPresenter() {
        return (LoginPresenter) BasePresenter.PresenterManager.getPresenter(LoginPresenter.class);
    }


}
