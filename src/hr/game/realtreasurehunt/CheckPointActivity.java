package hr.game.realtreasurehunt;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;


public class CheckPointActivity extends Activity {

	Button btnSaveCheckpoint;
	Button btnChooseScanPhoto;
	Button btnInputCode;
	EditText txtInstructions;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_point);
		// Show the Up button in the action bar.
		setupActionBar();
		
		// ============ interface setup ========================
		btnSaveCheckpoint = (Button) findViewById(R.id.btnSaveCheckpoint);
		txtInstructions = (EditText) findViewById(R.id.txtInstructions);
		btnInputCode = (Button) findViewById(R.id.btnInputCode);
		btnChooseScanPhoto = (Button) findViewById(R.id.btnChooseScanPhoto);
		
		
		
		// =========== onClick listeners =======================
		
		btnSaveCheckpoint.setOnClickListener(new OnClickListener () {

			@Override
			public void onClick(View v) {
				Intent resultData = new Intent();
				resultData.putExtra("instructions", txtInstructions.toString());
				//TODO: putExtra GPS coordinates
				setResult(Activity.RESULT_OK, resultData);
				finish();
			}
			
		});
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.check_point, menu);
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
