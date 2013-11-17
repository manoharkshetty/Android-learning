package com.example.autoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DiscountAndGifts extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.discount_and_gifts);
		Button submit=(Button) findViewById(R.id.submit);
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent(DiscountAndGifts.this,DiscountFbPost.class);
				startActivity(in);
				
				
			}
		});
	
	}
}
