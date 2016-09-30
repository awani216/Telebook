package com.example.telebook.History.Api;

import com.example.telebook.Tracking.View.TrackResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iket on 25/9/16.
 */
public interface HistoryApi {
    @GET("history/")
    Call<TrackResponse> getHistoryData(@Query("userid") int userid);
}
