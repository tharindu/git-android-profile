package com.wordpress.tharindufit.gitprofile;

import android.util.Log;

import com.wordpress.tharindufit.gitprofile.interfaces.ApplicationGraph;
import com.wordpress.tharindufit.gitprofile.interfaces.DaggerApplicationGraph;
import com.wordpress.tharindufit.gitprofile.models.Profile;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for Github user profile business logic
 */
public class ProfileUnitTests {

    @Test
    public void userProfile_comparision() {
        ApplicationGraph applicationGraph = DaggerApplicationGraph.create();
        Profile profile1 = applicationGraph.userProfile();
        Profile profile2 = applicationGraph.userProfile();
        assert(profile1 != null);
        assert(profile2 != null);
        assert(profile1 != profile2);
    }
}