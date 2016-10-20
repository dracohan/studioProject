package com.weiready.www.uilistviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity_simplelist extends Activity {

//	public String[] data = {"Apple", "Banana", "Orange", "Cherry"};
	public Integer[] data = {1123123,1231,23,12,123123,123123};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_simplelist);

		//data is a String Array
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(
		//		MainActivity_simplelist.this, android.R.layout.simple_list_item_1, data);
		ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(
				MainActivity_simplelist.this, android.R.layout.simple_list_item_checked, data);

		ListView listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(adapter);
	}
}
