package com.training.helloworld;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {


	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	

	Button myButton =  (Button) findViewById(R.id.go);
	myButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			  String url=((EditText) findViewById(R.id.search)).getText().toString();
			  Intent in= new Intent(MainActivity.this , second.class);
			  in.putExtra("URL", url);
			  startActivity(in);
		}
	});
		
	}
}
