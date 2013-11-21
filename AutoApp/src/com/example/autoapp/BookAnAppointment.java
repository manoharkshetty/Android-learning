package com.example.autoapp;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class BookAnAppointment extends Activity{
	public int daySelected,monthSelected,yearSelected,hourSelected,minuteSelected;
	public int mDay,mMonth,mYear,mHour,mMinute;
	private Button bDate,bTime,submit; 
	static final int DATE_DIALOG_ID=0;
	static final int TIME_DIALOG_ID=1;
	private EditText dateview,timeview;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form);
		bDate=(Button) findViewById(R.id.date);
		bTime=(Button) findViewById(R.id.time);
		submit=(Button) findViewById(R.id.button1);
		final Calendar c=Calendar.getInstance();
		mYear=c.get(Calendar.YEAR);
		mMonth=c.get(Calendar.MONTH);
		mDay=c.get(Calendar.DAY_OF_MONTH);
		mHour=c.get(Calendar.HOUR_OF_DAY);
		mMinute=c.get(Calendar.MINUTE);
		dateview=(EditText) findViewById(R.id.dateView);
		timeview=(EditText) findViewById(R.id.timeView);
		
		
		bDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID);
			}
		});
		bTime.setOnClickListener(new View.OnClickListener() {
			
	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(TIME_DIALOG_ID);
				
			}
		});
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent(BookAnAppointment.this,AboutUs.class);
				startActivity(in);
				
			}
		});

}
	
	private DatePickerDialog.OnDateSetListener mDateListener=new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			
			yearSelected=year;
			monthSelected=monthOfYear;
			daySelected=dayOfMonth;
			dateview.setText(daySelected + "/" + monthSelected + "/" + yearSelected);
			
		}
	};
	
	private TimePickerDialog.OnTimeSetListener mTimeListener=new TimePickerDialog.OnTimeSetListener() {
		
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			hourSelected=hourOfDay;
			minuteSelected=minute;
			timeview.setText(hourSelected + ":" + minuteSelected);
			
			
		}
	};
	protected Dialog onCreateDialog(int id){
		switch (id) {
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, mDateListener, mYear, mMonth, mDay);
			
			
		case TIME_DIALOG_ID:
			return new TimePickerDialog(this, mTimeListener, mHour, mMinute, false);
			
			

		}
		return null;
		
	}
	
	
}