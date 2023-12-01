package com.example.main.raw.ck_mnq;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.main.raw.Adpter.Ck_grid;
import com.example.main.raw.Adpter.recy_ck;
import com.example.main.raw.Class_Custom.Lucency;
import com.example.main.raw.DataClass.Ck_server_class;
import com.example.main.R;

import java.util.List;
@RequiresApi(api = Build.VERSION_CODES.N)
public class Ck_Activity extends AppCompatActivity implements View.OnClickListener, SurfaceHolder.Callback  {
    SurfaceView surfaceView;
    private MediaPlayer mPlayer = null,ypplayer=null;
    private SurfaceHolder surfaceHolder;
    Ck_server_class csdata;
    Ck_server ck_server;
    int xx;
    RecyclerView recy;
    RelativeLayout r1,r2,r3,r4;
    ImageView lss;
    List<Ck_server_class> datacs2;
    int flag_ds=0,jsq=0,tg_flag=0,tg2_flag=0,flag_dg=0,flag_qr=2;
    View hp;
    GridView gridView;
    int a=0;
    ImageView kc1,kc2,kc3,kc4,one,ten,back,kc_1,ct,exit,addys,his_exit;
    ImageView imageView,back_zs,gm,dsj,tb,xx1,xx2,xx3,xx4,xx5,dg,dg_exit,dg_1,dg_2,dg_qr,dg_back_1,dg_back_2,dg_back_3,dg_3;
    TextView tg,ysl,name,tj_t,dg_text,dg_age;
    int flag_kc=1,zs_flag=0;
    LinearLayout yss;
    Context context;

