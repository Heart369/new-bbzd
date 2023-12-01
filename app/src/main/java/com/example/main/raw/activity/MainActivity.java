package com.example.main.raw.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.transition.ChangeBounds;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.disklrucache.DiskLruCache;
import com.example.main.R;
import com.example.main.mvvm.sqlite.Calculator_CSV;
import com.example.main.mvvm.sqlite.Sywpf_CSV;
import com.example.main.raw.Adpter.MainAdapter;
import com.example.main.raw.Class_Custom.Bq_gson;
import com.example.main.raw.Class_Custom.gx;
import com.example.main.raw.Class_Custom.time;
import com.example.main.raw.Class_Custom.wh.Ys_bk_Csh;
import com.example.main.raw.Class_Custom.wh.Ys_bk_wq;
import com.example.main.raw.DataClass.Bqdata;
import com.example.main.raw.DataClass.CghData;
import com.example.main.raw.DataClass.Userxx;
import com.example.main.raw.DataClass.WordData;
import com.example.main.raw.DsAlgorithm.MiHoYoAbstractSign;
import com.example.main.raw.DsAlgorithm.Sign;
import com.example.main.raw.JsonPares.bianqian;
import com.example.main.raw.JsonPares.jsonbq;
import com.example.main.raw.JsonPares.jsongr;
import com.example.main.raw.SQLite.ConfigSQLite;
import com.example.main.raw.Sh_js.GifCSV;
import com.example.main.raw.Sh_js.insertDataFromCSV;
import com.example.main.raw.Sh_js.insertDataFromCSV1;
import com.example.main.raw.Zdyclass.Csh;
import com.example.main.raw.Zdyclass.MyViewPager;
import com.example.main.raw.interface_.MainActivity_exit;
import com.example.main.raw.server.AlarmBroadcastReceiver;
import com.example.main.raw.server.MyService;
import com.example.main.raw.utils.DeviceIdUtils;
import com.example.main.raw.ys_bk.IcondataFormCSV;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends Activity implements View.OnClickListener {
    public static String DeviceId;
    public final Handler mhandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    String sz = (String) msg.obj;
                    json(sz, msg.what);
                    break;
                case 2:
                    String sz1 = (String) msg.obj;
                    json(sz1, msg.what);
                    break;
                case 3:
                    time  time=new time();
                    Toast.makeText(context, "签到成功", Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                    preferences.edit().putString("rq", time.getDay()).apply();
                    break;
                case 4:
                    Toast.makeText(context, "旅行者,你已经签到过了", Toast.LENGTH_SHORT).show();
                      time=new time();
                     preferences = getSharedPreferences("data", MODE_PRIVATE);
                    preferences.edit().putString("rq", time.getDay()).apply();
                    break;
                case 5:
                    Toast.makeText(context, "签到失败", Toast.LENGTH_SHORT).show();

            }

        }
    };
    private MyViewPager viewPager;
    private LinearLayout layout1, layout2, layout3;
    private ArrayList<View> pageview;
    private TextView videoLayout;
    private TextView musicLayout;
    Context context;
    int width;
    int anim_flag = 5;
    private TextView wwgLayout;
    view1_Activity view1_activity = new view1_Activity();
    view2_Activity view2_activity = new view2_Activity();
    view3_Activity view3_activity = new view3_Activity(mhandler);
    // 滚动条初始偏移量
    private int offset = 0;
    // 当前页编号
    private int currIndex = 0;
    //一倍滚动量
    private int one;
    private ImageView img_1, img_2, img_3;
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREFS_KEY_FIRST_LAUNCH = "first_launch";


    @SuppressLint({"Range", "ClickableViewAccessibility"})
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        videoLayout = (TextView) findViewById(R.id.t1);
        musicLayout = (TextView) findViewById(R.id.t2);
        wwgLayout = (TextView) findViewById(R.id.t3);
        layout1 = findViewById(R.id.llt_1);
        layout2 = findViewById(R.id.llt_2);
        layout3 = findViewById(R.id.llt_3);
        img_1 = findViewById(R.id.i1);
        img_2 = findViewById(R.id.i2);
        img_3 = findViewById(R.id.i3);
        context = this;

       DeviceId= DeviceIdUtils.getDeviceId(this);
        //透明状态栏
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
        ConfigSQLite sqLite=new ConfigSQLite(this,"Config.bd" +
                "",null,1);
        SQLiteDatabase database=sqLite.getReadableDatabase();
        String[] s=new String[]{"1","1","1","0"};
        ContentValues values = new ContentValues();
        for (int c=0;c<s.length;c++){
            values.put("id", c);
            values.put("ischeck", s[c]);
            database.insert("config", null, values);

        }
        database.close();
        //在此校验程序是否为第一次启动
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Ys_bk_Csh csh=new Ys_bk_Csh(context);
        Ys_bk_wq wq=new Ys_bk_wq(context);
        wq.start();
        csh.start();
        if (prefs.getBoolean(PREFS_KEY_FIRST_LAUNCH, true)) {
            // 应用程序是第一次启动
            prefs.edit().putBoolean(PREFS_KEY_FIRST_LAUNCH, false).commit();
            Log.d("TAG", "第一次启动");

            // 在这里添加你需要执行的操作
        } else {
            // 应用程序不是第一次启动
            // 在这里添加你需要执行的操作

        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                IcondataFormCSV icondataFormCSV = new IcondataFormCSV(context);
                icondataFormCSV.insertDataFromCSV();
                GifCSV csv = new GifCSV(context);
                csv.setsqlite();
                insertDataFromCSV1 mj = new insertDataFromCSV1(context);
                mj.setsqlite();
                insertDataFromCSV csv2 = new insertDataFromCSV(context);
                csv2.setsqlite();
                Csh csh = new Csh(context);
                csh.insertDataFromCSV();
                Calculator_CSV cal = new Calculator_CSV(context);
                cal.setsqlite();
                Sywpf_CSV csv1=new Sywpf_CSV(context);
                csv1.setsqlite();
            }
        }).start();

        LayoutInflater inflater = getLayoutInflater();
        //查找布局文件用LayoutInflater.inflate
        View view1 = inflater.inflate(R.layout.activity_view1, null);
        View view2 = inflater.inflate(R.layout.activity_view2, null);
        View view3 = inflater.inflate(R.layout.activity_view3, null);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        pageview = new ArrayList<View>();
        //添加想要切换的界面
        pageview.add(view1);
        pageview.add(view2);
        pageview.add(view3);
        MainAdapter mPagerAdapter=new MainAdapter(pageview);
        //绑定适配器
        viewPager.setAdapter(mPagerAdapter);
        //设置viewPager的初始界面为第一个界面
        viewPager.setCurrentItem(0);
        //添加切换界面的监听器
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //将当前窗口的一些信息放在DisplayMetrics类中
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //得到屏幕的宽度
        view1_activity.csh(view1, this, viewPager, this, mhandler, new MainActivity_exit() {
            @Override
            public void exit() {
                view3_activity.nologincsh(view3,MainActivity.this);
            }
        });
        view2_activity.csh(view2, this);
        view3_activity.nologincsh(view3, this);
        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
        String cookie = preferences.getString("cookie", "");
        Log.d("COOKIE",cookie);
        String uid = preferences.getString("uid", "");
        Log.d("UID",uid);
        getWindow().setSharedElementEnterTransition(new ChangeBounds());
        getWindow().setSharedElementReturnTransition(new ChangeBounds());
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        width = metric.widthPixels;     // 屏幕宽度（像素）
        setserver();
        time time = new time();
        ConfigSQLite sqLite1=new ConfigSQLite(context,"Config.bd",null,1);
        SQLiteDatabase databases=sqLite1.getReadableDatabase();
        Cursor cursor=databases.query("config",new String[]{"ischeck"},"id=?",new String[]{"3"},null,null,null);
        cursor.moveToFirst();
        if (cursor.getString(cursor.getColumnIndex("ischeck")).equals("0"))
        if (preferences.getString("rq", "").length()==0) {
            preferences.edit().putString("rq", time.getDay()+"123").apply();
        } else if (!preferences.getString("rq", "").equals(time.getDay())){
            if (uid .length()>2)
                qd(cookie, uid);
        }
        cursor.close();
        databases.close();
    }

    private void qd(String cookie, String uid) {
        Sign sign=new Sign(cookie,uid,mhandler);
        sign.sign();


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createtz() {

        String id = "channel_1";//channel的id
        String description = "123";//channel的描述信息
        int importance = NotificationManager.IMPORTANCE_HIGH;//channel的重要性
        NotificationChannel channel = new NotificationChannel(id, "123", importance);//生成channel
//为channel添加属性
//channel.enableVibration(true); 震动
//channel.enableLights(true);提示灯
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);//添加channel
        Notification notification = new Notification.Builder(MainActivity.this, id)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("树脂溢出提示")
                .setContentText("您的树脂已达到160请及时清理")
                .setAutoCancel(true)
                .build();
        manager.notify(1, notification);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setnz(int sz) {
        sz = 160 - sz;
        sz = sz * 7 * 60 * 1000;
        if (sz < 0)
            return;
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long firstTime = SystemClock.elapsedRealtime();    // 开机之后到现在的运行时间(包括睡眠时间)
        Intent intentMorning = new Intent(this, AlarmBroadcastReceiver.class);
        intentMorning.setAction("CLOCK_IN");
        String pack = getPackageName() + ".server.AlarmBroadcastReceiver";
        //   intentMorning.addFlags(FLAG_INCLUDE_STOPPED_PACKAGES);
        intentMorning.setClassName(MainActivity.this, pack);
        //获取到PendingIntent的意图对象
        PendingIntent piMorning = PendingIntent.getBroadcast(this, 0, intentMorning, PendingIntent.FLAG_IMMUTABLE);     //设置事件
        Log.d("TAG", "设置时间为" + sz);
        manager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + sz, piMorning); //提交事件，发送给 广播接收器
        Log.d("TAG", "123");
    }


    public void setserver() {

        gx gx = new gx(this, width);
        gx.jcgx();
        Intent intent;
        intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);
        Message message = new Message();
        message.obj = mhandler;
        message.what = 0;
        MyService.handler.sendMessage(message);
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            currIndex = arg0;
            switch (currIndex) {
                case 0:
                    //点击"视频“时切换到第一页
                    musicLayout.setTextColor(0xFF696969);
                    videoLayout.setTextColor(0xFF5BBCFD);
                    wwgLayout.setTextColor(0xFF696969);
                    img_1.setImageResource(R.drawable.os_pm4);
                    img_2.setImageResource(R.drawable.os_pm2);
                    img_3.setImageResource(R.drawable.os_pm3);
                    view1_activity.jcc();
                    if (anim_flag != 0)
                        view1_activity.setanim();
                    anim_flag = 0;
                    break;
                case 1:
                    //点击“音乐”时切换的第二页
                    musicLayout.setTextColor(0xFF5BBCFD);
                    videoLayout.setTextColor(0xFF696969);
                    wwgLayout.setTextColor(0xFF696969);
                    img_1.setImageResource(R.drawable.os_pm);
                    img_2.setImageResource(R.drawable.os_pm5);
                    img_3.setImageResource(R.drawable.os_pm3);
                    view1_activity.hf();
                    if (anim_flag != 1)
                        view2_activity.setanim();
                    anim_flag = 1;
                    break;
                case 2:
                    musicLayout.setTextColor(0xFF696969);
                    videoLayout.setTextColor(0xFF696969);
                    wwgLayout.setTextColor(0xFF5BBCFD);
                    img_1.setImageResource(R.drawable.os_pm);
                    img_2.setImageResource(R.drawable.os_pm2);
                    img_3.setImageResource(R.drawable.os_pm6);
                    view1_activity.hf();
                    break;
            }

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llt_1:
                //点击"视频“时切换到第一页
                viewPager.setCurrentItem(0);
                musicLayout.setTextColor(0xFF696969);
                videoLayout.setTextColor(0xFF5BBCFD);
                wwgLayout.setTextColor(0xFF696969);
                img_1.setImageResource(R.drawable.os_pm4);
                img_2.setImageResource(R.drawable.os_pm2);
                img_3.setImageResource(R.drawable.os_pm3);
                if (anim_flag != 0)
                    view1_activity.setanim();
                anim_flag = 0;
                break;
            case R.id.llt_2:
                //点击“音乐”时切换的第二页
                viewPager.setCurrentItem(1);
                musicLayout.setTextColor(0xFF5BBCFD);
                videoLayout.setTextColor(0xFF696969);
                wwgLayout.setTextColor(0xFF696969);
                img_1.setImageResource(R.drawable.os_pm);
                img_2.setImageResource(R.drawable.os_pm5);
                img_3.setImageResource(R.drawable.os_pm3);
                if (anim_flag != 1)
                    view2_activity.setanim();
                anim_flag = 1;
                break;
            case R.id.llt_3:
                viewPager.setCurrentItem(2);
                musicLayout.setTextColor(0xFF696969);
                videoLayout.setTextColor(0xFF696969);
                wwgLayout.setTextColor(0xFF5BBCFD);
                img_1.setImageResource(R.drawable.os_pm);
                img_2.setImageResource(R.drawable.os_pm2);
                img_3.setImageResource(R.drawable.os_pm6);
                anim_flag = 0;
                break;
        }
    }

    public void json(String data, int i) {
        jsonbq jsonbq;
        switch (i) {
            case 1:
                if (data.equals("NO")) {
                    Log.d("TAG789", "调用");
                    view1_activity.mw();
                    view3_activity.cshbq(null);
                } else {
                    Log.d("TAGBQ",data);
                    Gson gson=new Gson();
                    Bq_gson bq_gson=gson.fromJson(data,Bq_gson.class);
                    if (bq_gson.retcode == 1034){
                        view1_activity.jc();
                    }
                    else if (bq_gson.data==null){
                        view1_activity.login();
                    }
                    else
                        {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && bq_gson.data.current_resin == 160) {
                                createtz();
                            } else setnz( bq_gson.data.current_resin);
                            view1_activity.sx(bq_gson);
                        }

                    if (bq_gson.message.equals("OK"))
                        view3_activity.cshbq(bq_gson);
                    else if (bq_gson.retcode == 1034)
                        view3_activity.cshbq(bq_gson);
                }
                break;
            case 2:
                if (data.equals("NO"))
                    ;
                else {
                    Userxx user = null;
                    jsongr jsongrxx = new jsongr();
                    user = jsongrxx.grxx(data);
                    String[] jsxx;
                    jsxx = jsongrxx.jsxx(data);
                    CghData cgh;
                    cgh = jsongrxx.cgh(data);
                    List<WordData> word;
                    word = jsongrxx.jxword(data);
                    if (user.getMessage().equals("OK"))
                        view3_activity.cshuser(user, jsxx, cgh, word);
                }


        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.start, R.anim.back);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onRestart() {
        super.onRestart();
        view3_activity.nologincsh(pageview.get(2), this);
    }

    int a = 0;

    @Override
    public void onBackPressed() {
        if (view1_activity.iscbl()) {
            view1_activity.closscbl();
        } else
            super.onBackPressed();
    }
}
