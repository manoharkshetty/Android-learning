package com.example.tabhost;

import java.util.Dictionary;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;



public class MainActivity extends Activity {
	private TabHost myTabHost;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  
	    myTabHost =(TabHost) findViewById(R.id.TabHost01);
	// Before adding tabs, it is imperative to call the method setup()
	                myTabHost.setup();
	 
	// Adding tabs
	    // tab1 settings
	        TabSpec spec = myTabHost.newTabSpec("tab_creation");
	    // text and image of tab
	        spec.setIndicator("Create adresse",getResources().getDrawable(android.R.drawable.ic_menu_add));
	    // specify layout of tab
	        spec.setContent(R.id.onglet1);
	    // adding tab in TabHost
	        myTabHost.addTab(spec);
	 
	// otherwise :
	myTabHost.addTab(myTabHost.newTabSpec("tab_inser").setIndicator("Delete",getResources().getDrawable(android.R.drawable.ic_menu_edit)).setContent(R.id.Onglet2));
	 
	myTabHost.addTab(myTabHost.newTabSpec("tab_affiche").setIndicator("Show All",getResources().getDrawable(android.R.drawable.ic_menu_view)).setContent(R.id.Onglet3));
	          
	    }
	

	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

