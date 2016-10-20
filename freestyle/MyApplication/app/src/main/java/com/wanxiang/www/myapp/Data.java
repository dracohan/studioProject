package com.wanxiang.www.myapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JM on 2016/9/7.
 */
public class Data implements Parcelable {
	protected Data(Parcel in) {
	}

	public static final Creator<Data> CREATOR = new Creator<Data>() {
		@Override
		public Data createFromParcel(Parcel in) {
			return new Data(in);
		}

		@Override
		public Data[] newArray(int size) {
			return new Data[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {

	}
}
