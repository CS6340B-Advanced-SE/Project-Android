package com.project.choretracker.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPreferenceHelper {

	
	public static boolean getLoggedOnStatus( Context appContext ) {
		boolean loggedIn = false;
		
		SharedPreferences pref = appContext.getSharedPreferences( "choreTrackerPref", appContext.MODE_PRIVATE );
		loggedIn = pref.getBoolean( "loggedOn", false );
		
		return loggedIn;
	}
	
	public static void setPreferenceToLogoff( Context appContext ) {

		SharedPreferences pref = appContext.getSharedPreferences( "choreTrackerPref", appContext.MODE_PRIVATE );
		SharedPreferences.Editor editor = pref.edit();
		
		editor.putBoolean( "loggedOn", false );
		editor.commit();
		Log.i( "SharedPreferenceHelper", "in setPreferenceToLogoff" );
	}
}
