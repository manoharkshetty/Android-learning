package com.example.listviewsample;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.example.listviewsample.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TabHost.TabSpec;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

 
public class MainActivity extends Activity implements
        OnItemClickListener {
	 public TabHost myTabHost;
 
    public static final String[] titles = new String[] { "Strawberry",
            "Banana", "Orange", "Mixed" };
 
    public static final String[] descriptions = new String[] {
            "It is an aggregate accessory fruit",
            "It is the largest herbaceous flowering plant", "Citrus Fruit",
            "Mixed Fruits" };
 
    public static final Integer[] images = { R.drawable.michael,
            R.drawable.michael, R.drawable.michael, R.drawable.michael };
 
   public ListView listView;
    public List<LazyAdapter> rowItems;
   
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       myTabHost =(TabHost) findViewById(R.id.TabHost01);
    	// Before adding tabs, it is imperative to call the method setup()
    	                myTabHost.setup();
    	 
    	// Adding tabs
    	    // tab1 settings
    	        TabSpec spec = myTabHost.newTabSpec("tab_creation");
    	    // text and image of tab
    	        spec.setIndicator(null,getResources().getDrawable(R.drawable.icons));
    	    // specify layout of tab
    	        spec.setContent(R.id.onglet1);
    	    // adding tab in TabHost
    	        myTabHost.addTab(spec);
    	 
    	// otherwise :
    	myTabHost.addTab(myTabHost.newTabSpec("tab_inser").setIndicator(null,getResources().getDrawable(R.drawable.icons)).setContent(R.id.Onglet2));
    	 
    	myTabHost.addTab(myTabHost.newTabSpec("tab_affiche").setIndicator(null,getResources().getDrawable(R.drawable.icons)).setContent(R.id.Onglet3));
    	
    	myTabHost.addTab(myTabHost.newTabSpec("tab_affiche").setIndicator(null,getResources().getDrawable(R.drawable.icons)).setContent(R.id.Onglet3));
    	          
    	    
    
 
        rowItems = new ArrayList<LazyAdapter>();
        for (int i = 0; i < titles.length; i++) {
            LazyAdapter item = new LazyAdapter(images[i], titles[i], descriptions[i]);
            rowItems.add(item);
            Log.i("msg", titles[i]);
        }

        listView = (ListView) findViewById(R.id.list);
        CustomAdapter adapter = new CustomAdapter(this,
                R.layout.list_row, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

 
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
            "Item " + (position + 1) + ": " + rowItems.get(position),
            Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}