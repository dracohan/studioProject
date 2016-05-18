/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.weiready.www.fragmenttest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.fragments.R;

public class ArticleFragment extends Fragment {
	final static String TAG = "ArticleFragment";
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

	@Override
	public void onAttach (Activity activity){
		super.onAttach(activity);
		Log.d(TAG, "onAttach");
	}

	@Override
	public void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
	    Log.d(TAG, "onCreateView");
	    // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.article_view, container, false);
    }

	@Override
	public void onViewCreated (View view, Bundle savedInstanceState){
		super.onViewCreated(view, savedInstanceState);
		Log.d(TAG, "onViewCreated");
	}

	@Override
	public void onActivityCreated (Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG, "onActivityCreated");
	}

	/*@Override
	public void onViewStateRestored (Bundle savedInstanceState){
		super.onViewStateRestored(savedInstanceState);
		Log.d(TAG, "onViewStateRestored ");
	}*/

    @Override
    public void onStart() {
        super.onStart();
	    Log.d(TAG, "onStart");
        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateArticleView(mCurrentPosition);
        }
    }

	@Override
	public void onResume(){
		super.onResume();
		Log.d(TAG, "onResume");
	}


    public void updateArticleView(int position) {
	    Log.d(TAG, "updateArticleView");
        TextView article = (TextView) getActivity().findViewById(R.id.article);
        article.setText(com.weiready.www.fragmenttest.Ipsum.Articles[position]);
        mCurrentPosition = position;
    }

	@Override
	public void onPause(){
		super.onPause();
		Log.d(TAG, "onPause");
	}

    @Override
    public void onSaveInstanceState(Bundle outState) {
	    Log.d(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }

	@Override
	public void onStop(){
		super.onStop();
		Log.d(TAG, "onStop");
	}

	@Override
	public void onDestroyView (){
		super.onDestroyView();
		Log.d(TAG, "onDestroyView");
	}

	@Override
	public void onDestroy (){
		super.onDestroy();
		Log.d(TAG, "onDestroy");
	}

	@Override
	public void onDetach (){
		super.onDetach();
		Log.d(TAG, "onDetach");
	}

}