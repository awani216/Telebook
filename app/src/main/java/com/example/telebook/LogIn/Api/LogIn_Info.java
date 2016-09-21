package com.example.telebook.LogIn.Api;

import com.example.telebook.LogIn.View.SendLoginData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by iket on 20/9/16.
 */
public interface LogIn_Info {
    @FormUrlEncoded
    @POST("test/")
    Call<SendLoginData> getSuccess (@Field("username") String username, @Field("password") String password);
}
