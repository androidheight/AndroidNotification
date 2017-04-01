package musicplayer.com.androidnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    NotificationCompat.Builder mBuilder;
    NotificationManager mNotifyMgr;
    // Set the notification id to identify
    int mNotificationId = 100;

    Button btnNoti,btnCancelNoti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNoti = (Button)findViewById(R.id.btnNoti);
        btnCancelNoti =(Button)findViewById(R.id.btnCancelNoti);

        btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotification();
            }
        });
        btnCancelNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelNotification();
            }
        });
    }




    private void createNotification(){
        mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        //set title here
                        .setContentTitle("My Notification")
                        //set the text
                        .setContentText("This is my first notification.");


        // set the pendingintent to come  on that activity that you set in Intent.

        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);


        mBuilder.setContentIntent(pendingIntent);




// Gets an instance of the NotificationManager service
         mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());


    }


    private void  cancelNotification(){
        if(mNotifyMgr != null){
            mNotifyMgr.cancel(mNotificationId);
        }
    }
}
