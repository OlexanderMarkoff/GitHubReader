package com.example.m1.githubreader.utils;

import com.example.m1.githubreader.model.data.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M1 on 24.08.2016.
 */
public final class ReposListManager {

    private List<GitHubRepo> mMyRepos;
    private List<GitHubRepo> mOtherUserRepos;

    private static ReposListManager sInstance;

    private ReposListManager() {
        mMyRepos = new ArrayList<>();
        mOtherUserRepos = new ArrayList<>();
    }

    public static ReposListManager getInstance() {
        if (sInstance == null) {
            sInstance = new ReposListManager();
        }
        return sInstance;
    }

    public List<GitHubRepo> getOtherUserRepos() {
        return mOtherUserRepos;
    }

    public void setOtherUserRepos(List<GitHubRepo> otherUserRepos) {
        if (otherUserRepos == null) {
            mOtherUserRepos.clear();
        } else {
            mOtherUserRepos.addAll(otherUserRepos);
        }
    }

    public List<GitHubRepo> getMyRepos() {
        return mMyRepos;
    }

    public void setMyRepos(List<GitHubRepo> myRepos) {
        if (myRepos == null) {
            mMyRepos.clear();
        } else {
            mMyRepos.addAll(myRepos);
        }
    }
}
