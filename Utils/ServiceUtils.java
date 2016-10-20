package com.wanxiang.www.servicetest;

import android.content.Context;
import android.content.Intent;

/**
 * Created by JM on 2016/10/11.
 */

public class ServiceUtils {
	public static void startAllService(Context context){
		context.startService(new Intent(context, MyService1.class));
		context.startService(new Intent(context, MyService2.class));
		context.startService(new Intent(context, MyService3.class));
	}
}
