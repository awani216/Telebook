package com.example.telebook.ChooseRoom.Model;

import android.util.Log;

import com.example.telebook.ChooseRoom.Api.RoomOptionApi;
import com.example.telebook.ChooseRoom.OnRoomsReceived;
import com.example.telebook.ChooseRoom.View.RoomResponse;
import com.example.telebook.Helper.Urls;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by iket on 25/9/16.
 */
public class RetrofitOptionsProvider implements OptionsProvider {


    @Override
    public void reqRooms(String room_name, String date, String floor, String stime, String etime, String capacity, String proom,int msp,final OnRoomsReceived onRoomsReceived) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Log.d("Response Room","Start");
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.Base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        final RoomOptionApi request = retrofit.create(RoomOptionApi.class);
        Call<RoomResponse> call=request.getRoomData(room_name,date,capacity,stime,etime,proom,floor,msp);
        call.enqueue(new Callback<RoomResponse>() {
            @Override
            public void onResponse(Call<RoomResponse> call, Response<RoomResponse> response) {
                onRoomsReceived.onSuccess(response.body().getRooms());
                Log.d("Response Room","success room");
            }

            @Override
            public void onFailure(Call<RoomResponse> call, Throwable t) {
                t.printStackTrace();
                Log.d("Response Room","failed room");
            }
        });
    }
}
