package com.example.heidymap;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//AIzaSyCsT7FueLekKW2OPl_bCArNOsHPZ1gbaKE
public class MainActivity extends ActionBarActivity {
	protected GoogleMap googleMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try{
			
			if(googleMap==null ){
				MapFragment fragment=(MapFragment)getFragmentManager().findFragmentById(R.id.map);
				googleMap=fragment.getMap();
				
				
				 Marker marker = googleMap.addMarker(new MarkerOptions()
			     .position(new LatLng(37.7750, 122.4183))
			     .title("San Francisco"));
				 LatLng pos = new LatLng(10,-84);
				 Marker marca = googleMap.addMarker(new MarkerOptions().position(pos).title("Marquoitas"));
	    		 goToLocation(41, 2, 15);			     
				
			}
			
			
			//googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			
			
		}catch(Exception e){}
	}
	public void goToLocation(double lat, double Ing, float zoom){
		LatLng ll = new LatLng(lat,Ing);
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
		googleMap.moveCamera(update);
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
}
