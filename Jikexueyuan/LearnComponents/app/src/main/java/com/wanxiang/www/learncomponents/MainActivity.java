package com.wanxiang.www.learncomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

	private Spinner s;
	private String[] dataSource = new String[]{"jikexueyuan", "jm", "Han"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		s = (Spinner) findViewById(R.id.spinner);

		s.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,
				dataSource));

		s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
				System.out.println("用户选择的是" + dataSource[i]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {

			}
		});
	}
}
