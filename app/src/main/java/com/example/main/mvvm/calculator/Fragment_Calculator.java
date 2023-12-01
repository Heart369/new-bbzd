package com.example.main.mvvm.calculator;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.main.R;
import com.example.main.mvvm.adapter.calculator.fragment.Grid_adapter;
import com.example.main.mvvm.adapter.calculator.fragment.Grid_xg;
import com.example.main.mvvm.adapter.calculator.fragment.List_Ty_Adapter;
import com.example.main.mvvm.adapter.calculator.fragment.Mb_adapter;
import com.example.main.mvvm.adapter.calculator.fragment.Mz_adater;
import com.example.main.mvvm.adapter.calculator.fragment.Recy_pop;
import com.example.main.mvvm.adapter.calculator.fragment.Sh_grid;
import com.example.main.mvvm.base.BaseActivity;
import com.example.main.raw.Class_Custom.wh.Id_Name;
import com.example.main.mvvm.calculator.tool.Sh_data;
import com.example.main.mvvm.calculator.role.Obj_calculator;
import com.example.main.mvvm.json.Detail_Wq;
import com.example.main.mvvm.network.HttpbinServer;
import com.example.main.raw.Class_Custom.Dp_Px;
import com.example.main.raw.Class_Custom.wh.Jsdy_t;
import com.example.main.raw.SQLite.WqSQLite;
import com.example.main.raw.Sh_js.Sywxq;
import com.example.main.raw.Zdyclass.MyGridView;
import com.example.main.raw.Zdyclass.MyListView;
import com.example.main.raw.interface_.OnRecyclerItemClickListener;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_Calculator extends Fragment {
    Obj_calculator obj_calculator;
    int width;
    MyGridView gridView, grid_xg, grid_sh_2;
    MyListView mz, mb;
    MyGridView sh_grid;
    Grid_adapter grid_adapter;
    Mz_adater adater;
    Mb_adapter adapter;
    Sh_grid grid, grid_2;
    int l = 0;
    SwitchMaterial switchMaterial;
    List<Sh_data> sh_data, sh_data2;
    int Scroll1 = 0, Scroll2 = 0, l2 = 0;
    int hi2, flag_pop = 0, flag_pop2 = 0;
    String wq, jl, mzname, syw1;

    public void setObj_calculator(Obj_calculator obj_calculator) {
        this.obj_calculator = obj_calculator;
    }

    public Fragment_Calculator(Obj_calculator obj_calculator, int width) {
        this.obj_calculator = obj_calculator;
        this.width = width;
    }

    public Obj_calculator getObj_calculator() {
        return obj_calculator;
    }

    String name;
    Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            grid_adapter = new Grid_adapter(obj_calculator, getContext());
            gridView.setAdapter(grid_adapter);
            adater = new Mz_adater(obj_calculator, getContext());
            mz.setAdapter(adater);
            sh_data = obj_calculator.csh();
            sh_grid.setNumColumns(sh_data.size());
            grid = new Sh_grid(sh_data, getContext());
            sh_grid.setAdapter(grid);
            adapter = new Mb_adapter(getContext(), obj_calculator);
            mb.setAdapter(adapter);

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        flag_pop = 0;
        View view = inflater.inflate(R.layout.fragment_cal, container, false);
        TextView th = view.findViewById(R.id.text_th);
        ImageView image_lh = view.findViewById(R.id.image_lh);
        grid_sh_2 = view.findViewById(R.id.grid_sh_2);
        List<String> sb = new ArrayList<>();
        sb.add(String.valueOf(obj_calculator.getJszsg_fb().getAvatarId()));
        Jsdy_t jsdy_t = new Jsdy_t(sb);
        String[] sb2 = jsdy_t.js();
        name = sb2[0];
        switchMaterial=view.findViewById(R.id.switch_sh);
        if (name.contains("enka"))
            name=name.replaceAll("enka","");
        Gilde(image_lh, "https://enka.network/ui/UI_Gacha_AvatarImg_" + name + ".png");
        TextView name, lex;
        name = view.findViewById(R.id.textView_name);
        Id_Name id_name = new Id_Name();
        name.setText(id_name.getName(obj_calculator.getJszsg_fb().getAvatarId()));
        lex = view.findViewById(R.id.textView_lv);
        if (obj_calculator.getJszsg_fb().getTalentIdList() != null)
            lex.setText("LV_" + obj_calculator.getJszsg_fb().getPropMap().get("4001").getVal() + "  " + obj_calculator.getJszsg_fb().getTalentIdList().size() + "命");
        else
            lex.setText("LV_" + obj_calculator.getJszsg_fb().getPropMap().get("4001").getVal() + "  " + "0命");

        mz = view.findViewById(R.id.list_mz);

        mb = view.findViewById(R.id.list_mb);
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) mb.getLayoutParams();
        lp.width = width;

        ImageView image_e, image_q, image_a;
        image_a = view.findViewById(R.id.imageView_a);
        image_q = view.findViewById(R.id.iamge_q);
        image_e = view.findViewById(R.id.imageView_e);
        Gilde(image_a, "https://enka.network/ui/" + obj_calculator.getDu().getSkills().get(obj_calculator.getDu().getSkillOrder().get(0)) + ".png");
        Gilde(image_e, "https://enka.network/ui/" + obj_calculator.getDu().getSkills().get(obj_calculator.getDu().getSkillOrder().get(1)) + ".png");
        Gilde(image_q, "https://enka.network/ui/" + obj_calculator.getDu().getSkills().get(obj_calculator.getDu().getSkillOrder().get(2)) + ".png");
        TextView dj_a, dj_e, dj_q;
        dj_a = view.findViewById(R.id.dj_a);
        dj_e = view.findViewById(R.id.dj_e);
        dj_q = view.findViewById(R.id.dj_q);
        dj_a.setText(obj_calculator.getJszsg_fb().skillLevelMap.get(obj_calculator.getDu().getSkillOrder().get(0).toString()) + "");
        dj_e.setText(obj_calculator.getJszsg_fb().skillLevelMap.get(obj_calculator.getDu().getSkillOrder().get(1).toString()) + "");
        dj_q.setText(obj_calculator.getJszsg_fb().skillLevelMap.get(obj_calculator.getDu().getSkillOrder().get(2).toString()) + "");
        gridView = view.findViewById(R.id.grid_cal);
        sh_grid = view.findViewById(R.id.grid_sh);
        ImageView imageButton = view.findViewById(R.id.zyxq);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view_dialog = LayoutInflater.from(getContext()).inflate(R.layout.ty_list_dialog, null, false);
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                ListView listView = view_dialog.findViewById(R.id.list_ty);
                List_Ty_Adapter adapter = new List_Ty_Adapter(getContext(), obj_calculator);
                listView.setAdapter(adapter);
                builder.setView(view_dialog);
                builder.show();

            }
        });
        grid_xg = view.findViewById(R.id.grid_xg);
        Grid_xg xg = new Grid_xg(getContext());
        grid_xg.setAdapter(xg);
        grid_xg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("Range")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (obj_calculator.jl != null)
                    flag_pop2 = obj_calculator.jl - 1;
                Scroll2 = flag_pop2;
                Scroll1 = 0;
                Dp_Px dp_px = new Dp_Px();
                BaseActivity activity = (BaseActivity) getActivity();
                int hi = (int) (activity.getHeight() * 0.45);
                Recy_pop pop = null, pop2 = null;
                View popupView = getLayoutInflater().inflate(R.layout.pop_bj, null);
                TextView qr, qx;
                qr = popupView.findViewById(R.id.qr);
                qx = popupView.findViewById(R.id.qx);
                TextView t1 = popupView.findViewById(R.id.textViewRight), t2 = popupView.findViewById(R.id.textViewLeft);
                RecyclerView recy_1 = popupView.findViewById(R.id.recy_1);
                RecyclerView recy_2 = popupView.findViewById(R.id.recy_2);
                hi2 = dp_px.dip2px(getContext(), 36);
                switch (position) {
                    case 0:
                        WqSQLite sqLite1 = new WqSQLite(getContext(), "wq.bd", null, 1);
                        SQLiteDatabase database_wq = sqLite1.getWritableDatabase();
                        Cursor cursor_wq = database_wq.query("js", new String[]{"name", "rarity"}, "weapontype=?", new String[]{obj_calculator.wq_lx}, null, null, null, null);
                        cursor_wq.moveToFirst();
                        List<String> wqname = new ArrayList<>();
                        for (int a = 0; a < cursor_wq.getCount(); a++) {
                            int b = cursor_wq.getInt(cursor_wq.getColumnIndex("rarity"));
                            if (b > 2) {
                                String name = cursor_wq.getString(cursor_wq.getColumnIndex("name"));
                                wqname.add(name);
                                if (name.equals(obj_calculator.WqName))
                                    Scroll1 = wqname.size() - 1;
                                else
                                    Log.d("TAG", name + "," + obj_calculator.WqName);
                            }
                            cursor_wq.moveToNext();
                        }
                        cursor_wq.close();
                        database_wq.close();
                        sqLite1.close();
                        pop = new Recy_pop(getContext(), (int) (hi / 6 * 5 / 2) - dp_px.dip2px(getContext(), 21), (int) (hi / 6 * 5 / 2) + dp_px.dip2px(getContext(), 17), wqname);
                        pop2 = new Recy_pop(getContext(), (int) (hi / 6 * 5 / 2) - dp_px.dip2px(getContext(), 21), (int) (hi / 6 * 5 / 2) + dp_px.dip2px(getContext(), 17), new String[]{"精炼一阶", "精炼二阶", "精炼三阶", "精炼四阶", "精炼五阶"});
                        flag_pop = 1;
                        break;
                    case 1:
                        String[] mz = new String[]{"0命", "1命", "2命", "3命", "4命", "5命", "6命"};
                        pop = new Recy_pop(getContext(), (int) (hi / 6 * 5 / 2) - dp_px.dip2px(getContext(), 21), (int) (hi / 6 * 5 / 2) + dp_px.dip2px(getContext(), 17), mz);
                        Scroll1 = obj_calculator.getMz();
                        break;
                    case 2:
                        recy_2.setVisibility(View.GONE);
                        t1.setVisibility(View.GONE);
                        TextView ts = popupView.findViewById(R.id.text_4jt);
                        ts.setVisibility(View.VISIBLE);
                        Switch sw = popupView.findViewById(R.id.switch1);
                        sw.setVisibility(View.VISIBLE);
                        Sywxq sywxq = new Sywxq(getContext(), "sywxc.bd", null, 1);
                        SQLiteDatabase database = sywxq.getWritableDatabase();
                        Cursor cursor = database.query("mytable", new String[]{"name"}, "star=5", null, null, null, null, null);
                        String[] syw_data = new String[cursor.getCount()];
                        cursor.moveToFirst();
                        for (int a = 0; a < cursor.getCount(); a++) {
                            syw_data[a] = cursor.getString(cursor.getColumnIndex("name"));
                            cursor.moveToNext();
                        }
                        cursor.close();
                        database.close();
                        sywxq.close();
                        pop = new Recy_pop(getContext(), (int) (hi / 6 * 5 / 2) - dp_px.dip2px(getContext(), 21), (int) (hi / 6 * 5 / 2) + dp_px.dip2px(getContext(), 17), syw_data);
                        pop2 = new Recy_pop(getContext(), (int) (hi / 6 * 5 / 2) - dp_px.dip2px(getContext(), 21), (int) (hi / 6 * 5 / 2) + dp_px.dip2px(getContext(), 17), syw_data);
                        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (!isChecked) {
                                    recy_2.setVisibility(View.GONE);
                                    t1.setVisibility(View.GONE);
                                } else {
                                    recy_2.setVisibility(View.VISIBLE);
                                    t1.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                        break;
                }
                PopupWindow popupWindow = new PopupWindow(getContext());
// 设置宽度和高度
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);

                popupWindow.setHeight(hi);
