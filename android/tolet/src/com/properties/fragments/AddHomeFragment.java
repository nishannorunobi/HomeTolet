package com.properties.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.properties.command.api.ApiConnection;
import com.properties.home.tolet.R;
import com.properties.home.tolet.volley.OnLoadCompleteListener;
import com.properties.home.tolet.volley.post.AddHomeCommand;
import com.properties.home.tolet.volley.post.InsertHomeCommand;
import com.properties.model.Home;


public class AddHomeFragment extends MainFragment implements OnClickListener {
	private EditText etName;
	private EditText etAddress;
	private Button btnAddHome;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container,savedInstanceState);
		View view = inflater.inflate(R.layout.add_home_fragment, container,false);
		findViews(view);
		return view;
	}
	private void findViews(View view) {
		etName = (EditText)view.findViewById( R.id.et_name );
		etAddress = (EditText)view.findViewById( R.id.et_address );
		btnAddHome = (Button)view.findViewById( R.id.btn_add_home );
		btnAddHome.setOnClickListener( this );
	}

	@Override
	public void onClick(View v) {
		if ( v == btnAddHome ) {
			Home home = new Home();
			home.setName(etName.getText().toString());
			home.setAddress(etAddress.getText().toString());
			new AddHomeAsyncTask(home).execute();
			/*insertCommand = new InsertHomeCommand(completeListener, home);
			insertCommand.execute(mRequestQueue);*/
		}
	}
	
	InsertHomeCommand insertCommand;
	private OnLoadCompleteListener completeListener = new OnLoadCompleteListener() {
		
		@Override
		public void onLoadComplete(boolean isCompleted) {
			if(isCompleted){
				Toast.makeText(context, "Success : "+insertCommand.isSuccess()+"", Toast.LENGTH_SHORT).show();
			}
		}
	};
	private class AddHomeAsyncTask extends AsyncTask<Void, Void, Void>{
		Home home;
		AddHomeCommand command;
		public AddHomeAsyncTask(Home home){
			this.home = home;
		}
		@Override
		protected Void doInBackground(Void... params) {
			command = new AddHomeCommand(home);
			command.execute(ApiConnection.getInstance(getActivity()));
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			Toast.makeText(context, "Success : "+command.isSuccess()+"", Toast.LENGTH_SHORT).show();
		}


	}

}
