package com.example.m1.githubreader.view.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.m1.githubreader.R;
import com.example.m1.githubreader.presenter.Presenter;
import com.example.m1.githubreader.view.interfaces.GiHubReaderView;

/**
 * Created by Markov O on 19.08.16.
 */
public abstract class GitHubReaderActivity<T extends Presenter> extends Activity implements View.OnClickListener, GiHubReaderView {

    private AlertDialog mInfoDialog;
    private ProgressDialog mSpinnerDialog;
    protected boolean mIsDestroyed;

    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        setUI(savedInstanceState);
        mPresenter = getNeededPresenter();
        mPresenter.subscribe(this);
        mPresenter.restoreData();
        mIsDestroyed = false;
        mSpinnerDialog = new ProgressDialog(this);
        mSpinnerDialog.setMessage(getString(R.string.login_activity_login_in_process));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter.isSubscribed(this)) {
            mPresenter.saveData();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSpinnerDialog.hide();
        mIsDestroyed = true;
    }

    protected abstract T getNeededPresenter();

    protected abstract void initUI();

    protected abstract void setUI(Bundle savedInstanceState);

    public void showInfoDialog(final int titleRes, final int contentRes) {
        showInfoDialog(getString(titleRes), getString(contentRes));
    }

    public void showInfoDialog(final String title, final String content) {
        if (!isFinishing() && mInfoDialog != null && mInfoDialog.isShowing())
            return;

        @SuppressLint("InflateParams")
        final View customView = getLayoutInflater().inflate(R.layout.dialog_warning, null, false);
        final View warningIcon = customView.findViewById(R.id.img_dialog_warning);
        final TextView txtTitle = (TextView) customView.findViewById(R.id.txt_dialog_warning_title);
        final TextView txtContent = (TextView) customView.findViewById(R.id.txt_dialog_warning_content);
        final Button btnNeutral = (Button) customView.findViewById(R.id.btn_dialog_warning_neutral);

        btnNeutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mInfoDialog.dismiss();
            }
        });

        txtTitle.setText(title);
        txtContent.setText(content);

        mInfoDialog = new AlertDialog.Builder(this, R.style.WarningDialogStyle)
                .setView(customView)
                .create();
        mInfoDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(final DialogInterface dialog) {
                warningIcon.animate()
                        .setInterpolator(new AccelerateDecelerateInterpolator())
                        .rotationYBy(360F)
                        .setDuration(1000L)
                        .setStartDelay(100L)
                        .start();
            }
        });
        mInfoDialog.show();
    }

    public void showProgressDialog() {
        if (mIsDestroyed) return;
        if (mSpinnerDialog != null) {
            if (mSpinnerDialog.isShowing()) {
                hideProgressDialog();
            }
            mSpinnerDialog.show();
        }
    }

    public void hideProgressDialog() {
        if (mIsDestroyed) return;
        if (mSpinnerDialog != null && mSpinnerDialog.isShowing()) {
            mSpinnerDialog.hide();
        }
    }

    @Override
    public void onClick(View v) {
        mPresenter.onClick(v);
    }
}
