package com.properties.command.api;

import org.json.JSONException;


public abstract class JsonCommand extends Command{

	public static final boolean ISDEBUG = true;
	
	protected JsonCommand()
	{	
		
	}
	
	@Override
	public CommandResult execute(ApiConnection apiConnection) 
	{		
		try {
			String json = makeRequest(apiConnection);		
			parse(json);
			return new CommandSuccessResult(this);
		} catch (JSONException e) {
			return new CommandFailureResult(this, new ApiException(ApiException.ExceptionType.CommandFailed,
					"JSON parsing error: " + e.toString()));
		} catch (ApiException e) {
			return new CommandFailureResult(this, e);
		}
	}
	
	protected abstract String makeRequest(ApiConnection apiConnection) throws ApiException;

	protected abstract void parse(String data) throws JSONException;

}
