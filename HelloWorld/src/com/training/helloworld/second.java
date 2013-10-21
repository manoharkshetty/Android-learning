package com.training.helloworld;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class second extends Activity {
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		final WebView wv=(WebView)findViewById(R.id.helloWebView);
		
		 wv.getSettings() .setJavaScriptEnabled(true);
	     wv.loadUrl(getIntent().getExtras().getString("URL"));
	}

}
