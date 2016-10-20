package com.wanxiang.www.learncomponents;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class ChooseADate extends AppCompatActivity {

	private Button btnChooseDate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_adate);

		btnChooseDate = (Button) findViewById(R.id.btnChooseDate);
		btnChooseDate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new DatePickerDialog(ChooseADate.this, new DatePickerDialog.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
						String theDate = String.format("%d-%d-%d", i, i1 + 1, i2);

						System.out.println(theDate);

						btnChooseDate.setText(theDate);
					}
				}, 2016,8,26).show();
			}
		});
	}
}
