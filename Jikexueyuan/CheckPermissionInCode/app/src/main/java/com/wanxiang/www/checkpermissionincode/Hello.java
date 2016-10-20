package com.wanxiang.www.checkpermissionincode;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/**
 * Created by JM on 2016/8/24.
 */
public class Hello {

	public static final String PERMISSION_SAY_HELLO = "com.wanxiang.www.checkpermissionincode.permission.SAY_HELLO";

	public static void sayHello(Context context){

		int checkResult = context.checkCallingOrSelfPermission(PERMISSION_SAY_HELLO);

		if (checkResult != PackageManager.PERMISSION_GRANTED)
			throw new SecurityException("执行这个程序需要com.wanxiang.www.checkpermissionincode.permission.SAY_HELLO权限");

		Log.d("Hello", "Hello Jikexuanyuan");

	}
}
