package com.zoe.notificationtest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
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
                        notification.setLatestEventInfo(this, "This is content title", "This is content text", null);
                        manager.notify(1,notification);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
