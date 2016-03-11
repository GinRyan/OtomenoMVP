package org.xellossryan.mvpgo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import org.xellossryan.mvpgo.R;
import org.xellossryan.mvpgo.adapter.OtomeTachiAdapter;
import org.xellossryan.mvpgo.entity.WildOtome;
import org.xellossryan.mvpgo.mvp.views.Otometachi;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * MVP+GANK.IO 妹子图
 */
public class MainActivity extends AppCompatActivity implements Otometachi {

    @Bind(R.id.recyclerViewOtome)
    RecyclerView recyclerViewOtome;
    OtomeTachiAdapter otomeTachiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        otomeTachiAdapter = new OtomeTachiAdapter();
        recyclerViewOtome.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
    }

    @Override
    public void onRefresh(List<WildOtome> otometachi) {

    }

    @Override
    public void onLoadNext(int count, int page, List<WildOtome> otometachi) {

    }

    @Override
    public void onNetworkUnavailable() {

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
