package com.example.android.namshiapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TextView totalCoins, coinsSpent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listviewId);
        totalCoins = findViewById(R.id.totalCoins);
        coinsSpent = findViewById(R.id.coinsSpent);

        MyRetrofitServices taskService = ServiceBuilder.buildService(MyRetrofitServices.class);
        Call<Data> createRequest = taskService.getListObjects();

        createRequest.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                Data data = new Data(response.body().data, response.body().details);
                CustomAdapter adapter = new CustomAdapter(data, getApplicationContext());
                listView.setAdapter(adapter);
                totalCoins.setText(String.valueOf(data.getDetails().getCoins()));
                coinsSpent.setText(String.valueOf(data.getDetails().getCoinsSpent()));
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });

    }
}
