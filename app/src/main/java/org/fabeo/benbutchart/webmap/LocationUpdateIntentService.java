package org.fabeo.benbutchart.webmap;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.location.LocationServices;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class LocationUpdateIntentService extends IntentService {

    // Intent actions
    public static final String ACTION_LOCATION_UPDATE = "org.fabeo.benbutchart.webmap.action.LOCATION_UPDATE";
    private static final String LOG_TAG = "LocationUpdateIntentService" ;

    public LocationUpdateIntentService() {
        super("LocationUpdateIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();

            if (ACTION_LOCATION_UPDATE.equals(action)) {
                final Location updateLocation = (Location) intent.getExtras().get(LocationServices.FusedLocationApi.KEY_LOCATION_CHANGED);

                handleLocationUpdate(updateLocation);
            }
        }
    }

    /**
     * Handle action LOCATION_UPDATE in the provided background thread
     * We expect this to be called via a PendingIntent provided to FusedLocationProvider.requestLocationUpdates method
     */
    private void handleLocationUpdate(Location location) {
        // TODO: Write to GPX file

        Log.d(LOG_TAG, "handleLocationUpdate" + location) ;
    }


}