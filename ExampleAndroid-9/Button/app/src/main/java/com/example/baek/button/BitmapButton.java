package com.example.baek.button;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class BitmapButton extends AppCompatButton {

    public BitmapButton(Context context) {
        super(context);
        init(context);
    }

    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setBackgroundResource(R.drawable.no6);

//        setTextSize(100);
        float textSize = getResources().getDimension(R.dimen.text_size);
        setTextSize(textSize); // 이렇게 dp로 설정가능 java에서는 이렇게 안하면 픽셀단위로만 가능
        setPadding(20, 0, 20, 0);
        setTextColor(Color.BLACK);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                setBackgroundResource(R.drawable.no5);
                setTextColor(Color.WHITE);
                break;
            case MotionEvent.ACTION_UP:
                setBackgroundResource(R.drawable.no6);
                setTextColor(Color.BLACK);
                break;
        }

        invalidate(); // 다시 그려주세요

        return true;
    }
}
