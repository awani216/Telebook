package com.example.telebook.LogIn.Model;

import android.util.Log;

import com.example.telebook.Helper.Urls;
import com.example.telebook.LogIn.Api.LogIn_Info;
import com.example.telebook.LogIn.OnLoginSent;
import com.example.telebook.LogIn.View.SendLoginData;
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
 * Created by iket on 20/9/16.
 */
public class RetrofitLogInProvider implements LoginProvider {
    @Override
    public void login_send(String username, String password, final OnLoginSent onLoginSent) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Log.d("Response","1");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.Base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        Log.d("Response","2");
        final LogIn_Info request=retrofit.create(LogIn_Info.class);
        Call<SendLoginData> call = request.getSuccess(username,password);
        Log.d("Response","3");
        call.enqueue(new Callback<SendLoginData>() {
            @Override
            public void onResponse(Call<SendLoginData> call, Response<SendLoginData> response) {
                Log.d("Response","4");
                onLoginSent.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SendLoginData> call, Throwable t) {
                Log.d("Response","5");
                t.printStackTrace();
            }
        });

    }
}
