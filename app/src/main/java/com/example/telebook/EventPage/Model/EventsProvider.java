package com.example.telebook.EventPage.Model;


import com.example.telebook.EventPage.View.OnEventsReceived;

/**
 * Created by Iket on 7/27/2016.
 */
public interface EventsProvider {
    void requestEvents(OnEventsReceived onEventsReceived);
}
