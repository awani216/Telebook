package com.example.telebook.ChooseRoom.View;

/**
 * Created by iket on 25/9/16.
 */
public class RoomData {
    private String name,date2,date1,date,date_2,date_1;
    int capacity,mike,stage,proj;

    public RoomData(String name, String date2, String date1, String date, String date_2, String date_1, int capacity, int mike, int stage, int proj) {
        this.name = name;
        this.date2 = date2;
        this.date1 = date1;
        this.date = date;
        this.date_2 = date_2;
        this.date_1 = date_1;
        this.capacity = capacity;
        this.mike = mike;
        this.stage = stage;
        this.proj = proj;
    }

    public String getName() {
        return name;
    }

    public String getDate2() {
        return date2;
    }

    public String getDate1() {
        return date1;
    }

    public String getDate() {
        return date;
    }

    public String getDate_2() {
        return date_2;
    }

    public String getDate_1() {
        return date_1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMike() {
        return mike;
    }

    public int getStage() {
        return stage;
    }

    public int getProj() {
        return proj;
    }
}
