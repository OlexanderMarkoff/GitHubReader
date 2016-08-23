package com.example.m1.githubreader.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.m1.githubreader.R;
import com.example.m1.githubreader.adapters.ReposAdapter;
import com.example.m1.githubreader.api.APIHelper;
import com.example.m1.githubreader.app.Constants;
import com.example.m1.githubreader.app.GitHubReaderApp;
import com.example.m1.githubreader.data.GitHubRepo;
import com.example.m1.githubreader.emuns.ReposType;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by M1 on 23.08.2016.
 */
public class ReposActivity extends GitHubReaderActivity implements Callback<List<GitHubRepo>> {

    final static String LOG_TAG = ReposActivity.class.getSimpleName();

    private ReposType mType;

    private TextView mTxtTitle;
    private EditText mEdtSearch;
    private Button mBtnSearch;
    private ListView mListView;
    private ReposAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_repos);
        super.onCreate(savedInstanceState);
        if (getIntent() != null && getIntent().hasExtra(Constants.ARG_REPOS_TYPE)) {
            mType = (ReposType)getIntent().getSerializableExtra(Constants.ARG_REPOS_TYPE);
        }

        showProgressDialog();
        APIHelper.getMyRepos(this);
    }

    @Override
    protected void initUI() {
        mTxtTitle = (TextView)findViewById(R.id.txt_title);
        mEdtSearch = (EditText)findViewById(R.id.edt_search);
        mBtnSearch = (Button)findViewById(R.id.btn_search);
        mListView = (ListView)findViewById(R.id.list_repos);
    }

    @Override
    protected void setUI(Bundle savedInstanceState) {
        mTxtTitle.setText(R.string.title_my_repos);
        mBtnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
        if (mAdapter == null) {
            mAdapter = new ReposAdapter(GitHubReaderApp.getAppContext(), response.body());
            mListView.setAdapter(mAdapter);
        } else {
         mAdapter.update(response.body());
        }
        hideProgressDialog();
    }

    @Override
    public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
        hideProgressDialog();
    }
}
