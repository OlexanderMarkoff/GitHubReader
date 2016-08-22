package com.example.m1.githubreader.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by M1 on 22.08.2016.
 */
public class GitHubUserPlan {

    @SerializedName("name")
    private String mName;
    @SerializedName("space")
    private String mSpace;
    @SerializedName("collaborators")
    private String mCollaborators;
    @SerializedName("private_repos")
    private String mPrivateRepos;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSpace() {
        return mSpace;
    }

    public void setSpace(String space) {
        mSpace = space;
    }

    public String getCollaborators() {
        return mCollaborators;
    }

    public void setCollaborators(String collaborators) {
        mCollaborators = collaborators;
    }

    public String getPrivateRepos() {
        return mPrivateRepos;
    }

    public void setPrivateRepos(String privateRepos) {
        mPrivateRepos = privateRepos;
    }
}
