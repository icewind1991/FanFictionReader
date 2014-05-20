/**
 * 
 */
package com.gmail.michaelchentejada.fanfictionreader.activity;

import com.gmail.michaelchentejada.fanfictionreader.R;
import com.gmail.michaelchentejada.fanfictionreader.Settings;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

/**
 * @author Michael Chen
 *
 */
public class AboutActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.activity_about);
		Settings.setOrientation(this);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			onBackPressed();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
