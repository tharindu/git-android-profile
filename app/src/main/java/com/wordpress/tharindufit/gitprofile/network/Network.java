package com.wordpress.tharindufit.gitprofile.network;

import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.apollographql.apollo.request.RequestHeaders;
import com.wordpress.tharindufit.gitprofile.UserQuery;
import com.wordpress.tharindufit.gitprofile.configs.AppConstants;
import com.wordpress.tharindufit.gitprofile.interfaces.ResponseListener;
import com.wordpress.tharindufit.gitprofile.models.Profile;
import com.wordpress.tharindufit.gitprofile.presenters.ProfileActivityPresenter;

import org.jetbrains.annotations.NotNull;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Handles GraphQL API Calls.
 */
public class Network {

    private static final String TAG = Network.class.toString();

    private static Network instance = null;
    private static String AUTH_HEADER = "Bearer " + AppConstants.GITHUB_PERSONAL_ACCESS_TOKEN;

    /**
     * private constructor to avoid creating new objects
     */
    private Network() {

    }

    /**
     * Returns singleton Analytics instance
     * @return
     */
    public static Network getInstance() {
        if (instance == null) {
            instance = new Network();
        }
        return instance;
    }

    /**
     * Queries Github user profile using GraphQL
     */
    public void queryGithubProfile(final ResponseListener listener) {

        ApolloClient apoloClient = ApolloClient.builder()
                .serverUrl(AppConstants.GITHUB_GRAPHQL_API_URL)
                .build();
        apoloClient.query(new UserQuery())
                .requestHeaders(RequestHeaders.builder()
                        .addHeader("Authorization", AUTH_HEADER)
                        .build())
                .enqueue(new ApolloCall.Callback<UserQuery.Data>() {
            @Override
            public void onResponse(@NotNull Response<UserQuery.Data> response) {
                Log.d(TAG, "Response: " + response.getData());
                //TODO: process data and notify response listener
                listener.onResponse(new Profile());
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {
                Log.e(TAG, "ERROR: " + e);
                // return error message to response listener
                listener.onFailure(e.getMessage());
            }
        });
    }
}
