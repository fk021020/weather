package com.fk.weather.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fk.weather.db.bean.DailyResponse;
import com.fk.weather.databinding.ItemDailyRvBinding;
import com.fk.weather.utils.EasyDate;
import com.fk.weather.utils.WeatherUtil;

import java.util.List;

/**
 * 天气预报 数据适配器
 */
public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.ViewHolder> {

    // 天气预报数据列表
    private final List<DailyResponse.DailyBean> dailyBeans;

    /**
     * 构造方法，初始化天气预报数据列表
     *
     * @param dailyBeans 天气预报数据列表
     */
    public DailyAdapter(List<DailyResponse.DailyBean> dailyBeans) {
        this.dailyBeans = dailyBeans;
    }

    /**
     * 创建新的视图持有者
     *
     * @param parent 视图组
     * @param viewType 视图类型
     * @return 返回新的视图持有者
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDailyRvBinding binding = ItemDailyRvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    /**
     * 绑定视图持有者，为项视图设置数据
     *
     * @param holder 视图持有者
     * @param position 项的位置
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DailyResponse.DailyBean dailyBean = dailyBeans.get(position);
        holder.binding.fxDate.setText(EasyDate.dateSplit(dailyBean.getFxDate()) + EasyDate.getDayInfo(dailyBean.getFxDate()));
        WeatherUtil.changeIcon(holder.binding.iconDay, Integer.parseInt(dailyBean.getIconDay()));
        holder.binding.tempMax.setText(dailyBean.getTempMax() + "℃");
        holder.binding.tempMin.setText(" / " + dailyBean.getTempMin() + "℃");
    }

    /**
     * 获取项视图的数量
     *
     * @return 项视图的数量
     */
    @Override
    public int getItemCount() {
        return dailyBeans.size();
    }

    /**
     * 视图持有者类
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // 项视图绑定对象
        public ItemDailyRvBinding binding;

        /**
         * 构造方法，初始化视图绑定对象
         *
         * @param itemTextRvBinding 项视图绑定对象
         */
        public ViewHolder(@NonNull ItemDailyRvBinding itemTextRvBinding) {
            super(itemTextRvBinding.getRoot());
            binding = itemTextRvBinding;
        }
    }
}
