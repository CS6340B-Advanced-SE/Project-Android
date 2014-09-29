package com.project.choretracker.core.views.fragments;

import com.project.choretracker.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CalendarObjectFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate( R.layout.chore_tracker_calendar, container, false );
		
		return rootView;
	}
}
