package com.androidbatch.maplocation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

public class MapsActivity extends FragmentActivity {

    boolean isPermissionGranted = false;//booelan pwemission
    private GoogleMap mMap; //goolemap class object declaration
    private FusedLocationProviderClient fusedLocationClient;//predefined class object creation
    LatLng latLng;
    SupportMapFragment mapFragment;//declaring map fragment
    //int requestcode = 1;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        if (checkMyPermision() == true) {
            mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            checkMyPermision();
//            mapFragment.getMapAsync(this);
        } else {
            checkMyPermision();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean checkMyPermision() {
        if (getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            isPermissionGranted = true;

            //if permission is granted
            fusedLocationClient.getLastLocation()//predefined method
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                // Logic to handle location object
                                mapFragment.getMapAsync(new OnMapReadyCallback() {
                                    @Override
                                    public void onMapReady(GoogleMap googleMap) {
                                        latLng = new LatLng(location.getLatitude(), location.getLongitude());
                                        // mMap.setMyLocationEnabled(true);
                                        MarkerOptions options = new MarkerOptions().position(latLng).title("I am here");
                                        //zoom map
                                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                                        //add a marker to map
                                        googleMap.addMarker(options);
                                    }
                                });
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MapsActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            return true;
        } else {
            Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
            //requesting permission
            String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};
            requestPermissions(permissions, 1);//predifinned method request permission

            //isPermissionGranted = true;
            return false;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //when permission granted
                //call method
                checkMyPermision();
            }
            checkMyPermision();
        }
    }
}