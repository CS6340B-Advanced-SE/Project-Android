package com.project.choretracker.core;

import com.project.choretracker.core.views.fragments.CalendarObjectFragment;
import com.project.choretracker.core.views.fragments.HomeObjectFragment;
import com.project.choretracker.core.views.fragments.RewardsObjectFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ChoreTrackFragmentAdapter extends FragmentPagerAdapter{

	public ChoreTrackFragmentAdapter( FragmentManager fm ) {
		super( fm );
	}

	@Override
	public Fragment getItem( int index ) {
		Fragment fragment = null;
		
		if ( index == 0 ) {
			fragment = new HomeObjectFragment();
		}
		else if( index == 1 ) {
			fragment = new RewardsObjectFragment();
		}
		else if( index == 2 ) {
			fragment = new CalendarObjectFragment();
		}
		else {
			//TODO log error that no fragment exists at this index and that index is out of range.
		}
		
		return fragment;
	}

	@Override
	public int getCount() {
		return 3;
	}

}
