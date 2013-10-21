package com.example.implicitintent;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView iw=(ImageView) findViewById(R.id.img);
		iw.setImageURI((Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM));
		
	}

}
