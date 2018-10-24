package com.example.baek.picker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Picker picker;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        picker = (Picker) findViewById(R.id.picker);

        picker.setOnDateTimeChangedListener(new OnDateTimeChangedListener() {
            @Override
            public void onDateTimeChanged(Picker view, int yeear, int monthOfYear, int dayOfMonth, int hour, int minute) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(yeear, monthOfYear, dayOfMonth, hour, minute);
                String curTime = format.format(calendar.getTime());

                textView.setText(curTime);
            }
        });

    }
}
