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
    }

    public void setData(UserQuery.Node2 node) {
        this.login = node.owner().login();
        this.avatarUrl = node.owner().avatarUrl().toString();
        this.name = node.name();
        this.description = node.description();
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

}
