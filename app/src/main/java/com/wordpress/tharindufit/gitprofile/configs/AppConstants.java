package com.wordpress.tharindufit.gitprofile.configs;

/**
 * Common constants required by other classes.
 */
public class AppConstants {

    // Github GraphQL API root endpoint
    public static final String GITHUB_GRAPHQL_API_URL = "https://api.github.com/graphql";

    // Git personal access token with permissions: public_repo, read:user, user:email
    // Ideally the value should be read from a local properties file and should not be committed.
    public static final String GITHUB_PERSONAL_ACCESS_TOKEN = "f6c3e12940a024105e6218ed8c2fd878d3bc6daa";
}
