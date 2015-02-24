package com.aptitudeguru.dashboard.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import androidhive.dashboard.R;

import com.aptitudeguru.dashboard.AndroidDashboardDesignActivity;

public class AndroidDashboardDesignActivityTest extends ActivityUnitTestCase<AndroidDashboardDesignActivity> {

	private AndroidDashboardDesignActivity activity;
	
	public AndroidDashboardDesignActivityTest() {
		super(AndroidDashboardDesignActivity.class);
	}
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), AndroidDashboardDesignActivity.class);
	startActivity(intent, null, null);
	activity = getActivity();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testOnClick() {
		// Verify button exists on screen
		Button btnFav = (Button) activity.findViewById(R.id.btn_fav);
		assertNotNull("Button should not be null", btnFav);
		
		//Trigger a click on the button
		btnFav.performClick();
		
		// Verify the intent was started with correct result
		Intent triggeredIntent = getStartedActivityIntent();
		assertNotNull("Intent should have triggered after button press", triggeredIntent);
	}
}

