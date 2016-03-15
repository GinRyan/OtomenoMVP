package org.xellossryan.mvpgo.mvp.model;

import org.xellossryan.mvpgo.api.GankIO;
import org.xellossryan.mvpgo.api.GankIOBuildFacade;
import org.xellossryan.mvpgo.entity.OtomeResult;
import org.xellossryan.mvpgo.mvp.DataRequestCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 少女们数据模型和数据操作
 * Created by Liang on 2016/3/11.
 */
public class NetworkAsyncOtomeTachiModel implements AbsOtomeTachiModel {
    GankIO gankIO = null;

    public NetworkAsyncOtomeTachiModel() {
        gankIO = GankIOBuildFacade.create();
    }

    @Override
    public void query(int page, final DataRequestCallback callback) {
        Call<OtomeResult> listCall = gankIO.listOtome(page + "");
        listCall.enqueue(new Callback<OtomeResult>() {
            @Override
            public void onResponse(Call<OtomeResult> call, Response<OtomeResult> response) {
                callback.onDataResponse(response);
            }

            @Override
            public void onFailure(Call<OtomeResult> call, Throwable t) {
                callback.onDataFailure(t);
            }
        });
    }
}
