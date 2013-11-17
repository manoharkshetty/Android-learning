package com.example.autoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DiscountFbPost extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.discount_fb_post);
	
		 
	    String comments = getResources().getString(R.string.companyLink);
	    final TextView commentsText = (TextView) findViewById(R.id.companylink);
	    commentsText.setMovementMethod(LinkMovementMethod.getInstance());
	    commentsText.setText(Html.fromHtml(comments));
	    
	    
	   //link to map
	    
	    
	    Button b=(Button) findViewById(R.id.share);
	    b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent cong=new Intent(DiscountFbPost.this, CongratsMsg.class);
				startActivity(cong);
				
			}
		});
	 
	}
}
