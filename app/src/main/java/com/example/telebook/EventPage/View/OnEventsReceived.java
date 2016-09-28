package com.example.telebook.EventPage.View;

import com.example.telebook.EventPage.Model.data.EventsData;

import java.util.List;

/**
 * Created by Iket on 7/27/2016.
 */
public interface OnEventsReceived {
    void onFailure();
    void onSuccess(List<EventsData> eventDataList);
}
