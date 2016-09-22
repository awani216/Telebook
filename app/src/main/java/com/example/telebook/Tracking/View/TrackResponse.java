package com.example.telebook.Tracking.View;

import com.example.telebook.Tracking.Model.data.TrackData;

import java.util.List;

/**
 * Created by iket on 21/9/16.
 */
public class TrackResponse {

private List<TrackData> trackDatas;

    public TrackResponse(List<TrackData> trackDatas) {
        this.trackDatas = trackDatas;
    }

    public List<TrackData> getTrackDatas() {
        return trackDatas;
    }
}
