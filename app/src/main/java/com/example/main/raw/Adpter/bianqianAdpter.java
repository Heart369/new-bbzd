package com.example.main.raw.Adpter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.main.raw.Class_Custom.Bq_gson;
import com.example.main.raw.Class_Custom.Dp_Px;
import com.example.main.raw.Class_Custom.Share;
import com.example.main.raw.Class_Custom.time;
import com.example.main.raw.DataClass.Bqdata;
import com.example.main.R;
import com.king.view.arcseekbar.ArcSeekBar;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.util.List;

//实时便签适配器
public class bianqianAdpter extends BaseAdapter {
    List<Bqdata> data = null;
    int[] layout;
    Context context;
    Bq_gson bq;
    int[] draw = new int[]{R.drawable.back_item_1, R.drawable.back_item_2, R.drawable.back_item_3, R.drawable.back_item_4,R.drawable.back_item_5};

    public bianqianAdpter(List<Bqdata> data, int[] layout, Context context, Bq_gson bq_gson) {
        this.data = data;
        this.layout = layout;
        this.context = context;
        bq = bq_gson;
    }

    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 0 : 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Bqdata bqdata = data.get(position);
        int viewType = getItemViewType(position);
        if (viewType == 1) {
            SecondViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(layout[viewType], parent, false);
                holder = new SecondViewHolder();
                holder.imageView2 = convertView.findViewById(R.id.gj);
                holder.textView8 = convertView.findViewById(R.id.gjname);
                holder.textView9 = convertView.findViewById(R.id.tfid);
                holder.lin = convertView.findViewById(R.id.lin_back);
                holder.textView10 = convertView.findViewById(R.id.wqid);
                holder.imageView = convertView.findViewById(R.id.wq);
                holder.imageView1 = convertView.findViewById(R.id.tf);
                convertView.setTag(holder);
            } else {
                holder = (SecondViewHolder) convertView.getTag();
            }
            holder.lin.setBackground(context.getDrawable(draw[position - 1]));
            holder.textView8.setText(bqdata.getGjname());
            holder.textView9.setText(bqdata.getTfname());
            holder.textView10.setText(bqdata.getWqname());
            holder.imageView.setImageResource(bqdata.getWqimg());
            holder.imageView1.setImageResource(bqdata.getTfimg());
            holder.imageView2.setImageResource(bqdata.getGjimg());
        } else {
            FirstViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(layout[viewType], parent, false);
                holder = new FirstViewHolder();
                holder.arcSeekBar1 = convertView.findViewById(R.id.arcSeekBar1);
                holder.ywtime = convertView.findViewById(R.id.sytime);
                holder.shuzhi = convertView.findViewById(R.id.shuzhi);
                holder.btbq = convertView.findViewById(R.id.dtbq);
                holder.arcSeekBar2 = convertView.findViewById(R.id.arcSeekBar2);
                holder.dt_time = convertView.findViewById(R.id.dtbq_time);
                holder.arcSeekBar3 = convertView.findViewById(R.id.arcSeekBar3);
                holder.mr = convertView.findViewById(R.id.wt);
                holder.wtqk = convertView.findViewById(R.id.wtqk);
                holder.arcSeekBar4 = convertView.findViewById(R.id.arcSeekBar4);
                holder.zb = convertView.findViewById(R.id.zb);
                holder.sy1 = convertView.findViewById(R.id.sy);
                holder.clzby = convertView.findViewById(R.id.clzby);
                holder.clzby_time = convertView.findViewById(R.id.clzby_time);
                holder.arcSeekBar5 = convertView.findViewById(R.id.arcSeekBar5);
                holder.wt = convertView.findViewById(R.id.text_wt);
                holder.arcSeekBar10 = convertView.findViewById(R.id.arcSeekBar10);
                holder.i5 = convertView.findViewById(R.id.imageView_5);
                holder.t5 = convertView.findViewById(R.id.t5);
                holder.arcSeekBar9 = convertView.findViewById(R.id.arcSeekBar9);
                holder.i4 = convertView.findViewById(R.id.imageView_4);
                holder.t4 = convertView.findViewById(R.id.t4);
                holder.arcSeekBar8 = convertView.findViewById(R.id.arcSeekBar8);
                holder.i3 = convertView.findViewById(R.id.imageView_3);
                holder.t3 = convertView.findViewById(R.id.t3);
                holder.arcSeekBar7 = convertView.findViewById(R.id.arcSeekBar7);
                holder.i2 = convertView.findViewById(R.id.imageView_2);
                holder.t2 = convertView.findViewById(R.id.t2);
                holder.arcSeekBar6 = convertView.findViewById(R.id.arcSeekBar6);
                holder.i1 = convertView.findViewById(R.id.imageView_1);
                holder.t1 = convertView.findViewById(R.id.t1);


                convertView.setTag(holder);
            } else {
                holder = (FirstViewHolder) convertView.getTag();
            }
            if (bq != null) {
//                    arcSeekBar1.setProgress();
                holder.arcSeekBar1.showAnimation(bq.data.current_resin, 3000);
                time times = new time();
                int b = Integer.parseInt(times.getHour());
                int c = Integer.parseInt(times.getmini());
                String i = "";
                if (bq.data.current_resin == 160)
                    holder.ywtime.setText("树脂溢出啦快上线吧");
                else {
                    int hz = (160 - bq.data.current_resin) * 7;
                    c += hz % 60;
                    if (c > 60) {
                        b++;
                        c -= 60;
                    }
                    b += hz / 60;
                    if (b > 24) {
                        b -= 24;
                        i = "次日";
                    }
                    String h = String.valueOf(hz / 60);
                    String m = String.valueOf(hz % 60);
                    if (h.length() == 1)
                        h = "0" + h;
                    if (m.length() == 1)
                        m = "0" + m;

                    String data = "需要" + h + "小时" + m + "分钟" + "预计" + i + b + "点" + c + "分恢复完毕";
                    SpannableString spannableString = new SpannableString(data);
                    spannableString.setSpan(new ForegroundColorSpan(0xFFFB9D11), 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spannableString.setSpan(new ForegroundColorSpan(0xFFFB9D11), 6, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spannableString.setSpan(new ForegroundColorSpan(0xFFFB9D11), 12, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spannableString.setSpan(new ForegroundColorSpan(0xFFFB9D11), 15, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    holder.ywtime.setText(spannableString);
                }

                String text = bq.data.current_resin + "/" + bq.data.max_resin;
                SpannableString spannableString = new SpannableString(text);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(0xFFFB9D11);
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(25, true);
                spannableString.setSpan(foregroundColorSpan, 0, String.valueOf(bq.data.current_resin).length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannableString.setSpan(absoluteSizeSpan, 0, String.valueOf(bq.data.current_resin).length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.shuzhi.setText(spannableString);
                if (bq.data.current_resin == 160)
                    holder.shuzhi.setTextColor(0xFFE6113C);

                holder.arcSeekBar2.setMax(bq.data.max_home_coin);
                holder.arcSeekBar2.showAnimation(bq.data.current_home_coin, 3000);

                holder.dt_time.setText("还需" + Integer.parseInt(bq.data.home_coin_recovery_time) / 3600 + "小时" + Integer.parseInt(bq.data.home_coin_recovery_time) % 3600 / 60 + "分钟");
                holder.btbq.setText(bq.data.current_home_coin + "/" + bq.data.max_home_coin);

                holder.arcSeekBar3.showAnimation(bq.data.finished_task_num * 100, 3000);

                holder.mr.setText(bq.data.finished_task_num + "/" + 4);

                if (bq.data.finished_task_num < 4)
                    holder.wtqk.setText("还有任务未完成");
                else holder.wtqk.setText("委托已经完成");

                holder.arcSeekBar4.showAnimation(bq.data.remain_resin_discount_num * 100, 3000);

                holder.zb.setText(bq.data.remain_resin_discount_num + "/" + 3);

                if (bq.data.remain_resin_discount_num == 3)
                    holder.sy1.setText("本周已完成");
                else holder.sy1.setText("剩余" + (3 - bq.data.remain_resin_discount_num) + '次');

                if (bq.data.transformer.obtained) {

                    int time = bq.data.transformer.recovery_time.Day * 86400 + bq.data.transformer.recovery_time.Hour * 360 + bq.data.transformer.recovery_time.Minute * 60;
                    time = 518400 - time;
                    holder.arcSeekBar5.showAnimation(time, 3000);
                    if (bq.data.transformer.recovery_time.reached) {
                        holder.clzby.setText("已就绪");
                        holder.clzby_time.setText("已经冷却完毕");
                    } else {
                        holder.clzby.setText("未就绪");
                        holder.clzby_time.setText("剩余" + bq.data.transformer.recovery_time.Day + "天" + bq.data.transformer.recovery_time.Hour + "小时" + bq.data.transformer.recovery_time.Minute + "分钟");
                    }
                } else holder.clzby.setText("未获得");
                int sy = 0, flag = 0;

                switch (bq.data.expeditions.size()) {
                    case 5:

                        sy = Integer.parseInt(bq.data.expeditions.get(4).remained_time);
                        holder.arcSeekBar10.showAnimation(72000 - sy, 3000);

                        Glide.with(context).load(bq.data.expeditions.get(4).avatar_side_icon).into(holder.i5);

                        if (sy == 0) {
                            holder.t5.setText("已探索完毕");
                            flag++;
                        } else {
                            holder.t5.setText(sy / 3600 + "小时" + sy % 3600 / 60 + "分钟");
                        }

                    case 4:

                        sy = Integer.parseInt(bq.data.expeditions.get(3).remained_time);
                        holder.arcSeekBar9.showAnimation(72000 - sy, 3000);

                        Glide.with(context).load(bq.data.expeditions.get(3).avatar_side_icon).into(holder.i4);

                        if (sy == 0) {
                            holder.t4.setText("已探索完毕");
                            flag++;
                        } else {
                            holder.t4.setText(sy / 3600 + "小时" + sy % 3600 / 60 + "分钟");
                        }
                    case 3:

                        sy = Integer.parseInt(bq.data.expeditions.get(2).remained_time);
                        holder.arcSeekBar8.showAnimation(72000 - sy, 3000);

                        Glide.with(context).load(bq.data.expeditions.get(2).avatar_side_icon).into(holder.i3);

                        if (sy == 0) {
                            holder.t3.setText("已探索完毕");
                            flag++;
                        } else {
                            holder.t3.setText(sy / 3600 + "小时" + sy % 3600 / 60 + "分钟");
                        }
                    case 2:

                        sy = Integer.parseInt(bq.data.expeditions.get(1).remained_time);
                        holder.arcSeekBar7.showAnimation(72000 - sy, 3000);

                        Glide.with(context).load(bq.data.expeditions.get(1).avatar_side_icon).into(holder.i2);

                        if (sy == 0) {
                            holder.t2.setText("已探索完毕");
                            flag++;
                        } else {
                            holder.t2.setText(sy / 3600 + "小时" + sy % 3600 / 60 + "分钟");
                        }
                    case 1:

                        sy = Integer.parseInt(bq.data.expeditions.get(0).remained_time);
                        holder.arcSeekBar6.showAnimation(72000 - sy, 3000);

                        Glide.with(context).load(bq.data.expeditions.get(0).avatar_side_icon).into(holder.i1);

                        if (sy == 0) {
                            holder.t1.setText("已探索完毕");
                            flag++;
                        } else {
                            holder.t1.setText(sy / 3600 + "小时" + sy % 3600 / 60 + "分钟");
                        }
                }
                holder.wt.setText("委托派遣" + flag + "/" + bq.data.expeditions.size());

            } else if (bqdata.getSztime().contains("网络")) {

                holder.shuzhi.setText("无网络连接,请尝试下拉刷新");
            } else if (bqdata.getSztime().contains("被米游社检测")) {

                holder.shuzhi.setText("请前往米游社我的角色验证");
            } else {
                holder.shuzhi.setText("请登录账号哦");
            }
        }
        return convertView;
    }

    public static class FirstViewHolder {
        ArcSeekBar arcSeekBar1, arcSeekBar2, arcSeekBar3, arcSeekBar4, arcSeekBar5, arcSeekBar6, arcSeekBar7, arcSeekBar8, arcSeekBar9, arcSeekBar10;
        TextView ywtime, shuzhi, btbq, dt_time, mr, wtqk, zb, sy1, clzby, clzby_time, wt, t5, t4, t3, t2, t1;
        ImageView i5, i4, i3, i2, i1;
    }

    public static class SecondViewHolder {
        TextView textView8, textView9, textView10;
        ImageView imageView, imageView1, imageView2;
        LinearLayout lin;

    }
}
