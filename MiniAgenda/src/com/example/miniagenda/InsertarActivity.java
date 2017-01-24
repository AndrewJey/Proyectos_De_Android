package com.example.miniagenda;

import java.util.ArrayList;

import com.example.miniagenda.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class InsertarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insertar, menu);
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

	public void guardarOnClick(View view) {

		EditText tituloText = (EditText) findViewById(R.id.tituloTxt);
		EditText horaText = (EditText) findViewById(R.id.horaTxt);
		EditText lugarText = (EditText) findViewById(R.id.lugarTxt);
		EditText descripcionText = (EditText) findViewById(R.id.descripcionTxt);

		String titulo = tituloText.getText().toString();
		String hora = horaText.getText().toString();
		String lugar = lugarText.getText().toString();
		String descripcion = descripcionText.getText().toString();

		Datos ObjectoDatos = new Datos(titulo, hora, lugar, descripcion);		
		MainActivity.lista.add(ObjectoDatos);
		
		Toast toast1 =
	            Toast.makeText(getApplicationContext(),
	                    "Guardando Datos", Toast.LENGTH_SHORT);	 
	        toast1.show();
		
		Intent intent2 = new Intent(this, MainActivity.class);		
		startActivity(intent2);	
	}
}
