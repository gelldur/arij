package com.tadamski.arij.util.analytics;

import android.app.Activity;

import com.google.analytics.tracking.android.EasyTracker;

/**
 * Created by tmszdmsk on 13.07.13.
 */
public class Tracker {

    public static void activityStart(Activity activity) {
        EasyTracker.getInstance().activityStart(activity);
    }

    public static void activityStop(Activity activity) {
        EasyTracker.getInstance().activityStop(activity);
    }

    public static void sendEvent(String category, String action, String label, Long value) {
        EasyTracker.getTracker().sendEvent(category, action, label, value);
    }
}
