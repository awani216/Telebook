package com.example.telebook.Tracking.Api;

import com.example.telebook.ChooseRoom.View.RoomResponse;
import com.example.telebook.Tracking.View.TrackResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iket on 21/9/16.
 */
public interface TrackingApi {
    @GET("track/")
    Call<TrackResponse> getTrackData(@Query("userid") int userid, @Query("reqid") int reqid);
}
