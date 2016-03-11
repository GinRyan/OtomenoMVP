package org.xellossryan.mvpgo.mvp.views;

import org.xellossryan.mvpgo.entity.WildOtome;

import java.util.List;

/**
 * 少女们
 * <p/>
 * Created by Liang on 2016/3/11.
 */
public interface Otometachi {
    /**
     * 刷新
     */
    void onRefresh(List<WildOtome> otometachi );

    /**
     * 加载下一页
     *
     * @param count 每页数量
     * @param page  页码
     */
    void onLoadNext(int count, int page, List<WildOtome> otometachi);

    /**
     * 网络不可用
     */
    void onNetworkUnavailable();

}
