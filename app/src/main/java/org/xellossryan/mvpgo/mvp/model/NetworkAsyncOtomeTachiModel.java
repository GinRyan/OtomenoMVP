package org.xellossryan.mvpgo.mvp.model;

import org.xellossryan.mvpgo.api.GankIO;
import org.xellossryan.mvpgo.api.GankIOBuildFacade;
import org.xellossryan.mvpgo.entity.OtomeResult;
import org.xellossryan.mvpgo.mvp.DataRequestCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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

    @Override
    public void queryRx(int page, final DataRequestCallback callback) {
        Observable<OtomeResult> otomeRx = gankIO.listOtomeRx(page + "");
        otomeRx.observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Action1<OtomeResult>() {
                    @Override
                    public void call(OtomeResult otomeResult) {
                        callback.onDataResponse(otomeResult.getResults());
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<OtomeResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onDataFailure(e);
                    }

                    @Override
                    public void onNext(OtomeResult otomeResult) {

                    }
                });

    }
}
