package com.example.smarthomeapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;


import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;
import android.os.AsyncTask;

public class Registration extends Activity {
	
	Button proceed;
	private static final String TAG = "RegistrationActivity";
	
	String firstName,lastName,phoneNumber,addr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regsitration);
		
		final JSONObject jsonObject=new JSONObject();
		final DefaultHttpClient httpclient = new DefaultHttpClient();
		
		proceed=(Button)findViewById(R.id.proceed);
		final EditText fname=(EditText)findViewById(R.id.editText1);
		final EditText lname=(EditText)findViewById(R.id.editText2);
		final EditText phoneNum=(EditText)findViewById(R.id.editText3);
		final EditText address=(EditText)findViewById(R.id.editText4);
		
					
		
		proceed.setOnClickListener(new OnClickListener() {
			
		@Override
		public void onClick(View v) 
		{
			firstName = fname.getText().toString();
			lastName = lname.getText().toString();
			phoneNumber = phoneNum.getText().toString();
			addr= address.getText().toString();	
			try {
				// Add key/value pairs
				
				HttpClient task = new HttpClient(firstName, lastName, phoneNumber, addr);
				task.execute();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// Send the HttpPostRequest and receive a JSONObject in return
			
			// TODO Auto-generated method stub
			 AlertDialog.Builder alertDialog = new AlertDialog.Builder(Registration.this);
            // Setting Dialog Title
            alertDialog.setTitle("Alert Dialog");
            // Setting Dialog Message
            alertDialog.setMessage("Ur user id is........");

            alertDialog.setPositiveButton("OK",new DialogInterface.OnClickListener()
            {
            	@Override
				public void onClick(DialogInterface dialog,int id) 
            	{
					// TODO Auto-generated method stub
            		Intent newIntent=new Intent(Registration.this,LauncherActivity.class);
            		startActivity(newIntent);
    				Registration.this.finish();
		    	}
            }).show();
			}
		});
	}
	
	private class HttpClient extends AsyncTask<Void, Void, String>{
		private static final String TAG = "HttpClient";
		private String URL = null;
		String firstName;
		String lastName;
		String phoneNumber;
		String addr;
		
		HttpClient(String firstName, String lastName, String phoneNumber, String addr) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
			this.addr = addr;
		}
	    
		@Override
		protected String doInBackground(Void... voidstr) {
			JSONObject jsonObject = new JSONObject();
			
			try {
				jsonObject.accumulate("firstName", firstName);
				jsonObject.accumulate("lastName", lastName);
				jsonObject.accumulate("phoneNumber", phoneNumber);
				jsonObject.accumulate("address",addr);

				// Add a nested JSONObject (e.g. for header information)
				/*JSONObject header = new JSONObject();
				header.put("deviceType","Android"); // Device type
				header.put("deviceVersion","2.0"); // Device OS version
				header.put("language", "es-es");	// Language of the Android client
				jsonObject.put("header", header);*/
				// Output the JSON object we're sending to Logcat:
				
				URL = "http://162.243.114.166/cgi-bin/Database_scripts/Registration_script.py";
				DefaultHttpClient httpclient = new DefaultHttpClient();
				HttpPost httpPostRequest = new HttpPost(URL);
				System.out.println("printing json object : "+jsonObject);
				String se;
				se = jsonObject.toString();
				System.out.println("printing se : "+se);
				

				/*// Set HTTP parameters
				httpPostRequest.setEntity(se);
				System.out.println("printing req : "+httpPostRequest.getEntity().getContent().toString());
				httpPostRequest.setHeader("Accept", "application/json");
				httpPostRequest.setHeader("Content-type","application/json");
				//httpPostRequest.setHeader("Content-length", IntegejsonObjSend.toString().length());
				//httpPostRequest.setHeader("Accept-Encoding", "gzip"); // only set this parameter if you would like to use gzip compression
			
				InputStream inp = httpPostRequest.getEntity().getContent();
				String req = convertStreamToString(inp);
				System.out.println("printing entities : "+req);
				
				System.out.println("printing http request message : message is :"+httpPostRequest);
				HttpResponse response = null;
				try
				{
				response = (HttpResponse) httpclient.execute(httpPostRequest);
				}catch(Exception ex)
				{System.out.println("printing error :"+ex);}
				InputStream is = response.getEntity().getContent();
	            String res = convertStreamToString(is);
	            System.out.println("printing Response is :" + res);
				System.out.println("printing response code : "+response.getStatusLine().getStatusCode());
				

				// Get hold of the response entity (-> the data)
				HttpEntity entity = response.getEntity();
				String serverresp = entity.toString();
				System.out.println("printing server response, entity length : "+entity.getContentLength());
				System.out.println("printing server response : "+serverresp);*/
				
				/*if (entity != null) {
					// Read the content stream
					InputStream instream = entity.getContent();
					Header contentEncoding = response.getFirstHeader("Content-Encoding");
					if (contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
						instream = new GZIPInputStream(instream);
					}
					System.out.println("Debug point : 1.3");
					// convert content stream to a String
					String resultString= convertStreamToString(instream);
					instream.close();
					resultString = resultString.substring(1,resultString.length()-1); // remove wrapping "[" and "]"

					// Transform the String into a JSONObject
					JSONObject jsonObjRecv = new JSONObject(resultString);
					// Raw DEBUG output of our received JSON object:
					Log.i(TAG,"<JSONObject>\n"+jsonObjRecv.toString()+"\n</JSONObject>");
					System.out.println("Debug point : 1.4");
					return jsonObjRecv;
				} */
				//return serverresp;
				
				try 
				{
			        // Add your data
			        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			        nameValuePairs.add(new BasicNameValuePair("q", se));
			        httpPostRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			        System.out.println("printing http params: "+httpPostRequest.getParams().toString());
			        // Execute HTTP Post Request
			        HttpResponse response = httpclient.execute(httpPostRequest);
			        
			    } 
				catch (ClientProtocolException e) 
				{
			        // TODO Auto-generated catch block
			    } 
				catch (IOException e) 
				{
			        // TODO Auto-generated catch block
			    }
			}
			catch (Exception e)
			{
				System.out.println("Debug point : 1.4(a)");
				// More about HTTP exception handling in another tutorial.
				// For now we just print the stack trace.
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
	    protected void onPostExecute(String serverresp)
		{
			System.out.println("Response from browser : "+serverresp);
		}

		private String convertStreamToString(InputStream is) 
		{
			/*
			 * To convert the InputStream to String we use the BufferedReader.readLine()
			 * method. We iterate until the BufferedReader return null which means
			 * there's no more data to read. Each line will appended to a StringBuilder
			 * and returned as String.
			 * 
			 * (c) public domain: http://senior.ceng.metu.edu.tr/2009/praeda/2009/01/11/a-simple-restful-client-at-android/
			 */
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();

			String line = null;
			try 
			{
				while ((line = reader.readLine()) != null) 
				{
					sb.append(line + "\n");
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				try 
				{
					is.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			return sb.toString();
		}
	}
}
