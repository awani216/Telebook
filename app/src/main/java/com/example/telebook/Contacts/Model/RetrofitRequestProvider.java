package com.example.telebook.Contacts.Model;

import android.util.Log;

import com.example.telebook.Contacts.api.RequestInterface;
import com.example.telebook.Contacts.view.JsonResponse;
import com.example.telebook.Contacts.view.OnContactsReceived;
import com.example.telebook.Helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Iket on 8/20/2016.
 */
public class RetrofitRequestProvider implements ContactsProvider {


    @Override
    public void requestContacts(final OnContactsReceived onContactsReceived) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        final RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JsonResponse> call = request.getContacts();
        Log.d("Response","1");

        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                Log.d("Response","2");
                onContactsReceived.onSuccess(response.body().getContacts());
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                t.printStackTrace();
                onContactsReceived.onFailure();
                Log.d("Response","3");
            }
        });

    }


}
