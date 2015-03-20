package com.aptitudeguru.dashboard.Tests;
import com.aptitudeguru.dashboard.AndroidDashboardDesignActivity;
import com.aptitudeguru.dashboard.CTable;
import com.aptitudeguru.dashboard.DatabaseHandler;
import com.aptitudeguru.dashboard.QuestionRecord;


import android.R.bool;

import java.util.List;
import java.util.Locale;

import junit.framework.TestCase;


public class testConversionGB extends TestCase {
	
	public testConversionGB(String name) {		
		super(name);
	}
	
	protected void setUp() throws Exception {
	    super.setUp();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
			
	String str1 = "km Rs. 23 km/h kmph rupees ";
	String str2 = getQuestion();
	
	/* this method is not declared as static in the
	 * original code (see QuestionRecord) and in 
	 * order to prevent unwanted behaviour I left
	 * it like that there, here's a copy 
	 * of it that uses str1 instead of _questiontext 
	 * and is for GB:
	 */
	public String getQuestion() {
		
		String questionText =  str1;
		String checkedTestQestion = "";
			
		return checkedTestQestion;

	}
	
	
	public boolean createObject() {	//£		
		if (str2.contains("£") && str2.contains("mph") && 
				str2.contains("miles") && str2.contains("pounds")){
			return true;
		} else
			return false;		
	}
		
	
    public void testConversionMethod() {
    	assertTrue("Error! Not yet converted.", createObject());
    }
	
}





