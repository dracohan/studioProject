package com.weiready.www.fragmentbestpractice;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by JM on 2016/8/12.
 */
public class BaseFragment extends Fragment {
	public String TAG = getClass().getSimpleName();

	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		Log.d(TAG, "onAttach");
	}

	@Override
	public void onCreate(Bundle savedinstanceState) {
		super.onCreate(savedinstanceState);
		Log.d(TAG, "onCreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState){
		Log.d(TAG, "onCreateView");
		View view = inflater.inflate(R.layout.news_content_frag, container, false);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState){
		super.onViewCreated(view, savedInstanceState);
		Log.d(TAG, "onViewCreated");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG, "onActivityCreated");
	}

	@Override
	public void onViewStateRestored(Bundle savedInstanceState){
		super.onViewStateRestored(savedInstanceState);
		Log.d(TAG, "onViewStateRestored");
	}

	@Override
	public void onStart(){
		super.onStart();
		Log.d(TAG, "onStart");
	}

	@Override
	public void onResume(){
		super.onResume();
		Log.d(TAG, "onResume");
	}

	@Override
	public void onPause(){
		super.onPause();
		Log.d(TAG, "onPause");
	}

	@Override
	public void onStop(){
		super.onStop();
		Log.d(TAG, "onStop");
	}

	@Override
	public void onDestroyView(){
		super.onDestroyView();
		Log.d(TAG, "onDestroyView");
	}

	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.d(TAG, "onDestroy");
	}

	@Override
	public void onDetach(){
		super.onDetach();
		Log.d(TAG, "onDetach");
	}
}
