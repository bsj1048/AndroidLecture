package com.example.baek.landscape;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);


        if(savedInstanceState != null) {
            String name = savedInstanceState.getString("name");
            editText.setText(name);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String name = editText.getText().toString();
        outState.putString("name", name); // outState는 onCreate시 전달되는 bundle객체와 같다고 볼 수 있다
    }
}
