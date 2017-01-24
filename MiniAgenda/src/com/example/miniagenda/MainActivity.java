package com.example.miniagenda;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static ArrayList<Datos> lista = new ArrayList<Datos>();
	ArrayAdapter<Datos> adapter = null;
	ListView mostrarDatos;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mostrarDatos  = (ListView) findViewById(R.id.listaMiniAgenda);
		adapter = new ArrayAdapter<Datos>(this,
				android.R.layout.simple_list_item_1, lista);
		mostrarDatos.setAdapter(adapter);
	}
	
	@Override
	public void onResume(){
	    super.onResume();
	    // put your code here...
	    mostrarDatos.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	public void insertarOnClick(View view) {
		Intent intent = new Intent(this, InsertarActivity.class);
		startActivity(intent);
	}
}
