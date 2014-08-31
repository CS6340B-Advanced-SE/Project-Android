package com.project.choretracker;

import android.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainFragment extends Fragment {

	LinearLayout tabView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View mainView = inflater.inflate( R.layout.fragment_main, container, false );
		
		tabView = (LinearLayout) mainView.findViewById( R.id.chore_tracker_tabs );
		
		return mainView;
	}
	
	public void addViewTab (View view) {
		tabView.addView( view, new LayoutParams( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT ) );
	}
	public void onClick() {
		
	}
}
