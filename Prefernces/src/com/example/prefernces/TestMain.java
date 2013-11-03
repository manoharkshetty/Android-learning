package com.example.prefernces;

import junit.framework.TestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.jayway.android.robotium.solo.*;

public class TestMain extends  ActivityInstrumentationTestCase2<MainActivity> {
	private Solo solo;

	public TestMain() {
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
   solo=new Solo(getInstrumentation(),getActivity());
		
	}
	public void testdisplayPrefernces(){
		String s="manohar";
		EditText ed=solo.getEditText(R.id.editText1);
		solo.enterText(ed, s);
		solo.goBack();
		   this.launchActivity(null, MainActivity.class, null);
		
	}



	protected void tearDown() throws Exception {
		super.tearDown();
		solo.finishOpenedActivities();
	}
	

}
