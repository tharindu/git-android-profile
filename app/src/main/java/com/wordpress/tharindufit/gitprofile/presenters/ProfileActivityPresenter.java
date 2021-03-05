package com.wordpress.tharindufit.gitprofile.presenters;

import com.wordpress.tharindufit.gitprofile.interfaces.ResponseListener;
import com.wordpress.tharindufit.gitprofile.models.Profile;
import com.wordpress.tharindufit.gitprofile.network.Network;

/**
 * Presenter for User Profile View.
 */
public class ProfileActivityPresenter {

    private static final String TAG = ProfileActivityPresenter.class.toString();

    // Github profile object
    private Profile profile;
    // Profile activity presenter view
    private View view;

    /**
     * Constructs Presenter for Profile activity
     * @param view
     */
    public ProfileActivityPresenter(final View view) {
        this.profile = new Profile();
        this.view = view;
        view.showProgressBar();
        // Query github profile
        Network.getInstance().queryGithubProfile(new ResponseListener() {
            @Override
            public void onResponse(Profile data) {
                // API call successfully completed
                view.updateUserInterface(data);
                view.hideProgressBar();
            }

            @Override
            public void onFailure(String message) {
                // API call failed to execute
                view.hideProgressBar();
            }
        });
    }

    /**
     * Presenter interface
     */
    public interface View {
        void updateUserInterface(Profile profile);
        void showProgressBar();
        void hideProgressBar();
    }
}
