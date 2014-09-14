package com.properties.home.tolet.volley;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonArrayRequest;

public abstract class JsonArrayCommand extends JsonCommand<JSONArray>{
	
	private JsonArrayRequest jsonArrayRequest;
	private Map<String, String> params;
	protected JSONObject jsonRequest;
	
	public JsonArrayCommand(OnLoadCompleteListener completeListener) {
		super(completeListener);
		params = null;
		jsonRequest = null;
	}

	@Override
	public void execute(RequestQueue queue) {
		makeRequest();
		url = url.replaceAll(" ", "%20");
		method = Method.GET;
		if(ISDEBUG)
			Log.i(TAG, url);
		jsonArrayRequest = new JsonArrayRequest(method,url,jsonRequest, this, this){
			@Override
			protected Map<String, String> getParams() throws AuthFailureError 
			{
				return params != null ? params: super.getParams();
			}					
		};
		
		jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DEFAULT_TIME_OUT,DEFAULT_RETRY, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		queue.add(jsonArrayRequest);
	}

}
