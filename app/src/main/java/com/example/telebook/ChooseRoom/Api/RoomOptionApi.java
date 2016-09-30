package com.example.telebook.ChooseRoom.Api;

import com.example.telebook.ChooseRoom.View.RoomResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iket on 25/9/16.
 */
public interface RoomOptionApi {

    @GET("roomsugg/")
    Call<RoomResponse> getRoomData(@Query("eventname") String roomname, @Query("date") String date, @Query("capacity") String capacity, @Query("stime") String stime, @Query("etime") String etime, @Query("proom") String prefroom,@Query("floor") String floor,@Query("msp") int msp);

}