// 设置要显示的内容视图
                LinearSnapHelper mid_1 = new LinearSnapHelper();
                LinearSnapHelper mid_2 = new LinearSnapHelper();
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                recy_1.setLayoutManager(manager);
                LinearLayoutManager manager2 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                recy_2.setLayoutManager(manager2);
                recy_1.setAdapter(pop);
                recy_1.smoothScrollBy(0, Scroll1 * hi2);
                recy_2.setAdapter(pop2);
                recy_2.smoothScrollBy(0, Scroll2 * hi2);
                if (pop.getWqname() != null)
                    l = pop.getWqname().size();
                else
                    l = pop.getData().length;
                if (pop2 != null)
                    l2 = pop2.getData().length;
                if (pop != null)
                    pop.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Scroll1 = manager.findLastVisibleItemPosition() - 2;
                            if (Scroll1 + 2 == l + 1) {
                                int b = manager.findFirstVisibleItemPosition();
                                Scroll1 = b + 6;
                            }
                            if (position + 2 > Scroll1) {
                                recy_1.smoothScrollBy(0, hi2 * ((position + 2) - Scroll1));

                            } else if (position + 2 < Scroll1) {
                                recy_1.smoothScrollBy(0, -hi2 * (Scroll1 - (position + 2)));

                            }

                        }
                    });
                if (pop2 != null)
                    pop2.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            if (flag_pop == 1) {
                                View view2 = mid_2.findSnapView(manager2);
                                TextView t2 = view2.findViewById(R.id.name);
                                int a = zh(t2.getText().toString());
                                if (a > position) {
                                    recy_2.smoothScrollBy(0, -hi2 * (a - position));
                                } else recy_2.smoothScrollBy(0, hi2 * (position - a));
                                Log.d("TAG", a + "," + position);
                                return;
                            }
                            Scroll2 = manager2.findLastVisibleItemPosition() - 2;
                            if (Scroll2 + 2 == l2 + 1) {
                                int b = manager2.findFirstVisibleItemPosition();
                                Toast.makeText(activity, "" + b, Toast.LENGTH_SHORT).show();
                                if (b == 0)
                                    return;
                                Scroll2 = b + 6;
                            }

                            if (position + 2 > Scroll2) {
                                recy_2.smoothScrollBy(0, hi2 * ((position + 2) - Scroll2));
                            } else if (position + 2 < Scroll2) {
                                recy_2.smoothScrollBy(0, -hi2 * (Scroll2 - (position + 2)));
                            }
                        }
                    });
                if (pop2 == null) {
                    recy_2.setVisibility(View.GONE);
                    t1.setVisibility(View.GONE);
                }
                mid_1.attachToRecyclerView(recy_1);
                mid_2.attachToRecyclerView(recy_2);
                qr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        String r2 = null, r1 = null;
                        View view1 = mid_1.findSnapView(manager);
                        TextView t1 = view1.findViewById(R.id.name);
                        if (recy_2.getVisibility() == View.VISIBLE) {
                            View view2 = mid_2.findSnapView(manager2);
                            TextView t2 = view2.findViewById(R.id.name);
                            r2 = t2.getText().toString();
                        }
                        th.setVisibility(View.VISIBLE);
                        r1 = t1.getText().toString();
                        switch (position) {
                            case 0:
                                Log.d("TAG", t1.getText().toString() + "," + r2);
                                wq = t1.getText().toString();
                                jl = r2;
                                Retrofit retrofit = new Retrofit.Builder()
                                        //设置网络请求BaseUrl地址
                                        .baseUrl("https://api.minigg.cn/")
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build();
                               HttpbinServer httpbinServer = retrofit.create(HttpbinServer.class);
                                Call<Detail_Wq> cs = httpbinServer.getwq_base(wq,null,"90");
                                cs.enqueue(new Callback<Detail_Wq>() {
                                    @Override
                                    public void onResponse(Call<Detail_Wq> call, Response<Detail_Wq> response) {
                                      Log.d("TAGCs",response.body().specialized+"");
                                        obj_calculator.CutWeapon(wq, zh(jl)-1,response.body());
                                        sxsh();
                                    }

                                    @Override
                                    public void onFailure(Call<Detail_Wq> call, Throwable t) {

                                    }
                                });
                                break;
                            case 1:
                                int mz = Integer.parseInt(r1.substring(0, 1));
                                if (mz == obj_calculator.getMz())
                                    return;
                                obj_calculator.setMz(mz);
                                sxsh();
                                mzname = mz + "命";

                                break;
                            case 2:
                               Log.d("TAGS",r1+","+r2);
                                List<String> syw_hz = new ArrayList<>();
                                syw_hz.add(r1);
                                syw1=r1+"4";
                                if (r2!=null){
                                    syw_hz.add(r2);
                                    if (r1.equals(r2))
                                        syw1=r1+"2";
                                    else syw1=r1+"2"+","+r2+"2";
                                }
                                obj_calculator.setSyw_hz(syw_hz);
                                obj_calculator.syw_j=1;
                                obj_calculator.syw_fj=1;
                                sxsh();
                                break;
                        }
                        String ths = "替换为：";

                        if (wq != null)
                            ths += wq + jl;
                        if (mzname != null)
                            ths += mzname;
                        if (syw1!=null)
                            ths+=syw1;
                        if (!ths.equals("替换为："))
                            th.setText(ths);

                    }
                });
                qx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });


                popupWindow.setContentView(popupView);
