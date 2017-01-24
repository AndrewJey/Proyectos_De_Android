package com.example.agendaxaj2l;

import java.util.ArrayList;

import com.example.agendaxaj2l.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DetalleActivity extends Activity {

	public static ArrayList<Data> lista = new ArrayList<Data>();
	ArrayAdapter<Data> adapter = null;
	ListView mostrarDatos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle);
		
		mostrarDatos  = (ListView) findViewById(R.id.listaMiniAgenda);
		adapter = new ArrayAdapter<Data>(this,
				android.R.layout.simple_list_item_1, lista);
		mostrarDatos.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalle, menu);
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
	
	public void cargarOnClick(View view) {
		EditText tituloText = (EditText) findViewById(R.id.tituloTxt);
		EditText horaText = (EditText) findViewById(R.id.horaTxt);
		EditText lugarText = (EditText) findViewById(R.id.lugarTxt);
		EditText descripcionText = (EditText) findViewById(R.id.descripcionTxt);

		String titulo = tituloText.getText().toString();
		String hora = horaText.getText().toString();
		String lugar = lugarText.getText().toString();
		String descripcion = descripcionText.getText().toString();
			
		Data lista = new Data(titulo, hora, lugar, descripcion);
		adapter.add(lista);
		
		Toast toast2 =
	            Toast.makeText(getApplicationContext(),
	                    "Cargando Datos", Toast.LENGTH_SHORT);	 
	        toast2.show();
	}	
	
	public void startOnClick(View view) {
		Intent intent3 = new Intent(this, MainActivity.class);
		startActivity(intent3);
	}	
}
