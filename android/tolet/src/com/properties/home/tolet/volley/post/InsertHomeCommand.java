package com.properties.home.tolet.volley.post;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.android.volley.Request.Method;
import com.properties.home.tolet.volley.JsonObjectCommand;
import com.properties.home.tolet.volley.OnLoadCompleteListener;
import com.properties.model.Home;

public class InsertHomeCommand extends JsonObjectCommand{

	private Home home;
	private String errorMessage = "";
	private boolean success = false;

	public InsertHomeCommand(OnLoadCompleteListener completeListener,Home home) {
		super(completeListener);
		this.home = home;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public boolean isSuccess() {
		return success;
	}
	@Override
	public void makeRequest() {
		StringBuilder sb = new StringBuilder("http://localhost:8080/Tolet-Web-service/");
		sb.append("addHome?name="+home.getName()+"&address="+home.getAddress());
		method = Method.POST;
		url = sb.toString();
		Log.d(TAG, url);
	}
	@Override
	public void parse(JSONObject jsonObject) {
		/*Log.d(TAG, data);
		if(data == null)
			return;
		JSONObject jsonObject = new JSONObject(data);*/
		try {
			if(jsonObject.has("success"))
			{
				success = jsonObject.getBoolean("success");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
