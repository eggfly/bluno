
package com.example.blunobasicdemo;

import android.app.AlertDialog;
import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.Toast;

/**
 * @author eggfly
 */
public class NotificationCollectorService extends NotificationListenerService {
    private static final String TAG = "NotificationCollectorService";

    @Override
    public void onNotificationPosted(StatusBarNotification notification) {
        Log.d(TAG, "onNotificationPosted");
        Bundle extras = notification.getNotification().extras;
        Bitmap bitmap = (Bitmap) extras.getParcelable(Notification.EXTRA_LARGE_ICON);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        BitmapDrawable drawable = new BitmapDrawable(getResources(), bitmap);
        builder.setIcon(drawable);
        builder.setTitle("sss");
        builder.show();
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification notification) {
        Log.d(TAG, "onNotificationRemoved");
        Bundle extras = notification.getNotification().extras;
        Toast.makeText(this, extras.toString(), Toast.LENGTH_LONG).show();
    }
}
