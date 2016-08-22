package com.example.m1.githubreader.data;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by M1 on 22.08.2016.
 */
public class GitHubUser {
    @SerializedName("login")
    private String mLogin;
    @SerializedName("id")
    private int mId;
    @SerializedName("avatar_url")
    private String mAvatarUrl;
    @SerializedName("gravatar_id")
    private String mGravatarId;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("html_url")
    private String mHtmlUrl;
    @SerializedName("followers_url")
    private String mFollowersUrl;
    @SerializedName("following_url")
    private String mFollowingUrl;
    @SerializedName("gists_url")
    private String mGistsUrl;
    @SerializedName("starred_url")
    private String mStarredUrl;
    @SerializedName("subscriptions_url")
    private String mSubscriptionsUrl;
    @SerializedName("organizations_url")
    private String mOrganizationsUrl;
    @SerializedName("repos_url")
    private String mReposUrl;
    @SerializedName("events_url")
    private String mEventsUrl;
    @SerializedName("received_events_url")
    private String mReceivedEventsUrl;
    @SerializedName("User")
    private String mUser;
    @SerializedName("type")
    private String mType;
    @SerializedName("site_admin")
    private String mSiteAdmin;
    @SerializedName("name")
    private String mName;
    @SerializedName("company")
    private String mCompany;
    @SerializedName("blog")
    private String mBlog;
    @SerializedName("location")
    private String mLocation;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("hireable")
    private String mHireable;
    @SerializedName("bio")
    private String mBio;
    @SerializedName("public_repos")
    private int mPublicRepos;
    @SerializedName("public_gists")
    private int mPublicGists;
    @SerializedName("followers")
    private int mFollowers;
    @SerializedName("following")
    private int mFollowing;
    @SerializedName("created_at")
    private Date mCreatedAt;
    @SerializedName("updated_at")
    private Date mUpdatedAt;
    @SerializedName("private_gists")
    private int mPrivateGists;
    @SerializedName("total_private_repos")
    private int mTotalPrivateRepos;
    @SerializedName("owned_private_repos")
    private int mOwnedPrivateRepos;
    @SerializedName("disk_usage")
    private int mDiskUsage;
    @SerializedName("collaborators")
    private int mCollaborators;
    @SerializedName("plan")
    private GitHubUserPlan mPlan;

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return mGravatarId;
    }

    public void setGravatarId(String gravatarId) {
        mGravatarId = gravatarId;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        mHtmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return mFollowersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        mFollowersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return mFollowingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        mFollowingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return mGistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        mGistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return mStarredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        mStarredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return mSubscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        mSubscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return mOrganizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        mOrganizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return mReposUrl;
    }

    public void setReposUrl(String reposUrl) {
        mReposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return mEventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        mEventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return mReceivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        mReceivedEventsUrl = receivedEventsUrl;
    }

    public String getUser() {
        return mUser;
    }

    public void setUser(String user) {
        mUser = user;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getSiteAdmin() {
        return mSiteAdmin;
    }

    public void setSiteAdmin(String siteAdmin) {
        mSiteAdmin = siteAdmin;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCompany() {
        return mCompany;
    }

    public void setCompany(String company) {
        mCompany = company;
    }

    public String getBlog() {
        return mBlog;
    }

    public void setBlog(String blog) {
        mBlog = blog;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getHireable() {
        return mHireable;
    }

    public void setHireable(String hireable) {
        mHireable = hireable;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }

    public int getPublicRepos() {
        return mPublicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        mPublicRepos = publicRepos;
    }

    public int getPublicGists() {
        return mPublicGists;
    }

    public void setPublicGists(int publicGists) {
        mPublicGists = publicGists;
    }

    public int getFollowers() {
        return mFollowers;
    }

    public void setFollowers(int followers) {
        mFollowers = followers;
    }

    public int getFollowing() {
        return mFollowing;
    }

    public void setFollowing(int following) {
        mFollowing = following;
    }

    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        mCreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public int getPrivateGists() {
        return mPrivateGists;
    }

    public void setPrivateGists(int privateGists) {
        mPrivateGists = privateGists;
    }

    public int getTotalPrivateRepos() {
        return mTotalPrivateRepos;
    }

    public void setTotalPrivateRepos(int totalPrivateRepos) {
        mTotalPrivateRepos = totalPrivateRepos;
    }

    public int getOwnedPrivateRepos() {
        return mOwnedPrivateRepos;
    }

    public void setOwnedPrivateRepos(int ownedPrivateRepos) {
        mOwnedPrivateRepos = ownedPrivateRepos;
    }

    public int getDiskUsage() {
        return mDiskUsage;
    }

    public void setDiskUsage(int diskUsage) {
        mDiskUsage = diskUsage;
    }

    public int getCollaborators() {
        return mCollaborators;
    }

    public void setCollaborators(int collaborators) {
        mCollaborators = collaborators;
    }

    public GitHubUserPlan getPlan() {
        return mPlan;
    }

    public void setPlan(GitHubUserPlan plan) {
        mPlan = plan;
    }
}
