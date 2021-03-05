package com.wordpress.tharindufit.gitprofile.models;

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

}
