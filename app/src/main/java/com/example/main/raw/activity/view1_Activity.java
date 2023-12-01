package com.example.main.raw.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.ChangeBounds;
import android.util.Log;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.webkit.CookieManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.main.R;
import com.example.main.raw.Adpter.bianqianAdpter;
import com.example.main.raw.Class_Custom.Bq_gson;
import com.example.main.raw.Class_Custom.Dp_Px;
import com.example.main.raw.Class_Custom.Share;
import com.example.main.raw.Class_Custom.Th;
import com.example.main.raw.Class_Custom.gx;
import com.example.main.raw.Class_Custom.time;
import com.example.main.raw.Menu_Activity.Gy_Activity;
import com.example.main.raw.Menu_Activity.Set_Activity;
import com.example.main.raw.ScZs.ClmainActivity;
import com.example.main.raw.DataClass.Bqdata;
import com.example.main.raw.Zdyclass.MyListView;
import com.example.main.raw.JsonPares.bianqian;
import com.example.main.raw.Zdyclass.MyViewPager;
import com.example.main.raw.interface_.MainActivity_exit;
import com.example.main.raw.server.MyService;
import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.engine.CropEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class view1_Activity extends AppCompatActivity {
    TextView text_week;
    TextView text_year;
    ImageView text_bbzd;
    boolean b = true;
    ImageView tx;
    View fj;
    DrawerLayout drawerLayout;
    ScrollView scrollView;
    RelativeLayout relativeLayout;
    SwipeRefreshLayout pull;
    boolean flag_wl = true;
    boolean flag_sx = false;
    int[] layout = {R.layout.new_bq, R.layout.cailiao_item, R.layout.cailiao_item, R.layout.cailiao_item, R.layout.cailiao_item, R.layout.cailiao_item};
    List<Bqdata> bqdata = new ArrayList<>();
    MyListView listView;
    NavigationView nav;
    Context context;
    Bq_gson bq_gson;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void csh(View view, Context context, MyViewPager viewPager, Activity activity, Handler handler, MainActivity_exit exit) {
        this.context = context;
        Bqdata bqdata1 = new Bqdata("数据获取中", "数据获取中", null, null, null, null, null, null);
        bqdata.add(bqdata1);
        initData();
        fj=view.findViewById(R.id.fj_viwe);
        fj.setVisibility(View.GONE);
        time time = new time();
        String timedata = time.getWeek();
        TextView day = view.findViewById(R.id.xq);
        TextView month = view.findViewById(R.id.year);
        String timemonth = time.getMonth();
        timemonth += time.getDay();
        nav = view.findViewById(R.id.navigation_view);
        TextView t = nav.getHeaderView(0).findViewById(R.id.version);
        try {
            t.setText("版本号:" + gx.getVersionName(context));
        } catch (Exception e) {
            e.printStackTrace();
        }
        scrollView = view.findViewById(R.id.view1_scr);
        drawerLayout = view.findViewById(R.id.draw);
        pull = view.findViewById(R.id.pu);
        day.setText(timedata);
        tx=view.findViewById(R.id.image_tx);
        File cropFile = new File(context.getCacheDir(), "crop_tx.jpg");
        if (cropFile.exists()) {
            // 读取文件，并进行后续处理
            Bitmap bitmap = BitmapFactory.decodeFile(cropFile.getAbsolutePath());
            Glide.with(context).load(bitmap).transform(new RoundedCorners(1000)).into(tx);
            // 进行文件的上传、保存等操作
        } else {
            // 文件不存在或无法访问，处理错误
            Glide.with(context).load(R.drawable.md_zy_kl).transform(new RoundedCorners(1000)).into(tx);
        }

        text_week = view.findViewById(R.id.xq);
        text_year = view.findViewById(R.id.year);
        relativeLayout = view.findViewById(R.id.re);
        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","cscscscsc");
                PictureSelector.create(context)
                .openGallery(SelectMimeType.ofImage())
                .setImageEngine(new GlideEngine())
                .setCropEngine(new CropEngine() {
                    @Override
                    public void onStartCrop(Fragment fragment, LocalMedia currentLocalMedia, ArrayList<LocalMedia> dataSource, int requestCode) {
                        Glide.with(fragment)
                                .asBitmap()
                                .load(currentLocalMedia.getAvailablePath())
                                .into(new SimpleTarget<Bitmap>() {
                                    @Override
                                    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
                                        // 在这里获取到转换后的Bitmap对象
                                        Uri uri= Share.shareImageToQQ(bitmap,context);
                                        String fileName = "crop_tx" + ".jpg";
                                        File cropFile = new File(context.getCacheDir(), fileName);
                                        Uri destinationUri = Uri.fromFile(cropFile);
                                        Dp_Px dp_px=new Dp_Px();
                                        int a=dp_px.dip2px(context,70);
                                        UCrop.of(uri, destinationUri)
                                                .withAspectRatio(1, 1)
                                                .withMaxResultSize(a, a)
                                                .start(context,fragment,requestCode);
                                        // 进行裁剪操作或其他处理
                                    }
                                });
                    }
                }).setMaxSelectNum(1)
                .forResult(new OnResultCallbackListener<LocalMedia>() {
                    @Override
                    public void onResult(ArrayList<LocalMedia> result) {
                        if (cropFile.exists()) {
                            // 读取文件，并进行后续处理
                            Bitmap bitmap = BitmapFactory.decodeFile(cropFile.getAbsolutePath());
                            Glide.with(context).load(bitmap).transform(new RoundedCorners(1000)).into(tx);
                            // 进行文件的上传、保存等操作
                        } else {
                            // 文件不存在或无法访问，处理错误
                            Glide.with(context).load(R.drawable.md_zy_kl).transform(new RoundedCorners(1000)).into(tx);
                        }
                    }

                    @Override
                    public void onCancel() {

                    }
                });
            }
        });
        month.setText(timemonth);
        text_bbzd = view.findViewById(R.id.bbzd);
        listView = view.findViewById(R.id.list_home);
        setAdpter();
        pull.setColorSchemeColors(Color.parseColor("#ff0000"), Color.parseColor("#00ff00"));
        pull.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Intent intent = new Intent(context, MyService.class);
                context.startService(intent);
                flag_sx = true;

            }
        });

        text_bbzd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_bbzd.animate().rotation(90);
                if (b) {
                    drawerLayout.openDrawer(GravityCompat.START);
                    Log.d("TAG", "tc");

                } else {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                b = !b;
            }
        });


        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                b = false;
                text_bbzd.animate().rotation(90);
                viewPager.setPagingEnabled(false);

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                b = true;
                text_bbzd.animate().rotation(0);
                viewPager.setPagingEnabled(true);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        viewPager.setCurrentItem(2);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        Intent intent = new Intent(context, ClmainActivity.class);
                        context.startActivity(intent);
                        break;
                }

            }
        });
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.gyrj:
                        RelativeLayout re = nav.getHeaderView(0).findViewById(R.id.bbzd_re);
                        String transitionName = "shareNames";
                        re.setTransitionName(transitionName);
                        Intent intent = new Intent(context, Gy_Activity.class);
                        Pair<View, String> pair = Pair.create(re, "shareNames");
                        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pair);
                        context.startActivity(intent, activityOptions.toBundle());
                        break;
                    case R.id.set1:
                        intent = new Intent(context, Set_Activity.class);
                        context.startActivity(intent);
                        break;
                    case R.id.tc:
                        activity.finish();
                        break;
                    case R.id.qh:
                        SharedPreferences preferences = context.getSharedPreferences("data", MODE_PRIVATE);
                        String uid = preferences.getString("uid", "");
                        if (uid.length()<1)
                            Toast.makeText(context, "请先登录账号", Toast.LENGTH_SHORT).show();
                        else {
                            intent=new Intent(context,LoginActivity.class);
                            context.startActivity(intent);
                        }
                        break;
                    case R.id.tcdl:
                        preferences = context.getSharedPreferences("data", MODE_PRIVATE);
                        uid = preferences.getString("uid", "");
                        if (uid.length()<1)
                            Toast.makeText(context, "请先登录账号", Toast.LENGTH_SHORT).show();
                        else {
                            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor=context.getSharedPreferences("data",MODE_PRIVATE).edit();
                            editor.putString("uid",null);
                            editor.putString("server",null);
                            editor.putString("name",null);
                            editor.putString("level",null);
                            editor.putString("server_name",null);
                            editor.commit();
                            CookieManager.getInstance().removeAllCookies(null);
                            CookieManager.getInstance().flush();
                            Th t = new Th(handler,"12334","https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/dailyNote?role_id="+"111"+"&server="+"cff","123","123",1);
                            t.start();
                            exit.exit();
                        }
                        break;
                    case R.id.sys:
                        new IntentIntegrator(activity)
                                .setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES)// 扫码的类型,可选：一维码，二维码，一/二维码
                                .setPrompt("此功能暂无具体用途")// 设置提示语
                                .setCameraId(0)// 选择摄像头,可使用前置或者后置
                                .setBeepEnabled(false)// 是否开启声音,扫完码之后会"哔"的一声
                                .setBarcodeImageEnabled(true)// 扫完码之后生成二维码的图片
                                .setRequestCode(123)
                                .setCaptureActivity(SmActivity.class)
                                .initiateScan();// 初始化扫码
                        break;
                }
                return true;
            }
        });
        ImageView image = view.findViewById(R.id.title);
        Dp_Px dp_px = new Dp_Px();
        int px = dp_px.dip2px(context, 95);
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY <= 0) {
                    relativeLayout.setBackgroundColor(Color.argb((int) 0, 91, 188, 253));
                    text_week.setTextColor(Color.argb((int) 0, 255, 255, 255));
                    text_year.setTextColor(Color.argb((int) 0, 255, 255, 255));
                    fj.setVisibility(View.GONE);
                } else if (scrollY > 0 && scrollY <= px) {
                    float scale = (float) scrollY / px;
                    float alpha = (255 * scale);
                    relativeLayout.setBackgroundColor(Color.argb((int) alpha, 91, 188, 253));
                    text_week.setTextColor(Color.argb((int) alpha, 255, 255, 255));
                    text_year.setTextColor(Color.argb((int) alpha, 255, 255, 255));
                    fj.setVisibility(View.GONE);
                } else {
                    relativeLayout.setBackgroundColor(Color.argb((int) 255, 91, 188, 253));
                    text_week.setTextColor(Color.argb((int) 255, 255, 255, 255));
                    text_year.setTextColor(Color.argb((int) 255, 255, 255, 255));
                    fj.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    public void hf() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }


    public void setAdpter() {
        bianqianAdpter bqAdpter = new bianqianAdpter(bqdata, layout, context,bq_gson);
        listView.setAdapter(bqAdpter);
    }

    private void initData() {
        time time = new time();
        String week = time.getWeek();
        String hour = time.getHour();
        Log.d("TAG", hour);
        if (hour.equals("00") || hour.equals("01") || hour.equals("02") || hour.equals("03"))
            switch (week) {
                case "周一":
                    week = "周日";
                    break;
                case "周二":
                    week = "周一";
                    break;
                case "周三":
                    week = "周二";
                    break;
                case "周四":
                    week = "周三";
                    break;
                case "周五":
                    week = "周四";
                    break;
                case "周六":
                    week = "周五";
                    break;
                case "周日":
                    week = "周六";
                    break;

            }
        Log.d("TAG", time.getHour());
        Log.d("R", week);
        switch (week) {
            case "周一":
            case "周四":
            case "Mo":
                Bqdata mddata = new Bqdata("自由的哲学", "高塔孤王的碎梦", "蒙德今日素材", R.drawable.md, R.drawable.md_zy, R.drawable.md_sm);
                Bqdata lydata = new Bqdata("繁荣的哲学", "孤光寒林的神体", "璃月今日素材", R.drawable.liyue, R.drawable.ly_ql, R.drawable.ly_st);
                Bqdata dqdata = new Bqdata("浮世的哲学", "远海夷地的金枝", "稻妻今日素材", R.drawable.jp, R.drawable.jp_fs, R.drawable.jp_jz);
                Bqdata xmdata = new Bqdata("净言的哲学", "谧林涓露的金符", "须弥今日素材", R.drawable.xmi, R.drawable.xm_jy, R.drawable.xm_jf);
                Bqdata fddata = new Bqdata("公平的哲学", "悠古弦音的回响", "枫丹今日素材", R.drawable.fd, R.drawable.fd_zy, R.drawable.fd_zy_wq);
                bqdata.add(mddata);
                bqdata.add(lydata);
                bqdata.add(dqdata);
                bqdata.add(xmdata);
                bqdata.add(fddata);
                break;
            case "周二":
            case "周五":
                Bqdata mddata1 = new Bqdata("抗争的哲学", "凛风奔狼的怀乡", "蒙德今日素材", R.drawable.md, R.drawable.md_kz, R.drawable.md_hx);
                Bqdata lydata1 = new Bqdata("勤劳的哲学", "雾海云间的转还", "璃月今日素材", R.drawable.liyue, R.drawable.ly_ft, R.drawable.ly_zh);
                Bqdata dqdata1 = new Bqdata("风雅的哲学", "鸣神御灵的勇武", "稻妻今日素材", R.drawable.jp, R.drawable.jp_fr, R.drawable.dq_yw);
                Bqdata xmdata1 = new Bqdata("巧思的哲学", "绿洲花园的真谛", "须弥今日素材", R.drawable.xmi, R.drawable.xm_dx, R.drawable.xm_zd);
                 fddata = new Bqdata("正义的哲学", "纯圣露滴的真粹", "枫丹今日素材", R.drawable.fd, R.drawable.fd_ze, R.drawable.fd_ze_wq);
                bqdata.add(mddata1);
                bqdata.add(lydata1);
                bqdata.add(dqdata1);
                bqdata.add(xmdata1);
                bqdata.add(fddata);
                break;
            case "周三":
            case "周六":

                Bqdata mddata2 = new Bqdata("诗文的哲学", "狮牙斗士的理想", "蒙德今日素材", R.drawable.md, R.drawable.md_sw, R.drawable.md_lx);
                Bqdata lydata2 = new Bqdata("黄金的哲学", "漆黑陨铁的一块", "璃月今日素材", R.drawable.liyue, R.drawable.ly_hj, R.drawable.ly_yt);
                Bqdata dqdata2 = new Bqdata("天光的哲学", "今昔剧画之鬼人", "稻妻今日素材", R.drawable.jp, R.drawable.dq_tg, R.drawable.dq_gr);
                Bqdata xmdata2 = new Bqdata("笃行的哲学", "烈日权威的旧日", "须弥今日素材", R.drawable.xmi, R.drawable.xm_ddx, R.drawable.xm_lr);
                fddata = new Bqdata("秩序的哲学", "无垢之海的金杯", "枫丹今日素材", R.drawable.fd, R.drawable.fd_zs, R.drawable.fd_zs_wq);
                bqdata.add(fddata);
                bqdata.add(mddata2);
                bqdata.add(lydata2);
                bqdata.add(dqdata2);
                bqdata.add(xmdata2);
                break;
            case "周日":
                Bqdata mddata3 = new Bqdata("想刷啥刷啥", "想刷啥刷啥", "蒙德今日素材", R.drawable.md, R.drawable.os_pm5, R.drawable.os_pm5);
                Bqdata lydata3 = new Bqdata("想刷啥刷啥", "想刷啥刷啥", "璃月今日素材", R.drawable.liyue, R.drawable.os_pm5, R.drawable.os_pm5);
                Bqdata dqdata3 = new Bqdata("想刷啥刷啥", "想刷啥刷啥", "稻妻今日素材", R.drawable.jp, R.drawable.os_pm5, R.drawable.os_pm5);
                Bqdata xmdata3 = new Bqdata("想刷啥刷啥", "想刷啥刷啥", "须弥今日素材", R.drawable.xmi, R.drawable.os_pm5, R.drawable.os_pm5);
                fddata = new Bqdata("想刷啥刷啥", "想刷啥刷啥", "枫丹今日素材", R.drawable.fd, R.drawable.os_pm5, R.drawable.os_pm5);
                bqdata.add(mddata3);
                bqdata.add(lydata3);
                bqdata.add(dqdata3);
                bqdata.add(xmdata3);
                bqdata.add(fddata);
                break;
        }

    }

    public Bqdata sx(Bq_gson bq) {
        if (flag_sx)
            pull.setRefreshing(false);
        if (bq.message.equals("OK")) {
            if (flag_sx) {
                Toast.makeText(context, "刷新成功", Toast.LENGTH_SHORT).show();
                flag_sx = false;
            }
//            String sz, pq, sznum, mr, pqnum, dtbq, zb, zby;
//            Double d = Double.valueOf(bq.getResin_recovery_time());
//            int a = (int) Math.ceil(d);
//            int b = a / 3600;
//            int c = a / 60 % 60;
//            if (bq.getCurrent_resin() < 160)
//                sz = "剩余时间" + b + "小时" + c + "分钟";
//            else sz = "已经溢出啦ovo";
//            if (bq.getCurrent_expedition_num() == 0)
//                pq = "派遣已完成";
//            else pq = "还有" + bq.getCurrent_expedition_num() + "位伙伴未完成";
//            sznum = bq.getCurrent_resin() + "/160";
//            mr = bq.getFinished_task_num() + "/4";
//            pqnum = bq.getCurrent_expedition_num() + "/" + bq.getMax_expedition_num();
//            dtbq = bq.getCurrent_home_coin() + "/" + bq.getMax_home_coin();
//            zb = bq.getRemain_resin_discount_num() + "/3";
//            if (bq.getObtained())
//                if (bq.getDay() == 0)
//                    zby = "已就绪";
//                else zby = "还差" + bq.getDay() + "天";
//            else zby = "未获得质变仪";
            this.bq_gson=bq;
            Bqdata data1 = new Bqdata();
            bqdata.set(0, data1);
            setAdpter();
            return data1;


        } else {
            if (flag_sx)
                pull.setRefreshing(false);
            if (flag_sx || flag_wl)
                Toast.makeText(context, "请登录账号", Toast.LENGTH_SHORT).show();
            flag_sx = false;
            flag_wl = !flag_wl;
            Bqdata data1 = new Bqdata("账号过期请重新登录", "账号过期请重新登录", null, null, null, null, null, null);
            bqdata.set(0, data1);
            bq_gson=null;
            setAdpter();
            return data1;
        }


    }
    public void login() {
        if (flag_sx)
            pull.setRefreshing(false);
        if (flag_sx || flag_wl)
            Toast.makeText(context, "请登录账号", Toast.LENGTH_SHORT).show();
        flag_sx = false;
        flag_wl = !flag_wl;
        Bqdata data1 = new Bqdata("账号过期请重新登录", "账号过期请重新登录", null, null, null, null, null, null);
        bqdata.set(0, data1);
        bq_gson=null;
        setAdpter();
    }

    public void mw() {
        if (flag_sx)
            pull.setRefreshing(false);
        if (flag_sx || flag_wl)
            Toast.makeText(context, "检查网络连接", Toast.LENGTH_SHORT).show();
        flag_sx = false;
        flag_wl = !flag_wl;
        bqdata.set(0, new Bqdata("请检查网络连接", "请检查网络连接", null, null, null, null, null, null));
        bq_gson=null;
        setAdpter();
    }

    public void jc() {
        if (flag_sx)
            pull.setRefreshing(false);
        if (flag_sx || flag_wl)
            Toast.makeText(context, "被检测啦", Toast.LENGTH_SHORT).show();
        flag_sx = false;
        flag_wl = !flag_wl;
        bq_gson=null;
        bqdata.set(0, new Bqdata("被米游社检测请前往米游社通过验证", "被米游社检测请前往米游社通过验证", null, null, null, null, null, null));
        setAdpter();
    }

    public void setanim() {
        Animation animation;
        scrollView.scrollTo(0, 0);
        LayoutAnimationController controller;
        animation = new ScaleAnimation(0f, 1f, 0f, 1f, listView.getWidth() / 2f, -200f);
        animation.setDuration(250);
        controller = new LayoutAnimationController(animation, 0.3f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        listView.setLayoutAnimation(controller);
        listView.startLayoutAnimation();
        listView.startLayoutAnimation();
    }

    public void jcc() {
        setAdpter();
    }

    public boolean iscbl() {
        return drawerLayout.isDrawerOpen(GravityCompat.START);
    }

    public void closscbl() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
