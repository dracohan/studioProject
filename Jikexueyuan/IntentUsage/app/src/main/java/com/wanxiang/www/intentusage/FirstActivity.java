package com.wanxiang.www.intentusage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by JM on 2016/8/11.
 */
public class FirstActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle saveInstanceBundle){
		super.onCreate(saveInstanceBundle);
		setContentView(R.layout.first_layout);
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//Explicit Intent
				//Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				//startActivity(intent);

				//Implicit Intent
				//Intent intent = new Intent("com.wanxiang.www.intentusage.START");
				//startActivity(intent);

				//Uri uri = Uri.parse("smsto:18817878501");
				//Intent it = new Intent(Intent.ACTION_SENDTO, uri);
				//it.putExtra("sms_body", "The text");


				Intent it = new Intent(Intent.ACTION_SENDTO);
				it.setData(Uri.parse("smsto:18817878501"));
				it.putExtra("sms_body", "The text");
				startActivity(it);
			}
		});

	}


}