  Handler handler=new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                back_zs.setVisibility(View.VISIBLE);
                back_zs.animate().scaleX(1.6f).scaleY(1.6f).alpha(0.2f).setDuration(400).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                    back_zs.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }else if (msg.what==2){
                imageView.animate().translationX(100).setDuration(300);
                imageView.setColorFilter(new LightingColorFilter(0x00FFFFFF,0));
                gm.setVisibility(View.VISIBLE);
                dsj.setVisibility(View.VISIBLE);
                dsj.setAlpha(0.0f);
                name.setVisibility(View.VISIBLE);
                name.animate().translationX(-100).alpha(1).setDuration(300);
                tb.setVisibility(View.VISIBLE);
                tb.animate().translationX(-100).alpha(1).setDuration(300);
                dsj.animate().alpha(1f).setDuration(400);
                gm.animate().scaleX(1.6f).scaleY(1.6f).alpha(0.2f).setDuration(400).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        gm.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });


            }else {

                Animation animation2 = AnimationUtils.loadAnimation(Ck_Activity.this, R.anim.xx_sf);
                animation2.setRepeatCount(1);
                animation2.setFillAfter(true);
                animation2.setAnimationListener(new anim(1));
                if (a==1){
                    xx1.setAnimation(animation2); xx1.setVisibility(View.VISIBLE);
                }else if (a==2){
                    xx2.setAnimation(animation2);xx2.setVisibility(View.VISIBLE);
                }else if (a==3){
                    xx3.setAnimation(animation2); xx3.setVisibility(View.VISIBLE);
                }else if (a==4){
                    xx4.setAnimation(animation2);  xx4.setVisibility(View.VISIBLE);
                }else if (a==5){
                    xx5.setAnimation(animation2);xx5.setVisibility(View.VISIBLE);
                    a=0;
                }


            }


        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ck);
        bindid();
         ck_server=new Ck_server(1);
         context=this;
        Lucency lucency=new Lucency();
        lucency.light(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        this.getWindow().setAttributes(lp);
        //隐藏标题栏
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
    }

    private void bindid() {
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        int height = metric.heightPixels;   // 屏幕高度（像素）

        surfaceView=findViewById(R.id.sur);
        kc1=findViewById(R.id.kc1);
        kc2=findViewById(R.id.kc2);
        kc3=findViewById(R.id.kc3);
        kc4=findViewById(R.id.kc4);
        one=findViewById(R.id.one_ck);
        ten=findViewById(R.id.ten_ck);
        back=findViewById(R.id.image_back);
        kc_1=findViewById(R.id.kc_1);
        ct=findViewById(R.id.ct);
        exit=findViewById(R.id.exit);
        gridView=findViewById(R.id.his_grid);
        tg=findViewById(R.id.tg);
        tg.setVisibility(View.GONE);
        tg.setClickable(false);
        ysl=findViewById(R.id.ysl);
        addys=findViewById(R.id.addys);
        his_exit=findViewById(R.id.his_exit);
        yss=findViewById(R.id.yss);
        r1=findViewById(R.id.zscq);
        r1.setVisibility(View.GONE);
        r1.setOnClickListener(this);
        r2=findViewById(R.id.r2);
        r2.setVisibility(View.GONE);
        r2.setOnClickListener(this);
        r3=findViewById(R.id.re_his);
        r3.setVisibility(View.GONE);
        r4=findViewById(R.id.dg_back);
        r4.setVisibility(View.GONE);
        name=findViewById(R.id.qym);
        name.setVisibility(View.GONE);
        tb=findViewById(R.id.tb);
        name.setAlpha(0);
        tb.setAlpha(0f);
        dsj=findViewById(R.id.dsj);
        xx1=findViewById(R.id.xx1);
        xx2=findViewById(R.id.xx2);
        xx3=findViewById(R.id.xx3);
        xx4=findViewById(R.id.xx4);
        xx5=findViewById(R.id.xx5);

        xx1.setVisibility(View.GONE);
        xx2.setVisibility(View.GONE);
        xx3.setVisibility(View.GONE);
        xx4.setVisibility(View.GONE);
        xx5.setVisibility(View.GONE);

        tj_t=findViewById(R.id.js);
        lss=findViewById(R.id.history);
        recy=findViewById(R.id.ck_recy);

        dg=findViewById(R.id.dg);
        dg.setVisibility(View.GONE);
        dg_exit=findViewById(R.id.dg_exit);
        dg_1=findViewById(R.id.dg_1);
        dg_2=findViewById(R.id.dg_2);
        dg_1.setOnClickListener(this);
        dg_2.setOnClickListener(this);
        dg_text=findViewById(R.id.dg_name);
        String text = "选择你要定轨的武器";
        dg_text.setText(text);
        dg_qr=findViewById(R.id.dg_qr);
        dg_qr.setOnClickListener(this);
        dg_3=findViewById(R.id.dg_3);
        dg_back_1=findViewById(R.id.dg_1_back);
        dg_back_2=findViewById(R.id.dg_2_back);
        dg_back_3=findViewById(R.id.dg_3_back);
        dg_3.setVisibility(View.GONE);
        dg_back_3.setVisibility(View.GONE);
        dg_age=findViewById(R.id.dg_age);
        dg_age.setVisibility(View.GONE);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) kc_1.getLayoutParams();
        layoutParams.width = (int) (width*0.67);        //设置高度
        layoutParams.height = (int) (height*0.78);
        layoutParams.setMargins((int) (width*0.2),0,0,0);

        layoutParams= (RelativeLayout.LayoutParams) ct.getLayoutParams();
        layoutParams.width = (int) (width*0.046);        //设置高度
        layoutParams.setMargins((int) (width*0.056),0,0,0);

        layoutParams= (RelativeLayout.LayoutParams) one.getLayoutParams();
        layoutParams.width = (int) (width*0.182);        //设置高度
        layoutParams.setMargins(0,0,(int) (width*0.027),(int) (width*0.025));

        layoutParams= (RelativeLayout.LayoutParams) ten.getLayoutParams();
        layoutParams.width = (int) (width*0.182);        //设置高度
        layoutParams.setMargins(0,0,(int) (width*0.067),(int) (width*0.025));

        LinearLayout.LayoutParams   layoutParams2 = (LinearLayout.LayoutParams) kc1.getLayoutParams();
        layoutParams2.width = (int) (width*0.1);        //设置高度
        layoutParams2.height = (int) (height*0.11);
        layoutParams2.setMargins((int) (width*0.026),0,0,(int) (width*0.022));

        layoutParams2 = (LinearLayout.LayoutParams)kc2.getLayoutParams();
        layoutParams2.width = (int) (width*0.1);        //设置高度
        layoutParams2.height = (int) (height*0.11);
        layoutParams2.setMargins((int) (width*0.026),0,0,(int) (width*0.011));

        layoutParams2 = (LinearLayout.LayoutParams) kc3.getLayoutParams();
        layoutParams2.width = (int) (width*0.1);        //设置高度
        layoutParams2.height = (int) (height*0.11);
        layoutParams2.setMargins((int) (width*0.026),(int) (width*0.01),0,0);

        layoutParams2 = (LinearLayout.LayoutParams)kc4.getLayoutParams();
        layoutParams2.width = (int) (width*0.1);        //设置高度
        layoutParams2.height = (int) (height*0.11);
        layoutParams2.setMargins((int) (width*0.026),(int) (width*0.022),0,0);

        layoutParams= (RelativeLayout.LayoutParams) name.getLayoutParams();
        layoutParams.height=(int)(height*0.088);
        layoutParams.setMargins((int) (width*0.128),(int) (height*0.53),0,0);

        layoutParams= (RelativeLayout.LayoutParams) tb.getLayoutParams();
        layoutParams.height=(int)(height*0.088);
        layoutParams.setMargins((int) (width*0.090),(int) (height*0.53),0,0);


        LinearLayout ls=findViewById(R.id.lin_ck);
        layoutParams= (RelativeLayout.LayoutParams) ls.getLayoutParams();
     //   layoutParams.height=(int)(height*0.068);
        layoutParams.setMargins((int) (width*0.075),(int) (height*0.60),0,0);
        layoutParams2= (LinearLayout.LayoutParams) xx1.getLayoutParams();
        layoutParams2.height=(int)(height*0.060);

        layoutParams2= (LinearLayout.LayoutParams) xx2.getLayoutParams();
        layoutParams2.height=(int)(height*0.060);
        layoutParams2= (LinearLayout.LayoutParams) xx3.getLayoutParams();
        layoutParams2.height=(int)(height*0.060);
        layoutParams2= (LinearLayout.LayoutParams) xx4.getLayoutParams();
        layoutParams2.height=(int)(height*0.060);
        layoutParams2= (LinearLayout.LayoutParams) xx5.getLayoutParams();
        layoutParams2.height=(int)(height*0.060);

        layoutParams= (RelativeLayout.LayoutParams) dsj.getLayoutParams();
        layoutParams.height=(int)(height*0.9);


        Glide.with(this)
                .load(R.drawable.kc_8)
                .fitCenter()
                .error(R.drawable.kc_8)
                .transform(new RoundedCorners(6))
                .into(kc_1);
        kc1.setOnClickListener(this);
        kc2.setOnClickListener(this);
        kc3.setOnClickListener(this);
        kc4.setOnClickListener(this);
        one.setOnClickListener(this);
        ten.setOnClickListener(this);
        exit.setOnClickListener(this);
        tg.setOnClickListener(this);
        addys.setOnClickListener(this);
        lss.setOnClickListener(this);
        his_exit.setOnClickListener(this);
        dg.setOnClickListener(this);
        dg_exit.setOnClickListener(this);
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

    }

    private void schsp(int ck_sp_blue) {
        mPlayer = MediaPlayer.create(Ck_Activity.this, ck_sp_blue);
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mPlayer.setDisplay(surfaceHolder);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
      //          extracteds();
                if (flag_ds==1){
                    zsdh(datacs2.get(0));
                }else
                    zsdh(csdata);
                tg_flag=1;
                mPlayer.release();
            }
        });
        Log.d("TAG","12345");
    }

    private void zsdh(Ck_server_class data) {
        tg2_flag=1;
        zs_flag++;
        r1.setVisibility(View.VISIBLE);
        imageView = findViewById(R.id.cscs);
        back_zs = findViewById(R.id.back_cs);
        back_zs.setVisibility(View.GONE);
        gm=findViewById(R.id.gm);
        gm.setVisibility(View.GONE);
        name.setText(data.getName());
        tb.setImageResource(data.getlx());
        xx=data.getStar();
        if (data.getBack()==0){
            dsj.setImageResource(R.drawable.tm_back);
        }else {
            dsj.setImageResource(data.getBack());
        }

        if (data.getImage()!=2){
            imageView.setImageResource(data.getImage());
        }else imageView.setImageResource(R.drawable.ys_1);
        if (ypplayer!=null)
            ypplayer.release();
        if (data.getStar()==3){
            ypplayer= MediaPlayer.create(Ck_Activity.this, R.raw.there_yp);
            ypplayer.start();
            back_zs.setBackgroundResource(R.drawable.back_cs);
            gm.setBackgroundResource(R.drawable.gm);
        }else if (data.getStar()==4){
            back_zs.setBackgroundResource(R.drawable.zg_back_cs);
            ypplayer= MediaPlayer.create(Ck_Activity.this, R.raw.four_ck);
            ypplayer.start();
            gm.setBackgroundResource(R.drawable.zg_back_sw);
        }else {
            ypplayer= MediaPlayer.create(Ck_Activity.this, R.raw.five_yp);
            ypplayer.start();
            back_zs.setBackgroundResource(R.drawable.jg_back_cs);
            gm.setBackgroundResource(R.drawable.jg_back_sw);
        }




        dsj.setVisibility(View.GONE);
        xx1.setVisibility(View.GONE);
        xx2.setVisibility(View.GONE);
        xx3.setVisibility(View.GONE);
        xx4.setVisibility(View.GONE);
        xx5.setVisibility(View.GONE);

        xx1.animate().scaleX(1).scaleY(1).setDuration(10);
        xx2.animate().scaleX(1).scaleY(1).setDuration(10);
        xx3.animate().scaleX(1).scaleY(1).setDuration(10);
        xx4.animate().scaleX(1).scaleY(1).setDuration(10);
        xx5.animate().scaleX(1).scaleY(1).setDuration(10);

        back_zs.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(10);
        gm.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(10);
        imageView.animate().translationX(0).setDuration(0);
        name.animate().translationX(0).alpha(0).setDuration(0);
        tb.animate().translationX(0).alpha(0).setDuration(0);
        dsj.animate().translationX(100).setDuration(0);
        imageView.setColorFilter(new LightingColorFilter(0xFF000000, 0));
        Animation animation = AnimationUtils.loadAnimation(Ck_Activity.this, R.anim.ck_sf);
        animation.setRepeatCount(1);
        animation.setFillAfter(true);
        animation.setAnimationListener(new anim(0));
        imageView.setAnimation(animation);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int s=zs_flag;
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = new Message();
                message.what =1;
                handler.sendMessage(message);
                try {
                    Thread.sleep(1300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (zs_flag==s)
                     setxx(xx);
            }
        }).start();






    }


    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }


    @Override
    public void onClick(View v) {
        TranslateAnimation translateAnimation = new TranslateAnimation(100f,
                0.f, 0, 00.f);
        translateAnimation.setDuration(500);
        translateAnimation.setRepeatMode(Animation.RESTART);
        switch (v.getId()){
            case R.id.kc1:
               if (flag_kc==1)
                   return;
                dg.setVisibility(View.GONE);
                Glide.with(this)
                        .load(R.drawable.kc_8)
                        .fitCenter()
                        .error(R.drawable.kc_8)
                        .transform(new RoundedCorners(6))
                        .into(kc_1);
                kc_1.setAnimation(translateAnimation);

                ck_server.setPool(1);
                flag_kc=1;
                break;
            case R.id.kc2:
                if (flag_kc==2)
                    return;
                dg.setVisibility(View.GONE);
                Glide.with(this)
                        .load(R.drawable.kc_9)
                        .fitCenter()
                        .error(R.drawable.kc_8)
                        .transform(new RoundedCorners(6))
                        .into(kc_1);
                kc_1.setAnimation(translateAnimation);
                flag_kc=2;
                ck_server.setPool(4);
                break;
            case R.id.kc3:
                if (flag_kc==3)
                    return;
                dg.setVisibility(View.VISIBLE);
                dg.setAnimation(translateAnimation);
                Glide.with(this)
                        .load(R.drawable.kc_10)
                        .fitCenter()
                        .error(R.drawable.kc_8)
                        .transform(new RoundedCorners(6))
                        .into(kc_1);
                kc_1.setAnimation(translateAnimation);
                flag_kc=3;
                ck_server.setPool(3);

                break;
            case R.id.kc4:
                if (flag_kc==4)
                    return;
                dg.setVisibility(View.GONE);
                Glide.with(this)
                        .load(R.drawable.kc_4)
                        .fitCenter()
                        .error(R.drawable.kc_8)
                        .transform(new RoundedCorners(6))
                        .into(kc_1);
                kc_1.setAnimation(translateAnimation);
                flag_kc=4;
                ck_server.setPool(2);
                break;
            case R.id.one_ck:
                r4.setVisibility(View.GONE);
                csdata= ck_server.getone();
                flag_ds=0;
               int a=csdata.getStar();
               if (a==3)
                schsp(R.raw.ck_sp_blue);
               else if (a==4)
                   schsp(R.raw.ck_sp_violet);
               else
                   schsp(R.raw.ck_sp_gold);
                mPlayer.start();
                extracted();
                break;
            case R.id.ten_ck:
                r4.setVisibility(View.GONE);
                 datacs2= ck_server.getten();
                flag_ds=1;
                int b=0;
                for (Ck_server_class ss:datacs2) {
                    if (b<ss.getStar())
                        b=ss.getStar();
                }
                if (b==3)
                    schsp(R.raw.ck_sp_blue);
                else if (b==4)
                    schsp(R.raw.ck_sp_violet);
                else
                    schsp(R.raw.ck_sp_gold);
                mPlayer.start();
                extracted();

                break;
            case R.id.exit:
                finish();
                break;
            case R.id.tg:
                if (tg2_flag==1&&flag_ds==1){

                    jw();
                    return;
                }
                if (tg_flag==0){
                    if (flag_ds==1){
                          jw();
//                        zsdh(datacs2.get(0));
                    }else
                        zsdh(csdata);
                    mPlayer.stop();
                    tg_flag=1;
                }else {
                    extracteds();
                    tg_flag=0;
                }

                break;
            case R.id.zscq:
                if(flag_ds==0){
                    extracteds();
                    tg_flag=0;
                    return;
                }
                if (jsq!=10){
                    if (flag_ds==1){
                        zsdh(datacs2.get(jsq));
                        jsq++;
                    }
                }else
                    jw();

                break;
            case R.id.r2:
                extracteds();
                break;
            case R.id.history:
                Ck_grid adapter;
                int tj=0;
                int js=0;
                if (ck_server.getPool()==1||ck_server.getPool()==4){
                    List<Integer> cs= ck_server.getFivecs();
                    List<String>  jsname=ck_server.getFivename();
                   adapter=new Ck_grid(context,jsname,cs);
                    for (int a1:cs)
                       tj+=a1;
                    for (String c:jsname)
                       js++;
                }else if (ck_server.getPool()==3){
                    List<Integer> cs2= ck_server.getWqfivecs();
                    List<String>  jsname2=ck_server.getWqfivename();
                    for (int a1:cs2)
                        tj+=a1;
                    for (String c:jsname2)
                        js++;
                     adapter=new Ck_grid(context,jsname2,cs2);

                }else {
                    List<Integer> cs2= ck_server.getCzfivecs();
                    List<String>  jsname2=ck_server.getCzfivename();
                    for (int a1:cs2)
                        tj+=a1;
                    for (String c:jsname2)
                        js++;
                   adapter=new Ck_grid(context,jsname2,cs2);
                }
                if (tj>0)
                tj_t.setText("共计"+tj+"抽"+"----平均每金"+(tj/js*160)+"原石");
                else tj_t.setText("您还未出金，先去抽取吧(～￣▽￣)～");
                r3.setVisibility(View.VISIBLE);
                gridView.setAdapter(adapter);
                break;
            case R.id.his_exit:
                r3.setVisibility(View.GONE);
                break;
            case R.id.addys:
                final EditText input = new EditText(Ck_Activity.this);
                input.setBackgroundResource(R.drawable.shape_11dp_corners);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                AlertDialog dialoganim;
               dialoganim= new AlertDialog.Builder(Ck_Activity.this)
                        .setTitle("请输入原石数量")
                        .setView(input)
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String text = input.getText().toString();
                                // 获取输入框的内容并进行处理
                                Toast.makeText(Ck_Activity.this, "您输入的数字是：" + text, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                Window window = dialoganim.getWindow();
                window.setWindowAnimations(R.style.dialogWindowAnim3);
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.dimAmount =0f;
                lp.width=800;
                window.setAttributes(lp);
                window.setBackgroundDrawable(getDrawable(R.drawable.shape_19dp));
                break;
            case R.id.dg:
                r4.setVisibility(View.VISIBLE);
                dg_age.setText(ck_server.getCount()+"/"+2);
                break;
            case R.id.dg_exit:
                r4.setVisibility(View.GONE);
                break;
            case R.id.dg_1:
                String text = "为千夜浮梦定轨";
                SpannableString spannableString = new SpannableString(text);
                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED); //设置红色
                spannableString.setSpan(colorSpan, 1, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); //设置前5个字符为红色
                dg_text.setText(spannableString);
                flag_qr=1;
                flag_dg=1;
                break;
            case R.id.dg_2:
                String text1 = "为圣显之钥定轨";
                SpannableString spannableString1 = new SpannableString(text1);
                ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.RED); //设置红色
                spannableString1.setSpan(colorSpan1, 1, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); //设置前5个字符为红色
                dg_text.setText(spannableString1);
                flag_dg=2;
                flag_qr=1;
                break;
            case R.id.dg_qr:
               flag_qr*=-1;
               if (flag_qr*flag_qr==4){
                   Toast.makeText(this, "请先选择您要定轨的武器", Toast.LENGTH_SHORT).show();
                   return;
               }
               if(flag_qr<0){
                   ck_server.setChose(flag_dg);
                   r4.setBackground(getDrawable(R.drawable.dg_back_2));
                   if (flag_dg==1){
                       dg_3.setImageResource(R.drawable.qyfm);
                   }else
                       dg_3.setImageResource(R.drawable.sxzy);
                   dg_3.setVisibility(View.VISIBLE);
                   dg_back_3.setVisibility(View.VISIBLE);
                   dg_1.setVisibility(View.GONE);
                   dg_2.setVisibility(View.GONE);
                   dg_back_1.setVisibility(View.GONE);
                   dg_back_2.setVisibility(View.GONE);
                   dg_text.setVisibility(View.GONE);
                   dg_age.setVisibility(View.VISIBLE);
                   dg_age.setText("0/2");
                   dg_qr.setImageResource(R.drawable.dg_qx);
                   dg.setImageResource(R.drawable.dg_zero);
                   ck_server.setCount(0);
               }else {
                   ck_server.setChose(0);
                   ck_server.setCount(0);
                   r4.setBackground(getDrawable(R.drawable.dg_back));
                   dg_3.setVisibility(View.GONE);
                   dg_back_3.setVisibility(View.GONE);
                   dg_1.setVisibility(View.VISIBLE);
                   dg_2.setVisibility(View.VISIBLE);
                   dg_back_1.setVisibility(View.VISIBLE);
                   dg_back_2.setVisibility(View.VISIBLE);
                   dg_text.setVisibility(View.VISIBLE);
                   dg_age.setVisibility(View.GONE);
                   dg_age.setText("0/2");
                   dg_qr.setImageResource(R.drawable.dg_dj);
                   flag_qr=2;
                   dg.setImageResource(R.drawable.dg_tb);
                   dg_text.setText("选择要定轨的武器");

               }

                break;

        }

    }

    private void extracted() {

        try {
            Thread.sleep(280);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        kc1.setVisibility(View.GONE);
        kc2.setVisibility(View.GONE);
        kc3.setVisibility(View.GONE);
        kc4.setVisibility(View.GONE);
        one.setVisibility(View.GONE);
        ten.setVisibility(View.GONE);
        back.setVisibility(View.GONE);
        kc_1.setVisibility(View.GONE);
        ct.setVisibility(View.GONE);
        yss.setVisibility(View.GONE);
        exit.setVisibility(View.GONE);
        exit.setClickable(false);
        tg.setClickable(true);
        tg.setVisibility(View.VISIBLE);
        lss.setVisibility(View.GONE);
        tg.setAlpha(0f);
        dg.setVisibility(View.GONE);
        tg.animate().alpha(1f).setDuration(4000);
    }
   public void setxx(int x){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int s=zs_flag;
                Message message1=new Message();
                message1.what=3;
                a++;
                if (s!=zs_flag){
                    a=0;
                    return;
                }

                handler.sendMessage(message1);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Message message2=new Message();
                message2.what=3;
                a++;
                if (s!=zs_flag){
                    a=0;
                    return;
                }

                handler.sendMessage(message2);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Message message3=new Message();
                message3.what=3;
                a++;
                if (s!=zs_flag){
                    a=0;
                    return;
                }

                handler.sendMessage(message3);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (x>=4){
                    Message message4=new Message();
                    message4.what=3;
                    a++;
                    if (s!=zs_flag){
                        a=0;
                        return;
                    }
                    handler.sendMessage(message4);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else a=0;


                if (x!=5){
                    a=0;
                    return;
                }

                Message message5=new Message();
                message5.what=3;
                a++;
                if (s!=zs_flag){
                    a=0;
                    return;
                }
                handler.sendMessage(message5);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }

    private void extracteds() {
        tg_flag=0;
        if (tg2_flag==1){
            ypplayer.setOnErrorListener(null);
            ypplayer.setOnInfoListener(null);
            ypplayer.stop();
        }
        tg2_flag=0;
      if (flag_kc==3)
          dg.setVisibility(View.VISIBLE);
        kc1.setVisibility(View.VISIBLE);
        kc2.setVisibility(View.VISIBLE);
        kc3.setVisibility(View.VISIBLE);
        kc4.setVisibility(View.VISIBLE);
        one.setVisibility(View.VISIBLE);
        ten.setVisibility(View.VISIBLE);
        lss.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        kc_1.setVisibility(View.VISIBLE);
        ct.setVisibility(View.VISIBLE);
        exit.setVisibility(View.VISIBLE);
        yss.setVisibility(View.VISIBLE);
        exit.setClickable(true);
        tg.setClickable(false);
        mPlayer.release();
        tg.setVisibility(View.GONE);
        r1.setVisibility(View.GONE);
        r2.setVisibility(View.GONE);
        jsq=1;
        if(ck_server.getCount()==1){
            dg.setImageResource(R.drawable.dg_one);
            r4.setBackground(getDrawable(R.drawable.dg_one_back));
        }else if (ck_server.getCount()==2){
            dg.setImageResource(R.drawable.ys_h);
        }else if (ck_server.getCount()==0&&flag_qr*flag_qr==4){
            dg.setImageResource(R.drawable.dg_tb);
        }else {
            dg.setImageResource(R.drawable.dg_zero);
            r4.setBackground(getDrawable(R.drawable.dg_back_2));
        }

    }
        class anim implements Animation.AnimationListener{
        int s;

            public anim(int s) {
                this.s = s;
            }

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            if (s==0)
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int f=zs_flag;
                        try {
                            Thread.sleep(300);
                            Message message = new Message();
                            message.what=2;
                            if (zs_flag==f)
                            handler.sendMessage(message);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        }


        public void jw(){
            if (tg2_flag==1){
               ypplayer.release();
            }
            ypplayer= MediaPlayer.create(Ck_Activity.this, R.raw.jw_yp);
            ypplayer.start();
        r2.setVisibility(View.VISIBLE);
        Animation animation;
        LayoutAnimationController controller;
            animation = new TranslateAnimation(2000f, 0f, 0f, 0f);
            animation.setDuration(200);
            controller = new LayoutAnimationController(animation, 0.5f);
            controller.setOrder( LayoutAnimationController.ORDER_NORMAL);
            recy.setLayoutAnimation(controller);
            recy_ck adapter=new recy_ck(this,datacs2);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false){
                @Override
                public boolean canScrollHorizontally() {
                    return false;
                }
            };
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recy.setLayoutManager(layoutManager);
            recy.setAdapter(adapter);


        }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back,R.anim.closs);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer!=null)
        mPlayer.release();
    }
}