package org.xellossryan.mvpgo.mvp.views;

import org.xellossryan.mvpgo.entity.WildOtome;

import java.util.List;

/**
 * 少女们的数据操作回调
 * <p/>
 * Created by Liang on 2016/3/11.
 */
public interface Otometachi {
    /**
     * 刷新
     */
    void onLoadingFinished(int page, List<WildOtome> otometachi);

    /**
     * 网络不可用
     * @param t
     */
    void onNetworkUnavailable(Throwable t);

}
