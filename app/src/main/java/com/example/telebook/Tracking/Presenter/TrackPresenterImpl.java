package com.example.telebook.Tracking.Presenter;

import com.example.telebook.Tracking.Model.TrackDataProvider;
import com.example.telebook.Tracking.Model.data.TrackData;
import com.example.telebook.Tracking.OnTrackReceived;
import com.example.telebook.Tracking.View.TrackViewInterface;

import java.util.List;

/**
 * Created by Iket on 9/5/2016.
 */
public class TrackPresenterImpl implements TrackPresenter {
    private TrackViewInterface trackViewInterface;
    private TrackDataProvider trackDataProvider;

    public TrackPresenterImpl(TrackViewInterface trackViewInterface, TrackDataProvider trackDataProvider) {
        this.trackViewInterface = trackViewInterface;
        this.trackDataProvider = trackDataProvider;
    }


    @Override
    public void getTracking(int userId, int reqId) {

        trackViewInterface.showLoading(true);
        trackDataProvider.requestTrack(1, 1, new OnTrackReceived() {
            @Override
            public void onSuccess(List<TrackData> trackDataList) {
                trackViewInterface.showLoading(false);
                trackViewInterface.onTrackingRecieved(trackDataList);
            }

            @Override
            public void onFailed() {
                trackViewInterface.showLoading(false);

            }
        });
    }
}
