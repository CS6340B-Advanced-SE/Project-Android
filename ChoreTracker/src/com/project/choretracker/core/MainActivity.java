package com.project.choretracker.core;

import com.project.choretracker.R;

import android.app.ActionBar.TabListener;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

	ChoreTrackFragmentAdapter pagerAdapter;
	ViewPager viewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.fragment_main  );
		
		ActionBar actionBar = this.getActionBar();
		actionBar.setNavigationMode( ActionBar.NAVIGATION_MODE_TABS );
		initActionBarTabs();

		pagerAdapter = new ChoreTrackFragmentAdapter( getSupportFragmentManager() );
		
		viewPager = (ViewPager) findViewById( R.id.pager );

		viewPager.setAdapter( pagerAdapter );
		
		/**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                getActionBar().setSelectedNavigationItem( position );
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
 
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void initActionBarTabs() {
		ActionBar actionBar = getActionBar();
		
		actionBar.addTab( initHomeTab(), 0, true );
//		actionBar.addTab( initCalendarTab(), 1, false );
		actionBar.addTab( initRewardsTab(), 1, false );
	}
	
	public Tab initHomeTab() {
		ActionBar actionBar = getActionBar();
		
		Tab tab = actionBar.newTab().setText( "Home" ).setTabListener( new TabListener() {

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			} 
		});
		
		return tab;
	}
	
	public Tab initCalendarTab() {
		ActionBar actionBar = getActionBar();
		
		Tab tab = actionBar.newTab().setText( "Calendar" ).setTabListener( new TabListener() {

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			} 
		});
		
		return tab;
	}
	
	public Tab initRewardsTab() {
		ActionBar actionBar = getActionBar();
		
		Tab tab = actionBar.newTab().setText( "Rewards" ).setTabListener( new TabListener() {

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			} 
		});
		
		return tab;
	}
}
