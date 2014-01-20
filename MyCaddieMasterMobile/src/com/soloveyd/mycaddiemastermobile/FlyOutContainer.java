package com.soloveyd.mycaddiemastermobile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class FlyOutContainer extends LinearLayout{

	private View mMenu;
	private View mContent;
	
	public enum MenuState{
		OPEN,CLOSED
	};
	
	protected static final int MENU_MARGIN = 150;
	protected int mCurrentContentOffset = 0;
	protected MenuState mCurrentMenuState = MenuState.CLOSED;
	
	public FlyOutContainer(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public FlyOutContainer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public FlyOutContainer(Context context) {
		super(context);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		super.onLayout(changed, l, t, r, b);
		if(changed){
			this.calculateChildDimensions();
		}
		this.mMenu.layout(l, t, r - MENU_MARGIN, b);
		this.mContent.layout(l+mCurrentContentOffset, t, r+mCurrentContentOffset, b);
	}

	@Override
	protected void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
		this.mMenu = this.getChildAt(0);
		this.mContent = this.getChildAt(1);
		this.mMenu.setVisibility(View.GONE);
	}
	
	private void calculateChildDimensions(){
		this.mContent.getLayoutParams().height = this.getHeight();
		this.mContent.getLayoutParams().width = this.getWidth();
		
		this.mMenu.getLayoutParams().height = this.getHeight();
		this.mMenu.getLayoutParams().width = this.getWidth()-MENU_MARGIN;
	}
	
	private int getMenuWidth(){
		return this.mMenu.getLayoutParams().width;
	}
	
	public void toggleMenu(){
		switch(this.mCurrentMenuState){
		case CLOSED:
			this.mMenu.setVisibility(View.VISIBLE);
			this.mCurrentContentOffset = this.getMenuWidth();
			this.mContent.offsetLeftAndRight(mCurrentContentOffset);
			this.mCurrentMenuState = MenuState.OPEN;
			break;
		case OPEN:
			this.mContent.offsetLeftAndRight(-mCurrentContentOffset);
			this.mCurrentContentOffset = 0;
			this.mCurrentMenuState = MenuState.CLOSED;
			this.mMenu.setVisibility(View.GONE);
			break;
		}
		this.invalidate();
	}
}
