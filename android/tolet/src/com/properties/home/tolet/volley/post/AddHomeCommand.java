package com.properties.home.tolet.volley.post;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.properties.command.api.ApiConnection;
import com.properties.command.api.ApiException;
import com.properties.command.api.JsonCommand;
import com.properties.model.Home;

public class AddHomeCommand extends JsonCommand{
	private Home home;
	private String errorMessage = "";
	private boolean success = false;
	public AddHomeCommand(Home home){
		this.home = home;
	}
	@Override
	protected String makeRequest(ApiConnection apiConnection)
			throws ApiException {
		StringBuilder sb = new StringBuilder("http://192.168.9.10:8080/Tolet-Web-service/");
		sb.append("addHome");
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("name", home.getName()));
		parameters.add(new BasicNameValuePair("address",home.getAddress()));
		return apiConnection.post(sb.toString(), parameters,200,201,207);
	}

	@Override
	protected void parse(String data) throws JSONException {
		Log.d(TAG, data);
		if(data == null)
			return;
		JSONObject jsonObject = new JSONObject(data);
		if(jsonObject.has("success"))
		{
			success = jsonObject.getBoolean("success");
		}
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public boolean isSuccess() {
		return success;
	}
}
