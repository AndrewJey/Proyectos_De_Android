package com.example.logeo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
	ArrayList<Data> lista = new ArrayList<Data>();
	static String nombre;
	static String mail;
	static String password;
	ArrayAdapter<Data> adapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
    ListView usuarios = (ListView)findViewById(R.id.ListaUsuarios);
	adapter = new ArrayAdapter<Data>(this, android.R.layout.simple_list_item_1, lista);
	usuarios.setAdapter(adapter);
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

	public void guardarOnClick(View v) {
		
		EditText nombreTxT = (EditText) findViewById(R.id.nombreTxT);
		EditText mailTxT = (EditText) findViewById(R.id.mailTxT);
		EditText passTxT = (EditText) findViewById(R.id.passTxT);
		
		String nombre = nombreTxT.getText().toString();
		String mail = mailTxT.getText().toString();
		String passw = passTxT.getText().toString();
				
		Data nuevoUsuario = new Data (nombre, mail, passw);
		adapter.add(nuevoUsuario);

		Toast toast1 =
	            Toast.makeText(getApplicationContext(),
	                    "Registro Guardado", Toast.LENGTH_SHORT);	 
	        toast1.show();

	}
	
	public void Login(View view) {
	
		Intent intent = new Intent(this, Login.class);		
		startActivity(intent);
	}
	
	public static void Usuarios() {
	ArrayList usuarios = new ArrayList();
	usuarios.add(nombre);
	usuarios.add(mail);
	usuarios.add(password);		
	}	
}