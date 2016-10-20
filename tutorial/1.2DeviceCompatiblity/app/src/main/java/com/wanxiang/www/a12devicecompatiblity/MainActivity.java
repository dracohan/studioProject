package com.wanxiang.www.a12devicecompatiblity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.util.Log;
import android.view.View;


public class MainActivity extends BaseActivity {
	public String TAG = getClass().getSimpleName();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		PackageManager pm = getPackageManager();
		if (pm.hasSystemFeature(PackageManager.FEATURE_SENSOR_COMPASS))
			Log.d("MainActivity", "Has Compass Feature");

		Log.d("MainActivity", System.getProperty("java.vm.version"));
		Log.d("MainActivity", "isFinishing(): " + isFinishing());

	}

	public void InsertContact(View view) {
		String name = "aaa", email = "bbb";
		Intent intent = new Intent(Intent.ACTION_INSERT);
		intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
		intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
		intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
		if (intent.resolveActivity(getPackageManager()) != null) {
			startActivity(intent);
		}
	}

	public void openWIFISetting(View view) {
		Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
		if (intent.resolveActivity(getPackageManager()) != null) {
			startActivity(intent);
		}
	}

	public void sendEmail(View view) {
		Intent intent = new Intent(Intent.ACTION_SENDTO);
		intent.setData(Uri.parse("mailto:")); // only email apps should handle this
		intent.putExtra(Intent.EXTRA_EMAIL, "13240943@qq.com");
		intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
		if (intent.resolveActivity(getPackageManager()) != null) {
			startActivity(intent);
		}
	}

}
