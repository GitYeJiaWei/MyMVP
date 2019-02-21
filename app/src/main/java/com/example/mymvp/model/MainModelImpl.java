package com.example.mymvp.model;

import com.example.mymvp.api.Constant;
import com.example.mymvp.api.DataApi;
import com.example.mymvp.bean.BaseBean;
import com.example.mymvp.bean.LoginBean;
import com.example.mymvp.bean.StoresBean;
import com.example.mymvp.contract.MainContract;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class MainModelImpl implements MainContract.MainModel{
    private DataApi mApi;

    public MainModelImpl() {
        //创建Retrofit的  Observable
        mApi = new Retrofit.Builder().baseUrl(Constant.HOST).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(DataApi.class);
    }

    @Override
    public Observable<BaseBean<LoginBean>> loadMainData() {
        Map<String,String> params = new HashMap<>();
        params.put("userName","admin");
        params.put("password","123");
        return mApi.login(params);
    }
}
