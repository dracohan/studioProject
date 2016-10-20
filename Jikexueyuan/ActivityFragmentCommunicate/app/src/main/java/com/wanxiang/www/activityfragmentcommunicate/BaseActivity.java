package com.wanxiang.www.activityfragmentcommunicate;

import android.support.v4.app.FragmentActivity;

/**
 * Created by JM on 2016/8/12.
 */
public abstract class BaseActivity extends FragmentActivity {
	/**
	 * 为fragment设置functions，具体实现子类来做
	 * @param fragmentId */
	public void setFunctionsForFragment(
			int fragmentId){
	}
}
