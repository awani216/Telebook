package com.example.telebook.Tracking.Model;

import com.example.telebook.Tracking.Api.TrackingApi;
import com.example.telebook.Tracking.OnTrackReceived;
import com.example.telebook.Tracking.View.TrackResponse;

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

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://198.168............")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        final TrackingApi request = retrofit.create(TrackingApi.class);
        Call<TrackResponse> call=request.getTrackData(1,1);
        call.enqueue(new Callback<TrackResponse>() {
            @Override
            public void onResponse(Call<TrackResponse> call, Response<TrackResponse> response) {
                onTrackReceived.onSuccess(response.body().getTrackDatas());
            }

            @Override
            public void onFailure(Call<TrackResponse> call, Throwable t) {

            }
        });

    }
}
