package com.wanxiang.www.networktest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by JM on 2016/8/24.
 */
public class MainActivity extends Activity implements View.OnClickListener{

	public static final int SHOW_RESPONSE = 0;

	private Button sendRequest;

	private TextView responseText;

	private Handler handler = new Handler(){
		public void handleMessage(Message message){
			switch (message.what){
				case SHOW_RESPONSE:
					String response = (String) message.obj;
					responseText.setText(response);
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sendRequest = (Button) findViewById(R.id.send_request);
		responseText = (TextView) findViewById(R.id.response_text);
		sendRequest.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.send_request)
//			sendRequestWithHttpURLConnection();
			sendRequestWithHttpClient();
	}

	private void sendRequestWithHttpClient() {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try{
//					HttpClient httpClient = new DefaultHttpClient();
//				}catch (Exception e){
//					e.printStackTrace();
//				}
//			}
//		}).start();

		
	}

	private void sendRequestWithHttpURLConnection() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				HttpURLConnection connection = null;
				try {
					URL url = new URL("http://www.baidu.com");
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while( (line = reader.readLine()) != null)
						response.append(line);

					Message message = new Message();
					message.what = SHOW_RESPONSE;
					message.obj = response.toString();
					handler.sendMessage(message);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (connection != null){
						connection.disconnect();
					}
				}
			}
		}).start();
	}
}
