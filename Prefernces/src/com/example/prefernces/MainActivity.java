package com.example.prefernces;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 et=(EditText) findViewById(R.id.editText1);
		SharedPreferences settings=getSharedPreferences("MYPREFS", 0);
		et.setText(settings.getString("tvalue", ""));
		
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		SharedPreferences settings =getSharedPreferences("MYPREFS", 0);
		SharedPreferences.Editor editor=settings.edit();
		editor.putString("tvalue", et.getText().toString());
		editor.commit();
	}


}
