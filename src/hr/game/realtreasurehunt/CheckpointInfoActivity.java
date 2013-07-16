package hr.game.realtreasurehunt;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class CheckpointInfoActivity extends Activity {

	GoogleMap infoMap;
	TextView txtInstructions;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkpoint_info);
		
		// ========== info about checkpoint =============
		Intent checkIntent = getIntent();
		String instructions = checkIntent.getStringExtra("instructions");
		String checkCode = checkIntent.getStringExtra("checkpointCode");
		double latitude = checkIntent.getDoubleExtra("latitude",  45.86);
		double longitude = checkIntent.getDoubleExtra("longitude",  15.99);
		
		LatLng gpsInfo = new LatLng(latitude, longitude);
		
		
		// ========== interface definition ==============
		infoMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapCPInfo)).getMap();
		txtInstructions = (TextView) findViewById(R.id.txtCPInfoInstructions);
		
		
		// ========= instructions ======================
		txtInstructions.setText(instructions);
		
		
		// ========== map gps setup ========================
		infoMap.addMarker(new MarkerOptions().position(gpsInfo).title("Checkpoint"));
		infoMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gpsInfo, 15));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.checkpoint_info, menu);
		return true;
	}

}
