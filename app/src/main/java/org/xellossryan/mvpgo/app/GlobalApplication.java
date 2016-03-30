package org.xellossryan.mvpgo.app;

import android.app.Application;

import org.xellossryan.mvpgo.di.component.CommonComponent;

/**
 * Created by Liang on 2016/3/30.
 */
public class GlobalApplication extends Application {
    protected static CommonComponent graph;

    @Override
    public void onCreate() {
        super.onCreate();
        graph = CommonComponent.Initializer.init();
    }

    public static CommonComponent getCommonComponent() {
        return graph;
    }
}
