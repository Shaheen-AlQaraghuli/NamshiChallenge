package com.example.android.namshiapp;

import java.util.ArrayList;

public class Data {
    public ArrayList<ListObject> data;
    public Details details;

    public Data(ArrayList<ListObject> events, Details details) {
        this.data = events;
        this.details = details;
    }

    public ArrayList<ListObject> getData() {
        return data;
    }

    public Details getDetails() {
        return details;
    }
}
