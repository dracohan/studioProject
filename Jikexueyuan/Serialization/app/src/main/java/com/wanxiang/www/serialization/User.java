package com.wanxiang.www.serialization;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JM on 2016/8/17.
 */
//public class User implements Serializable{
public class User implements Parcelable{

	String name;
	Integer age;

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public User(String name, Integer age){
		this.name = name;
		this.age = age;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(getName());
		parcel.writeInt(getAge());
	}

	public static final Creator<User> CREATOR = new Creator<User>() {
		@Override
		public User createFromParcel(Parcel parcel) {
			return new User(parcel.readString(), parcel.readInt());
		}

		@Override
		public User[] newArray(int i) {
			return new User[i];
		}
	};

}
