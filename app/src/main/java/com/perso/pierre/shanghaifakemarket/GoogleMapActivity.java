package com.perso.pierre.shanghaifakemarket;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Double mXuser;
    private Double mYuser;
    private LocationManager lm;
    private final static int MY_PERMISSIONS_REQUEST_LOCATION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);


        //_______________________ASKING LOCATION PERMISSION________________________
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

                // MY_PERMISSIONS_ACCESS LOCATION is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }


        }

        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (location != null) {
            mXuser = location.getLatitude();
            mYuser = location.getLongitude();
        }


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        if (mXuser != null && mYuser != null) {
            mMap.setMyLocationEnabled(true);
            LatLng myLatLng = new LatLng(mXuser, mYuser);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLatLng,13));
        }else{
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(31.234126, 121.474865),13));
        }


        LatLng fake1 = new LatLng(31.230954, 121.466062);
        mMap.addMarker(new MarkerOptions()
                        .position(fake1)
                        .title("Han City")
                        .snippet(getResources().getString(R.string.emplacement_fake1))
        );


        LatLng fake2 = new LatLng(31.218261, 121.541692);
        mMap.addMarker(new MarkerOptions()
                        .position(fake2)
                        .title("AP Plaza")
                        .snippet(getResources().getString(R.string.emplacement_fake2))

        );



        LatLng fake3 = new LatLng(31.211689, 121.499712);
        mMap.addMarker(new MarkerOptions()
                        .position(fake3)
                        .title("Fabric Market")
                        .snippet(getResources().getString(R.string.emplacement_fake3))
        );


        LatLng fake4 = new LatLng(31.245810, 121.482006);
        mMap.addMarker(new MarkerOptions()
                        .position(fake4)
                        .title("Qipu Lu Clothing")
                        .snippet(getResources().getString(R.string.emplacement_fake4))
        );


        LatLng fake5 = new LatLng(31.226924, 121.491379);
        mMap.addMarker(new MarkerOptions()
                        .position(fake5)
                        .title("Yu Garden")
                        .snippet(getResources().getString(R.string.emplacement_fake5))
        );


    }
}
