package com.wanxiang.www.applicationcontext;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

/**
 * Created by JM on 2016/8/18.
 */
public class App extends Application {
	private String textData = "default";

	public void setTextData(String textData) {
		this.textData = textData;
	}

	public String getTextData() {
		return textData;
	}

	//executed before activity's onCreate()
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("App", "App onCreate");
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		Log.d("App", "onTerminate");
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
}
