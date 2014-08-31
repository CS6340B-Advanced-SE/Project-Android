package com.project.choretracker.core;

import com.project.choretracker.core.views.fragments.HomeObjectFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ChoreTrackFragmentAdapter extends FragmentStatePagerAdapter{

	public ChoreTrackFragmentAdapter( FragmentManager fm ) {
		super( fm );
	}

	@Override
	public Fragment getItem( int index ) {
		Fragment fragment = new HomeObjectFragment();
		
		return fragment;
	}

	@Override
	public int getCount() {
		return 0;
	}

}
