package com.example.android.namshiapp;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomAdapter extends BaseAdapter implements ListAdapter {
    private List<ListObject> list;
    private Context context;

    public CustomAdapter(Data data, Context context) {
        this.list = data.data;
        Log.d("We are here", String.valueOf(data.data));
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public long getItemId(int position) {
        return Long.valueOf(list.get(position).getRefID());
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview, null);
        }

        ImageView imageView = view.findViewById(R.id.image);
        TextView date = view.findViewById(R.id.date);
        TextView order = view.findViewById(R.id.order);
        TextView action = view.findViewById(R.id.coinsAction);
        TextView actionValue = view.findViewById(R.id.coinsActionValue);

        String pre;

        Date d = new Date(list.get(position).getDate() * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, YYYY - h:mm a");
        date.setText(String.valueOf(simpleDateFormat.format(d)));

        actionValue.setText(String.valueOf(list.get(position).getAmount()));



        switch (list.get(position).getEvent()) {
            case "order":
                imageView.setBackgroundResource(R.drawable.ic_order_activity);
                order.setText("Order");
                pre = "Added";
                actionValue.setTextColor(Color.parseColor("#923466"));
                action.setText(pre);
                break;
            case "discount":
                imageView.setBackgroundResource(R.drawable.ic_discount_activity);
                order.setText(list.get(position).getTitle());
                pre = "Spent";
                action.setText(pre);
                break;
            case "activated":
                imageView.setBackgroundResource(R.drawable.ic_discount_activity);
                order.setText(list.get(position).getTitle());
                pre = "Debited";
                action.setText(pre);
                break;
            case "levelUnlocked":
                String tmp;
                pre = "Debited";
                action.setText(pre);
                if (list.get(position).getRefID().contains("Silver")) {
                    imageView.setBackgroundResource(R.drawable.ic_silver_unlock);
                    tmp = "Unlocked level Silver";
                    order.setText(tmp);
                }else if(list.get(position).getRefID().contains("Gold")){
                    imageView.setBackgroundResource(R.drawable.ic_gold_unlock);
                    tmp = "Unlocked level Gold";
                    order.setText(tmp);
                }else if(list.get(position).getRefID().contains("Platinum")){
                    imageView.setBackgroundResource(R.drawable.ic_platinum_unlock);
                    tmp = "Unlocked level Platinum";
                    order.setText(tmp);
                }else if(list.get(position).getRefID().contains("Titanium")){
                    imageView.setBackgroundResource(R.drawable.ic_titanium_unlock);
                    tmp = "Unlocked level Titanium";
                    order.setText(tmp);
                }
                break;
        }



        return view;
    }
}
