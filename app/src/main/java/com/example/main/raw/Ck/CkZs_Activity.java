package com.example.main.raw.Ck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.main.raw.Adpter.Fragment_Adpter;
import com.example.main.raw.Class_Custom.Share;
import com.example.main.raw.DataClass.CkData;
import com.example.main.raw.JsonPares.JsonCk;
import com.example.main.R;
import com.example.main.raw.SQLite.CkSQLite;
import com.example.main.raw.Zdyclass.MyListView;
import com.example.main.raw.activity.JsXq_Activity;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dev.utils.app.CapturePictureUtils;
import dev.utils.app.ScreenshotUtils;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CkZs_Activity extends AppCompatActivity {
    int flag_gb = 0;
    private Handler mhandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (flag_f < 3)
                        getData(flag_f);
                    else
                        Zs();
                    textView.setText("已获取完毕解析中");
                    break;
                case 2:
                    String CZ;
                    if (flag_f == 0)
                        CZ = "角色池";
                    else if (flag_f == 1)
                        CZ = "武器池";
                    else
                        CZ = "常驻池";
                    int age = page * 20;
                    textView.setText("正在获取" + CZ + "第" + page + "页" + "已经获取" + age + "抽");
            }

        }
    };

    Toolbar toolbar1;
    String URL;
    String url;
    TabLayout toolbar;
    LottieAnimationView lottie;
    ViewPager viewPager;
    String data;
    String end_id;
    int page;
    int flag_f;
    MyListView listView;
    int jsq = 0;
    int[] size = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};//0-3up池武器角色武器角色，4-7武器角色武器武器 8-12武器角色武器角色武器
    List<String> five = new ArrayList<>();
    List<Integer> list_jsq = new ArrayList<>();
    TextView textView, textView_zs;
    List<Integer> sy = new ArrayList<>();
    List<Integer> list_size = new ArrayList<>();
    ImageView image;
    Intent intent;
    CkSQLite sqLite = new CkSQLite(this, "ck.db", null, 1);
    SQLiteDatabase database;
    String[] flag = new String[]{"301", "302", "200"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ck_zs);
        database = sqLite.getWritableDatabase();
        Intent intent = getIntent();
        this.intent = intent;
        textView = findViewById(R.id.ts);
        lottie = findViewById(R.id.progr);
        toolbar1 = findViewById(R.id.toolbar_ck_zs);
        setSupportActionBar(toolbar1);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back, R.anim.closs);
            }
        });
        setTitle(null);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int option = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            window.getDecorView().setSystemUiVisibility(option);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        URL = intent.getStringExtra("url");
        flag_f = 0;
        String post = intent.getStringExtra("post");
        if (post == null)
            getData(flag_f);
        else
            getHistory(post);
    }

    @SuppressLint("Range")
    private void getHistory(String post) {
        Cursor cursor = database.query("ck", new String[]{"uid", "size", "five", "sy", "jsq"}, "uid=?",
                new String[]{post}, null, null, null);
        if (cursor.getCount() == 0)
            textView.setVisibility(View.VISIBLE);
        Log.d("TAG", "已进入");
        cursor.moveToNext();
        String uid_h = cursor.getString(cursor.getColumnIndex("uid"));
        String size_h = cursor.getString(cursor.getColumnIndex("size"));
        String five_h = cursor.getString(cursor.getColumnIndex("five"));
        String sy_h = cursor.getString(cursor.getColumnIndex("sy"));
        String jsq_h = cursor.getString(cursor.getColumnIndex("jsq"));
        try {
            JSONArray jsonArray = new JSONArray(size_h);
            for (int a = 0; a < size.length; a++) {
                size[a] = (int) jsonArray.get(a);
            }
            jsonArray = new JSONArray(five_h);
            for (int a = 0; a < jsonArray.length(); a++) {
                five.add((String) jsonArray.get(a));
            }
            jsonArray = new JSONArray(sy_h);
            for (int a = 0; a < jsonArray.length(); a++) {
                sy.add((int) jsonArray.get(a));
            }
            jsonArray = new JSONArray(jsq_h);
            for (int a = 0; a < jsonArray.length(); a++) {
                list_jsq.add((int) jsonArray.get(a));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        cj();

    }

    private void getData(int s) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                end_id = "0";
                Message message = new Message();
                for (page = 1; page < 200; page++) {
                    if (flag_gb == 1)
                        return;
                    message = new Message();
                    message.what = 2;
                    if (mhandler != null)
                        mhandler.sendMessage(message);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    OkHttpClient httpClient = new OkHttpClient();
                    getUrl(end_id, page, flag[flag_f]);
                    Request getRequest = new Request.Builder()
                            .url(url)
                            .get()
                            .build();
                    Call call = httpClient.newCall(getRequest);
                    data = call.toString();
                    Response response = null;
                    try {
                        response = call.execute();
                        data = response.body().string();
                        Log.d("TAG", data);
                        if (data.length() < 110) {
//                               List<CkData> ck=null;
//                               Ckdata.add(ck);
                            break;
                        }
                        JsonCk jsonCk = new JsonCk(data);
                        List<CkData> ckData = jsonCk.jx();
//                           Ckdata.add(ckData);
                        jxdata(ckData);
                        end_id = ckData.get(ckData.size() - 1).getId();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                message = new Message();
                message.what = 1;
                flag_f++;
                sy.add(jsq);
                jsq = 0;
                if (mhandler != null)
                    mhandler.sendMessage(message);
            }
        }).start();

    }

    private void getUrl(String end_id, int page, String flag) {
        url = URL.replaceAll("(" + "page" + "=[^&]*)", "page" + "=" + page);
        url = url.replaceAll("(" + "end_id" + "=[^&]*)", "end_id" + "=" + end_id);
        url = url.replaceAll("(" + "gacha_type" + "=[^&]*)", "gacha_type" + "=" + flag);

    }

    private void jxdata(List<CkData> ckData) {
        for (int f = 0; f < ckData.size(); f++) {
            CkData ckData1 = ckData.get(f);
            jsq++;
            String x = ckData1.getRank_type();
            String name = ckData1.getName();
            String lx = ckData1.getItem_type();
            //0-3up池武器角色武器角色，4-7武器角色武器武器 8-12武器角色武器角色武器
            switch (flag_f) {
                case 0://up池
                    switch (lx) {
                        case "武器":
                            if (x.equals("3"))
                                size[0] += 1;
                            else if (x.equals("4"))
                                size[2] += 1;
                            break;
                        case "角色":
                            if (x.equals("4"))
                                size[1] += 1;
                            else if (x.equals("5")) {
                                size[3] += 1;
                                list_jsq.add(jsq);
                                five.add(name);
                                jsq = 0;
                            }
                            break;
                    }
                    break;
                case 1://武器池
                    switch (lx) {
                        case "武器":
                            if (x.equals("3"))
                                size[4] += 1;
                            else if (x.equals("4"))
                                size[6] += 1;
                            else {
                                size[7] += 1;
                                list_jsq.add(jsq);
                                five.add(name);
                                jsq = 0;
                            }
                            break;
                        case "角色":
                            size[5] += 1;
                            break;
                    }
                    break;
                case 2://常驻
                    switch (lx) {
                        case "角色":
                            if (x.equals("4"))
                                size[9] += 1;
                            else {
                                size[11] += 1;
                                five.add(name);
                                list_jsq.add(jsq);
                                jsq = 0;
                            }
                            break;
                        case "武器":
                            if (x.equals("3"))
                                size[8] += 1;
                            else if (x.equals("4"))
                                size[10] += 1;
                            else {
                                size[12] += 1;
                                five.add(name);
                                list_jsq.add(jsq);
                                jsq = 0;
                            }
                            break;
                    }


            }

        }
    }

    @SuppressLint("Range")
    private void Zs() {

        int s1;
        int s;
        if (size[3] != 0) {
            s = sy.get(0);
            s1 = list_jsq.get(0);
            sy.set(0, s1 - 1);
            list_jsq.set(0, s + 1);

        }

        if (size[7] != 0) {
            s = sy.get(1);
            s1 = list_jsq.get(size[3]);
            list_jsq.set(size[3], s + 1);
            sy.set(1, s1 - 1);

        }
        if (size[11] != 0 || size[12] != 0) {
            s = sy.get(2);
            s1 = list_jsq.get(size[3] + size[7]);
            list_jsq.set(size[3] + size[7], s + 1);
            sy.set(2, s1 - 1);
        }
        Gson gson = new Gson();
        String five_js = gson.toJson(five);
        String list_jsq_js = gson.toJson(list_jsq);
        String sy_js = gson.toJson(sy);
        String uid = intent.getStringExtra("uid");
        for (int a = 0; a < size.length; a++) {
            list_size.add(size[a]);
        }
        String size_js = gson.toJson(list_size);
        Log.d("TAG", size_js);

        Cursor cursor = database.query("ck", new String[]{"uid"}, null,
                null, null, null, null);
        boolean flag = true;
        while (cursor.moveToNext()) {
            Log.d("TAG", "已进入");
            String uid2 = cursor.getString(cursor.getColumnIndex("uid"));
            if (uid.equals(uid2))
                flag = false;

        }
        if (flag)
            xz(five_js, uid, list_jsq_js, sy_js, size_js, database);
        else
            xg(five_js, uid, list_jsq_js, sy_js, size_js);
        cj();


    }

    public void cj() {
        List<Fragment> fragments = new ArrayList<>();
//        textView.setVisibility(View.GONE);
//        lottie.setVisibility(View.GONE);
        image = findViewById(R.id.image_ck);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        int height = metric.heightPixels;   // 屏幕高度（像素）
        lottie.animate().translationX(width).setDuration(3000);
        image.animate().translationX(width).setDuration(3000);
        textView.animate().translationX(width).setDuration(3000);
        viewPager = findViewById(R.id.ck_viewpager);
        toolbar = findViewById(R.id.ck_toolbar);
        Frament_ck frament_1 = new Frament_ck(sy.get(0), five, list_jsq, size, this, 1);
        Frament_ck frament_2 = new Frament_ck(sy.get(1), five, list_jsq, size, this, 2);
        Frament_ck frament_3 = new Frament_ck(sy.get(2), five, list_jsq, size, this, 3);
        fragments.add(frament_1);
        fragments.add(frament_2);
        fragments.add(frament_3);
        Fragment_Adpter adpter = new Fragment_Adpter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adpter);
        toolbar.setupWithViewPager(viewPager);
    }

    private void xg(String five_js, String uid, String list_jsq_js, String sy_js, String size_js) {
        Log.d("TAG", "进入修改");
        ContentValues values = new ContentValues();
        values.put("uid", uid);
        values.put("size", size_js);
        values.put("five", five_js);
        values.put("sy", sy_js);
        values.put("jsq", list_jsq_js);
        database.update("ck", values, "uid=?", new String[]{uid});

    }

    private void xz(String five_js, String uid, String list_jsq_js, String sy_js, String size_js, SQLiteDatabase database) {
        ContentValues values = new ContentValues();
        values.put("uid", uid);
        values.put("size", size_js);
        values.put("five", five_js);
        values.put("sy", sy_js);
        values.put("jsq", list_jsq_js);

        Log.d("TAG", "完成新建");
        database.insert("ck", null, values);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mhandler = null;
        database.close();
        flag_gb = 1;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back, R.anim.closs);
    }
}