package com.soylentispeople.route_alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by krish98sai on 1/21/2017.
 */

public class AlarmReceiver extends Activity {

    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        boolean repeat = getIntent().getBooleanExtra("repeat", false);

        alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);

        if(repeat) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, /*time of start*/AlarmManager.INTERVAL_DAY, AlarmManager.INTERVAL_DAY, alarmIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, /*trigger millis*/ AlarmManager.RTC, alarmIntent);
        }
    }
}
