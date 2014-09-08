package com.properties.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.properties.home.tolet.R;


public class AddHomeFragment extends Fragment implements OnClickListener {
	private EditText etName;
	private EditText etAddress;
	private Button btnAddHome;
	private Activity context;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		context = getActivity();
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
			Toast.makeText(context, etName.getText().toString(), Toast.LENGTH_SHORT).show();
			
		}
	}


}
