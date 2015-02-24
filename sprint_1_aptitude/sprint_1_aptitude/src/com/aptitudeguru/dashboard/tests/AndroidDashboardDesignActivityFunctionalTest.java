package com.aptitudeguru.dashboard.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aptitudeguru.dashboard.AndroidDashboardDesignActivity;

import android.test.ActivityInstrumentationTestCase2;

public class AndroidDashboardDesignActivityFunctionalTest extends
		ActivityInstrumentationTestCase2<AndroidDashboardDesignActivity> {
	
	private AndroidDashboardDesignActivity activity;
	
	public AndroidDashboardDesignActivityFunctionalTest() {
		super(AndroidDashboardDesignActivity.class);
	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
