package com.example.listviewsample;
	
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
	 
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
	        TextView txtpoints;
	        TextView txtpos;
	        TextView txttrans;
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
	            holder.txtpos = (TextView) convertView.findViewById(R.id.points);
	            holder.txtpoints = (TextView) convertView.findViewById(R.id.pos);
	            holder.txttrans = (TextView) convertView.findViewById(R.id.trans);
	            convertView.setTag(holder);
	        } else
	            holder = (ViewHolder) convertView.getTag();
	        
		    	holder.txtDesc.setText(rowItem.getPlayerName());
		        holder.txtTitle.setText(rowItem.getTeamName());
		   	    holder.imageView.setImageResource(rowItem.getImageId());
		   	    holder.txtpos.setText(rowItem.getPoints());
		   	    holder.txtpoints.setText(rowItem.getPos());
		    	holder.txttrans.setText(rowItem.getTrans()); 
		    	 Toast.makeText(getContext(), "settinggggg",Toast.LENGTH_LONG).show();
		    	return convertView;
	    	}
	}
	

