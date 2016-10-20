package com.jikexueyuan.actionbarusing;

import android.os.Bundle;
import android.R.integer;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ShareActionProvider mShareActionProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		MenuItem shareItem = menu.findItem(R.id.action_share);
		mShareActionProvider = (ShareActionProvider) shareItem.getActionProvider();
		mShareActionProvider.setShareIntent(getDefaultIntent());
		return true;
	}
	
	private Intent getDefaultIntent(){
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/*");
		return intent;
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
		case android.R.id.home:
			finish();
			break;
		case R.id.action_search:
			Toast.makeText(this, "Action_Search", 0).show();
			break;
		case R.id.action_setting:
			Toast.makeText(this, "Action_Setting", 0).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}




/* ΪActionBar����TAB����
 * ActionBar actionBar = getActionBar(); //for <3.0   getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {
			
			@Override
			public void  (Tab tab, FragmentTransaction ft) {
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				Toast.makeText(MainActivity.this, "TabSelected" + tab.getPosition(), 0).show();
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
		};
		
		for (int i=0;i<3;i++){
			Tab tab = actionBar.newTab();
			tab.setText("Tab" + i);
			tab.setTabListener(tabListener);
			actionBar.addTab(tab);
		}
		*/
