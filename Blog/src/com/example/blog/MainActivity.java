package com.example.blog;

import java.io.IOException;
import java.net.CookieStore;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private AsyncHttpClient mclient;
	  
	
	
	private String url1="https://www.switch-hit.com/league/ajax/get-league-standings/?league_id=221";
	RequestParams params=new RequestParams();
	private String url2="http://api.twitter.com/1/";
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		HttpResponse response;
		String name="";
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://api.twitter.com/1/");
		PersistentCookieStore myCookieStore = new PersistentCookieStore(this);
		myCookieStore.clear();
		



		

		
		
		try {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
			response = client.execute(request);
			System.out.println(response.toString());
			Header[] headers = response.getAllHeaders();
			for (Header header : headers) {
				System.out.println("Key : " + header.getName() 
				      + " ,Value : " + header.getValue());
				if(header.getName().equalsIgnoreCase("Set-Cookie")){
					name=header.getValue();
					System.out.println("this is from my app" +name);
					System.out.println("this is from my app" + name.substring(10,42));
				}
			}
			
				
			
			BasicClientCookie newCookie = new BasicClientCookie("csrfoken",name.substring(10,42));
			newCookie.setVersion(1);
			newCookie.setDomain("http://www.switch-hit.com");
			newCookie.setPath("/");
			myCookieStore.addCookie(newCookie);
			List<Cookie> mycookies=myCookieStore.getCookies();
			
			
			System.out.println("cookie" + mycookies.get(0).toString());
			AsyncHttpClient mclient = new AsyncHttpClient();
			mclient.get(url1, null,new JsonHttpResponseHandler() {
			    @Override
			    public void onSuccess(JSONObject response) {
			        System.out.println(response.toString());
			    }
			
			
		 });
		
			//get header by 'key'
			String server = response.getFirstHeader("Server").getValue(); 
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
			
		
		
	
		
			}
	
}
