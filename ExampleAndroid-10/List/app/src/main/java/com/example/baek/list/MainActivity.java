package com.example.baek.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SingerAdapter adapter;

    EditText editText1;
    EditText editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("김건모", "010-1234-1234"));
        adapter.addItem(new SingerItem("아이유", "010-1111-1111"));
        adapter.addItem(new SingerItem("빅뱅", "010-1234-5678"));
        adapter.addItem(new SingerItem("트와이스", "010-2345-7890"));
        adapter.addItem(new SingerItem("비투비", "010-4321-8765"));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                String mobile = editText2.getText().toString();

                adapter.addItem(new SingerItem(name, mobile));
                // 리스트뷰 갱신
                adapter.notifyDataSetChanged();
            }
        });
    }

    // 리스트 뷰는 껍데기고 어댑터가 데이터를 관리
    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<>();


        @Override
        public int getCount() {
            return items.size(); // 리스트뷰에게 데이터 개수 전달
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }


        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 대량의 자료는 재사용 해야함
            SingerItemView view = null;
            if(convertView == null) {
                view = new SingerItemView(getApplicationContext());
            } else {
                view = (SingerItemView) convertView;
            }

            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());

            return view; // 아이템들의 뷰를 반환
        }
    }

}
