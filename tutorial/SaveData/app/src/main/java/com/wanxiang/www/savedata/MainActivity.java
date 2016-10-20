package com.wanxiang.www.savedata;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.FileOutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println(getExternalFilesDir(null));
		System.out.println(getExternalFilesDirs(null)[0]);
		//Internal Storage
		System.out.println(getFilesDir());
		//Internal Cache Storage
		System.out.println(getCacheDir());

		System.out.println(Environment.getExternalStorageState());

		System.out.println();

	}

	public void SaveSharedPreference(View view) {
//		SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
		SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
		editor.putString("name", "Tom");
		editor.putInt("age", 28);
		editor.commit();
	}

	public void SaveToFile(View view) {
		String filename = "myfile";
		String string = "Hello world!";
		FileOutputStream outputStream;

		try {
			outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
			outputStream.write(string.getBytes());
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Dial(View view) {
		Uri number  = Uri.parse("tel:55125014");
		Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
		startActivity(callIntent);
	}

	public void Geo(View view) {
		// Build the intent
		Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
		Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

		// Verify it resolves
		PackageManager packageManager = getPackageManager();
		List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
		boolean isIntentSafe = activities.size() > 0;

		// Start an activity if it's safe
		if (isIntentSafe) {
			startActivity(mapIntent);
		}
	}

}
