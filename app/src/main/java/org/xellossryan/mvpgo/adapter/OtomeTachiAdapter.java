package org.xellossryan.mvpgo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.xellossryan.mvpgo.R;
import org.xellossryan.mvpgo.entity.WildOtome;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 少女们的适配器
 * Created by Liang on 2016/3/11.
 */
public class OtomeTachiAdapter extends RecyclerView.Adapter<OtomeTachiAdapter.VH> {
    List<WildOtome> otometachis = new ArrayList<>();
    private Context context;
    Object listLock = new Object();

    public OtomeTachiAdapter(Context context) {
        this.context = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        VH vh = new VH(LayoutInflater.from(context).inflate(R.layout.item_otome, parent, false));
        return vh;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.name.setText(getItem(position).desc);
        Glide.with(context)
                .load(getItem(position).url)
                .centerCrop()
                .crossFade()
                .into(holder.ivOtome);
    }

    public WildOtome getItem(int position) {
        return otometachis.get(position);
    }

    @Override
    public int getItemCount() {
        return otometachis.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @Bind(R.id.ivOtome)
        ImageView ivOtome;
        @Bind(R.id.name)
        TextView name;

        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void add(WildOtome data) {
        synchronized (listLock) {
            if (otometachis == null) {
                otometachis = new ArrayList<>();
            }
            otometachis.add(data);
        }
    }

    public void addAll(List<WildOtome> data) {
        synchronized (listLock) {
            if (otometachis == null) {
                otometachis = new ArrayList<>();
            }
            otometachis.addAll(data);
        }
    }

    public void clear() {
        synchronized (listLock) {
            if (otometachis == null) {
                otometachis.clear();
            }
        }
    }

}
