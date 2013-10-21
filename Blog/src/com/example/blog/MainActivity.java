package com.example.blog;

import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity<AsyncResponse> extends Activity {
	private AsyncHttpClient client;
	   static JSONObject jObj = null;
	    static String json = "";
	    private HttpResponse response;
	    private TextView text;
	
	
	private String url="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20feed%20where%20url%20%3D%20%22http%3A%2F%2Ffeeds.feedburner.com%2Fnettuts%22&format=json&diagnostics=true";

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text=(TextView) findViewById(R.id.text1);
		
	
	client=new AsyncHttpClient();
	client.get(url,null, new JsonHttpResponseHandler(){
	
		  @Override
		public void onSuccess(JSONObject resp) {
		
			  try {
				 JSONObject query=resp.getJSONObject("query");
				 Log.i("query",query.toString());
			} catch (JSONException e) {
				Log.i("err","cant parse");
				// TODO Auto-generated catch block
			
			}
			
			
			
				
		}
		
	});

		
	

	}
	
}