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
import android.os.Build;
import android.os.StrictMode;

public class MainActivity extends Activity {

	Button signIn,signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signIn=(Button)findViewById(R.id.signin);
        signUp=(Button)findViewById(R.id.signup);
        signIn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,SignIn.class);
				startActivity(intent);
				finish();
			}
		});
        
        signUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,NewRegistrationActivity.class);
				startActivity(intent);
				finish();				
			}
		});        
    }
 }
