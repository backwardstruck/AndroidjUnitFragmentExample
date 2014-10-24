package com.servicelive.android.servicelivepro.test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;

import com.servicelive.android.servicelivepro.activity.MainActivity;
import com.servicelive.android.servicelivepro.fragment.LoginFragment;

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
		//Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
		//startActivity(intent, null, null);
		//activity = getActivity();
		

	    activity = this.getActivity();


	}

	public void testLayout() {
		/*assertNotNull(activity.findViewById(R.id.navBar));
		View view = activity.findViewById(R.id.navBar);
		view.setVisibility(View.VISIBLE);
		assertEquals(view.getVisibility(), View.VISIBLE);*/
	}

	public void testScreenshot() {
		//assertNotNull(activity);

		/*Instrumentation mInstr = this.getInstrumentation();
		mInstr.callActivityOnCreate(activity, null);
		mInstr.callActivityOnResume(activity);

		LoginFragment lf = (LoginFragment) waitForFragment("HOME", 10000);

		
		 */
		
	    FragmentManager fragmentManager = getActivity().getFragmentManager();
	    mLoginFragment = (LoginFragment) fragmentManager.findFragmentByTag("HOME");
	    if (mLoginFragment == null) {

	    	mLoginFragment = (LoginFragment) waitForFragment("HOME", 10000);

	    }
		
		mLoginFragment.doLogin();
		
		
		
		
		
		
		

		
	}

	/*
	 * public void testLogin() { FragmentManager fragmentManager =
	 * activity.getFragmentManager(); FragmentTransaction ft =
	 * fragmentManager.beginTransaction();
	 * 
	 * LoginFragment lf = new LoginFragment(); if (!lf.isAdded()) {
	 * ft.add(R.id.content, lf, "HOME"); ft.commit();
	 * 
	 * fragmentManager.executePendingTransactions();
	 * 
	 * lf.doLogin(); }
	 * 
	 * }
	 */
	
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
