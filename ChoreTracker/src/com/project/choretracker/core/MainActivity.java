package com.project.choretracker.core;

import com.project.choretracker.R;
import com.project.choretracker.authentication.AuthenticationActivity;

import android.app.ActionBar.TabListener;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

	ChoreTrackFragmentAdapter 				pagerAdapter;
	ViewPager 								viewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate( savedInstanceState );
		setContentView( R.layout.fragment_main  );
		
		initSharedPreferences();
		ActionBar actionBar = this.getActionBar();
		actionBar.setNavigationMode( ActionBar.NAVIGATION_MODE_TABS );
		ColorDrawable color = new ColorDrawable();
		color.setColor( Color.DKGRAY );
//		actionBar.setBackgroundDrawable( color );
//		actionBar.getThemedContext().setTheme(  )
		
		pagerAdapter = new ChoreTrackFragmentAdapter( getSupportFragmentManager() );
		
		viewPager = (ViewPager) findViewById( R.id.pager );
		viewPager.setAdapter( pagerAdapter );
		initActionBarTabs();
		initTabUpdateOnSwipe();
		
		boolean loggedOn = SharedPreferenceHelper.getLoggedOnStatus( getApplicationContext() );
		
		if( !loggedOn ) {
			Intent intent = new Intent( this, AuthenticationActivity.class );
			intent.putExtra( "loggedOn",  false );
			startActivity( intent );
		}
	}

	private void initSharedPreferences() {

		SharedPreferences pref = this.getApplicationContext().getSharedPreferences( "choreTrackerPref", MODE_PRIVATE );
		boolean prefExists = pref.contains( "loggedOn" );

		if( !prefExists ) {
			SharedPreferences.Editor editor = pref.edit();
			editor.putBoolean( "logged", false );
			editor.commit();
			Log.i( "SharePreferences", "in initSharedPrefernces() create preference" );
		}
		Log.i( "SharePreferences", "in initSharedPrefernces()" );
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onPrepareOptionsMenu( Menu menu ) {
	
		boolean loggedOn = SharedPreferenceHelper.getLoggedOnStatus( getApplicationContext() );
		if( loggedOn ) {
			menu.getItem( 1 ).setVisible( true );
		}
		else if( !loggedOn ){
			menu.getItem( 1 ).setVisible( false );
		}
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected( MenuItem item ) {
		
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		if ( id == R.id.action_settings ) {
			return true;
		}
		if( id == R.id.logoff ) {
			SharedPreferenceHelper.setPreferenceToLogoff( getApplicationContext() );
			Intent intent = new Intent( this, AuthenticationActivity.class );
			startActivity( intent );
			
		}
		
		return super.onOptionsItemSelected( item );
	}
	
	public void initActionBarTabs() {
		
		ActionBar actionBar = getActionBar();
		
		actionBar.addTab( initHomeTab(), 0, true );
		actionBar.addTab( initRewardsTab(), 1, false );
		actionBar.addTab( initCalendarTab(), 2, false );
	}
	
	public void initTabUpdateOnSwipe() {
		
		/**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener( new ViewPager.OnPageChangeListener() {
 
            @Override
            public void onPageSelected( int position ) {
                // on changing the page
                // make respected tab selected
                getActionBar().setSelectedNavigationItem( position );
            }
 
            @Override
            public void onPageScrolled( int arg0, float arg1, int arg2 ) {
            }
 
            @Override
            public void onPageScrollStateChanged( int arg0 ) {
            }
        });
	}
	
	public Tab initHomeTab() {
		
		final ActionBar actionBar = getActionBar();
		
		Tab tab = actionBar.newTab().setText( "Home" ).setTabListener( new TabListener() {

			@Override
			public void onTabReselected( Tab tab, FragmentTransaction ft ) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				int index = tab.getPosition();
				viewPager.setCurrentItem( index );
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			} 
		});
		
		return tab;
	}
	
	public Tab initCalendarTab() {
		
		final ActionBar actionBar = getActionBar();
		
		Tab tab = actionBar.newTab().setText( "Calendar" ).setTabListener( new TabListener() {

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				int index = tab.getPosition();
				viewPager.setCurrentItem( index );
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			} 
		});
		
		return tab;
	}
	
	public Tab initRewardsTab() {
		
		final ActionBar actionBar = getActionBar();
		
		Tab tab = actionBar.newTab().setText( "Rewards" ).setTabListener( new TabListener() {

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				int index = tab.getPosition();
				viewPager.setCurrentItem( index );
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			} 
		});
		
		return tab;
	}
}
