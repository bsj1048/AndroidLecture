package com.example.baek.parcelableactivity;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements android.os.Parcelable{

    int number;
    int number2;
    String message;

    public SimpleData(int number, int number2, String message) {
        this.number = number;
        this.number2 = number2;
        this.message = message;
    }

    public SimpleData(Parcel src) {
        this.number = src.readInt();
        this.number2 = src.readInt();
        this.message = src.readString();
    }

    // 필수!!!!!!!!!!!!!!!!!
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public SimpleData createFromParcel(Parcel src) {
            return new SimpleData(src);
        }

        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeInt(number2);
        dest.writeString(message);
    }
}
