package org.xellossryan.mvpgo.di.component;

import org.xellossryan.mvpgo.mvp.model.NetworkAsyncOtomeTachiModel;
import org.xellossryan.mvpgo.ui.MainActivity;

/**
 * 内存中实例图结构
 * <p/>
 * Created by Liang on 2016/3/30.
 */
public interface InstanceGraph {

    public void inject(MainActivity activity);

    public void inject(NetworkAsyncOtomeTachiModel tachiModel);
}
