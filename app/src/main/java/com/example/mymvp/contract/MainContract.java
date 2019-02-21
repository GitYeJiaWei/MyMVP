package com.example.mymvp.contract;

import com.example.mymvp.bean.StoresBean;

import rx.Observable;


/**
 * 以往的MVP 都要定义3个接口 分别是 IModel IView IPresenter。
 * 写多了你就会发现，太特么占地方了。。。 这里介绍一种解决办法，
 * 就是引用一种契约类。说白了就是三个接口放一起。
 */
public interface MainContract {
    //View 的接口
   interface MainView{
       void showData(StoresBean storesBean);
       void showProgressBar();
   }

   //Presenter的接口
    interface MainPresenter{
       void getMainData();
   }

   //Model的接口
    interface MainModel{
       Observable loadMainData();
   }
}
