package org.xellossryan.mvpgo.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Liang on 2016/3/14.
 */
public class GankIOBuildFacade {
    public static final GankIO create(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://gank.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return  retrofit.create(GankIO.class);
    }
}
