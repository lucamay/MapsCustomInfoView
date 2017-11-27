package com.example.lupe.mapscustominfoview;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap = googleMap;
        mMap.getUiSettings().setZoomGesturesEnabled(true);

        LatLng uno = new LatLng(-18, -69);
        mMap.addMarker(new MarkerOptions().position(uno)
                .title("Proyecto:"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(uno));


        // Setting a custom info window adapter for the google map
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            // Use default InfoWindow frame
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }


            // Defines the contents of the InfoWindow
            @Override
            public View getInfoContents(Marker arg0) {
                View v = null;
                try {

                    // Getting view from the layout file info_window_layout
                    v = getLayoutInflater().inflate(R.layout.custom_info_contents, null);

                    // Getting reference to the TextView to set latitude
                    TextView addressTxt = (TextView) v.findViewById(R.id.textTitle);
                    addressTxt.setText(arg0.getTitle());

                } catch (Exception ev) {
                    System.out.print(ev.getMessage());
                }

                return v;
            }
        });
    }

}
