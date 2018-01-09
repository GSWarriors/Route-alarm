package com.soylentispeople.route_alarm;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import static android.R.attr.duration;


/**
 * Created by sidpu on 1/21/2017.
 */

public class calcTraffic {

    int departTime;

    public void parseJSON(String json) {
        try {
            JSONObject obj;
            obj = new JSONObject(json);
            Log.d("demo", "obj \t" + obj.toString());

            JSONArray array = obj.getJSONArray("destination_addresses");
            departTime  = obj.getJSONArray("rows").getJSONObject(0).getJSON("elements").getJSONObject(0).getJSONObject("departure_time");
        }
    }




}
