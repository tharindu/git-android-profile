package com.wordpress.tharindufit.gitprofile.interfaces;

import com.wordpress.tharindufit.gitprofile.models.Profile;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Application Graph for Singleton User Profile.
 */
@Component
public interface ApplicationGraph {

    /**
     * Returns Github user profile instance
     * @return user profile
     */
    Profile userProfile();
}
