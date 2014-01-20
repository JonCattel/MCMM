package com.soloveyd.mycaddiemastermobile;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class StartupActivity extends Activity {
//WRITE CODE TO DESIGN THE STARTUP ACTIVITY
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startup);
		//call the menu
		Intent startApp = new Intent(this, MenuActivity.class);
		startActivity(startApp);
	}


}
