package com.example.telebook.ChooseRoom.View;

import java.util.List;

/**
 * Created by iket on 29/9/16.
 */
public class RoomResponse {
    public List<RoomData> rooms;

    public RoomResponse(List<RoomData> rooms) {
        this.rooms = rooms;
    }

    public List<RoomData> getRooms() {
        return rooms;
    }
}
