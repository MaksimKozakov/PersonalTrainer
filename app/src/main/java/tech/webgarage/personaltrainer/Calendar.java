package tech.webgarage.personaltrainer;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;


public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
    }



    public void onClick(View view) {

       Intent intent = new Intent(this, Calendar.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification;

        switch (view.getId()) {
            case R.id.button2:
                notification = new NotificationCompat.Builder(this)
                        .setAutoCancel(true).setSmallIcon(R.mipmap.ic_launcher)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setTicker("Не забудь!")
                        .setContentTitle("Тренировка!")
                        .setContentText("Сегодня в")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent).build();
                nm.notify(1, notification);
                break;
        }
    }
}
