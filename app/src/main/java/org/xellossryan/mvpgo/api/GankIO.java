package org.xellossryan.mvpgo.api;

import org.xellossryan.mvpgo.entity.OtomeResult;
import org.xellossryan.mvpgo.entity.WildOtome;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * gank.io接口
 * Created by Liang on 2016/3/14.
 */
public interface GankIO {

    @GET("api/data/福利/24/{page}")
    Call<OtomeResult> listOtome(@Path("page") String page);

    /**
     * 使用RxJava
     * @param page
     * @return
     */
    @GET("api/data/福利/24/{page}")
    Observable<OtomeResult> listOtomeRx(@Path("page") String page);
}
