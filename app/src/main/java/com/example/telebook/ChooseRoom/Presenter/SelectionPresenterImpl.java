package com.example.telebook.ChooseRoom.Presenter;

import com.example.telebook.ChooseRoom.Model.OptionsProvider;
import com.example.telebook.ChooseRoom.Model.RetrofitOptionsProvider;
import com.example.telebook.ChooseRoom.View.SelectRoom;
import com.example.telebook.ChooseRoom.View.SelectRoomInterface;

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
    public void reqRooms() {

    }
}
