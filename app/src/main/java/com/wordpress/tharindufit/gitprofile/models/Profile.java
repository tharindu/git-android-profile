package com.wordpress.tharindufit.gitprofile.models;

import com.wordpress.tharindufit.gitprofile.UserQuery;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Sets data from ApolloGraphQL query data
     * @param response
     */
    public void setData(UserQuery.Data response) {
        UserQuery.Viewer viewer = response.viewer();
        this.login = viewer.login();
        this.avatarUrl = viewer.avatarUrl().toString();
        this.name = viewer.name();
        this.email = viewer.email();
        this.followers = viewer.followers().totalCount();
        this.following = viewer.following().totalCount();

        // append pinned repositories
        pinnedRepos = new ArrayList<Repository>();
        for (UserQuery.Node node : viewer.pinnedItems().nodes()) {
            Repository repo = new Repository();
            repo.setData(node);
            pinnedRepos.add(repo);
        }

        // append top repositories
        topRepos = new ArrayList<Repository>();
        for (UserQuery.Node2 node : viewer.topRepositories().nodes()) {
            Repository repo = new Repository();
            repo.setData(node);
            topRepos.add(repo);
        }

        // append starred repositories
        starredRepos = new ArrayList<Repository>();
        for (UserQuery.Node1 node : viewer.starredRepositories().nodes()) {
            Repository repo = new Repository();
            repo.setData(node);
            starredRepos.add(repo);
        }
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

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public ArrayList<Repository> getPinnedRepos() {
        return pinnedRepos;
    }

    public ArrayList<Repository> getTopRepos() {
        return topRepos;
    }

    public ArrayList<Repository> getStarredRepos() {
        return starredRepos;
    }
}
