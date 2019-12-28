package com.example.myexperiments.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String name;
    private int rollNumer;
    private double marks;

    public User(String name, int rollNumer, double marks) {
        this.name = name;
        this.rollNumer = rollNumer;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumer() {
        return rollNumer;
    }

    public void setRollNumer(int rollNumer) {
        this.rollNumer = rollNumer;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public User(Parcel parcel) {
        name = parcel.readString();
        rollNumer = parcel.readInt();
        marks = parcel.readDouble();
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(rollNumer);
        parcel.writeDouble(marks);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {

        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int i) {
            return new User[i];
        }
    };
}
