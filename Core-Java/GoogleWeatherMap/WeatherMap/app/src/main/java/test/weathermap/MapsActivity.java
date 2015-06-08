package test.weathermap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Entity;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        final String cityInfoURL = "https://intense-dawn-6176.herokuapp.com/";

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpGet get = new HttpGet();
                    get.setURI(new URI(cityInfoURL));
                    HttpResponse response = client.execute(get);

                    String content = EntityUtils.toString(response.getEntity());

                    JSONArray cities = new JSONArray(content);

                    for (int i = 0; i < cities.length(); i++) {
                        JSONObject currentCity = cities.getJSONObject(i);
                        final String cityName = currentCity.getString("city");
                        final Double temp = currentCity.getDouble("temp");
                        final Double lon = new JSONObject(
                                currentCity.get("coords").toString()).getDouble("lon");
                        final Double lat = new JSONObject(
                                currentCity.get("coords").toString()).getDouble("lat");

                        Log.i("as", String.format("%s,%s,%s,%s", cityName, temp, lat, lon));

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mMap.addMarker(
                                        new MarkerOptions()
                                                .position(new LatLng(lat, lon))
                                                .title(cityName + " - " + temp));
                            }
                        });
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}