package com.example.admin.tp9;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class Traceur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast toast = Toast.makeText(this, "Appli créée", Toast.LENGTH_LONG);
        //toast.show();
        notify("onCreate");

    }
    protected void onPause() {
        super.onPause();
        //Toast toast = Toast.makeText(this, "Appli en pause", Toast.LENGTH_LONG);
        //toast.show();
        notify("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast toast = Toast.makeText(this, "Appli reprise", Toast.LENGTH_LONG);
        //toast.show();
        notify("onResume");
    }

    protected void onStop() {
        super.onStop();
        //Toast toast = Toast.makeText(this, "Appli invisible", Toast.LENGTH_LONG);
        //toast.show();
        notify("onStop");
    }
    protected void onDestroy() {
        super.onDestroy();
        //Toast toast = Toast.makeText(this, "Appli stoppée", Toast.LENGTH_LONG);
        //toast.show();
        notify("onDestroy");
    }
    protected void onRestoreInstanceState(Bundle savedInstantState) {
        super.onRestoreInstanceState(savedInstantState);
        //Toast toast = Toast.makeText(this, "Appli Restore", Toast.LENGTH_LONG);
        //toast.show();
        notify("onRestoreInstanceState");
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Toast toast = Toast.makeText(this, "Appli Save", Toast.LENGTH_LONG);
        //toast.show();
        notify("onSaveInstanceState");
    }

    private void notify(String methodName) {
        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        Notification noti = new Notification.Builder(this)
            .setContentTitle(methodName + " " + strings[strings.length - 1])
            .setAutoCancel(true)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentText(name).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify((int) System.currentTimeMillis(),noti);
    }
}