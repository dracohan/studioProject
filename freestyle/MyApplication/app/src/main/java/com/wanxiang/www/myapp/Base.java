package com.wanxiang.www.myapp;

import android.util.ArrayMap;

/**
 * Created by JM on 2016/9/1.
 */
public class Base {
	public static void func(){
		System.out.println("Base.func()");
	}

	public static void main(String[] args) {
		Base b = new Ext();
		b.func();

		ArrayMap arrayMap = new ArrayMap();
		arrayMap.put("data", "value");
		arrayMap.put("data1", "value1");

		System.out.println("Item:" + arrayMap.get("data"));
		System.out.println("Item1:" + arrayMap.get("data1"));

	}
}


class Ext extends Base{
	public static void func(){
		System.out.println("Ext.func()");
	}
}