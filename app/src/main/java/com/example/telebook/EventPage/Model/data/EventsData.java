package com.example.telebook.EventPage.Model.data;

/**
 * Created by Iket on 7/27/2016.
 */
public class EventsData {

    private String name,description,date,stime,etime,venue,image;


    public EventsData(String name, String description, String date, String stime, String etime, String venue, String image) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.stime = stime;
        this.etime = etime;
        this.venue = venue;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getStime() {
        return stime;
    }

    public String getEtime() {
        return etime;
    }

    public String getVenue() {
        return venue;
    }

    public String getImage() {
        return image;
    }
}
