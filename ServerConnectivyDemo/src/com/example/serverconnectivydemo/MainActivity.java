package com.example.serverconnectivydemo;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
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

public class MainActivity extends Activity {
	JSONArray jArray=null;
	String result=null;
	StringBuilder sb=null;
	InputStream is=null;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ArrayList<NameValuePair> nameValuPair=new ArrayList<NameValuePair>();
		/*
		try {
			HttpClient httpclient=new DefaultHttpClient();
			HttpPost httppost=new HttpPost("http://10.0.2.2/serverconnectiondemo/serverconnection.php");
			httppost.setEntity(new UrlEncodedFormEntity(nameValuPair));
			HttpResponse response=httpclient.execute(httppost);
			HttpEntity entity=response.getEntity();
			is=entity.getContent();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		*/
		String url="http://10.0.2.2/serverconnectiondemo/serverconnection.php";
		AsyncHttpClient client=new AsyncHttpClient();
		client.get(url, new JsonHttpResponseHandler(){
			
			  @Override
				public void onSuccess(JSONArray resp) {
					
					  Log.i("sss"," parsed");
			  }
			
		});
	}
		
		
	}

	


