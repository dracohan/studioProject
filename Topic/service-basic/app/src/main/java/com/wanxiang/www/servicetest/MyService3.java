package com.wanxiang.www.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService3 extends Service {
	public MyService3() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
