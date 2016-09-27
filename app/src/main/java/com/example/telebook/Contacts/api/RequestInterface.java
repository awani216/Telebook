package com.example.telebook.Contacts.api;

import com.example.telebook.Contacts.view.JsonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by iket on 27/9/16.
 */
public interface RequestInterface {
    @GET("contacts/")
    Call<JsonResponse> getContacts();
}

