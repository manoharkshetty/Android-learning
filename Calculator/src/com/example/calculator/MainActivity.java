package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private int num1;
	private int num2;
	private int result;
	private TextView num1view;
	private TextView num2view;
	private Button addview;
	private Button subview;

	
	private TextView resultview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		num1view=(TextView) findViewById(R.id.num1);
		num2view=(TextView) findViewById(R.id.num2);
		addview = (Button) findViewById(R.id.add);
		resultview = (TextView) findViewById(R.id.res);
		try {
		  
			String s=num1view.getText().toString();
			num1=new Integer(s).intValue();
		} catch (NumberFormatException e) {
		    Log.i("err","cant parse");
		}
		
		try {
			String s2=num2view.getText().toString();
			
			num2= new Integer(s2).intValue();
			  
			
		} catch (NumberFormatException e) {
		    Log.i("err","cant parse2");
		}
		addview.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				result = num1 + num2;
				
				
				resultview.setText("sum is:" +result);

			}
		});
		subview=(Button) findViewById(R.id.sub);
		subview.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				result=num1-num2;
				resultview.setText("difference is:" + result);
				
			}
		
		});
	
	}

}
