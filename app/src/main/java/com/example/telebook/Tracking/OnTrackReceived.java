package com.example.telebook.Tracking;

import com.example.telebook.Tracking.Model.data.TrackData;

import java.util.List;

/**
 * Created by iket on 21/9/16.
 */
public interface OnTrackReceived {
    void onSuccess(List<TrackData> trackDataList);

    void onFailed();
}
