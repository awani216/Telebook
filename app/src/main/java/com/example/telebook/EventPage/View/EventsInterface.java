package com.example.telebook.EventPage.View;

import com.example.telebook.EventPage.Model.data.EventsData;

import java.util.List;

public interface EventsInterface {
    void ShowProgressBar(boolean show);
    void SetData(List<EventsData> eventDataList);
}
