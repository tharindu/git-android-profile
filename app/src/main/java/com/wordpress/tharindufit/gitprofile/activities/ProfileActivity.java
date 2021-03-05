package com.wordpress.tharindufit.gitprofile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.wordpress.tharindufit.gitprofile.R;
import com.wordpress.tharindufit.gitprofile.models.Profile;
import com.wordpress.tharindufit.gitprofile.presenters.ProfileActivityPresenter;

/**
 * Main Activity class displays Git Profile User Interface.
 */
public class ProfileActivity extends AppCompatActivity implements ProfileActivityPresenter.View {

    private ProfileActivityPresenter presenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // setup tool bar and user interface
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        this.progressBar = findViewById(R.id.progress_bar);

        // setup presenter
        this.presenter = new ProfileActivityPresenter(this);
    }

    @Override
    public void updateUserInterface(Profile profile) {

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}