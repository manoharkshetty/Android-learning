package com.example.autoapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CarDent extends Activity{

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.car_dent);
		
		Button photo=(Button) findViewById(R.id.photo);
		photo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(in, 0);
			
			}
		});

}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Bitmap bm=(Bitmap) data.getExtras().get("data");
		
	}

}
