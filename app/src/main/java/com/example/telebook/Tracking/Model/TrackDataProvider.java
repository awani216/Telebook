package com.example.telebook.Tracking.Model;

import com.example.telebook.Tracking.OnTrackReceived;

/**
 * Created by iket on 21/9/16.
 */
public interface TrackDataProvider {
    void requestTrack(int userId, int reqId, OnTrackReceived onTrackReceived);
}
