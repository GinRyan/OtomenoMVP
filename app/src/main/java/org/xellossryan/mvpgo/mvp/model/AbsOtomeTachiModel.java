package org.xellossryan.mvpgo.mvp.model;

import org.xellossryan.mvpgo.mvp.DataRequestCallback;

/**
 * 针对少女们的操作
 * Created by Liang on 2016/3/11.
 */
public interface AbsOtomeTachiModel {
    void query(int count, int page, DataRequestCallback callback);
}
