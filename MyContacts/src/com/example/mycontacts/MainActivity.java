package com.example.mycontacts;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * Begin main
 * Show Contacts fragment
 *
 */

public class MainActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
    }
    
    private void init(){
    	FragmentTransaction mFragmentManager = getFragmentManager().beginTransaction();
    	mFragmentManager.replace(R.id.frmain, new ContactsFragment());
    	mFragmentManager.commit();
    }
}
