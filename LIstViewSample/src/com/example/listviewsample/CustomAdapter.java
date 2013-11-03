package com.example.listviewsample;
	
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;


import com.example.listviewsample.*;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
	 
	public class CustomAdapter extends ArrayAdapter<LazyAdapter> {
	 
		 Context context;

		   public CustomAdapter(Context context, int resourceId,
		           List<LazyAdapter> items) {
		       super(context, resourceId, items);
		       this.context = context;
		   }
	 
	    /*private view holder class*/
	    private class ViewHolder {
	        ImageView imageView;
	        TextView txtTitle;
	        TextView txtDesc;
	    }
	 
	    public View getView(int position, View convertView, ViewGroup parent) {
	        ViewHolder holder = null;
	        LazyAdapter rowItem = getItem(position);
	       
	        LayoutInflater mInflater = (LayoutInflater) context
	                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	        if (convertView == null) {
	            convertView = mInflater.inflate(R.layout.list_row, null);
	            holder = new ViewHolder();
	            holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);
	            holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
	            holder.imageView = (ImageView) convertView.findViewById(R.id.list_image);
	            convertView.setTag(holder);
	        } else
	            holder = (ViewHolder) convertView.getTag();
	       
	 
	        holder.txtDesc.setText(rowItem.getTitle());
	        Log.i("title",rowItem.getTitle());
	        holder.txtTitle.setText(rowItem.getDesc());
	        holder.imageView.setImageResource(rowItem.getImageId());
	      
	 
	        return convertView;
	    }
	}

