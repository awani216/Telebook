package com.example.telebook.ChooseRoom.Presenter;

import com.example.telebook.ChooseRoom.Model.OptionsProvider;
import com.example.telebook.ChooseRoom.Model.RetrofitOptionsProvider;
import com.example.telebook.ChooseRoom.OnRoomsReceived;
import com.example.telebook.ChooseRoom.View.RoomData;
import com.example.telebook.ChooseRoom.View.SelectRoom;
import com.example.telebook.ChooseRoom.View.SelectRoomInterface;

import java.util.List;

/**
 * Created by iket on 25/9/16.
 */
public class SelectionPresenterImpl implements SelectionPresenter{
    private SelectRoomInterface selectRoomInterface;
    private OptionsProvider optionsProvider;

    public SelectionPresenterImpl(SelectRoomInterface selectRoomInterface, OptionsProvider optionsProvider) {
        this.selectRoomInterface = selectRoomInterface;
        this.optionsProvider = optionsProvider;
    }


    @Override
    public void reqRooms(String room_name, String date, String floor, String stime, String etime, String capacity, String proom,int msp) {
        selectRoomInterface.showLoading(true);
        optionsProvider.reqRooms(room_name,date,floor,stime,etime,capacity,proom,msp,new OnRoomsReceived() {
            @Override
            public void onSuccess(List<RoomData> roomDatas) {
                selectRoomInterface.showLoading(false);
                selectRoomInterface.onRoomsRecieved(roomDatas);
            }

            @Override
            public void onFailed() {
                selectRoomInterface.showLoading(false);
            }
        });
    }
}
