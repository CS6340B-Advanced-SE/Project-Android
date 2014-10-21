package com.project.choretracker.authentication;

import com.project.choretracker.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChildListActivity extends FragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i( "ChildListActivity", "in onCreate" );
		super.onCreate( savedInstanceState );
		setContentView( R.layout.child_selection_view );
		
		
		LinearLayout selectionView = (LinearLayout)this.findViewById( R.id.child_List );
		
		selectionView = setSelectionList( selectionView );
		selectionView.setVisibility( View.VISIBLE );
		selectionView.setOrientation( LinearLayout.VERTICAL );
		Log.i( "ChildListActivity", "in setSelectionList TextView Count: " + selectionView.getChildCount() );
	}
	
	private LinearLayout setSelectionList( LinearLayout view ) {
		Log.i( "ChildListActivity", "in setSelectionList()" );

		Log.i( "ChildListActivity", "setting layout params" );
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams( 
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT );

		Log.i( "ChildListActivity", "setting textView" );
		final TextView text = new TextView( ChildListActivity.this );
		text.setText( "Mike" );
		text.setTextSize( 40 );
		text.setGravity( Gravity.CENTER );
		text.setVisibility( View.VISIBLE );
		text.setClickable( true );
		text.bringToFront();
		text.setLayoutParams( params );
		Log.i( "ChildListActivity", "created textView" );
		text.setOnClickListener( new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				launchChildAuthView( text.getText().toString(), v );
			}
		});

		Log.i( "ChildListActivity", "adding textView" );
		view.addView( text );
		Log.i( "ChildListActivity", "exiting setSelectionList()" );
		return view;
	}
	
	public void launchChildAuthView( String selectedChild, View v ) {
		Log.i("ChildListActivity", "in launchChildAuthView");
		
		v.performHapticFeedback( HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING );
		
		setContentView( R.layout.child_logon_view );
		ChildAuthenticationFragment childFrag = new ChildAuthenticationFragment();
		getFragmentManager().beginTransaction().add( childFrag, "childFrag" ).commit();

		Log.i("ChildListActivity", "exiting launchChildAuthView");
	}
}
