package com.wanxiang.www.myapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {


	public BlankFragment2() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View root =  inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
		root.findViewById(R.id.btnStartFrag3).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				System.out.println("onclicked");
				getFragmentManager().beginTransaction()
						.replace(R.id.container, new BlankFragment3())
						.commit();
			}
		});
		return  root;
	}

}
