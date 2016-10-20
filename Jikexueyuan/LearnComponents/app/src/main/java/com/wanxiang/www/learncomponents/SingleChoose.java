package com.wanxiang.www.learncomponents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Date;

public class SingleChoose extends AppCompatActivity {

	private Button btnSubmit;
	private RadioButton rbA;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_choose);

		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		rbA = (RadioButton) findViewById(R.id.rbA);


		btnSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				System.out.println("date: " + new Date(System.currentTimeMillis()));
				System.out.println("SingleChoose.this: " + SingleChoose.this);
				System.out.println("this: " + this);
				if (rbA.isChecked()) {
					Toast.makeText(SingleChoose.this, "所选是正确的", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(SingleChoose.this, "所选是错误的", Toast.LENGTH_SHORT).show();

				}

			}
		});
	}
}
