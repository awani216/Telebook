package com.example.telebook.ChooseRoom.View;

import com.example.telebook.Tracking.Model.data.TrackData;

import java.util.List;

/**
 * Created by iket on 25/9/16.
 */
public interface SelectRoomInterface {
    void showLoading(boolean visible);
    void onRoomsRecieved(List<RoomData> roomDatas);
    void showMessage();

}
