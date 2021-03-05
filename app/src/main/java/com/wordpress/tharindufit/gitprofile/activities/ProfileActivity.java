package com.wordpress.tharindufit.gitprofile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wordpress.tharindufit.gitprofile.R;
import com.wordpress.tharindufit.gitprofile.models.Profile;
import com.wordpress.tharindufit.gitprofile.models.Repository;
import com.wordpress.tharindufit.gitprofile.presenters.ProfileActivityPresenter;

/**
 * Main Activity class displays Git Profile User Interface.
 */
public class ProfileActivity extends AppCompatActivity implements ProfileActivityPresenter.View {

    private ProfileActivityPresenter presenter;

    private ProgressBar progressBar;

    // Profile Basic information
    private ImageView avatarImageView;
    private TextView nameTextView;
    private TextView usernameTextView;
    private TextView emailTextView;
    private TextView followersCountTextView;
    private TextView followingCountTextView;

    // Pinned, Top, and Starred Repositories
    private ScrollView pinnedScrollView;
    private ScrollView topReposScrollView;
    private ScrollView starredReposScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // setup tool bar and user interface
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initUIElements();

        // setup presenter
        this.presenter = new ProfileActivityPresenter(this);
    }

    // Initializes UI elements
    private void initUIElements() {
        this.progressBar = findViewById(R.id.progress_bar);
        this.avatarImageView = findViewById(R.id.avatar_imageview);

        this.nameTextView = findViewById(R.id.name_textview);
        this.usernameTextView = findViewById(R.id.username_textview);
        this.emailTextView = findViewById(R.id.email_textview);
        this.followersCountTextView = findViewById(R.id.follower_count_textview);
        this.followingCountTextView = findViewById(R.id.following_count_textview);

        this.pinnedScrollView = findViewById(R.id.pinned_scrollview);
        this.topReposScrollView = findViewById(R.id.top_scrollview);
        this.starredReposScrollView = findViewById(R.id.starred_scrollview);
    }

    @Override
    public void updateUserInterface(final Profile profile) {
        runOnUiThread(new Runnable() {
            public void run() {
                // user profile basic information
                Picasso.get().load(profile.getAvatarUrl()).into(avatarImageView);
                nameTextView.setText(profile.getName());
                usernameTextView.setText(profile.getLogin());
                emailTextView.setText(profile.getEmail().isEmpty() ? getString(R.string.email_label) : profile.getEmail());
                followersCountTextView.setText(String.valueOf(profile.getFollowers()));
                followingCountTextView.setText(String.valueOf(profile.getFollowing()));
                // Pinned Repositories
                LinearLayout pinnedLL = new LinearLayout(nameTextView.getContext());
                pinnedLL.setOrientation(LinearLayout.VERTICAL);
                pinnedLL.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                for (Repository repo : profile.getPinnedRepos()) {
                    pinnedLL.addView(createRepoLayout(repo, true));
                }
                pinnedScrollView.addView(pinnedLL);

                // Top Repositories
                LinearLayout topLL = new LinearLayout(nameTextView.getContext());
                topLL.setOrientation(LinearLayout.HORIZONTAL);
                topLL.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
                for (Repository repo : profile.getTopRepos()) {
                    topLL.addView(createRepoLayout(repo, false));
                }
                topReposScrollView.addView(topLL);

                // Starred Repositories
                LinearLayout starredLL = new LinearLayout(nameTextView.getContext());
                starredLL.setOrientation(LinearLayout.HORIZONTAL);
                starredLL.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
                for (Repository repo : profile.getStarredRepos()) {
                    starredLL.addView(createRepoLayout(repo, false));
                }
                starredReposScrollView.addView(starredLL);
            }
        });
    }

    private View createRepoLayout(Repository repo, boolean fullWidth) {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.repo_cardview, null);
        int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 220, getResources().getDisplayMetrics());
        int height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 164, getResources().getDisplayMetrics());
        v.setLayoutParams(new LinearLayout.LayoutParams(fullWidth ? ActionBar.LayoutParams.MATCH_PARENT : width, height));

        ImageView ownerImageView = v.findViewById(R.id.owner_imageview);
        TextView ownerTextView = v.findViewById(R.id.owner_textview);
        TextView nameTextView = v.findViewById(R.id.name_textview);
        TextView descTextView = v.findViewById(R.id.desc_textview);
        TextView starredTextView = v.findViewById(R.id.starred_textview);
        TextView langTextView = v.findViewById(R.id.language_textview);

        Picasso.get().load(repo.getAvatarUrl()).into(ownerImageView);
        ownerTextView.setText(repo.getLogin());
        nameTextView.setText(repo.getName());
        descTextView.setText(repo.getDescription());
        starredTextView.setText(String.valueOf(repo.getStarred()));
        langTextView.setText(repo.getPrimaryLanguage());
        return v;
    }

    @Override
    public void showProgressBar() {
        runOnUiThread(new Runnable() {
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void hideProgressBar() {
        runOnUiThread(new Runnable() {
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}