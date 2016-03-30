package org.xellossryan.mvpgo.di.component;

import org.xellossryan.mvpgo.di.module.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 应用组件，包括Api模块
 * Created by Liang on 2016/3/30.
 */
@Singleton
@Component(modules = {
        ApiModule.class
})
public interface CommonComponent extends InstanceGraph {
    final class Initializer {
        public static CommonComponent init() {
            return DaggerCommonComponent
                    .builder()
                    .apiModule(new ApiModule())
                    .build();
        }
    }
}
