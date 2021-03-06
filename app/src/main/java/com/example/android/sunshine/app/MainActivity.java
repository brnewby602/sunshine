package com.example.android.sunshine.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();
    private String m_location;
    private final String FORECASTFRAGMENT_TAG = "FFTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        m_location = Utility.getPreferredLocation(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment(), FORECASTFRAGMENT_TAG)
                    .commit();
        }

        Log.d(LOG_TAG, "onCreate lifecycle method called.");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(LOG_TAG, "onDestroy lifecycle method called.");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(LOG_TAG, "onPause lifecycle method called.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume lifecycle method called.");

        String location = Utility.getPreferredLocation(this);

        if( location != null && !location.equals(m_location) ) {
            ForecastFragment ff = (ForecastFragment)getSupportFragmentManager().findFragmentByTag(FORECASTFRAGMENT_TAG);
            if(null != ff) {
                ff.onLocationChanged();
            }

            m_location = location;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(LOG_TAG, "onStop lifecycle method called.");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(LOG_TAG, "onStart lifecycle method called.");
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
        // as you specify a parent activity in AndroidManifest.pref_general.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        else if(id == R.id.action_map) {
            String location = Utility.getPreferredLocation(this);
            //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            //String postalCode = prefs.getString(getString(R.string.pref_location_key), getString(R.string.pref_location_default));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW);
            mapIntent.setData( Uri.parse("geo:0,0?").buildUpon().appendQueryParameter("q", location).build());

            if(mapIntent.resolveActivity(this.getPackageManager()) != null) {
                startActivity(mapIntent);
            }
        }

        return super.onOptionsItemSelected(item);
    }

}