// 设置动画效果
                popupWindow.setAnimationStyle(R.style.PopupAnimation);

// 设置点击外部可以关闭弹出窗口
                popupWindow.setFocusable(true);
                popupWindow.setOutsideTouchable(true);
// 显示弹出窗口
                popupWindow.showAtLocation(getActivity().getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);

            }
        });
        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (obj_calculator.reversal())
                    sxsh();
            }
        });
        return view;
    }

    private void sxsh() {
        sh_data2 = obj_calculator.csh();
        grid_2 = new Sh_grid(sh_data2, getContext());
        grid_sh_2.setNumColumns(sh_data2.size());
        grid_sh_2.setAdapter(grid_2);
        grid_sh_2.setVisibility(View.VISIBLE);
    }

    @Override
    public void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    Message message = new Message();
                    handler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    private void Gilde(ImageView view, String url) {
        Glide.with(this)
                .load(url)
                .into(view);
    }

    public void sx() {
        if (adater == null)
            return;
        adapter.setObj_calculator(obj_calculator);
        adapter.notifyDataSetChanged();
        adater.setObj_calculator(obj_calculator);
        adater.notifyDataSetChanged();
        grid_adapter.setObj_calculator(obj_calculator);
        grid_adapter.notifyDataSetChanged();
        sh_data = obj_calculator.csh();
        sh_grid.setNumColumns(sh_data.size());
        grid.setData(sh_data);
        grid.notifyDataSetChanged();
    }

    public int zh(String jl) {
        switch (jl) {
            case "精炼一阶":
                return 1;
            case "精炼二阶":
                return 2;
            case "精炼三阶":
                return 3;
            case "精炼四阶":
                return 4;
            case "精炼五阶":
                return 5;
        }
        return 0;
    }
}
