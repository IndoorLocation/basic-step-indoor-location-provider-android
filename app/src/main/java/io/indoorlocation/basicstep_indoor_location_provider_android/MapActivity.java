package io.indoorlocation.basicstep_indoor_location_provider_android;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;

import io.indoorlocation.basicsteplocationprovider.BasicStepIndoorLocationProvider;
import io.indoorlocation.core.IndoorLocation;
import io.mapwize.mapwizeformapbox.MapOptions;
import io.mapwize.mapwizeformapbox.MapwizePlugin;
import io.mapwize.mapwizeformapbox.model.LatLngFloor;

public class MapActivity extends AppCompatActivity {

    private MapView mapView;
    private MapwizePlugin mapwizePlugin;
    private BasicStepIndoorLocationProvider basicStepIndoorLocationProvider;
    private static final int MY_PERMISSION_ACCESS_FINE_LOCATION = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, "pk.mapwize");
        setContentView(R.layout.activity_map);

        mapView = findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);


        MapOptions opts = new MapOptions.Builder().build();
        mapwizePlugin = new MapwizePlugin(mapView, opts);
        mapwizePlugin.setOnDidLoadListener(new MapwizePlugin.OnDidLoadListener() {
            @Override
            public void didLoad(MapwizePlugin plugin) {
                setupLocationProvider();


                basicStepIndoorLocationProvider.start();

                mapwizePlugin.setOnMapClickListener(new MapwizePlugin.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLngFloor latLngFloor) {
                        Location location = new Location(basicStepIndoorLocationProvider.getName());
                        location.setLatitude(latLngFloor.getLatitude());
                        location.setLongitude(latLngFloor.getLongitude());
                        IndoorLocation indoorLocation = new IndoorLocation(basicStepIndoorLocationProvider.getName(), latLngFloor.getLatitude(), latLngFloor.getLongitude(), latLngFloor.getFloor(), System.currentTimeMillis());
                        basicStepIndoorLocationProvider.setIndoorLocation(indoorLocation);
                    }
                });
            }
        });
    }

    private void setupLocationProvider() {
        basicStepIndoorLocationProvider = new BasicStepIndoorLocationProvider(getSystemService(SENSOR_SERVICE));



        mapwizePlugin.setLocationProvider(basicStepIndoorLocationProvider);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_ACCESS_FINE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    setupLocationProvider();
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
