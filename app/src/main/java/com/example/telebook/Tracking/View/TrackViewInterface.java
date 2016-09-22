package com.example.telebook.Tracking.View;

import com.example.telebook.Tracking.Model.data.TrackData;

import java.util.List;

/**
 * Created by Iket on 9/5/2016.
 */
public interface TrackViewInterface {
    void showLoading(boolean visible);
    void onTrackingRecieved(List <TrackData> trackDatas);
    void showMessage();


}
