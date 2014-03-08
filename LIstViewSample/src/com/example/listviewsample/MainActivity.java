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
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
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
 
    public static final String[] playerNames = new String[] { "Mohith Mehta","Lokesh Chauhan","Avinash Bhandari",
    	"Ravindra Kumar","Kedar Shiroor","Sanal Nair","Utkarsh Rathore","Karthik Viswanathan"};
 
    public static final String[] teamNames = new String[] {
    	"The Bulldozers","Jhaaduwale","chasers_11","Test","King Julian's Lemurs",
    	"CrimeMasterGogo","Doppelganger","Tester"};
    public static final Integer[] transfers={4,5,5,5,5,5,5,30};
    public static final Integer[] points={4057,3793,3611,3442,2668,2364,943,0};
 
   public ListView listView;
    public List<LazyAdapter> rowItems;
    public String[] playername=new String[10];
    int i=0;
   
    
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
    	myTabHost.addTab(myTabHost.newTabSpec("tab_creation").setIndicator(null,getResources().getDrawable(R.drawable.icons)).setContent(R.id.Onglet2));
    	 
    	myTabHost.addTab(myTabHost.newTabSpec("tab_creation").setIndicator(null,getResources().getDrawable(R.drawable.icons)).setContent(R.id.Onglet3));
    	
    	myTabHost.addTab(myTabHost.newTabSpec("tab_creation").setIndicator(null,getResources().getDrawable(R.drawable.icons)).setContent(R.id.Onglet3));
    	          
    	    
    	
    	Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
	    while (cursor.moveToNext()) {
	    	
	         playername[i++] = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
	        if(i==playerNames.length)
	        	break;
	   
	    }
        rowItems = new ArrayList<LazyAdapter>();
        for (int i = 0; i < playerNames.length; i++) {
            LazyAdapter item = new LazyAdapter(R.drawable.michael, playername[i], teamNames[i],transfers[i],points[i],i+1);
            rowItems.add(item);
           
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

@Override
public boolean onCreateOptionsMenu(Menu menu) {
  MenuInflater inflater = getMenuInflater();
  inflater.inflate(R.menu.main, menu);
  return true;
} 
}
