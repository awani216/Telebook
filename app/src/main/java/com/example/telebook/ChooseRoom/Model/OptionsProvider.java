package com.example.telebook.ChooseRoom.Model;

import com.example.telebook.ChooseRoom.OnRoomsReceived;

/**
 * Created by iket on 25/9/16.
 */
public interface OptionsProvider {
    void reqRooms(String room_name, String date, String floor, String stime, String etime, String capacity, String proom,int msp, OnRoomsReceived onRoomsReceived);
}
