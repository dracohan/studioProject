package com.wanxiang.www.activityfragmentcommunicate;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by JM on 2016/8/12.
 */
public abstract class BaseFragment extends Fragment {
	protected BaseActivity mBaseActivity;
	/** * 函数的集合 */
	protected Functions mFunctions;

	/** * activity调用此方法进行设置Functions
	 * @param functions */
	public void setFunctions(Functions functions){
		this.mFunctions = functions;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		//呼叫activity进行回调方法的设置
		if(activity instanceof BaseActivity){
			mBaseActivity = (BaseActivity)activity;
			mBaseActivity.setFunctionsForFragment(getId());
		}
	}
}
