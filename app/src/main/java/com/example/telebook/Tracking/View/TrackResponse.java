package com.example.telebook.Tracking.View;

import com.example.telebook.Tracking.Model.data.TrackData;

import java.util.List;

/**
 * Created by iket on 21/9/16.
 */
public class TrackResponse {

private List<TrackData> track;

    public TrackResponse(List<TrackData> track) {
        this.track = track;
    }

    public List<TrackData> getTrack() {
        return track;
    }
}
