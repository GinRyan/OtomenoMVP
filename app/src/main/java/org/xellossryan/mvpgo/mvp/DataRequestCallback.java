package org.xellossryan.mvpgo.mvp;

/**
 * 数据请求回调
 * Created by Liang on 2016/3/11.
 */
public interface DataRequestCallback<T> {
    /**
     * 数据请求响应
     *
     * @param object 响应内容
     */
    void onDataResponse(T object);

    /**
     * 数据请求失败
     */
    void onDataFailure(Throwable t);

}
