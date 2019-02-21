package com.example.mymvp.api;

import com.example.mymvp.bean.BaseBean;
import com.example.mymvp.bean.LoginBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface DataApi {

    //http://192.168.66.3:8107/api/user/Login?userName=admin&password=123
    @GET("user/Login")//登录
    Observable<BaseBean<LoginBean>> login(@QueryMap Map<String ,String> params);
}
