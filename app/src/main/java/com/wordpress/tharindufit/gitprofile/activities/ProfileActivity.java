package com.wordpress.tharindufit.gitprofile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wordpress.tharindufit.gitprofile.R;

/**
 * Main Activity class displays Git Profile User Interface.
 */
public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}