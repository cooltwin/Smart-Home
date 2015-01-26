package com.example.smarthomeapp;


import android.support.v7.app.ActionBar;
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
import android.widget.ImageButton;
import android.os.Build;

public class LauncherActivity extends Activity {
	ImageButton lock,sprinkler,thermostat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		lock=(ImageButton)findViewById(R.id.Lock);
		sprinkler=(ImageButton)findViewById(R.id.Sprinkler);
		//thermostat=(ImageButton)findViewById(R.id.Alarm);
		//lighting=(ImageButton)findViewById(R.id.Lighting);
		//thermostat=(ImageButton)findViewById(R.id.temperature);
		
		lock.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent LauncherIntent=new Intent(LauncherActivity.this, LockPage.class);
				startActivity(LauncherIntent);
				finish();
				
				
			}
		});

	}	

}
