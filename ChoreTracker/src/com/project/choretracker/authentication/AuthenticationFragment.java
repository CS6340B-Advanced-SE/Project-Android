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
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;

public class AuthenticationFragment extends Fragment{

	Button accept;
	ImageButton parent;
	ImageButton child;
	OnClickListener acceptListener;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i( "AuthenticationFragment", "in onCreateView()" );
		View authView = inflater.inflate( R.layout.authentication_layout, container, false );
		accept = (Button) authView.findViewById( R.id.button1 );
		accept.setClickable( true );
		accept.bringToFront();
		parent = (ImageButton) authView.findViewById( R.id.parentButton );
		parent.setClickable( true );
		parent.bringToFront();
		child = (ImageButton) authView.findViewById( R.id.childButton );
		child.setClickable( true );
		child.bringToFront();
		
		return authView;
	}
	
	public void onAcceptClicked( View v ) {
		Log.i( "AuthenticationFragment", "in onAcceptClicked" );
		v.performHapticFeedback( HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING );
		getActivity().finish();
	}
	
	public void onParentClicked( View v ) {
		Log.i("AuthenticatinoFragment", "in onParentClicked");
		
		v.performHapticFeedback( HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING );
		//TODO Load activity with new view
		
		getActivity().setContentView( R.layout.parent_logon_view );
		ParentAuthenticationFragment parentFrag = new ParentAuthenticationFragment();
		getActivity().getFragmentManager().beginTransaction().add( parentFrag, "parentAuth" ).commit();

		Log.i("AuthenticatinoFragment", "exiting onParentClicked");
	}
	
}
