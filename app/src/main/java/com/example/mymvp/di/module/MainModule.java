package com.example.mymvp.di.module;

import com.example.mymvp.contract.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * 提供依赖（presenter构造器需要的参数）
 */
@Module
public class MainModule {
    private MainContract.MainView mMainView;

    //Module的构造器，传入一个MainView， 提供给Component
    public MainModule(MainContract.MainView mMainView) {
        this.mMainView = mMainView;
    }

    //Provides注解代表提供的参数，为构造器传进来的
    @Provides
    public MainContract.MainView inject(){
        return mMainView;
    }
}
