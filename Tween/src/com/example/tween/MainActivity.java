package com.example.tween;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				Animation anim=AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation);
				b.startAnimation(anim);
				
				
			}
		});
	}



}
