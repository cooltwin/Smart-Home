package com.example.smarthomeapp;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class ViewLock extends Activity {

	Button signIn,signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    { 
    		super.onCreate(savedInstanceState); 
    		setContentView(R.layout.activity_view_lock);
    		final Button garage =(Button)findViewById(R.id.garage_btn);
    		garage.setOnClickListener(new OnClickListener() {
    			public void onClick(View v) { 
    				Intent MyIntent = new Intent(ViewLock.this, LockUnlockGarage.class); 
    				startActivity(MyIntent);
    			}
    		});
    	}
        
        
   }
