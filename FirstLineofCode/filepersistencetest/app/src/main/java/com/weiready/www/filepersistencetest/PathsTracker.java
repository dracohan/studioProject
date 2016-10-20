package com.weiready.www.filepersistencetest;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by JM on 2016/8/30.
 */
public class PathsTracker {
	private LinkedHashMap<String, String> mPathMap;
	private static PathsTracker ourInstance = new PathsTracker();

	public PathsTracker(){
		mPathMap = new LinkedHashMap<>();
	}

	public static PathsTracker getInstance(){
		return ourInstance;
	}

	public void clear(){
		mPathMap.clear();
	}

	public void setPath(String pathName, String path){
		mPathMap.put(pathName, path);
	}

	public Set<String> keySet(){
		return mPathMap.keySet();
	}

	public String getPath(String pathname) {
		String path = mPathMap.get(pathname);
		return path;
	}
}
