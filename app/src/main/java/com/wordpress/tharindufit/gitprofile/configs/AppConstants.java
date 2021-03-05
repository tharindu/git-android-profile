package com.wordpress.tharindufit.gitprofile.configs;

import com.wordpress.tharindufit.gitprofile.BuildConfig;

/**
 * Common constants required by other classes.
 */
public class AppConstants {

    // Github GraphQL API root endpoint
    public static final String GITHUB_GRAPHQL_API_URL = "https://api.github.com/graphql";

    // Git personal access token with permissions: public_repo, read:user, user:email
    public static final String GITHUB_AUTH_HEADER = "Bearer " + BuildConfig.GIT_PERSONAL_ACCESS_TOKEN;
}
