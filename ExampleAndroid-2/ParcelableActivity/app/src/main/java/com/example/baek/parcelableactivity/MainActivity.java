package com.example.baek.parcelableactivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                /* add Extra data with Serialization*/

                ArrayList<String> names = new ArrayList<>();
                names.add("백승진");
                names.add("황수연");

                intent.putExtra("names", names);

                SimpleData data = new SimpleData(100, 200, "Hello");
                intent.putExtra("data", data);

                startActivityForResult(intent, 101);
            }
        });
    }

    // 보통 onPause에서 상태 저장
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", "blahblah");
        editor.commit(); // 이 때 저장

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if(pref != null) {
            String name = pref.getString("name", ""); // 없을 경우 "" 반환
        }
    }
}
