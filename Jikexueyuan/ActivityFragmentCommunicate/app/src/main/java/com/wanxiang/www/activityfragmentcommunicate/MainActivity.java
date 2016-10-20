package com.wanxiang.www.activityfragmentcommunicate;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.niu.myapp.actcomwifrag.R;

/**
 * Created by JM on 2016/8/12.
 */
public class MainActivity extends BaseActivity {


	@Override
	protected void onCreate(Bundle saveInstanceBundle){
		super.onCreate(saveInstanceBundle);
		setContentView(R.layout.activity_main_layout);
	}
	@Override public void setFunctionsForFragment(int fragmentId) {
		super.setFunctionsForFragment(fragmentId);
		switch (fragmentId) {
			case R.id.fragment_main:
				FragmentManager fm = getSupportFragmentManager();
				BaseFragment fragment = (BaseFragment) fm.findFragmentById(fragmentId);
				//开始添加functions
				fragment.setFunctions(new Functions()
						.addFunction(new Functions.FunctionNoParamAndResult(MainFragment.FUNCTION_NO_PARAM_NO_RESULT) {

							@Override
							public void function() {
								Toast.makeText(MainActivity.this, "成功调用无参无返回值方法", Toast.LENGTH_LONG).show();
							}
						}).
						addFunction(new Functions.FunctionWithParam<Integer>(MainFragment.FUNCTION_HAS_PARAM_NO_RESULT) {
							@Override
							public void function(Integer o) {
								Toast.makeText(MainActivity.this, "成功调用有参无返回值方法 参数值=" + o, Toast.LENGTH_LONG).show(); } }));
		}
	}
}
