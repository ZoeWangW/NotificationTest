package com.zoe.notificationtest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case  R.id.send_notice:
                        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Notification notification = new Notification(R.mipmap.ic_launcher,"This is ticker text",System.currentTimeMillis());
                        Intent intent = new Intent(this,NotificationActivity.class);
                        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                        notification.setLastestEventInfo(this,"this is content title","this is content text",pi);
                        manager.notify(1,notification);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
