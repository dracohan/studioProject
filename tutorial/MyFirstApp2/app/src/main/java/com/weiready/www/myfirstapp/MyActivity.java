package com.weiready.www.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MyActivity extends AppCompatActivity {
	public final static String EXTRA_MESSAGE = "com.weiready.myfirstapp.MESSAGE";
	public final static String TAG = "MyActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		Log.d(TAG, "onCreate");

		/*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_my, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
		finish();
/*		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);*/
	}

	@Override
	protected void onStart(){
		super.onStart();
		Log.d(TAG, "onStart");
	}

	@Override
	protected void onResume(){
		super.onResume();
		Log.d(TAG, "onResume");
	}

	@Override
	protected void onPause(){
		super.onPause();
		Log.d(TAG, "onPause");
	}

	@Override
	protected void onStop(){
		super.onStop();
		Log.d(TAG, "onStop");
	}

	@Override
	protected void onDestroy(){
		super.onDestroy();
		Log.d(TAG, "onDestroy");
	}
	@Override
	protected void onRestart(){
		super.onRestart();
		Log.d(TAG, "onRestart");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		Log.d(TAG, "onSaveInstanceState");
		// Always call the superclass so it can save the view hierarchy state
		super.onSaveInstanceState(savedInstanceState);
	}
}
