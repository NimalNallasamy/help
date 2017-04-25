package com.example.nimal.help;

import android.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Location extends AppCompatActivity {


    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = android.Manifest.permission.ACCESS_FINE_LOCATION;
    GPSTracker gps;
    TextView txt;
    EditText edt;
    StringBuffer str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public void show_location(View view)
    {
        gps = new GPSTracker(Location.this);
        txt = (TextView) findViewById(R.id.LocationShow);
        double latitude;
        double longitude;

        // check if GPS enabled
        if (gps.canGetLocation()) {

            latitude = gps.getLatitude();
            longitude = gps.getLongitude();

            String x = "Latitude : " + latitude+ "\nLongitude : " + longitude;
            txt.setText(x);

        }
        else
        {
            gps.showSettingsAlert();
        }
    }
}
