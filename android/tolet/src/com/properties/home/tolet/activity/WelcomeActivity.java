package com.properties.home.tolet.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.properties.fragments.AddHomeFragment;
import com.properties.fragments.WelcomeFragment;
import com.properties.home.tolet.R;

public class WelcomeActivity extends MainActivity{
	Fragment fragment;
	FragmentTransaction transaction;
	private PopupWindow popupWindow;
	private LayoutInflater layoutInflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layoutInflater = getLayoutInflater();
		showFragment(new WelcomeFragment());
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.welcome_menu, menu);
		final MenuItem dashboardItem = menu.findItem(R.id.menu_dashboard);
		initPopUpWindow(dashboardItem.getActionView());
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		int id = item.getItemId();
		if(id == R.id.add_home)
			showFragment(new AddHomeFragment());
		/*else if(id == R.id.menu_dashboard)
			item.setActionView(inflater.inflate(R.layout.dashboard_action_view, null));
			*/
		
		return true;
	}

	protected void initPopUpWindow(View ViewAnchor)
	{
		if(ViewAnchor == null)
			return;
		if(popupWindow == null)
		{
			View popupView = layoutInflater.inflate(R.layout.dashboard, null); 
			popupWindow = new PopupWindow(popupView);
			popupWindow.setWindowLayoutMode(ViewGroup.LayoutParams.MATCH_PARENT, 
					ViewGroup.LayoutParams.WRAP_CONTENT);
			popupWindow.showAsDropDown(ViewAnchor);
			/*initPopupView(popupView);
			setUserData(popupWindow.getContentView());*/
		}

		/*if(popupWindow.isShowing())			
			popupWindow.dismiss();
		else
			popupWindow.showAsDropDown(ViewAnchor,10,10)*/;
	}	

	private void setUserData(final View v)
	{
		TextView tvBucksAmmount = (TextView) v.findViewById(R.id.tv_dashboard_item_bucks_amount);
		TextView tvReferalAmmount = (TextView) v.findViewById(R.id.tv_dashboard_referral_amount);
		TextView tvBookingAmmount = (TextView) v.findViewById(R.id.tv_dashboard_booking_amount);
		TextView tvNoOfReview = (TextView) v.findViewById(R.id.tv_dashboard_review_hotel);
	}

	private void showFragment(Fragment fragment){
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fragment_container, fragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}
}
