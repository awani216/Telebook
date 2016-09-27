package com.example.telebook.EventPage.Model.data;

/**
 * Created by Awani on 9/27/2016.
 */
public class EventData {
    private String event_name;
    private String event_detail;
    private int photo_id;

    public EventData(String event_name, String event_detail, int photo_id)
    {
        this.event_name=event_name;
        this.event_detail=event_detail;
        this.photo_id=photo_id;
    }
    public String getEvent_name(){ return event_name; }

    public String getEvent_detail(){ return event_detail; }

    public int getPhoto_id(){ return photo_id; }
}
