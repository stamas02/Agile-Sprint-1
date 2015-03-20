package com.aptitudeguru.dashboard.Tests;
import com.aptitudeguru.dashboard.AndroidDashboardDesignActivity;
import com.aptitudeguru.dashboard.CTable;
import com.aptitudeguru.dashboard.DatabaseHandler;
import com.aptitudeguru.dashboard.QuestionRecord;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import android.R.bool;

import java.util.List;
import java.util.Locale;

import org.junit.Test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;


public class testConversionFR extends TestCase {
	
	public testConversionFR(String name) {		
		super(name);
	}
	
	protected void setUp() throws Exception {
	    super.setUp();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
			
	String str1 = " feet Rs. 23  rupees miles";
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
	
		
		if (questionText.contains(" Rs.")) {
			checkedTestQestion = questionText.replaceAll(" Rs.", " \\€");
			// return checkedTestQestion;
		} else {
			checkedTestQestion = questionText;
		}
		if (checkedTestQestion.contains(" Rs")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" Rs", " \\€");
			// return checkedTestQestion;
		}
		if (checkedTestQestion.contains("rupees")) {
			checkedTestQestion = checkedTestQestion.replaceAll("rupees", "euros");
			// return checkedTestQestion;
		}
		if (checkedTestQestion.contains("rupee")) {
			checkedTestQestion = checkedTestQestion.replaceAll("rupee",	"euro");
			// return checkedTestQestion;
		}
		if (checkedTestQestion.contains(" feet")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" feet",	" meters");
			// return checkedTestQestion;
		}
		if (checkedTestQestion.contains(" ft")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" ft", " meters");
			// return checkedTestQestion;
		}
		if (checkedTestQestion.contains(" miles")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" miles", " km");
			// return checkedTestQestion;
		}
		if (checkedTestQestion.contains(" mile")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" mile", " km");
			// return checkedTestQestion;
		}

		return checkedTestQestion;

	}
	
	
	@Before
	public boolean createObject() {		
		if (str2.contains("€") && str2.contains("meters") && str2.contains("km") ){
			return true;
		} else
			return false;		
	}
		
	
    @Test
    public void testConversionMethod() {
    	assertTrue("Error! Not yet converted.", createObject());
    }
	
}





