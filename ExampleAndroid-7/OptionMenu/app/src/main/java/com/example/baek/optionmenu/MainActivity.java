package com.example.baek.optionmenu;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ActionBar abar = getSupportActionBar();
        //abar.hide(); // 액션바 사라짐
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu); // menu 파라미터에 붙여달라

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 파라미터 item 선택된 item이 넘어옴

        int curId = item.getItemId();
        switch (curId) {
            case R.id.menu_refresh:
                Toast.makeText(this, "새로고침", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_search:
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getApplicationContext(),"검색", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                break;
            case R.id.menu_settings:
                Toast.makeText(this, "설정", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
