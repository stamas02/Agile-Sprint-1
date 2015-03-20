package com.aptitudeguru.dashboard.Tests;
import com.aptitudeguru.dashboard.AndroidDashboardDesignActivity;
import com.aptitudeguru.dashboard.CTable;
import com.aptitudeguru.dashboard.DatabaseHandler;
import com.aptitudeguru.dashboard.QuestionRecord;

/*
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
*/
import android.R.bool;
import java.util.List;
import java.util.Locale;
import junit.framework.TestCase;


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
				
		return checkedTestQestion;

	}
	
	
	//@Before
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
		
	
    //@Test
    public void testConversionMethod() {
    	assertTrue("Error! ", createObject());
    }
	
}





