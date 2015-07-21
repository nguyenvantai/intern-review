package com.example.mycontacts;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

public class ContactsFragment extends Fragment implements OnClickListener{
	private ArrayList<String> mNames;
	private ArrayList<Integer> mAvatars;
	private int mSelectedContact;
	private View mContact;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mContact = inflater.inflate(R.layout.activity_contacts, null);
		init();
		return mContact;
	}
	
	private void init() {
		/**
		 * Create and set adapter for listview in Contacts
		 * @param names of people
		 * @param avatars for show in contacts
		 */

		// Create new
		String[] names = { "Someone 1", "Someone 2", "Someone 3", "Someone 4",
				"Someone 5", "Someone 6", "Someone 7" };
		int[] avatars = { R.drawable.ic_contacts_1, R.drawable.ic_contacts_2,
				R.drawable.ic_contacts_3, R.drawable.ic_contacts_4,
				R.drawable.ic_contacts_1, R.drawable.ic_contacts_2, 
				R.drawable.ic_contacts_3};

		mNames = new ArrayList<String>();
		for (String str : names) {
			mNames.add(str);
		}

		mAvatars = new ArrayList<Integer>();
		for (int i : avatars) {
			mAvatars.add(i);
		}
		
		loadContacts();
	}
	
	/**
	 * 
	 */
	public void setSelectedContact(int position){
		//Set contact has selected
		this.mSelectedContact = position;
	}
	
	private void loadContacts(){
		ListView mContacts = (ListView) mContact.findViewById(R.id.lv_contacts);
		ContactsAdapter mAdapter = new ContactsAdapter(getActivity(), mNames, mAvatars, this);
		mContacts.setAdapter(mAdapter);
	}

	@Override
	public void onClick(View v) {
		
	}
}
