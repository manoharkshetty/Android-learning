package com.example.blog;

import java.lang.reflect.Array;

import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity<AsyncResponse> extends ListActivity {
	private AsyncHttpClient client;
	   static JSONObject jObj = null;
	    static String json = "";
	    private HttpResponse response;
	    private TextView text;
	
	
	private String url="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20feed%20where%20url%20%3D%20%22http%3A%2F%2Ffeeds.feedburner.com%2Fnettuts%22&format=json&diagnostics=true";
	
	
	private String[] objects={"manu","shree","ravi","rakesh"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	
	client=new AsyncHttpClient();
	client.get(url,null, new JsonHttpResponseHandler(){
	
		  @Override
		public void onSuccess(JSONObject resp) {
			
			  try {
				 JSONObject query=resp.getJSONObject("query");
				 JSONObject results=query.getJSONObject("results");
				 JSONArray item=results.getJSONArray("item");
				 for(int i=0;i<item.length();i++){
				 JSONObject obj= (JSONObject) item.get(i);
				 final String title=obj.getString("title");
				
				 Log.i("title",title);
				
				 }
			} catch (JSONException e) {
				Log.i("err","cant parse");
				// TODO Auto-generated catch block
			
			}
			
			
			
				
		}
		
	});
	  

	

	}
	
}
