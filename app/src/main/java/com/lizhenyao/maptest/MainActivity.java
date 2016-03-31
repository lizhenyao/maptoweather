package com.lizhenyao.maptest;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.lizhenyao.maptest.helper.AbsLocationListener;
import com.lizhenyao.maptest.helper.LocationHelper;

import java.util.List;

public class MainActivity extends Activity {

    private TextView text;

    private LocationHelper locationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();

        initViews();

        initDates();

        initListener();

    }

    private void initListener() {

        locationHelper.setLocationListener(new AbsLocationListener() {
            @Override
            public void handleLocation(Location location) {
                showLocation(location);
            }
        });
    }

    private void initDates() {

        Location location = locationHelper.getLocation();

        showLocation(location);

    }

    private void showLocation(Location location) {
        String currentPosition = "经度：" + location.getLongitude() + ",纬度：" + location.getLatitude();
        text.setText(currentPosition);
    }

    private void initVariables() {
        locationHelper = new LocationHelper(this);
    }

    private void initViews() {

        text = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationHelper.removeLocationListener();
    }



}
