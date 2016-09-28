package com.example.telebook.Tracking.Model;

import android.util.Log;

import com.example.telebook.Helper.Urls;
import com.example.telebook.Tracking.Api.TrackingApi;
import com.example.telebook.Tracking.OnTrackReceived;
import com.example.telebook.Tracking.View.TrackResponse;
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
 * Created by Iket on 9/5/2016.
 */
public class RetrofitTrackingProvider implements TrackDataProvider{


    @Override
    public void requestTrack(int userId, int reqId, final OnTrackReceived onTrackReceived) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Log.d("Response","1");
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.Base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        final TrackingApi request = retrofit.create(TrackingApi.class);
        Call<TrackResponse> call=request.getTrackData(3,1);
        Log.d("Response","2");
        call.enqueue(new Callback<TrackResponse>() {
            @Override
            public void onResponse(Call<TrackResponse> call, Response<TrackResponse> response) {
                Log.d("Response","3");
                onTrackReceived.onSuccess(response.body().getTrack());
            }

            @Override
            public void onFailure(Call<TrackResponse> call, Throwable t) {
                Log.d("Response","4");
                t.printStackTrace();


            }
        });

    }
}
