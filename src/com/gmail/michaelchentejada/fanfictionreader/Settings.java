package com.gmail.michaelchentejada.fanfictionreader;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;


public class Settings extends PreferenceActivity implements OnPreferenceChangeListener{
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Settings.setOrientation(this);
		addPreferencesFromResource(R.xml.preferences);
		
		Preference orientationPref = findPreference(getString(R.string.pref_orientation));
		orientationPref.setOnPreferenceChangeListener(this);
		
	}
	
	public static int fontSize(Context context){
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
		String textSize = sharedPref.getString(context.getResources().getString(R.string.pref_text_size), "");
		if (textSize.equals("S")) {
			return 14;
		}else if (textSize.equals("M")) {
			return 18;
		} else {
			return 22;
		}
	}
	
	public static void setOrientation(Activity activity){
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(activity);
		String textSize = sharedPref.getString(activity.getResources().getString(R.string.pref_orientation), "A");
		if (textSize.equals("A")) {
			activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
		}else if (textSize.equals("H")) {
			activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		} else {
			activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		}
	}

	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {
		Settings.setOrientation(this);
		return false;
	}

}

