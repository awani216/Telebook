package com.example.telebook.Tracking.Api;

import com.example.telebook.Tracking.View.TrackResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iket on 21/9/16.
 */
public interface TrackingApi {
    @GET("url")
    Call<TrackResponse> getTrackData(@Query("UserId") int userId,@Query("ReqId") int ReqId);
}
