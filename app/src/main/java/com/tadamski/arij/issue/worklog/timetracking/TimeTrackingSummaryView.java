package com.tadamski.arij.issue.worklog.timetracking;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.FragmentById;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;
import com.tadamski.arij.R;
import com.tadamski.arij.issue.resource.model.TimeTracking;

/**
 * Created by t.adamski on 7/11/13.
 */
@EViewGroup(R.layout.time_tracking_summary_view)
public class TimeTrackingSummaryView extends RelativeLayout {
    private TimeTracking timeTracking;

    @ViewById(R.id.progress)
    ProgressBar progressBar;
    @ViewById(R.id.time_logged)
    TextView timeLogged;
    @ViewById(R.id.time_remaining)
    TextView timeRemaining;

    public TimeTrackingSummaryView(Context context) {
        super(context);
    }

    public TimeTrackingSummaryView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TimeTrackingSummaryView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void updateView(TimeTracking timeTracking) {
        progressBar.setMax(timeTracking.getRemainingEstimateSeconds() + timeTracking.getTimeSpentSeconds());
        progressBar.setProgress(timeTracking.getTimeSpentSeconds());
        timeLogged.setText(timeTracking.getTimeSpent());
        timeRemaining.setText(timeTracking.getRemainingEstimate());
    }

    public TimeTracking getTimeTracking() {
        return timeTracking;
    }

    public void setTimeTracking(TimeTracking timeTracking) {
        this.timeTracking = timeTracking;
        updateView(this.timeTracking);
    }
}
