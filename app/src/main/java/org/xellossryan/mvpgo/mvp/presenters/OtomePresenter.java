package org.xellossryan.mvpgo.mvp.presenters;

import org.xellossryan.mvpgo.api.GankIO;
import org.xellossryan.mvpgo.api.GankIOBuildFacade;
import org.xellossryan.mvpgo.entity.OtomeResult;
import org.xellossryan.mvpgo.mvp.model.AbsOtomeTachiModel;
import org.xellossryan.mvpgo.mvp.model.NetworkAsyncOtomeTachiModel;
import org.xellossryan.mvpgo.mvp.views.Otometachi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 少女们的操作主导器
 * <p/>
 * Created by Liang on 2016/3/11.
 */
public class OtomePresenter {
    AbsOtomeTachiModel absOtomeTachiModel;
    private Otometachi otometachi;
    GankIO gankIO = null;
    int page = 1;

    public OtomePresenter(Otometachi otometachi) {
        this.otometachi = otometachi;
        absOtomeTachiModel = new NetworkAsyncOtomeTachiModel();
        gankIO = GankIOBuildFacade.create();
    }

    public void refresh() {
        page = 1;
        Call<OtomeResult> listCall = gankIO.listOtome(page + "");
        listCall.enqueue(new Callback<OtomeResult>() {
            @Override
            public void onResponse(Call<OtomeResult> call, Response<OtomeResult> response) {
                otometachi.onLoadingFinished(page, response.body().getResults());
            }

            @Override
            public void onFailure(Call<OtomeResult> call, Throwable t) {
                otometachi.onNetworkUnavailable(t);
            }
        });
    }

    public void loadNext() {
        page++;
        Call<OtomeResult> listCall = gankIO.listOtome(page + "");
        listCall.enqueue(new Callback<OtomeResult>() {
            @Override
            public void onResponse(Call<OtomeResult> call, Response<OtomeResult> response) {
                otometachi.onLoadingFinished(page, response.body().getResults());
            }

            @Override
            public void onFailure(Call<OtomeResult> call, Throwable t) {
                page--;
                otometachi.onNetworkUnavailable(t);
            }
        });
    }
}
