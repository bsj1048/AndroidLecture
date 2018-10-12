package com.example.baek.parcelableactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent sentIntent = getIntent(); // onCreate가 실행되기 때문에 getIntent()로 받을 수 있음 재사용의 경우 -> OnNewIntent
        processIntent(sentIntent);
    }

    private void processIntent(Intent intent) {
        if(intent != null) {
            ArrayList<String> names = (ArrayList<String>) intent.getSerializableExtra("names");// ArrayList는 자바 API 기본으로 Serializable을 구현하기 때문에 바로 사용가능
            if(names != null) {
                Toast.makeText(getApplicationContext(), "전달받은 이름 갯수 : " + names.size(), Toast.LENGTH_LONG).show();
            }

            SimpleData data = (SimpleData) intent.getParcelableExtra("data");
            if(data != null) {
                Toast.makeText(getApplicationContext(), "전달받은 데이터 : " + data.number + ", " + data.number2 + ", " + data.message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
