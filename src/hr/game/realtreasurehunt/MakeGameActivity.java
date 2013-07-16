package hr.game.realtreasurehunt;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class MakeGameActivity extends Activity {

	Button btnAddCheckpoint;
	ListView listCheckpoints;
	
	private int checkpointNumber = 0;
	private ArrayList<Checkpoint> checkpointArray;
	private ArrayAdapter<Checkpoint> checkpointAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_game);
		// Show the Up button in the action bar.
		setupActionBar();
		
		// ============= interface definition ======================
		btnAddCheckpoint = (Button) findViewById(R.id.btnAddCheckpoint);
		
		// checkpointList setup
		listCheckpoints = (ListView) findViewById(R.id.listCheckpoints);
		checkpointArray = new ArrayList<Checkpoint>();
		checkpointArray.clear();
		checkpointAdapter = new ArrayAdapter<Checkpoint>(this, android.R.layout.simple_list_item_1, checkpointArray);
		listCheckpoints.setAdapter(checkpointAdapter);
		
		
		
		// =============== onClick listeners =======================
		
		btnAddCheckpoint.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent addCheckpoint = new Intent (MakeGameActivity.this, CheckPointActivity.class);
				startActivityForResult(addCheckpoint, checkpointNumber);
			}
			
		});
		
		listCheckpoints.setOnItemClickListener(new OnItemClickListener () {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				Checkpoint check = (Checkpoint) listCheckpoints.getAdapter().getItem(position);
				
				Intent checkInfo = new Intent(MakeGameActivity.this, CheckpointInfoActivity.class);
				
				checkInfo.putExtra("instructions",  check.getInstructions());
				checkInfo.putExtra("checkpointCode", check.getCheckpointCode());
				checkInfo.putExtra("latitude",  check.getGpsLatitude());
				checkInfo.putExtra("longitude",  check.getGpsLongitude());
				startActivity(checkInfo);
				
				
			}
			
		});
	}
	
	
	
	// ======== on return from CheckPointActivity, returns checkpoint info =============
	protected void onActivityResult(int requestCode, int resultCode,
	          Intent data) {
	      if (requestCode == checkpointNumber) {
	          if (resultCode == RESULT_OK) {
	        	  //TODO: ucitati vracene vrijednosti iz CheckPointActivityja - upute i GPS koordinate
	            String instructions = data.getStringExtra("instructions"); 
	            String checkpointCode = data.getStringExtra("checkpointCode");
	            double gpsLatitude = data.getDoubleExtra("latitude", 45.86);
	            double gpsLongitude = data.getDoubleExtra("longitude",  15.993);
	            
	            Checkpoint cPoint = new Checkpoint(instructions, checkpointCode, gpsLatitude, gpsLongitude);
	            checkpointArray.add(cPoint);
	            checkpointAdapter.notifyDataSetChanged();
	          }
	      }
	}
	
	
	// ================= auto code =========================
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.make_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}



