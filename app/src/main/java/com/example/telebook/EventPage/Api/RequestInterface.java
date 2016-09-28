package com.example.telebook.EventPage.Api;

import com.example.telebook.EventPage.View.jsonResponse;
import com.example.telebook.Helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Iket on 7/27/2016.
 */
public interface RequestInterface {
    @GET("events/")
    Call<jsonResponse> getEvents();


}
