package com.lizhenyao.maptest.helper;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by zhenyao on 2016/3/31.
 */
public abstract class AbsLocationListener implements LocationListener {

    @Override
    public void onLocationChanged(Location location) {
        handleLocation(location);
    }

    public abstract void handleLocation(Location location);


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
