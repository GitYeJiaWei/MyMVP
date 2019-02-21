package com.example.mymvp.presenter;

import android.util.Log;

import com.example.mymvp.bean.BaseBean;
import com.example.mymvp.bean.LoginBean;
import com.example.mymvp.bean.StoresBean;
import com.example.mymvp.contract.MainContract;
import com.example.mymvp.model.MainModelImpl;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 想要注入presenter，那么就在presenter的构造器添加注解@Inject
 */
public class MainPresenterImpl implements MainContract.MainPresenter{
    private MainContract.MainView mMainView;
    private MainContract.MainModel mMainModel;

    @Inject
    public MainPresenterImpl(MainContract.MainView mainView){
        mMainView = mainView;
        mMainModel = new MainModelImpl();
    }

    @Override
    public void getMainData() {
        mMainModel.loadMainData()
                .observeOn(AndroidSchedulers.mainThread())//拿到数据的时候在主线程
                .subscribeOn(Schedulers.io())//访问数据在工作线程
                .subscribe(new Subscriber<BaseBean<LoginBean>>() {
                    @Override
                    public void onCompleted() {
                        //当所有onNext()执行完毕后处罚
                        Log.e("wing","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        //错误的时候触发
                        Log.e("wing","onError");
                    }

                    @Override
                    public void onNext(BaseBean<LoginBean> o) {
                        //当sampleObservable发生事件的时候触发
                        mMainView.showData(o.getData().getListWarehouse().get(0));
                        Log.e("wing","onNext");
                    }
                });
    }
}
