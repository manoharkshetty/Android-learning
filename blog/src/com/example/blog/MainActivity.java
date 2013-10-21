package com.example.blog;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;



public class MainActivity extends Activity {

	
	private String items[] = {"Item 1", "Item 2", "Item 3", "Item 4"};
	private ListView list = null;
	private ArrayAdapter<String> adapter = null;
	//private HttpClient client;
	//private HttpResponse response;
	//private String url="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20feed%20where%20url%20%3D%20%22http%3A%2F%2Ffeeds.feedburner.com%2Fnettuts%22&format=json&diagnostics=true";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		adapter = new ArrayAdapter<String>(this, R.layout.posts, items);
		list=(ListView) findViewById(R.id.ListView);
		list.setAdapter(adapter);
		
		

	}
	/*
	private void AsyncHttpResponseHandler() {
		
		HttpGet httpGet=new HttpGet(url);
		try {
			HttpResponse response = client.execute(httpGet);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			
		}*/
		
		// TODO Auto-generated method stub
		
	




}