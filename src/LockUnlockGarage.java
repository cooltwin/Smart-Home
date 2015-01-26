package com.example.smarthomeapp;


import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Button;
import android.content.Intent;
import android.graphics.*;

public class LockUnlockGarage extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_lock_unlock_garage);
		
		final Button Lock_Garage =(Button)findViewById(R.id.Lock_Garage_btn);
		final Button Unlock_Garage =(Button)findViewById(R.id.Unlock_Garage_btn);
		Lock_Garage.getBackground().setColorFilter(0xff888888, PorterDuff.Mode.MULTIPLY);
		
		Unlock_Garage.setOnClickListener(new OnClickListener() {
			public void onClick(View v) { 
				AlertDialog alertDialog = new AlertDialog.Builder(LockUnlockGarage.this).create();
	            // Setting Dialog Message
	            alertDialog.setMessage("Garage Door Unlocked Successfully");

	            // Setting Icon to Dialog
	            alertDialog.setIcon(R.drawable.tick);

	            // Setting OK Button
	            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {

	                        public void onClick(DialogInterface dialog,int which) 
	                        {
	                        	/*Intent MyIntent = new Intent(this, LockUnlockGarage.class); 
	            				startActivity(MyIntent);*/
	                        }
	                    });

	            // Showing Alert Message
	            alertDialog.show();

	        }
	    });

				//alert message on click
	}
		
}
