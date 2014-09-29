package com.project.choretracker.authentication;

import com.project.choretracker.R;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class AuthenticationFragment extends Fragment{

	Button accept;
	OnClickListener acceptListener;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		System.out.println( "in onCreateView() for Authentication Fragment" );
		View authView = inflater.inflate( R.layout.authentication_layout, container, false );
		accept = (Button) authView.findViewById( R.id.button1 );
		accept.setClickable( true );
		accept.bringToFront();
	
		return authView;
	}
	
	public void onAcceptClicked( View v ) {
		Log.i( "AuthenticationFragment", "in onAcceptClicked" );
		v.performHapticFeedback( HapticFeedbackConstants.VIRTUAL_KEY, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING );
		getActivity().finish();
	}
	
}
