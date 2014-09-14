package com.properties.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.properties.home.tolet.volley.VolleySingleton;


public class MainFragment extends Fragment{
	private VolleySingleton mInstance = null;
	protected RequestQueue mRequestQueue;
    protected ImageLoader mImageLoader;
	protected Context context;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.context = getActivity();
		mInstance = VolleySingleton.getInstance(context);
		mRequestQueue = mInstance.getRequestQueue();
		mImageLoader = mInstance.getImageLoader();
		return super.onCreateView(inflater, container,savedInstanceState);
	}
	
}