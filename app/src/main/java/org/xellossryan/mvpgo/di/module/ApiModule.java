package org.xellossryan.mvpgo.di.module;

import org.xellossryan.mvpgo.api.GankIO;
import org.xellossryan.mvpgo.api.GankIOBuildFacade;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Api 模块初始化
 * Created by Liang on 2016/3/30.
 */
@Module
public class ApiModule {

    public ApiModule() {
    }

    @Provides
    @Singleton
    protected GankIO provideGankIOService() {
        return GankIOBuildFacade.create();
    }
}
