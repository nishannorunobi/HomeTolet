package com.properties.home.tolet.volley;

import java.util.Map;

import org.json.JSONObject;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;

public abstract class JsonObjectCommand extends JsonCommand<JSONObject>{
	
	private JsonObjectRequest jsObjRequest;
	private Map<String, String> params;
	protected JSONObject jsonRequest;
	
	public JsonObjectCommand(OnLoadCompleteListener completeListener) {
		super(completeListener);
	}
	@Override
	public void execute(RequestQueue queue) {
		makeRequest();
		url = url.replaceAll(" ", "%20");
		if(ISDEBUG)
			Log.i(TAG, url);
		jsObjRequest = new JsonObjectRequest(method, url, jsonRequest, this, this)
		{
			@Override
			protected Map<String, String> getParams() throws AuthFailureError 
			{
				return params != null ? params: super.getParams();
			}					
		};		
	
		jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(DEFAULT_TIME_OUT,DEFAULT_RETRY,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		queue.add(jsObjRequest);
	}
}
