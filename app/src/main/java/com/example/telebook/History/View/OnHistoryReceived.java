package com.example.telebook.History.View;

import com.example.telebook.Tracking.Model.data.TrackData;

import java.util.List;

/**
 * Created by iket on 25/9/16.
 */
public interface OnHistoryReceived {
    void onSuccess(List<HistoryData> historyDatas);

    void onFailed();
}
