package com.wision.myfirstappcreatedbycmd;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity

{
	Integer[] iArr;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	    System.out.println(System.getProperty("java.vm.version"));
	    ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
	    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
		    System.out.println(am.getMemoryClass());
	    }
    }

	public void GC(View view) {
		System.out.println("gc triggered");
		System.gc();
		System.out.println("gc finished");
	}

	public void allocate(View view) {

		for (int i = 0; i < 1024; i++){
			Integer[] integers = new Integer[10];
		}
	}

	public void deallocate(View view) {
		iArr = null;
	}
}
