package com.example.baek.exampleandroid;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    TextView background0;
    TextView background1;

    View subView;

    int index = 1;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout container = (LinearLayout) findViewById(R.id.main_layout);
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.activity_relative, container , true);
            }
        });

        // 나중에 dialog로 잠시 띄우는 형태로 변경해보자

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout container = (LinearLayout) findViewById(R.id.main_layout);
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.activity_table, container , true);
            }
        });

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout container = (LinearLayout) findViewById(R.id.main_layout);
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                subView = (View) inflater.inflate(R.layout.activity_text, container , true);


                background0 = (TextView) findViewById(R.id.image0);
                background1 = (TextView) findViewById(R.id.image1);

                button8 = (Button) findViewById(R.id.button8);
                button8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewGroup parent = (ViewGroup) subView.getParent();
                        parent.removeView(subView);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        /*
                        *
                        *
                        * inflation 된 레이아웃을 전화면으로 돌리는 방법은 없는건가? intent로 화면전환하는 것과는 전혀 다른 차원의 문제??!!
                        *
                        *
                         */
                    }
                });

                button7 = (Button) findViewById(R.id.button7);
                button7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch(index){
                            case 0:
                                background1.setVisibility(View.INVISIBLE);
                                background0.setVisibility(View.VISIBLE);
                                button7.setText("블루");
                                index = 1;
                                break;
                            case 1:
                                background0.setVisibility(View.INVISIBLE);
                                background1.setVisibility(View.VISIBLE);
                                button7.setText("그린");
                                index = 0;
                                break;
                                default:
                        }
                    }
                });
                /**
                 *
                 *
                // inflation한 sublayout을 .java를 따로 만들어 변수를 참조할 수 있다면 따로 분리시켜서 만들어보자!
                 * 또 분리 시켰다면 중복되는 id를 이용할 수 있는지 예를 들면 여기서의 button7 -> button1
                 *
                 *
                 * radioBox는 따로 실습하지 않았지만 isChecked를 이용하여 boolean 값을 받아 처리함
                 *
                 *
                 **/
            }
        });

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                ComponentName name = new ComponentName("com.example.baek.exampleandroid", "com.example.baek.exampleandroid.DataActivity");
                intent.setComponent(name);
                // 화면을 전환하는 다른 방법, 장점 : 문자열을 이용해서 전환가능
                intent.putExtra("tell", "01012345678");
                setResult(Activity.RESULT_OK, intent);
                startActivityForResult(intent, 101);
            }
        });

    }

    public void onButton1Clicked(View v){
        Toast.makeText(getApplicationContext(), "클릭 함수 직접 구현", Toast.LENGTH_LONG).show();
//        Toast.makeText(this, "클릭 함수 직접 구현", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 이 함수는 finish()로 끝나는 액티비티에서 결과값을 받음, 메인에서 다른 액티비티로 전달했을 경우는 그 쪽에서 getIntent()로 받아서 사용하면 됨
    }
}
