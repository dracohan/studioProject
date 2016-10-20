package com.wanxiang.www.c04_customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by JM on 2016/9/11.
 */
public class CircleView extends View {
	private int mColor = Color.RED;
	private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private int mWidth = 500;
	private int mHeight = 500;

	public CircleView(Context context) {
		super(context);
		init();
	}

	private void init() {
		mPaint.setColor(mColor);
	}

	public CircleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		final int paddingleft = getPaddingLeft();
		final int paddingRight = getPaddingRight();
		final int paddingTop = getPaddingTop();
		final int paddingBottom = getPaddingBottom();
		int width = getWidth() - paddingleft - paddingRight;
		int height = getHeight() - paddingTop - paddingBottom;
		int radius = Math.min(width, height) / 2;
		canvas.drawCircle(paddingleft + width / 2, paddingRight + height / 2, radius, mPaint);

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

		if(widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST){
			setMeasuredDimension(mWidth, mHeight);
		} else if (widthSpecMode == MeasureSpec.AT_MOST){
			setMeasuredDimension(mWidth, heightSpecSize);
		} else if (heightMeasureSpec == MeasureSpec.AT_MOST){
			setMeasuredDimension(mHeight, heightMeasureSpec);
		}
	}
}
