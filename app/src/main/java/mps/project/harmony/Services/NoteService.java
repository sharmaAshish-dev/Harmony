package mps.project.harmony.Services;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.core.app.NotificationCompat;

import mps.project.harmony.R;

public class NoteService extends BroadcastReceiver {
    int MID = 0;

    @Override
    public void onReceive(Context p_context, Intent p_intent) {
        NotificationManager notificationManager = (NotificationManager) p_context.getSystemService(Context.NOTIFICATION_SERVICE);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(p_context);

        mNotifyBuilder.setSmallIcon(R.drawable.ic_logo)
                .setContentTitle("Drink Water Title")
                .setContentText("Drink Water!!")
                .setSound(alarmSound)
                //.setAutoCancel(true).setWhen(when)
                //.setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});

        notificationManager.notify(MID, mNotifyBuilder.build());
        MID++;
    }
}