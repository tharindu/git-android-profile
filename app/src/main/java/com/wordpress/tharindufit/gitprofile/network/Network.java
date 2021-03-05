package com.wordpress.tharindufit.gitprofile.network;

import android.content.Context;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.apollographql.apollo.request.RequestHeaders;
import com.wordpress.tharindufit.gitprofile.R;
import com.wordpress.tharindufit.gitprofile.UserQuery;
import com.wordpress.tharindufit.gitprofile.configs.AppConstants;
import com.wordpress.tharindufit.gitprofile.interfaces.ResponseListener;
import com.wordpress.tharindufit.gitprofile.models.Profile;

import org.jetbrains.annotations.NotNull;

/**
 * Handles GraphQL API Calls.
 */
public class Network {

    private static final String TAG = Network.class.toString();

    private static Network instance = null;

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
    public void queryGithubProfile(final Context context, final ResponseListener listener) {

        ApolloClient apoloClient = ApolloClient.builder()
                .serverUrl(AppConstants.GITHUB_GRAPHQL_API_URL)
                .build();
        apoloClient.query(new UserQuery())
                .requestHeaders(RequestHeaders.builder()
                        .addHeader("Authorization", AppConstants.GITHUB_AUTH_HEADER)
                        .build())
                .enqueue(new ApolloCall.Callback<UserQuery.Data>() {
            @Override
            public void onResponse(@NotNull Response<UserQuery.Data> response) {
                Log.d(TAG, "Response: " + response.getData());
                // process data and notify response listener
                Profile profile = new Profile();
                profile.setData(response.getData());
                listener.onResponse(profile);
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {
                Log.e(TAG, "ERROR: " + e + " message: " + e.getMessage());
                // return error message to response listener
                if (e.getMessage().trim().equals("HTTP 401")) {
                    listener.onFailure(context.getString(R.string.error_in_github_access_token));
                } else {
                    listener.onFailure(e.getMessage());
                }
            }
        });
    }
}
