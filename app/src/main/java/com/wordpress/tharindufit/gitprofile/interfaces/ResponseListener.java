package com.wordpress.tharindufit.gitprofile.interfaces;

import com.wordpress.tharindufit.gitprofile.models.Profile;

/**
 * Response Listener interface to be called on request completion
 */
public interface ResponseListener {

    public void onResponse(Profile data);

    public void onFailure(String message);
}
