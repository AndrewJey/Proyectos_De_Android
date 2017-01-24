package com.example.sqlexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SQLHelper extends SQLiteOpenHelper {

	//Settings
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "Zoológico.db";
	
	private static final String TABLA_ANIMAL = "Animal";
	private static final String COLUMNA_ID = "ID";
	private static final String COLUMNA_NOMBRE = "Nombre";
	private static final String COLUMNA_COLOR = "Color";
	
	public SQLHelper(Context contexto, CursorFactory factory) {
		super(contexto, DATABASE_NAME, factory,DATABASE_VERSION);
	}
		
	@Override 
	public void onCreate(SQLiteDatabase bd) {
		String query = "CREATE TABLE " + TABLA_ANIMAL +  "(" + COLUMNA_ID
				+ " INTERGER PRIMARY KEY," + COLUMNA_NOMBRE + " TEXT,"
				+ COLUMNA_COLOR + " TEXT)";
		
		bd.execSQL(query);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase bd, int ant, int act) {
	
			bd.execSQL("DROP TABLE IF EXIST " + TABLA_ANIMAL);
			onCreate(bd);
			
	}
	
	public void insertarAnimal(Animal animal){
		
		ContentValues values = new ContentValues();
		values.put(COLUMNA_ID, animal.getId());
		values.put(COLUMNA_NOMBRE, animal.getNombre());
		values.put(COLUMNA_COLOR, animal.getColor());
	
		SQLiteDatabase bd = this.getWritableDatabase();
		bd.insert(TABLA_ANIMAL, "", values);
		
		bd.close();
	}
	
	public Animal buscarAnimal(String idAnimal) {
		
		String query = "SELECT * FROM " + TABLA_ANIMAL + " WHERE " + COLUMNA_ID 
				+ " = " + idAnimal;
		
		SQLiteDatabase bd = this.getWritableDatabase();
		Cursor cursor = bd.rawQuery(query, null);
		
		Animal resultado;
		
		if (cursor.moveToFirst()) {
			
			resultado = new Animal();
			
			cursor.moveToFirst();
			resultado.setId(Integer.parseInt(cursor.getString(0)));
			resultado.setNombre(cursor.getString(1));
			resultado.setColor(cursor.getString(2));
			cursor.close();			
		}
		
		else {
			resultado = null;
		}
		
		bd.close();
		
		return resultado;
	}
	
	public boolean eliminarAnimal(String idAnimal) {
		
		String query = "SELECT * FROM " + TABLA_ANIMAL + " WHERE " + COLUMNA_ID 
				+ " = " + idAnimal;
		
		SQLiteDatabase bd = this.getWritableDatabase();
		Cursor cursor = bd.rawQuery(query, null);
		
		boolean resultado;
		
		if (cursor.moveToFirst()) {
			
			bd.delete(TABLA_ANIMAL, COLUMNA_ID + " = ?", new String[]{idAnimal});
			cursor.close();
			resultado = true;
		}
		
		else {
			resultado = false;
		}
		
		bd.close();
		
		return resultado;
	}
}