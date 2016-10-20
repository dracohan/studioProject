package com.wanxiang.www.myapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by JM on 2016/9/11.
 */
public class MyRect extends View {
	private int degree;

	/**
	 * Simple constructor to use when creating a view from code.
	 *
	 * @param context The Context the view is running in, through which it can
	 *                access the current theme, resources, etc.
	 */
	public MyRect(Context context) {
		super(context);
		initproperties();
	}

	/**
	 * Constructor that is called when inflating a view from XML. This is called
	 * when a view is being constructed from an XML file, supplying attributes
	 * that were specified in the XML file. This version uses a default style of
	 * 0, so the only attribute values applied are those in the Context's Theme
	 * and the given AttributeSet.
	 * <p/>
	 * <p/>
	 * The method onFinishInflate() will be called after all children have been
	 * added.
	 *
	 * @param context The Context the view is running in, through which it can
	 *                access the current theme, resources, etc.
	 * @param attrs   The attributes of the XML tag that is inflating the view.

	 */
	public MyRect(Context context, AttributeSet attrs) {
		super(context, attrs);
		initproperties();
	}

	/**
	 * Perform inflation from XML and apply a class-specific base style from a
	 * theme attribute. This constructor of View allows subclasses to use their
	 * own base style when they are inflating. For example, a Button class's
	 * constructor would call this version of the super class constructor and
	 * supply <code>R.attr.buttonStyle</code> for <var>defStyleAttr</var>; this
	 * allows the theme's button style to modify all of the base view attributes
	 * (in particular its background) as well as the Button class's attributes.
	 *
	 * @param context      The Context the view is running in, through which it can
	 *                     access the current theme, resources, etc.
	 * @param attrs        The attributes of the XML tag that is inflating the view.
	 * @param defStyleAttr An attribute in the current theme that contains a
	 *                     reference to a style resource that supplies default values for
	 *                     the view. Can be 0 to not look for defaults.
	 */
	public MyRect(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		initproperties();
	}
	
	private void initproperties() {
		p = new Paint();
		p.setColor(Color.RED);
	}

//	@Override
//	public void draw(Canvas canvas) {
//		super.draw(canvas);
//		canvas.save();
//		canvas.rotate(degree++, 200, 200);
//		canvas.drawRect(0, 0, 400, 400, p);
//		canvas.restore();
//		invalidate();
//	}


	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.save();
		canvas.rotate(degree++, 200, 200);
		canvas.drawRect(0, 0, 400, 400, p);
		canvas.restore();
		invalidate();
	}

	private Paint p;
}
