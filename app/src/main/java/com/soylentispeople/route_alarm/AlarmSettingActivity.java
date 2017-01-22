package com.soylentispeople.route_alarm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by krish98sai on 1/21/2017.
 */

public class AlarmSettingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_settings);

        ((EditText)findViewById(R.id.departure_location)).setText(getIntent().getStringExtra("departure"));
        ((EditText)findViewById(R.id.arrival_location)).setText(getIntent().getStringExtra("arrival"));

        ((Button)findViewById(R.id.set_alarm)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
            }
        });
    }

    @SuppressLint("NewApi")
    public double getTravelTime(LatLng origin, String destinationAddress) {
        long seconds = (Calendar.getInstance().getTime().getTime()) / 1000;
        Calendar calendar = Calendar.getInstance();
        if (true) {
            destinationAddress = destinationAddress.replaceAll(" ", "%20");
            String url = "http://maps.googleapis.com/maps/api/direct    ions/json?origin="
                    + origin.latitude + "," + origin.longitude + "&destination=" + destinationAddress
                    + "&mode=driving&arrival_time=" + (seconds);
        }

}
