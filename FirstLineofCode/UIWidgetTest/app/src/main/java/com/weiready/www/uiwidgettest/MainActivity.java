package com.weiready.www.uiwidgettest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends BaseActivity implements OnClickListener {
	public String TAG = "MainActivity";
	private Button button;
	private Button button_dialog;
	
	private EditText editText;
	
	private ImageView imageView;
	
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.button);
		button_dialog = (Button) findViewById(R.id.button_dialog);
		editText = (EditText) findViewById(R.id.edit_text);
		imageView  = (ImageView) findViewById(R.id.image_view);
		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
		button.setOnClickListener(this);
		button_dialog.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button:
			ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
			progressDialog.setTitle("This is ProgressDialog");
			progressDialog.setMessage("Loading...");
			progressDialog.setCancelable(true);
			progressDialog.show();
/*			if (progressBar.getVisibility() == View.GONE){
				progressBar.setVisibility(View.VISIBLE);
			} else {
				progressBar.setVisibility(View.GONE);
			}*/
			int progress = progressBar.getProgress();
			progress = progress + 10;
			progressBar.setProgress(progress);
//
//			//TODO why this will not cause onPause executed like DialogActivity
//			//TODO is it in the same Activity?
//			AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//			dialog.setTitle("This is a Dialog");
//			dialog.setMessage("Something important");
//			dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//				}
//			});
//			dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//
//				}
//			});
//			dialog.show();
//			break;
		case R.id.button_dialog:
			Log.d(TAG, "click dialog button");
			Intent intent = new Intent(MainActivity.this, DialogActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}