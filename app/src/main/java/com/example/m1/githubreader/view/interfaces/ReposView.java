package com.example.m1.githubreader.view.interfaces;

import com.example.m1.githubreader.model.data.GitHubRepo;

import java.util.List;

/**
 * Created by Markov O on 28.09.16.
 */

public interface ReposView extends GiHubReaderView  {

    String getSearchString();
    void setSearchString(String query);
    void setList(List<GitHubRepo> repos);
    void setTitle(String title);

}
