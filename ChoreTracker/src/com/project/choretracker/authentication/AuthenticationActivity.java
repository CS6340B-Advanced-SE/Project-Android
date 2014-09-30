package com.project.choretracker.authentication;

import com.project.choretracker.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class AuthenticationActivity extends FragmentActivity {

	boolean									loggedOn;
	AuthenticationFragment					authFrag;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.authentication_layout );
		
		Intent intent = getIntent();
		loggedOn = intent.getBooleanExtra( "loggedOn", false );
		
		authFrag = new AuthenticationFragment();

		getFragmentManager().beginTransaction().add( authFrag, "authFrag" ).commit();
	}
	
	
	public void onAcceptClicked( View v ) {
		SharedPreferences pref = getApplicationContext().getSharedPreferences( "choreTrackerPref",  MODE_PRIVATE );
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean( "loggedOn", true );
		editor.commit();
		authFrag.onAcceptClicked( v );
	}
	
	public void onParentClicked( View v ) {
		authFrag.onParentClicked( v );
	}
}
