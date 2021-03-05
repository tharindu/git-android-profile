package com.wordpress.tharindufit.gitprofile.models;

import com.wordpress.tharindufit.gitprofile.UserQuery;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Provides;

/**
 * Repository model objects represent user's git repos.
 */
public class Repository {

    // owner login username
    private String login;
    // owner avatar image url
    private String avatarUrl;
    // repository name
    private String name;
    // repository description
    private String description;
    // starred count
    private int starred;
    // primary language
    private String primaryLanguage;

    @Inject
    public Repository() {

    }

    public void setData(UserQuery.Node node) {

    }

    public void setData(UserQuery.Node1 node) {
        this.login = node.owner().login();
        this.avatarUrl = node.owner().avatarUrl().toString();
        this.name = node.name();
        this.description = node.description();
        this.starred = node.stargazerCount();
        this.primaryLanguage = (node.primaryLanguage() != null) ? node.primaryLanguage().name() : "";
    }

    public void setData(UserQuery.Node2 node) {
        this.login = node.owner().login();
        this.avatarUrl = node.owner().avatarUrl().toString();
        this.name = node.name();
        this.description = node.description();
        this.starred = node.stargazerCount();
        this.primaryLanguage = (node.primaryLanguage() != null) ? node.primaryLanguage().name() : "";
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStarred() {
        return starred;
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

}
