package com.example.telebook.Helper;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.telebook.Home.View.Sample;
import com.example.telebook.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;


public class MyFirebaseService extends FirebaseMessagingService {
    int i;

    private static final String TAG = "MyFirebaseMsgService";

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d("Response", "From: " + remoteMessage.getData());
        String jsonStr=remoteMessage.getData().toString();
        try {
            JSONObject jsonRootObject = new JSONObject(jsonStr);
//
            i=Integer.parseInt(remoteMessage.getData().get("intent_id"));
        }
        catch (JSONException e) {
            e.printStackTrace();
        }


        sendNotification(""+remoteMessage.getData().get("body"),""+
                remoteMessage.getData().get("title"));

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
    // [END receive_message]

    private void sendNotification(String messageBody,String title) {
        Intent intent;

           intent = new Intent(this, Sample.class);


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);

        notificationBuilder .setSmallIcon(R.drawable.nitrr_logo)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(messageBody))
                .setAutoCancel(true);
        notificationBuilder.setDefaults(Notification.DEFAULT_LIGHTS|Notification.DEFAULT_VIBRATE|Notification.DEFAULT_SOUND);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 , notificationBuilder.build());




    }
}