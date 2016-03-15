package org.xellossryan.mvpgo.mvp.presenters;

import org.xellossryan.mvpgo.entity.OtomeResult;
import org.xellossryan.mvpgo.mvp.DataRequestCallback;
import org.xellossryan.mvpgo.mvp.model.AbsOtomeTachiModel;
import org.xellossryan.mvpgo.mvp.model.NetworkAsyncOtomeTachiModel;
import org.xellossryan.mvpgo.mvp.views.Otometachi;

import retrofit2.Response;

/**
 * 少女们的操作主导器
 * <p/>
 * Created by Liang on 2016/3/11.
 */
public class OtomePresenter {
    AbsOtomeTachiModel absOtomeTachiModel;
    private Otometachi otometachi;

    int page = 1;

    public OtomePresenter(Otometachi otometachi) {
        this.otometachi = otometachi;
        absOtomeTachiModel = new NetworkAsyncOtomeTachiModel();

    }

    public void refresh() {
        page = 1;
        absOtomeTachiModel.query(page, new DataRequestCallback() {
            @Override
            public void onDataResponse(Object object) {
                otometachi.onLoadingFinished(page, ((Response<OtomeResult>) object).body().getResults());
            }

            @Override
            public void onDataFailure(Throwable t) {
                otometachi.onNetworkUnavailable(t);
            }
        });

    }

    public void loadNext() {
        page++;
        absOtomeTachiModel.query(page, new DataRequestCallback() {
            @Override
            public void onDataResponse(Object object) {
                otometachi.onLoadingFinished(page, ((Response<OtomeResult>) object).body().getResults());
            }

            @Override
            public void onDataFailure(Throwable t) {
                page--;
                otometachi.onNetworkUnavailable(t);
            }
        });
    }
}
