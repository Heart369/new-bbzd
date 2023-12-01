package com.example.main.mvvm.sywmnq;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.main.R;
import com.example.main.databinding.ActivitySywMainBinding;
import com.example.main.mvvm.base.BaseActivity;
import com.example.main.raw.DataClass.SywData;
import com.example.main.raw.Sh_js.Sywxq;
import com.example.main.raw.Simulator.SywSx;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

public class SywMain_Activity extends BaseActivity implements View.OnClickListener {
    ActivitySywMainBinding binding;
    Syw_Viewmodel mainviewModel;
    private MediaPlayer mPlayer = null;
    SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    GridView gridView;
    ConstraintLayout r1;
    Toolbar toolbar;
    SwitchMaterial switch_m, relativeLayout;
    RelativeLayout r2, r3, re3;
    View hd;
    LinearLayout layout1, layout2, layout3, layout4;
    TextView text1, text2, text3, text4,t3;
    ImageView image1, image2, image3, image4,lq,image_r3;
    SywSx sywSx;
    int flag=0,flag_dh=0;
    int b=0;
    Button qh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_syw_main);
        mainviewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(Syw_Viewmodel.class);
        binding.setVm(mainviewModel);
        binding.setLifecycleOwner(this);
        viewbinding();
        hd();
        mainviewModel.csh();
        btl();
        setToolbar(R.id.toolbar_sywmnq, R.id.title_sywmnq, "圣遗物强化模拟器");
        ob();

    }

    @Override
    public void setToolbar(int id, int id2, String name) {
        Toolbar toolbar=findViewById(id);
        setSupportActionBar(toolbar);
        setTitle(null);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag==0){
                    fin();
                }else if (flag==1){
                    gridView.setVisibility(View.VISIBLE);
                    gridView.setAlpha(0);
                    gridView.animate().alpha(1).setDuration(1000);
                    flag_dh=1;
                    r1.animate().alpha(0).setDuration(1000).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            if (flag_dh==1){
                                r1.setVisibility(View.GONE);
                                r1.setAlpha(1);
                            }
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                    hd.setVisibility(View.GONE);
                    r2.setVisibility(View.GONE);
                    t3.setVisibility(View.GONE);
                    re3.setVisibility(View.GONE);
                    image_r3.setVisibility(View.GONE);
                    surfaceView.setVisibility(View.GONE);
                    surfaceView.setScaleX(1.0f);
                    surfaceView.setScaleY(1.0f);
                    lq.setClickable(true);
                    if (mPlayer!=null)
                    mPlayer.release();
                    flag=0;
                }
            }
        });
        TextView textView=findViewById(id2);
        textView.setText(name);
    }

    private void ob() {
        mainviewModel.getSywData().observe(this, new Observer<List<SywData>>() {
            @Override
            public void onChanged(List<SywData> sywData) {
                if (!switch_m.isChecked()) {
                    surfaceView.setScaleX(1.0f);
                    surfaceView.setScaleY(1.0f);
                    mPlayer = MediaPlayer.create(SywMain_Activity.this, R.raw.mj_lqsz);
                    mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    surfaceView.setVisibility(View.VISIBLE);
                    surfaceHolder = surfaceView.getHolder();
                    mPlayer.setDisplay(surfaceHolder);
                    mPlayer.start();
                    r1.setVisibility(View.GONE);
                    mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            r1.setVisibility(View.VISIBLE);
                            mPlayer.release();
                            showsyw(sywData);

                        }
                    });
                }
                showsyw(sywData);
            }
        });
    }

    private void showsyw(List<SywData> sywData) {

        lq.setClickable(false);
        sywSx=new SywSx(this,this,sywData);
        hd.setVisibility(View.VISIBLE);
        r2.setVisibility(View.VISIBLE);
        r3.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
        image_r3.setVisibility(View.VISIBLE);
        r2.setAlpha(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.02f, 1f, 1.02f, 1f);
        scaleAnimation.setDuration(500); //设置动画时长为0.5秒
        scaleAnimation.setFillAfter(true);
        r3.startAnimation(scaleAnimation);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, -240);
                translateAnimation.setDuration(500); //设置动画时长为0.5秒
                translateAnimation.setFillAfter(true);
                r3.startAnimation(translateAnimation);
                r2.animate().alpha(1).setDuration(500);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        text1.setText(sywData.get(0).getImage());
        gilde(image1, sywData.get(0).getName(), sywData.get(0).getId2());
        text2.setText(sywData.get(1).getImage());
        gilde(image2, sywData.get(1).getName(), sywData.get(1).getId2());

        if (sywData.size() == 2) {
            layout4.setVisibility(View.GONE);
            layout3.setVisibility(View.GONE);
        }
        if (sywData.size() == 3) {
            layout4.setVisibility(View.GONE);
            layout3.setVisibility(View.VISIBLE);
            text3.setText(sywData.get(2).getImage());
            gilde(image3, sywData.get(2).getName(), sywData.get(2).getId2());
        }
        if (sywData.size() == 4) {

            layout4.setVisibility(View.VISIBLE);
            layout3.setVisibility(View.VISIBLE);
            text4.setText(sywData.get(3).getImage());
            gilde(image4, sywData.get(3).getName(), sywData.get(3).getId2());
        }


    }

    @SuppressLint("Range")
    private void hd() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (flag_dh==2)
                    return;
                r1.setBackground(mainviewModel.getdraw(position));
                flag=1;
                List<String> zj=new ArrayList<>();
                Sywxq sywxq = new Sywxq(SywMain_Activity.this, "sywxc.bd", null, 1);
                SQLiteDatabase database_syw = sywxq.getWritableDatabase();
                Cursor cursor = database_syw.query("mytable", new String[]{"id","two","four"}, "name=?", new String[]{mainviewModel.getFb().get(position).getCc1()}, null, null, null, null);
                cursor.moveToNext();
                String id1 = cursor.getString(cursor.getColumnIndex("id"));
                zj.add(cursor.getString(cursor.getColumnIndex("two")));
                zj.add(cursor.getString(cursor.getColumnIndex("four")));
                zj.add(mainviewModel.getFb().get(position).getCc1());
                cursor = database_syw.query("mytable", new String[]{"id","two","four"}, "name=?", new String[]{mainviewModel.getFb().get(position).getCc2()}, null, null, null, null);
                cursor.moveToNext();
                String id2 = cursor.getString(cursor.getColumnIndex("id"));
                zj.add(cursor.getString(cursor.getColumnIndex("two")));
                zj.add(cursor.getString(cursor.getColumnIndex("four")));
                zj.add(mainviewModel.getFb().get(position).getCc2());
                mainviewModel.getRandom().setC1(id1);
                mainviewModel.getRandom().setC2(id2);
                mainviewModel.getRandom().setJz(zj);
                if (switch_m.isChecked()) {
                    r1.setVisibility(View.VISIBLE);
                    flag_dh=2;
                    gridView.animate().alpha(0).setDuration(1000).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            if (flag_dh==2){
                                gridView.setVisibility(View.GONE);
                                gridView.setAlpha(1);
                            }

                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                    r1.setAlpha(0);
                    r1.animate().alpha(1).setDuration(1000);
                    return;
                }
                gridView.setVisibility(View.GONE);
                toolbar.setVisibility(View.GONE);
                surfaceView.setVisibility(View.VISIBLE);
                mPlayer = MediaPlayer.create(SywMain_Activity.this, R.raw.mj_start);
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                surfaceHolder = surfaceView.getHolder();
                mPlayer.setDisplay(surfaceHolder);
                mPlayer.start();
                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Log.d("TAG", "123123123");
                        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(
                                surfaceView,
                                PropertyValuesHolder.ofFloat("scaleX", 1.0f, 2.0f),
                                PropertyValuesHolder.ofFloat("scaleY", 1.0f, 2.0f)
                        );
                        animator.setInterpolator(new AccelerateDecelerateInterpolator()); // 设置插值器
                        animator.setDuration(1500); // 设置动画持续时间
                        animator.start();
                        r1.setVisibility(View.VISIBLE);
                        animator = ObjectAnimator.ofFloat(r1, "alpha", 0.0f, 1.0f);
                        animator.setInterpolator(new AccelerateDecelerateInterpolator()); // 设置插值器
                        animator.setDuration(1500); // 设置动画持续时间
                        animator.start();
                        mPlayer.release();
                        toolbar.setVisibility(View.VISIBLE);
                    }
                });
            }
        });


    }

    @SuppressLint("WrongViewCast")
    private void viewbinding() {
        surfaceView = findViewById(R.id.sur_syw);
        surfaceView.setVisibility(View.INVISIBLE);
        gridView = findViewById(R.id.syw_grid);
        r1 = findViewById(R.id.r1_syw);
        r1.setVisibility(View.GONE);
        toolbar = findViewById(R.id.toolbar_sywmnq);
        switch_m = findViewById(R.id.switch_syw);
        r2 = findViewById(R.id.layout_ck_syw);
        r2.setVisibility(View.GONE);
        hd = findViewById(R.id.syw_hd);
        hd.setVisibility(View.GONE);
        hd.setOnClickListener(this);
        r3 = findViewById(R.id.back_syw_hd);
        r3.setVisibility(View.GONE);
        layout2 = findViewById(R.id.layout_2);
        layout1 = findViewById(R.id.layout_1);
        layout3 = findViewById(R.id.layout_3);
        layout4 = findViewById(R.id.layout_4);
        re3 = findViewById(R.id.re3);
        re3.setVisibility(View.GONE);
        re3.setOnClickListener(this);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);

        text1 = findViewById(R.id.syw_text_1);
        text2 = findViewById(R.id.syw_text_2);
        text3 = findViewById(R.id.syw_text_3);
        text4 = findViewById(R.id.syw_text_4);
        image1 = findViewById(R.id.syw_img_1);
        image2 = findViewById(R.id.syw_img_2);
        image3 = findViewById(R.id.syw_img_3);
        image4 = findViewById(R.id.syw_img_4);
        lq=findViewById(R.id.lq);
        t3=findViewById(R.id.text_r3);
        image_r3=findViewById(R.id.image_r3);
        qh=findViewById(R.id.btn_qh);
        qh.setVisibility(View.GONE);

    }

    public void gilde(ImageView imageView, String id, int bw) {
        Glide.with(SywMain_Activity.this)
                .load("https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_" + id + "_"+bw+".png")
                .fitCenter()
                .error(R.drawable.os_kl_cs)
                .placeholder(R.drawable.os_kl_cs)
                .transform(new RoundedCorners(15))
                .into(imageView);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_1:
               sywSx.sx(0);
                re3.setVisibility(View.VISIBLE);
               xg(false);
                break;
            case R.id.layout_2:
                sywSx.sx(1);
                re3.setVisibility(View.VISIBLE);
                xg(false);
                break;
            case R.id.layout_3:
                sywSx.sx(2);
                re3.setVisibility(View.VISIBLE);
                xg(false);
                break;
            case R.id.layout_4:
                sywSx.sx(3);
                re3.setVisibility(View.VISIBLE);
                xg(false);
                break;
            case R.id.re3:
                re3.setVisibility(View.GONE);
                xg(true);
                break;
            case R.id.syw_hd:
                hd.setVisibility(View.GONE);
                r2.setVisibility(View.GONE);
                t3.setVisibility(View.GONE);
                image_r3.setVisibility(View.GONE);
                lq.setClickable(true);
                break;
        }
    }

    private void xg(boolean i) {
        if (i){
            layout1.setClickable(true);
            layout2.setClickable(true);
            layout3.setClickable(true);
            layout4.setClickable(true);
            qh.setVisibility(View.GONE);
        }else {
            layout1.setClickable(false);
            layout2.setClickable(false);
            layout3.setClickable(false);
            layout4.setClickable(false);
            qh.setVisibility(View.VISIBLE);
        }

    }

}