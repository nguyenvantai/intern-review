package com.example.mycontacts;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactsAdapter extends BaseAdapter {

	private ArrayList<String> mNames;
	private ArrayList<Integer> mAvatars;
	
	private MainActivity mContext;
	private ContactsFragment mContactsActivity;

	private LayoutInflater mInflater;

	public ContactsAdapter(Context context, ArrayList<String> mNames,
			ArrayList<Integer> mAvatars, ContactsFragment activity) {
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		this.mNames = mNames;
		this.mAvatars = mAvatars;
		
		mContext = (MainActivity) context;
		mContactsActivity = activity;
	}

	public ContactsAdapter(Context context) {
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public int getCount() {
		return mNames.size();
	}

	@Override
	public String getItem(int position) {
		return mNames.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView( int pos, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		final int position = pos;

		if (convertView == null) {
			//Create new holder
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_contacts, null);
			holder.name = (TextView) convertView.findViewById(R.id.tvName);
			holder.avatar = (ImageView) convertView.findViewById(R.id.imgAvatar);
			convertView.setTag(holder);
		} else {
			//Get old holder
			holder = (ViewHolder) convertView.getTag();
		}

		holder.name.setText(mNames.get(position));
		holder.avatar.setImageResource(mAvatars.get(position));

		return convertView;
	}

	private class ViewHolder {
		public TextView name;
		public ImageView avatar;
	}

}