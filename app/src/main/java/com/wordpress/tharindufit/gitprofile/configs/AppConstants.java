package com.wordpress.tharindufit.gitprofile.configs;

/**
 * Common constants required by other classes.
 */
public class AppConstants {

    // Github GraphQL API root endpoint
    public static final String GITHUB_GRAPHQL_API_URL = "https://api.github.com/graphql";

    // Git personal access token with permissions: public_repo, read:user, user:email
    // Ideally the value should be read from a local properties file and should not be committed.
    //TODO: Replace with a valid Personal Acccess Token
    public static final String GITHUB_PERSONAL_ACCESS_TOKEN = "d8d4e57a43133e7d5636eb416156846d119752fb";
}
