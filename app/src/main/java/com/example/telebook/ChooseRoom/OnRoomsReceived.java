package com.example.telebook.ChooseRoom;

import com.example.telebook.ChooseRoom.View.RoomData;
import com.example.telebook.Tracking.Model.data.TrackData;

import java.util.List;

/**
 * Created by iket on 29/9/16.
 */
public interface OnRoomsReceived {
    void onSuccess(List<RoomData> roomDatas);

    void onFailed();
}
