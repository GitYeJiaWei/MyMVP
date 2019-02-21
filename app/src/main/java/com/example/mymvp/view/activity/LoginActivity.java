package com.example.mymvp.view.activity;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mymvp.R;
import com.example.mymvp.bean.StoresBean;
import com.example.mymvp.contract.MainContract;
import com.example.mymvp.di.component.DaggerMainComponent;
import com.example.mymvp.di.module.MainModule;

/**
 * 1.MVP 大家都知道 P的作用是让MV间接拥有肮脏的PY交易，而不是直接让他们进行交易。
 2.Rxjava 响应式编程 0.0 一个特别屌的地方就是你可以随便切换线程,异步
 3.Retrofit 代替Volley的东东，网络请求
 4.Dagger2 Android 的IOC框架，即控制反转，也叫依赖注入，解耦用的
 4.DataBinding MVVM的东东，用起来比较方便，可以让bean与View绑定，抛弃setText()!

 */
public class LoginActivity extends AppCompatActivity implements MainContract.MainView{
    MainContract.MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        //mPresenter 不再以new的形式创建
        mPresenter = DaggerMainComponent.builder().mainModule(new MainModule(this)).build().getPresenter();
    }

    public void getData(View view) {
        //使用presenter操作M与V的交互
        mPresenter.getMainData();
    }

    @Override
    public void showData(StoresBean storesBean) {
        Toast.makeText(this,storesBean.getWhName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        new ProgressDialog.Builder(this).setMessage("loading").create().show();
    }
}
