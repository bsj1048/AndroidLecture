package com.example.baek.landscapenonrestart;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // onSaveInstanceState() 없이, 화면 재시작 없이 가로,세로 전환
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "가로방향", Toast.LENGTH_LONG).show();
        } else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "세로방향", Toast.LENGTH_LONG).show();
        }
        // 그냥은 호출이 안되고 매니패스트 등록해야됨
    }
}
