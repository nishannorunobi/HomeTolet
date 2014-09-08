package com.properties.home.tolet.volley;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;

public abstract class JsonCommand<T> implements ErrorListener,Listener<T>{
	
	private OnLoadCompleteListener completeListener;
	protected String url;
	protected int method;
	public static final String TAG = JsonCommand.class.getName();
	public static final int DEFAULT_TIME_OUT = 20*1000;
	public static final int DEFAULT_RETRY = 3;
	public static final boolean ISDEBUG = true;
	
	public abstract void makeRequest();
	public abstract void execute(final RequestQueue queue);
	public abstract void parse(T obj);
	
	public JsonCommand(final OnLoadCompleteListener completeListener){
		this.completeListener = completeListener;
	}
	@Override
	public void onResponse(T response) {
		parse(response);
		if(completeListener != null)
			completeListener.onLoadComplete(true);
	}

	@Override
	public void onErrorResponse(VolleyError error) {
		if(completeListener != null)
			completeListener.onLoadComplete(false);
	}
	
	

}
