package com.example.root.sectionedrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Model implements Serializable, Parcelable {
    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };
    String abc;
    String def;
    String img_url;
    int count;
    int mainCount;

    public Model() {
    }

    public Model(String abc, String def, String img_url) {
        this.abc = abc;
        this.def = def;
        this.img_url = img_url;
    }

    protected Model(Parcel in) {
        abc = in.readString();
        def = in.readString();
        img_url = in.readString();
        count = in.readInt();
        mainCount = in.readInt();
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMainCount() {
        return mainCount;
    }

    public void setMainCount(int mainCount) {
        this.mainCount = mainCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(abc);
        parcel.writeString(def);
        parcel.writeString(img_url);
        parcel.writeInt(count);
        parcel.writeInt(mainCount);
    }
}
