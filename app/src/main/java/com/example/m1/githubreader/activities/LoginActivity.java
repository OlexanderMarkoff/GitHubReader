package com.example.m1.githubreader.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.m1.githubreader.R;

import static com.example.m1.githubreader.Constants.ARG_LOGIN;
import static com.example.m1.githubreader.Constants.ARG_PASSWORD;
import static com.example.m1.githubreader.Constants.ARG_WRONG_PASS;

/**
 * Created by M1 on 18.08.2016.
 */
public class LoginActivity extends GitHubReaderActivity{

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
            mTxtWrongPassword.setVisibility(savedInstanceState.getBoolean(ARG_WRONG_PASS) ? View.VISIBLE: View.GONE);
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
    }
}
