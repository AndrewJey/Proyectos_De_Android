package com.example.logeo;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

	ArrayList<Logineo> lista2 = new ArrayList<Logineo>();
	ArrayAdapter<Logineo> adapter2 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		// Get the message from the intent
	    //Intent intent = getIntent();
	    //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

	    // Create the text view
	    //TextView textView = new TextView(this);
	    //textView.setTextSize(40);
	    //textView.setText(message);

	    // Set the text view as the activity layout
	    //setContentView(textView);
	    
	    ListView datos = (ListView)findViewById(R.id.ListaDatos);
		adapter2 = new ArrayAdapter<Logineo>(this, android.R.layout.simple_list_item_1, lista2);
		datos.setAdapter(adapter2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void okOnClick(View vi) {
				
		EditText mailTexT = (EditText) findViewById(R.id.mailTexT);
		EditText passTexT = (EditText) findViewById(R.id.passTexT);
				
		String mail = mailTexT.getText().toString();
		String passw = passTexT.getText().toString();
				
		Logineo nuevoLog = new Logineo (mail, passw);
		adapter2.add(nuevoLog);
		
		Toast toast1 =
	            Toast.makeText(getApplicationContext(),
	                    "¡DATOS CORRECTOS! Ingresando...", Toast.LENGTH_SHORT);	 
	        toast1.show();
		
		Intent intent2 = new Intent(this, Text.class);		
		startActivity(intent2);		
	}
}