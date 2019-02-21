package com.example.mymvp.di.component;

import com.example.mymvp.di.module.MainModule;
import com.example.mymvp.presenter.MainPresenterImpl;

import dagger.Component;

/**
 * 上面的注解，代表使用MainModule
 */
@Component(modules = MainModule.class)
public interface MainComponent {
    MainPresenterImpl getPresenter();
}
