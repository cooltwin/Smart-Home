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

public class AddNewLock extends Activity {

	Button signIn,signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_lock);
        
        final EditText Lock_Id =(EditText)findViewById(R.id.LockId);
    	final EditText Lock_Name =(EditText)findViewById(R.id.LockName);
    	final EditText Address =(EditText)findViewById(R.id.Address);
    	final Button Submitbtn =(Button)findViewById(R.id.Submit);
    	
    	Submitbtn.setOnClickListener(new OnClickListener() 
    	{
    		public void onClick(View v) 
    		{ 
    			String str1 = Lock_Id.getText().toString();
    			if (str1.length() == 0)
    			Lock_Id.setError("Lock Id is required");
    			String str2 = Lock_Name.getText().toString();
    			if (str2.length() == 0)
    			Lock_Name.setError("Lock Name is required");
    			String str3 = Address.getText().toString();
    			if (str3.length() == 0)
    			Address.setError("Address is required");
    			 

    			/*try {
    			// add database check to validate if lock id is valid or arbitrary
    			Lock_Id.setError("Invalid Lock Id");
    			}
    			catch(NumberFormatException e) {
    				System.out.println("Lock id does not exists in database");
    			} */
    	        } 
    		});
    	}
    	@Override
        public boolean onCreateOptionsMenu(Menu menu) 
    	{
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        
        
   }
