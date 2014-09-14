package com.properties.home.tolet;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

public class HomeToletApplication extends Application {
	private final static String TAG = HomeToletApplication.class.getName();
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(TAG,"Application Created");
		
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		Log.d(TAG,"Application onConfigurationChanged Called");
		super.onConfigurationChanged(newConfig);
	}
	
}
