package com.project.choretracker.authentication;

import com.project.choretracker.R;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ChildAuthenticationFragment extends Fragment{
	EditText pinInput;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i( "ChildAuthenticationFragment", "in onCreateView()" );
		View authView = inflater.inflate( R.layout.child_logon_view, container, false );
		
		pinInput = (EditText)authView.findViewById( R.id.childPinEnter );
		pinInput.bringToFront();
		return authView;
	}
}
