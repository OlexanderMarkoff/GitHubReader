package com.example.m1.githubreader.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.m1.githubreader.R;

/**
 * Created by Markov O on 19.08.16.
 */
public abstract class GitHubReaderActivity extends Activity implements View.OnClickListener {

    private AlertDialog mInfoDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        setUI(savedInstanceState);
    }

    protected abstract void initUI();
    protected abstract void setUI(Bundle savedInstanceState);

    public void showInfoDialog(final int titleRes, final int contentRes) {
        showInfoDialog(getString(titleRes), getString(contentRes));
    }

    public void showInfoDialog(final String title, final String content) {
        if (!isFinishing() && mInfoDialog != null && mInfoDialog.isShowing())
            return;

        @SuppressLint("InflateParams")
        final View customView = getLayoutInflater().inflate(R.layout.layout_dialog_warning, null, false);
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
}
