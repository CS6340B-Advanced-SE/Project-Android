package com.project.choretracker.core;

import com.project.choretracker.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View mainView = inflater.inflate( R.layout.fragment_main, container, false );
		
		return mainView;
	}

	public void onClick() {
		
	}
}
