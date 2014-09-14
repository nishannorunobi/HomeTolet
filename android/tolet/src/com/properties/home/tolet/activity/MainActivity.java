package com.properties.home.tolet.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.properties.home.tolet.R;
import com.properties.home.tolet.volley.VolleySingleton;


public class MainActivity extends ActionBarActivity {
	private VolleySingleton mInstance = null;
	protected RequestQueue mRequestQueue;
    protected ImageLoader mImageLoader;
	protected Context context;
	protected ActionBar actionBar;
	protected LayoutInflater inflater;
	protected boolean hasTheme = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = MainActivity.this;
		mInstance = VolleySingleton.getInstance(context);
		mRequestQueue = mInstance.getRequestQueue();
		mImageLoader = mInstance.getImageLoader();
		actionBar = getSupportActionBar();
		inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
		setActionBar();
	}

	public void setActionBar(){
		if(actionBar != null){
			actionBar.setDisplayShowTitleEnabled(false);
			LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,Gravity.CENTER);
			View customNav = LayoutInflater.from(this).inflate(R.layout.actionbar_custom_view, null); // layout which contains your button.
			actionBar.setCustomView(customNav,lp);
			//actionBar.setCustomView(customNav);
			actionBar.setDisplayShowCustomEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
