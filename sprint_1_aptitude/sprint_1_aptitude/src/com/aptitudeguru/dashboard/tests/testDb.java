package com.aptitudeguru.dashboard.tests;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.test.AndroidTestCase;

import com.aptitudeguru.dashboard.CTable;
import com.aptitudeguru.dashboard.DatabaseHandler;

import junit.framework.TestCase;

public class testDb extends AndroidTestCase {

	//
	public testDb(String name) {		
		super();
	}

    public void test() {
	    //List<CTable> tmp = db.getAllC();
    	
    	DatabaseHandler db = new DatabaseHandler(this.getContext());
	    int i = 2;
	    assertEquals(2, 2);
	}
	
	
	
}
