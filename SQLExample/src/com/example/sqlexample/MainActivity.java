package com.example.sqlexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText idEditText;
	EditText nombreEditText;
	EditText colorEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
	
	@Override
	protected void onStart()
	{
		super.onStart();
		idEditText = (EditText) findViewById(R.id.idAnimalText);
		nombreEditText = (EditText) findViewById(R.id.nombreAnimalText);
		colorEditText = (EditText) findViewById(R.id.colorAnimalText);
    		
	}
	/*
	public void prueba(View v) {
		idEditText.setText("soy id");
		nombreEditText.setText("soy nombre");
		colorEditText.setText("soy color");
	}*/
	
	public void agregarBtn(View v) {
		
		SQLHelper helper = new SQLHelper(this, null);
		
		int id = Integer.parseInt(idEditText.getText().toString());
		String nombre = nombreEditText.getText().toString();
		String color = colorEditText.getText().toString();
		
		Animal animal = new Animal(id, nombre, color);
		
		helper.insertarAnimal(animal);
		
		idEditText.setText("");
		nombreEditText.setText("");
		colorEditText.setText("");
		Toast.makeText(getBaseContext(), "Agregado", Toast.LENGTH_SHORT).show();
	}	
	
	public void buscarBtn(View v) {
	
		SQLHelper helper = new SQLHelper(this, null);
		
		Animal resultado = helper.buscarAnimal(idEditText.getText().toString());
		
		if (resultado != null) {
			
			idEditText.setText(String.valueOf(resultado.getId()));
			nombreEditText.setText(resultado.getNombre());
			colorEditText.setText(resultado.getColor());
			Toast.makeText(getBaseContext(), "Buscando...", Toast.LENGTH_SHORT).show();
		}
		
		else { 
			idEditText.setText("");
			nombreEditText.setText("");
			colorEditText.setText(""); 
			Toast.makeText(getBaseContext(), "No Encontrado...", Toast.LENGTH_SHORT).show();	
		}
		
	}
										
		public void eliminarrBtn(View v) {
			
			SQLHelper helper = new SQLHelper(this, null);
			
			boolean resultado = helper.eliminarAnimal(idEditText.getText().toString());
			
			if (resultado) {
				
				idEditText.setText("");
				nombreEditText.setText("");
				colorEditText.setText("");
				Toast.makeText(getBaseContext(), "Borrado con Éxito", Toast.LENGTH_SHORT).show();
			}
			
			else {
				
				idEditText.setText("");
				nombreEditText.setText("");
				colorEditText.setText("");
				Toast.makeText(getBaseContext(), "No Encontrado", Toast.LENGTH_SHORT).show();
			}
		
	}
}