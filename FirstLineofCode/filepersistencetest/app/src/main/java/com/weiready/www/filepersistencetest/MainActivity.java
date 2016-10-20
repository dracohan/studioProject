package com.weiready.www.filepersistencetest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;

public class MainActivity extends Activity {
	public static final String TAG = "MainActivity";
	private EditText edit;

	private static Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edit = (EditText) findViewById(R.id.edit);
		String inputText = load();
		//String inputText = "";
		if (!TextUtils.isEmpty(inputText)) {
			edit.setText(inputText);
			//edit.setSelection(inputText.length());
			Toast.makeText(this, "Restoring succeeded", Toast.LENGTH_SHORT).show();
		}

		//listing all the file paths
		PathsTracker pathsTracker = PathsTracker.getInstance();
		pathsTracker.setPath("Internal Storage path: " ,
				getFilesDir().toString());
		pathsTracker.setPath("Internal Cache Storage path: " ,
				getCacheDir().toString());
		pathsTracker.setPath("External file path: " ,
				Environment.getExternalStorageDirectory().toString());
		pathsTracker.setPath("External picture file path: " ,
				Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString());
		Utils.printPaths((TextView) findViewById(R.id.file_path));




//		context = getApplicationContext();
//		String dir = context.getFilesDir().toString();
//		Log.d(TAG, dir);
//
//		String state = Environment.getExternalStorageState();
//		Log.d(TAG, state);
//
//		File file = new File(Environment.getExternalStoragePublicDirectory(
//				Environment.DIRECTORY_PICTURES), "aaa");
//		Log.d(TAG, file.toString());
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
		String inputText = edit.getText().toString();
		save(inputText);
	}

	public void save(String inputText) {
		FileOutputStream out = null;
		BufferedWriter writer = null;
		try {
			out = openFileOutput("data", Context.MODE_APPEND);
			writer = new BufferedWriter(new OutputStreamWriter(out));
			writer.write(inputText);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String load() {
		FileInputStream in = null;
		BufferedReader reader = null;
		StringBuilder content = new StringBuilder();
		try {
			//auto check "/data/data/<package name>/files"
			in = openFileInput("data");
			reader = new BufferedReader(new InputStreamReader(in));
			String line = "";
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return content.toString();
	}

}
