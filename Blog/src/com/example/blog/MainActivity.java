package com.example.blog;

import java.lang.reflect.Array;

import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

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

public class MainActivity extends Activity {
	private AsyncHttpClient client;
	  
	
	
	private String url="http://10.0.2.2/serverconnectiondemo/serverconnection.php";
	RequestParams params=new RequestParams();

	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	
	client=new AsyncHttpClient();
	params.put("fname", "ravindra");
	params.put("lname", "kumar");
	params.put("email", "ravidsrk@gmail.com");
	client.post(url, params, new JsonHttpResponseHandler(){
		  @Override
			public void onSuccess(JSONArray resp) {
		Log.i("post","success");
		  }
		  @Override
		public void onFailure(Throwable arg0) {
			// TODO Auto-generated method stub
				Log.i("post","failed");
		}
	});
	client.get(url,null, new JsonHttpResponseHandler(){
	
		  @Override
		public void onSuccess(JSONArray resp) {
			
			  try {
				  JSONObject obj=resp.getJSONObject(0);
				 String str=obj.getString("email");
				 Log.i("ses", str);
				 
				
				 
			} catch (JSONException e) {
				Log.i("err","cant parse");
				// TODO Auto-generated catch block
			
			}
			
			
			
				
		}
		
	});
	  

	

	}
	
}
