package com.example.sqlite;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SQLiteDatabase db=openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
		db.execSQL("create table if not exists myTable (fname varchar,lname varchar);");
		db.execSQL("insert into  myTable values('manohar','shetty');");
		db.close();

	}

}
