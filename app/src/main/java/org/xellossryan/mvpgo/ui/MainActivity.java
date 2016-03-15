package org.xellossryan.mvpgo.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.xellossryan.mvpgo.R;
import org.xellossryan.mvpgo.adapter.OtomeTachiAdapter;
import org.xellossryan.mvpgo.entity.WildOtome;
import org.xellossryan.mvpgo.mvp.presenters.OtomePresenter;
import org.xellossryan.mvpgo.mvp.views.Otometachi;

import java.util.List;
import java.util.logging.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * MVP+GANK.IO 妹子图
 */
public class MainActivity extends AppCompatActivity implements Otometachi {

    @Bind(R.id.recyclerViewOtome)
    RecyclerView recyclerViewOtome;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    OtomeTachiAdapter otomeTachiAdapter;
    OtomePresenter mOtomePresenter;
    StaggeredGridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        otomeTachiAdapter = new OtomeTachiAdapter(this);
        mOtomePresenter = new OtomePresenter(this);

        // otomeTachiAdapter.addAll(DataProvider.dataInject());

        layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewOtome.setLayoutManager(layoutManager);
        recyclerViewOtome.setAdapter(otomeTachiAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mOtomePresenter.refresh();
                swipeRefreshLayout.setRefreshing(true);
            }
        });
        recyclerViewOtome.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int[] tailItems = new int[3];

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int[] headItemPositions = new int[3];
                layoutManager.findFirstCompletelyVisibleItemPositions(headItemPositions);
                swipeRefreshLayout.setEnabled(headItemPositions[0] == 0);
                layoutManager.findLastVisibleItemPositions(tailItems);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE && tailItems.length > 0) {

                    for (int i = 0; i < tailItems.length; i++) {
                        //只要有一条是最后一条，就加载数据
                        if (tailItems[i] == otomeTachiAdapter.getItemCount() - 1) {
                            mOtomePresenter.loadNext();
                            swipeRefreshLayout.setRefreshing(true);
                        }
                    }
                }
            }
        });
        mOtomePresenter.refresh();
    }

    @Override
    public void onLoadingFinished(int page, List<WildOtome> otometachi) {
        if (page == 1) {
            otomeTachiAdapter.clear();
        }
        otomeTachiAdapter.addAll(otometachi);
        otomeTachiAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onNetworkUnavailable(Throwable t) {
        Snackbar.make(swipeRefreshLayout, "出错:" + t.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
        Log.d(this.getClass().toString(),t.getLocalizedMessage());
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
