package com.example.restaurantes;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	ArrayList<Restaurante> lista = new ArrayList<Restaurante>();
	ArrayAdapter<Restaurante> adapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView restaurantes = (ListView)findViewById(R.id.ListaRestaurantes);
		adapter = new ArrayAdapter<Restaurante>(this, android.R.layout.simple_list_item_1, lista);
		restaurantes.setAdapter(adapter);
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
					
		EditText nombreTxT = (EditText) findViewById(R.id.nombreRestauranteTxT);
		EditText direccionTxT = (EditText) findViewById(R.id.direccionRestauranteTxT);
		
		String nombre = nombreTxT.getText().toString();
		String direccion = direccionTxT.getText().toString();
		String tipo = "";
		
		RadioGroup tipos = (RadioGroup) findViewById(R.id.Tipos);
						
		switch(tipos.getCheckedRadioButtonId()) {			
			case R.id.Tipo1:
				tipo = getString(R.string.tipo1);
				break;
			case R.id.Tipo2:
				tipo = getString(R.string.tipo2);
				break;
			case R.id.Tipo3:
				tipo = getString(R.string.tipo3);
				break;
		}
		
		Restaurante nuevoRestaurante = new Restaurante(nombre, direccion, tipo);
		adapter.add(nuevoRestaurante);
	}	
}