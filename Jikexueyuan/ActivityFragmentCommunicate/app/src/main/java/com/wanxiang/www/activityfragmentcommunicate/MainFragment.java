package com.wanxiang.www.activityfragmentcommunicate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.niu.myapp.actcomwifrag.R;

/**
 * Created by JM on 2016/8/12.
 */
public class MainFragment extends BaseFragment {

	/**
	 * 没有参数没有返回值的函数
	 */
	public static final String FUNCTION_NO_PARAM_NO_RESULT = "FUNCTION_NO_PARAM_NO_RESULT";
	/**
	 * 有参数没有返回值的函数
	 */
	public static final String FUNCTION_HAS_PARAM_NO_RESULT = "FUNCTION_HAS_PARAM_NO_RESULT";

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_main_layout, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Button mBut1 = (Button) getView().findViewById(R.id.click1);
		Button mBut3 = (Button) getView().findViewById(R.id.click3);

		mBut1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					//调用无参无返回值的方法
					mFunctions.invokeFunc(
							FUNCTION_NO_PARAM_NO_RESULT);
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}

			}
		});

		mBut3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					//调用有参无返回值的方法
					mFunctions.invokeFunc(
							FUNCTION_HAS_PARAM_NO_RESULT, 100);
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
