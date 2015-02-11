package com.mize.test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;



public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	public MainActivityTest() {
		super(MainActivity.class);
	}

	private int buttonId;
	private MainActivity activity;
	private LoginFragment mLoginFragment = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();


	    activity = this.getActivity();


	}



	public void testScreenshot() {

		
	    FragmentManager fragmentManager = getActivity().getFragmentManager();
	    mLoginFragment = (LoginFragment) fragmentManager.findFragmentByTag("HOME");
	    if (mLoginFragment == null) {

	    	mLoginFragment = (LoginFragment) waitForFragment("HOME", 10000);

	    }
		
		mLoginFragment.doLogin();
		
		
		
		
		
		
		

		
	}

	
	protected Fragment waitForFragment(String tag, int timeout) {
        long endTime = SystemClock.uptimeMillis() + timeout;
        while (SystemClock.uptimeMillis() <= endTime) {

            Fragment fragment = getActivity().getFragmentManager().findFragmentByTag(tag);
            if (fragment != null) {
                return fragment;
            }
        }
        return null;
    }

}
