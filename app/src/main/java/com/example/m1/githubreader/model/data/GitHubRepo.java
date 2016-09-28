package com.example.m1.githubreader.model.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by M1 on 23.08.2016.
 */
@SuppressWarnings("unused")
public class GitHubRepo {

    @SerializedName("full_name")
    private String mFullName;
    @SerializedName("description")
    private String mDescription;

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
