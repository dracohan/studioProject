package com.weiready.www.ContactsTest;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	ListView contactsView;

	ArrayAdapter<String> adapter;

	List<String> contactsList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		contactsView = (ListView) findViewById(R.id.contacts_view);

		checkAndReadContacts();
		addSomeContacts();
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsList);
		contactsView.setAdapter(adapter);
	}

	private void checkAndReadContacts() {
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
				checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
			requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, 1);
		readContacts();
	}

	private void addSomeContacts() {
		ContentValues values = new ContentValues();
		values.put(ContactsContract.Contacts.DISPLAY_NAME, "aaa");
		values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, "111");
		getContentResolver().insert(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, values);
	}

	private void readContacts() {

		Cursor cursor = null;
		try {
			cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
					null, null, null, null);
			while (cursor.moveToNext()) {
				String displayName = cursor.getString(cursor
						.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				String number = cursor.getString(cursor
						.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				contactsList.add(displayName + "\n" + number);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
	}



}
