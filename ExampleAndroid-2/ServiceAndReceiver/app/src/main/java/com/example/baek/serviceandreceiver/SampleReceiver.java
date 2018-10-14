package com.example.baek.serviceandreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleReceiver extends BroadcastReceiver {

    private static final String TAG = "SMSReceiver";

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public void onReceive(Context context, Intent intent) { // context 객체 여기있네~

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);

        if(messages.length > 0) {
            String sender = messages[0].getDisplayOriginatingAddress();

            String contents = messages[0].getMessageBody().toString();

            Date date = new Date(messages[0].getTimestampMillis());

            format.format(date); // 포맷 변경
        }
    }

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objs = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objs.length];

        for(int i = 0; i < objs.length; i++) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
            } else {
               messages[i] =  SmsMessage.createFromPdu((byte[]) objs[i]);
            }
        }

        return messages;
    }
}
