package com.soylentispeople.route_alarm;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.util.List;
import java.util.Locale;

/**
 * Created by sidpu on 1/21/2017.
 */
public class geocodeLocation {
    static double lat;
    static double lng;
    Context myContext;
    Locale myLocale;

    public geocodeLocation(Context c) {

        myContext = c;
    }

    public geocodeLocation(Context c, Locale loc) {

        myContext = c;
        myLocale = loc;

    }


    public void geoCodeTest() {
        try {
            Geocoder selected_place_geocoder = new Geocoder(myContext);
            List<Address> address;
            address = selected_place_geocoder.getFromLocationName("1111 S Figueroa St, Los Angeles, CA 90015", 5);

            if (address == null) {
                //do nothing

            } else {
                Address location = address.get(0);
                lat = location.getLatitude();
                lng = location.getLongitude();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
