package tech.webgarage.personaltrainer;


import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;


public class Calendar extends AppCompatActivity {

    Button btnOk, btnCancelTime;
    AlarmManager alarmManager;
    TimePicker timePicker;
    TextView tvMess;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancelTime = (Button) findViewById(R.id.btnCancelTime);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        tvMess = (TextView) findViewById(R.id.tvMess);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        final java.util.Calendar calendar = java.util.Calendar.getInstance();

        //Intent
        Intent alarmIntent = new Intent(Calendar.this, Alarm.class);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnOk:
                        calendar.set(java.util.Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                        calendar.set(java.util.Calendar.HOUR_OF_DAY, timePicker.getCurrentMinute());

                        int hour = timePicker.getCurrentHour();
                        int minute = timePicker.getCurrentMinute();

                        String hourString = String.valueOf(hour);
                        String minuteString = String.valueOf(minute);

                        if (hour < 10) {
                            hourString = "0" + String.valueOf(hour);
                        }
                        if (minute < 10) {
                            minuteString = "0" + String.valueOf(minute);
                        }

                        tvMess.setText("Будильник установлен на: " + hourString + ":" + minuteString);
                        break;

                    //pendingIntent
                    pendingIntent = PendingIntent.getBroadcast(Calendar.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                    //alarmManager
                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                    case R.id.btnCancelTime:
                        tvMess.setText("Будильник отключен");
                        break;
                }
            }
        };
        btnCancelTime.setOnClickListener(onClickListener);
        btnOk.setOnClickListener(onClickListener);
    }
}
