package com.example.root.sectionedrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class SectionModel implements Serializable,Parcelable {
    String date;
    ArrayList<Model> ModelList;

    public SectionModel() {
    }

    public SectionModel(String date, ArrayList<Model> modelList) {
        this.date = date;
        ModelList = modelList;
    }

    protected SectionModel(Parcel in) {
        date = in.readString();
        ModelList = in.createTypedArrayList(Model.CREATOR);
    }

    public static final Creator<SectionModel> CREATOR = new Creator<SectionModel>() {
        @Override
        public SectionModel createFromParcel(Parcel in) {
            return new SectionModel(in);
        }

        @Override
        public SectionModel[] newArray(int size) {
            return new SectionModel[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Model> getModelList() {
        return ModelList;
    }

    public void setModelList(ArrayList<Model> modelList) {
        ModelList = modelList;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(date);
        parcel.writeTypedList(ModelList);
    }
}
