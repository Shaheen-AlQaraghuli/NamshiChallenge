package com.example.android.namshiapp;

public class ListObject {
    final String event, description, type, title, refId;
    final int amount, count;
    final long createdAt;

    public ListObject(String event, String description, String type, String title, String refId, int amount, int count, long createdAt) {
        this.event = event;
        this.description = description;
        this.type = type;
        this.title = title;
        this.refId = refId;
        this.amount = amount;
        this.count = count;
        this.createdAt = createdAt;
    }

    public String getEvent() {
        return event;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getRefID() {
        return refId;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }

    public long getDate() {
        return createdAt;
    }
}
