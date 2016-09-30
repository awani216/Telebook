package com.example.telebook.EventPage.Presenter;

import android.util.Log;

import com.example.telebook.EventPage.Model.EventsProvider;
import com.example.telebook.EventPage.Model.data.EventsData;
import com.example.telebook.EventPage.View.EventsInterface;
import com.example.telebook.EventPage.View.OnEventsReceived;

import java.util.List;


/**
 * Created by Iket on 7/27/2016.
 */
public class EventPresenterImpl implements EventsPresenter {
    private EventsProvider eventsProvider;
    private EventsInterface eventsInterface;


    public EventPresenterImpl(EventsInterface eventsInterface, EventsProvider eventsProvider) {
        this.eventsInterface=eventsInterface;
        this.eventsProvider=eventsProvider;

    }

    @Override
    public void requestEvents() {


        eventsInterface.ShowProgressBar(true);
        eventsProvider.requestEvents(new OnEventsReceived() {
            @Override
            public void onSuccess(List<EventsData> eventDataList) {

                eventsInterface.SetData(eventDataList);
                eventsInterface.ShowProgressBar(false);
                Log.d("ResponseOtp","Success");
            }

            @Override
            public void onFailure() {
                eventsInterface.ShowProgressBar(false);
                Log.d("ResponseOtp","Fail");
            }
        });
    }
}
