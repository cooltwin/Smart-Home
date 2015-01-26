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

public class ShareLock extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_share_lock);
		final EditText User_Id =(EditText)findViewById(R.id.User_Id);
		final EditText Lock_Name =(EditText)findViewById(R.id.Lock_Name);
		final EditText Access_Type =(EditText)findViewById(R.id.Access_Type);
		final Button Share_Lock_btn =(Button)findViewById(R.id.Share_Lock_btn);
		Share_Lock_btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) { 
				String str1 = User_Id.getText().toString();
				if (str1.length() == 0)
				User_Id.setError("User Id is required");
				String str2 = Lock_Name.getText().toString();
				if (str2.length() == 0)
				Lock_Name.setError("Lock Name is required");
				String str3 = Access_Type.getText().toString();
				if (str3.length() == 0)
				Access_Type.setError("Address is required");
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
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	    
        
   }
