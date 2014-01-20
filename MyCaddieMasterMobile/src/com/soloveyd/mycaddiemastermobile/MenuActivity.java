package com.soloveyd.mycaddiemastermobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity{

	FlyOutContainer mLayout;
	Button mBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		this.mLayout = (FlyOutContainer) this.getLayoutInflater().inflate(R.layout.menu_activity, null);
		mBtn = (Button) findViewById(R.id.toggle_btn);
		mBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				toggleMenu(v);
				
			}
			
		});
	}
	
	public void toggleMenu(View v){
		this.mLayout.toggleMenu();
	}
	

}
