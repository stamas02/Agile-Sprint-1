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


public class testConversionUS extends TestCase {
	
	public testConversionUS(String name) {		
		super(name);
	}
	
	protected void setUp() throws Exception {
	    super.setUp();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
			
	String str1 = "m  Rs. 23 km/h  metres km kmph rupees centimetres kg cm3 ";
	String str2 = getQuestion();
	
	/* this method is not declared as static in the
	 * original code (see QuestionRecord) and in 
	 * order to prevent unwanted behaviour I left
	 * it like that there, here's a copy 
	 * of it that uses str1 instead of _questiontext 
	 * and is for US:
	 */
	public String getQuestion() {
		
		String questionText =  str1;
		String checkedTestQestion = "";
		
		
		if (questionText.contains("km/hr ")) {
			checkedTestQestion = questionText.replaceAll("km/hr ", " mph ");
		} else {
			checkedTestQestion = questionText;
		}

		if (checkedTestQestion.contains("kmph ")) {
			checkedTestQestion = checkedTestQestion.replaceAll("kmph",	"mph");
			// System.out.println(questionText);
			// return questionText;
		}
		if (checkedTestQestion.contains("km ")) {
			checkedTestQestion = checkedTestQestion.replaceAll("km", "miles");
			// System.out.println(checkedTestQestion);
			// return checkedTestQestion;
		}
		// Log.d("OUTPUT: ", checkedTestQestion);
		// return checkedTestQestion;

		if (checkedTestQestion.contains(" Rs.")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" Rs.", " \\$");
			// return checkedTestQestion;
		}
		if (checkedTestQestion.contains(" Rs")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" Rs", " \\$");
			// return checkedTestQestion;
		}
		if (checkedTestQestion.contains("rupees")) {
			checkedTestQestion = checkedTestQestion.replaceAll("rupees", "dollars");
			// return checkedTestQestion;
		}
		if (checkedTestQestion.contains("rupee")) {
			checkedTestQestion = checkedTestQestion.replaceAll("rupee", "dollar");
			// return checkedTestQestion;
		}
				
		if (checkedTestQestion.contains("kg")) {
			checkedTestQestion = checkedTestQestion.replaceAll("kg", "pound(s)");
		}
		if (checkedTestQestion.contains("centimetres")) {
			checkedTestQestion = checkedTestQestion.replaceAll("centimetres", "inches");
		}
		if (checkedTestQestion.contains("centimetre")) {
			checkedTestQestion = checkedTestQestion.replaceAll("centimetre", "inch");
		}
		if (checkedTestQestion.contains(" cm")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" cm", " inches");
		}
		if (checkedTestQestion.contains(" metres")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" metres", " feet");
		}
		if (checkedTestQestion.contains(" m3")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" m3", " inches3");
		}
		if (checkedTestQestion.contains(" m2")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" m2", " inches2");
		}
		if (checkedTestQestion.contains(" mm")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" mm", " 1/10*inches");
		}
		if (checkedTestQestion.contains(" m ") || 
				checkedTestQestion.contains(" m,") ||
				checkedTestQestion.contains(" m.") ||
				checkedTestQestion.contains(" m-") ||
				checkedTestQestion.contains(" m -") ) {
			checkedTestQestion = checkedTestQestion.replaceAll(" m", " feet");
		}
		if (checkedTestQestion.contains(" g ") || checkedTestQestion.contains(" g/")) {
			checkedTestQestion = checkedTestQestion.replaceAll(" g", " 1/1000*pound");
		}
		return checkedTestQestion;

	}
	
	
	@Before
	public boolean createObject() {	//£		
		if (str2.contains("$") && str2.contains("mph") && 
				str2.contains("miles") && str2.contains("dollars") &&
				str2.contains("inches") && str2.contains("feet") && 
				str2.contains("pound(s)") && str2.contains("inches3")  && str2.contains("feet"))
			// added more explicit testing as US has more conversions
		{					
			return true;
		} else
			return false;		
	}
		
	
    @Test
    public void testConversionMethod() {
    	assertTrue("Error! ", createObject());
    }
	
}





