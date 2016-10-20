package com.wanxiang.www.download;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by JM on 2016/8/11.
 */
public class MainActivity extends Activity {
	String downloadUrl = "http://static.oschina.net/uploads/user/1178/2356166_100.jpg?t=1443506236000";
	String fileName = "xiaoman";
	@Override
	protected void onCreate(Bundle saveInstanceBundle){
		super.onCreate(saveInstanceBundle);
		setContentView(R.layout.layout);
		final Context mContext = getApplicationContext();
		Button button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				DownloadManager.Request request = new DownloadManager.Request(
						Uri.parse(downloadUrl));
				request.setDestinationInExternalPublicDir("/download/", fileName);
				DownloadManager downloadManager = (DownloadManager)mContext.
						getSystemService(Context.DOWNLOAD_SERVICE);
				downloadManager.enqueue(request);
			}
		});



	}


}
