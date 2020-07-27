package com.suek.nyamnyam;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class NyamNyamFCMReceiveService extends FirebaseMessagingService {

    //push server 에서 보낸 메세지가 수신되었을 때 자동으로 발동하는 메소드

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.i("msg","message recieved!");

        String fromWho= remoteMessage.getFrom();

        String notiTitle= "title";
        String notiBody= "body text";

        if(remoteMessage.getNotification() != null){
            notiTitle= remoteMessage.getNotification().getTitle();
            notiBody= remoteMessage.getNotification().getBody();
        }

        Map<String, String> data= remoteMessage.getData();

        String name= null;
        String msg= null;
        if(data != null){
            name= data.get("name");
            msg= data.get("msg");
        }

        //Log.i("tag", fromWho + ":" + notiTitle + "," + notiBody + ">>" + name + ", " + msg);

        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder= null;
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel("ch01", "channel 01", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            builder= new NotificationCompat.Builder(this, "ch01");
        }else {
            builder= new NotificationCompat.Builder(this, null);
        }

        builder.setSmallIcon(R.drawable.ic_restaurant_white_24dp);
        builder.setContentTitle(notiTitle);
        builder.setContentText(notiBody);

        Intent intent= new Intent(this, MainActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("msg",msg);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent= PendingIntent.getActivity(this, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        Notification notification= builder.build();
        notificationManager.notify(111, notification);


    }


}
