package com.weiready.www.filepersistencetest;

import android.widget.TextView;

/**
 * Created by JM on 2016/8/30.
 */
public class Utils {

	private static PathsTracker mPathsTracker = PathsTracker.getInstance();

	public static void printPaths(final TextView tv) {
		StringBuilder paths = new StringBuilder();
		for (String path : mPathsTracker.keySet()){
			paths.append(path + ":" + mPathsTracker.getPath(path) + "\r\n");
		}
		tv.setText(paths);
	}
}
