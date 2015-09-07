package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastDetailFragment extends Fragment {

    public ForecastDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forecast_detail, container, false);



        /*

        FIGURE OUT HOW TO REMOVE INNER CLASS FROM ACTIVITY

        View rootView = inflater.inflate(R.layout.fragment_forecast_detail, container, false);

        Intent detailForecastIntent = getActivity().getIntent();
        String weather = detailForecastIntent.getStringExtra(Intent.EXTRA_TEXT);

        TextView textView = (TextView) rootView.findViewById(R.id.forecast_detail_textview);
        textView.setText(weather);


        return rootView;
        */
    }
}
