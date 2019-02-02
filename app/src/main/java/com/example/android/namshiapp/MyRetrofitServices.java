package com.example.android.namshiapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyRetrofitServices {
    @GET("bins/d994w")
    Call<Data> getListObjects();
}
