package com.wordpress.tharindufit.gitprofile.models;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Model class for Git Profile.
 */
@Module
public class Profile {

    // profile username
    private String login;
    // profile avatar image url
    private String avatarUrl;
    // profile name
    private String name;
    // profile public email
    private String email;
    // profile followers count
    private int followers;
    // profile following count
    private int following;

    // list of pinned repositories for user profile
    private ArrayList<Repository> pinnedRepos;
    // list of top repositories of the user
    private ArrayList<Repository> topRepos;
    // list of starred repositories by user
    private ArrayList<Repository> starredRepos;

    @Inject
    public Profile() {

    }

    @Provides
    public ArrayList<Repository> providePinnedRepos() {
        return pinnedRepos;
    }

    @Provides
    public ArrayList<Repository> provideTopRepos() {
        return topRepos;
    }

    @Provides
    public ArrayList<Repository> provideStarredRepos() {
        return starredRepos;
    }


}
