package com.example.main.raw.ys_bk;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.main.raw.Adpter.Grid_bk;
import com.example.main.raw.Adpter.Recy_Bk_main;
import com.example.main.raw.Class_Custom.Lucency;
import com.example.main.raw.Class_Custom.Recy_item_jj;
import com.example.main.raw.JsonPares.jsdata;
import com.example.main.raw.JsonPares.wq;
import com.example.main.R;
import com.example.main.raw.SQLite.MidSQLite;
import com.example.main.raw.SQLite.WqSQLite;
import com.example.main.raw.Sh_js.insertDataFromCSV;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RequiresApi(api = Build.VERSION_CODES.N)
@SuppressLint("Range")
public class Js_xq_Activity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    int s = 0;
    SQLiteDatabase database_js, database_wq;
    ViewPager viewPager;
    Grid_bk grid_bk;
    RelativeLayout r2, r3;
    int statusBarHeight1 = -1, cz = 0, cz2 = 0;
    int width, height, tool, he, flag_jz = 0, flag_click = 0, flag_view = 0, flag_click2 = 0, flag_sx = 0, flag_recy = 0, flag_anim = 0;
    ImageView back;
    RelativeLayout.LayoutParams lp;
    RecyclerView recyclerView;
    frmt_recy frmt_js;
    EditText editText;
    ImageView image_sx;
    GridView gridView;
    String[] sxt = new String[]{"1", "1", "1"};
    String[] jcsx = new String[]{"风元素", "岩元素", "雷元素", "草元素", "水元素", "火元素", "冰元素"};
    int[] sx = new int[]{R.drawable.ys_f, R.drawable.ys_y, R.drawable.ys_l, R.drawable.ys_c, R.drawable.ys_s, R.drawable.ys_h, R.drawable.ys_b};
    int[] image = new int[]{R.drawable.js_bk, R.drawable.wq_bk, R.drawable.syw_bk, R.drawable.mj_bk, R.drawable.mj_bk};
    String[] name = new String[]{"角色", "武器", "圣遗物", "秘境", "占位"};
    int[] jl = new int[]{-1, -1, -1};
    TextView sx_1, sx_2, sx_3;
    View view;
    LinearLayout cx, sx_lin;
    Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    flag_jz++;
                    if (flag_jz == 2) {
                        r2.setVisibility(View.GONE);
                        setviewpager();
                    }
                    break;
                case 1:
                    toolbar.setVisibility(View.GONE);
                    break;
                case 2:
                    toolbar.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_xq2);
        Lucency lucency = new Lucency();
        lucency.light(this);
        bindid();
        getcs();
        setbl();
        MidSQLite sqLite = new MidSQLite(this, "js.db", null, 1);
        database_js = sqLite.getWritableDatabase();
        WqSQLite sqLite1 = new WqSQLite(this, "wq.bd", null, 1);
        database_wq = sqLite1.getWritableDatabase();
        Cursor cursor = database_js.query("js", new String[]{"name"}, null, null, null, null, null, null);
        Cursor cursor2 = database_wq.query("js", new String[]{"name"}, null, null, null, null, null, null);
        setviewpager();
        Log.d("TAG", tool + "," + height * 0.3 + "," + toolbar.getHeight());
    }

    private void setbl() {
        RelativeLayout.LayoutParams pi = (RelativeLayout.LayoutParams) back.getLayoutParams();
        pi.height = (int) (height * 0.3);
        pi = (RelativeLayout.LayoutParams) r3.getLayoutParams();
        pi.height = (int) (height * 0.3);
        pi = (RelativeLayout.LayoutParams) view.getLayoutParams();
        pi.height = statusBarHeight1;
        pi = (RelativeLayout.LayoutParams) toolbar.getLayoutParams();
        pi.height = (int) (height * 0.3 * 0.22);
        tool = (int) ((int) height * 0.3 - (int) (height * 0.3 * 0.27) - statusBarHeight1);
        he = (int) (height * 0.3 * 0.27) + statusBarHeight1;


    }

    private void getcs() {
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);
        }
        Log.d("TAG", statusBarHeight1 + "");
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        width = metric.widthPixels;     // 屏幕宽度（像素）
        height = metric.heightPixels;   // 屏幕高度（像素）
        Log.d("TAG", tool + "");

    }

    private void setviewpager() {
        frmt_js = new frmt_recy(tool, this, database_js, database_wq, handler, new frmt_recy.Scroll() {
            @Override
            public int scroll(int y) {
                float af = recyclerView.getHeight();
                if (y < af / 3) {
                    recyclerView.setVisibility(View.VISIBLE);
                    recyclerView.setAlpha((af / 3 - y) / (af / 3));
                    flag_click = 0;
                } else {
                    recyclerView.setAlpha(0f);
                    recyclerView.setVisibility(View.GONE);
                    flag_click = 1;
                }
                int a = (int) (cx.getHeight() * 1.1 * -1);
                int a1 = cx.getHeight();
                int h = (int) (height * 0.3 - he + a);
                if (h < y && h - y > a) {
                    cx.animate().translationY(h - y).setDuration(0);
                    sx_lin.animate().translationY(h - y).setDuration(0);
                } else if (h - y < 0) {
                    cx.animate().translationY(a).setDuration(0);
                    sx_lin.animate().translationY(a).setDuration(0);
                    toolbar.setAlpha(0f);
                    flag_click2 = 3;
                }
                toolbar.setAlpha(((a1 + h - y)) / 110.0f);
                if (h - y > 3) {
                    cx.animate().translationY(0).setDuration(0);
                    sx_lin.animate().translationY(0).setDuration(0);
                    toolbar.setVisibility(View.VISIBLE);
                    toolbar.setAlpha(1f);
                    flag_click2 = 2;
                }
                return 0;

            }
        });
        ArrayList<Fragment> pageview = new ArrayList<>();
        pageview.add(frmt_js);
        viewPager.setAdapter(new viewpager_adapter(getSupportFragmentManager(), pageview));
        viewPager.setCurrentItem(0);
        Recy_Bk_main adapter = new Recy_Bk_main(this, image, name, new Recy_Bk_main.onclick() {
            @Override
            public int onitemclick(int po) {
                if (po == flag_recy)
                    return 0;
                flag_recy = po;
                jl = new int[]{-1, -1, -1};
                flag_sx = 0;
                if (flag_click >= 1)
                    return 0;
                grid_bk.setI(-1);
                editText.setText(null);
                sx_1.setVisibility(View.VISIBLE);
                sx_2.setVisibility(View.VISIBLE);
                sx_3.setVisibility(View.VISIBLE);
                switch (po) {
                    case 0:
                        frmt_js.extracted();
                        flag_view = 0;
                        editText.setHint(new StringBuffer("输入角色名称"));
                        sx_1.setText("元素");
                        sx_2.setText("属地");
                        sx_3.setText("类型");

                        break;
                    case 1:
                        frmt_js.gxwq();
                        flag_view = 1;
                        editText.setHint(new StringBuffer("输入武器名称"));
                        sx_1.setText("星级");
                        sx_2.setText("类型");
                        sx_3.setVisibility(View.GONE);
                        break;
                    case 2:
                        frmt_js.gxsyw();
                        flag_view = 2;
                        editText.setHint(new StringBuffer("输入圣遗物名称"));
                        sx_1.setText("星级");
                        sx_2.setText("类型");
                        sx_3.setVisibility(View.GONE);
                        break;
                }
                return 0;
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(Recy_item_jj.LEFT_DECORATION, 50);
        recyclerView.addItemDecoration(new Recy_item_jj(stringIntegerHashMap));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }



    private void bindid() {
        recyclerView = findViewById(R.id.recy_bk);
        toolbar = findViewById(R.id.toolbar_js_xq);
        lp = (RelativeLayout.LayoutParams) toolbar.getLayoutParams();
        setSupportActionBar(toolbar);
        cx = findViewById(R.id.cx);
        sx_lin = findViewById(R.id.sx);
        sx_lin.setVisibility(View.GONE);
        image_sx = findViewById(R.id.iamge_sx);
        image_sx.setOnClickListener(this);
        back = findViewById(R.id.back_bk);
        view = findViewById(R.id.zw);
        setTitle(null);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag_click2 == 3)
                    return;
                finish();
                overridePendingTransition(R.anim.back, R.anim.closs);
                s = 1;
            }
        });
        viewPager = findViewById(R.id.viewpager_js);
        r2 = findViewById(R.id.r2);
        r2.setVisibility(View.GONE);
        r3 = findViewById(R.id.r3);
        editText = findViewById(R.id.edit_user_bk);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("TAG", "tag2" + "," + s + "," + start + "," + count);
                frmt_js.Query(flag_view, s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        gridView = findViewById(R.id.grid_sx);
        grid_bk = new Grid_bk(jcsx, sx, this, new Grid_bk.getClick() {
            @Override
            public void getname(String name) {

            }
        });
        gridView.setAdapter(grid_bk);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < parent.getChildCount(); i++) {
                    View childView = parent.getChildAt(i);

                    CardView cardView = childView.findViewById(R.id.card_bk);
                    if (position == i) {
                        // 设置当前Item的背景
                        if (jl[flag_sx] == position) {
                            cardView.setCardBackgroundColor(0xFFFFFFFF);
                            jl[flag_sx] = -1;
                        } else {
                            jl[flag_sx] = position;
                            Log.d("TAG", jl[0] + "");
                            cardView.setCardBackgroundColor(0xFFF3EC74);
                            TextView textView = childView.findViewById(R.id.text_bk);
                            String str = textView.getText().toString();
                            str = str.replaceAll(" ", "");
                            if (str.contains("星"))
                                switch (str) {
                                    case "一星":
                                        str = "1";
                                        break;
                                    case "二星":
                                        str = "2";
                                        break;
                                    case "三星":
                                        str = "3";
                                        break;
                                    case "四星":
                                        str = "4";
                                        break;
                                    case "五星":
                                        str = "5";
                                        break;
                                }
                            switch (flag_sx) {
                                case 0:
                                    if (str.contains("元素")) {
                                        Log.d("TAG", str);
                                        sxt[0] = str.substring(0, 1);
                                        Log.d("TAG", sxt[0]);
                                        break;
                                    }
                                    sxt[0] = str;
                                    break;
                                case 1:
                                    sxt[1] = str;
                                    break;
                                case 2:
                                    sxt[2] = str;
                                    break;
                            }

                        }
                        setgrid();
                    } else {
                        // 恢复其他Item的背景
                        cardView.setCardBackgroundColor(0xFFFFFFFF);
                    }
                }
            }
        });
        sx_1 = findViewById(R.id.sx_1);
        sx_2 = findViewById(R.id.sx_2);
        sx_3 = findViewById(R.id.sx_3);
        sx_1.setOnClickListener(this);

        sx_2.setOnClickListener(this);
        sx_3.setOnClickListener(this);
    }

    private void setgrid() {
        for (int i = 0; i < jl.length; i++) {
            if (jl[i] == -1)
                sxt[i] = "";
        }
        switch (flag_view) {
            case 0:
                String a = "";
                frmt_js.Query_sx("SELECT * FROM js WHERE (element LIKE '%" + sxt[0] + "%' AND region LIKE '%" + sxt[1] + "%' AND weapontype LIKE '%" + sxt[2] + "%');", 0);
                break;
            case 1:
                frmt_js.Query_sx("SELECT * FROM js WHERE (rarity LIKE '%" + sxt[0] + "%' AND weapontype LIKE '%" + sxt[1] + "%');", 1);
                break;
            case 2:
                frmt_js.Query_sx("SELECT * FROM mytable WHERE (star LIKE '%" + sxt[0] + "%' AND TAG LIKE '%" + sxt[1] + "%');", 2);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (s == 0) {
            overridePendingTransition(R.anim.start, R.anim.back);
        }
        s = 0;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        s = 1;
        overridePendingTransition(R.anim.back, R.anim.closs);
    }

    @Override
    public void onClick(View v) {
        String[] s;
        sx_1.setTextColor(0xFFFFFFFF);
        sx_2.setTextColor(0xFFFFFFFF);
        sx_3.setTextColor(0xFFFFFFFF);

        switch (v.getId()) {

            case R.id.sx_1:
                grid_bk.setImage(getimage(1));
                grid_bk.setName(getname(1));
                grid_bk.setI(jl[0]);
                grid_bk.notifyDataSetChanged();
                Log.d("TAG", "" + jl[0]);
                flag_sx = 0;
                sx_1.setTextColor(0xFF5278FF);
                break;
            case R.id.sx_2:
                grid_bk.setImage(getimage(2));
                grid_bk.setName(getname(2));
                grid_bk.setI(jl[1]);
                grid_bk.notifyDataSetChanged();
                sx_2.setTextColor(0xFF5278FF);
                flag_sx = 1;
                break;
            case R.id.sx_3:
                grid_bk.setImage(getimage(3));
                grid_bk.setName(getname(3));
                grid_bk.setI(jl[2]);
                grid_bk.notifyDataSetChanged();
                flag_sx = 2;
                sx_3.setTextColor(0xFF5278FF);
                break;
            case R.id.iamge_sx:
                if (flag_anim == 0) {
                    image_sx.setImageResource(R.drawable.sx_dj);
                    sx_1.setTextColor(0xFF5278FF);
                    if (sx_lin.getVisibility() == View.GONE) {
                        sx_lin.setVisibility(View.VISIBLE);
                        TranslateAnimation translate = new TranslateAnimation(0, 0, -300f, 0);
                        translate.setDuration(500);
                        translate.setFillAfter(true);
// 定义透明度动画
                        AlphaAnimation alpha = new AlphaAnimation(0, 1);
                        alpha.setDuration(500);
                        alpha.setFillAfter(true);
// 组合动画
                        AnimationSet set = new AnimationSet(false);
                        set.addAnimation(translate);
                        set.addAnimation(alpha);
// 绑定动画和控件
                        sx_lin.startAnimation(set);
                    }
                    sx_lin.animate().translationX(0).setDuration(500);
                    flag_anim = 1;
                } else {
                    image_sx.setImageResource(R.drawable.sx);
                    flag_anim = 0;
                    Random random = new Random();
                    if (random.nextDouble() > 0.5)
                        sx_lin.animate().translationX(sx_lin.getWidth()).setDuration(500);
                    else sx_lin.animate().translationX(sx_lin.getWidth() * -1).setDuration(500);
                }

                grid_bk.setImage(getimage(1));
                grid_bk.setName(getname(1));
                grid_bk.setI(jl[0]);
                grid_bk.notifyDataSetChanged();

                break;
        }
    }

    private int[] getimage(int i) {
        int[] a_1 = new int[]{R.drawable.md, R.drawable.liyue, R.drawable.jp, R.drawable.xmi};
        int[] a_2 = new int[]{R.drawable.wq_dsj, R.drawable.wq_dj, R.drawable.wq_fq, R.drawable.wq_gj, R.drawable.wq_cb};
        int[] b_1 = new int[]{R.drawable.xx, R.drawable.icon_2, R.drawable.icon_3, R.drawable.icon_4, R.drawable.icon_5};
        int[] c_1 = new int[]{R.drawable.icon_3, R.drawable.icon_4, R.drawable.icon_5};
        int[] c_2 = new int[]{R.drawable.xx, R.drawable.wq_dj, R.drawable.icon_3, R.drawable.icon_4, R.drawable.icon_5};
        switch (flag_view) {
            case 0:
                switch (i) {
                    case 1:
                        return sx;
                    case 2:
                        return a_1;
                    case 3:
                        return a_2;
                }
                break;
            case 1:
                switch (i) {
                    case 1:
                        return b_1;
                    case 2:
                        return a_2;
                }
                break;
            case 2:
                switch (i) {
                    case 1:
                        return c_1;
                    case 2:
                        return c_2;
                }
        }
        return null;
    }

    private String[] getname(int i) {
        String[] a1 = new String[]{"蒙德", "璃月", "稻妻", "须弥"};
        String[] a2 = new String[]{"单手剑", "双手剑", "法器", "弓", "长柄武器"};
        String[] b1 = new String[]{"一星", "二星", "三星", "四星", "五星"};
        String[] c1 = new String[]{"三星", "四星", "五星"};
        String[] c2 = new String[]{"增伤", "治疗", "抗性", "充能", "防御"};
        switch (flag_view) {
            case 0:
                switch (i) {
                    case 1:
                        return jcsx;
                    case 2:
                        return a1;
                    case 3:
                        return a2;
                }
                break;
            case 1:
                switch (i) {
                    case 1:
                        return b1;
                    case 2:
                        return a2;
                }
                break;
            case 2:
                switch (i) {
                    case 1:
                        return c1;
                    case 2:
                        return c2;
                }

        }
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database_js.close();
        database_wq.close();
    }
}