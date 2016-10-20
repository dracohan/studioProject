package com.wision.www.coolweather.util;

/**
 * Created by JM on 2016/10/18.
 */
public interface HttpCallbackListener {
	void onFinish(String response);
	void onError(Exception e);
}
