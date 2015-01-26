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
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.os.Build;

public class LockPage extends Activity 
{
	Button addNewLock, shareLock, viewLock;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lock_page);
		addNewLock=(Button)findViewById(R.id.LockButton1);
		shareLock=(Button)findViewById(R.id.LockButton2);
		viewLock=(Button)findViewById(R.id.LockButton3);
		
		addNewLock.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				
					// TODO Auto-generated method stub
					Intent intent=new Intent(LockPage.this,AddNewLock.class);
					startActivity(intent);
					finish();
					
			}
				
		});
		
		shareLock.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				
					// TODO Auto-generated method stub
					Intent intent=new Intent(LockPage.this,ShareLock.class);
					startActivity(intent);
					finish();
					
				}
				
			});
		
		viewLock.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				
					// TODO Auto-generated method stub
					Intent intent=new Intent(LockPage.this,LockUnlockGarage.class);
					startActivity(intent);
					finish();
					
				}
				
			});
			
		}
	 	
			
}
	

