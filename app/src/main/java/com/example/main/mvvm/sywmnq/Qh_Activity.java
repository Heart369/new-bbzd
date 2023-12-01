package com.example.main.mvvm.sywmnq;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.main.R;
import com.example.main.databinding.ActivityQhBinding;
import com.example.main.mvvm.base.BaseActivity;
import com.example.main.raw.DataClass.SywSxData2;

import java.util.ArrayList;
import java.util.List;

public class Qh_Activity extends BaseActivity implements View.OnClickListener {
    ActivityQhBinding binding;
    Qh_ViewModel mainviewModel;
    ScrollView scrollView;
    ConstraintLayout maincon,fct,c1,c2,c3;
    ImageView exit, zhiZ, up,qh,zs_syw,exit_qr,zs1,zs2;
    TextView t_mid, t_4, t_max,xdj,zs_qh,zs_dj,qhwc,mj;
    ConstraintLayout c4;
    LinearLayout l1;
    View back_fct;
    int cts;
    ProgressBar progressBar;
    View zs_back,zs_back2;
    List<SywSxData2> sywSxData2s_bd=null;
    List<SywSxData2> sywSxData2s_zs=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_qh);
        mainviewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(Qh_ViewModel.class);
        binding.setVm(mainviewModel);
        binding.setLifecycleOwner(this);
        btl();
        bindingid();
        sp();
        Intent intent = getIntent();
        cts = mainviewModel.csh(intent.getIntExtra("age", 0), intent.getStringExtra("zct"), intent.getStringExtra("fct"), intent.getStringExtra("jcdata"));
        if (cts == 3)
            c4.setVisibility(View.GONE);

        ob();
    }

    private void ob() {
        mainviewModel.getDj().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (cts==3&&integer>=4){
                    c4.setVisibility(View.VISIBLE);
                    if (integer==4){
                        kb(mainviewModel.getOb_syw_fct().getValue());
                        sywSxData2s_zs.add(sywSxData2s_bd.get(3));
                        sywSxData2s_zs.add(sywSxData2s_bd.get(3));
                        sywSxData2s_zs.add(sywSxData2s_bd.get(3));
                        sywSxData2s_zs.add(sywSxData2s_bd.get(3));
                        c1.setVisibility(View.GONE);
                        c2.setVisibility(View.GONE);
                        c3.setVisibility(View.GONE);
                        mainviewModel.getOb_syw().setValue(sywSxData2s_zs);
                    }
                    zs_fct();
                }
                if (integer==20){
                    l1.setVisibility(View.GONE);
                    t_4.setVisibility(View.GONE);
                    t_max.setVisibility(View.GONE);
                    qh.setVisibility(View.GONE);
                    zs1.setVisibility(View.GONE);
                    zs2.setVisibility(View.GONE);
                    mj.setVisibility(View.VISIBLE);
                }
            }
        });

        mainviewModel.getOb_syw_fct().observe(this, new Observer<List<SywSxData2>>() {
            @Override
            public void onChanged(List<SywSxData2> sywSxData2s) {
                if (sywSxData2s_bd==null){
                    kb(sywSxData2s);
                }
                sywSxData2s_zs=new ArrayList<>();
                for (int a=0;a<4;a++){
                    Log.d("TAG",sywSxData2s.get(a).getExp()+"----"+sywSxData2s_bd.get(a).getExp());
                    if (!sywSxData2s.get(a).getExp().equals(sywSxData2s_bd.get(a).getExp())){
                        SywSxData2 sxData2=sywSxData2s.get(a);
                        sxData2.setExp2(sywSxData2s_bd.get(a).getExp());
                        sywSxData2s_zs.add(sxData2);
                    }
                }
                kb(sywSxData2s);
                c1.setVisibility(View.VISIBLE);
                c2.setVisibility(View.VISIBLE);
                c3.setVisibility(View.VISIBLE);
                if (sywSxData2s_zs.size()!=0){
                    Log.d("TAG",sywSxData2s_zs.get(0).getName()+"--"+sywSxData2s_zs.get(0).getExp2()+"--"+sywSxData2s_zs.get(0).getExp()+"--"+sywSxData2s_zs.size());
                    switch (sywSxData2s_zs.size()){
                        case 1:
                            sywSxData2s_zs.add(sywSxData2s_zs.get(0));
                            c1.setVisibility(View.GONE);
                        case 2:
                            c2.setVisibility(View.GONE);
                            sywSxData2s_zs.add(sywSxData2s_zs.get(0));
                        case 3:
                            c3.setVisibility(View.GONE);
                            sywSxData2s_zs.add(sywSxData2s_zs.get(0));
                    }
                    mainviewModel.getOb_syw().setValue(sywSxData2s_zs);

                    zs_fct();
                }
            }
        });
    }

    private void zs_fct() {
        Animation animation = AnimationUtils.loadAnimation(Qh_Activity.this, R.anim.ck_sf);
        animation.setRepeatCount(1);
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fct.setVisibility(View.VISIBLE);
                animation = AnimationUtils.loadAnimation(Qh_Activity.this, R.anim.syw_sf);
                animation.setRepeatCount(1);
                animation.setFillAfter(true);
                Animation animation1=AnimationUtils.loadAnimation(Qh_Activity.this, R.anim.syw_py);
                animation1.setRepeatCount(1);
                animation1.setFillAfter(true);
                AnimationSet animSet = new AnimationSet(true);
                animSet.addAnimation(animation);
                animSet.addAnimation(animation1);
                animSet.setFillAfter(true);
                zs_syw.setAnimation(animation1);
                qhwc.setAnimation(animation1);
                zs_back.setAnimation(animation1);
                zs_dj.setAnimation(animation1);
                fct.setAnimation(animation1);
//                back_fct.setAnimation(animSet);
                zs_qh.setAnimation(animation1);
                exit_qr.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        zs_syw.setVisibility(View.VISIBLE);
        zs_syw.setAnimation(animation);
        zs_back.setVisibility(View.VISIBLE);
        zs_dj.setVisibility(View.VISIBLE);
        zs_qh.setVisibility(View.VISIBLE);
        zs_back2.setVisibility(View.VISIBLE);
        qhwc.setVisibility(View.VISIBLE);

    }

    private void kb(List<SywSxData2> sywSxData2s) {
        List<SywSxData2> sywSxData2s_bd = new ArrayList<>();
        for (int a=0;a<4;a++){
            sywSxData2s_bd.add(new SywSxData2(sywSxData2s.get(a).getName(),sywSxData2s.get(a).getExp(),sywSxData2s.get(a).getCts(),sywSxData2s.get(a).getB()));
        }
        this.sywSxData2s_bd=sywSxData2s_bd;
    }

    private void sp() {
        int height = getHeight();
        int weight = getWidth();
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) scrollView.getLayoutParams();
        lp.height = (int) (height * 0.24);
        lp = (ConstraintLayout.LayoutParams) maincon.getLayoutParams();
        lp.width = (int) (weight * 0.4);
        lp= (ConstraintLayout.LayoutParams) zs_back.getLayoutParams();
        lp.height=(int) (height*0.18);
        lp= (ConstraintLayout.LayoutParams) fct.getLayoutParams();
        lp.height=(int) (height*0.31);
        lp= (ConstraintLayout.LayoutParams) zs_syw.getLayoutParams();
        lp.height=(int) (height*0.175);
        lp.width= (int) (weight*0.0666);
    }

    private void bindingid() {
        scrollView = findViewById(R.id.scr_syw);
        maincon = findViewById(R.id.con_1);
        exit = findViewById(R.id.syw_exit);
        exit.setOnClickListener(this);
        t_mid = findViewById(R.id.textView10);
        zhiZ = findViewById(R.id.imageView5);
        up = findViewById(R.id.imageView4);
        t_mid.setVisibility(View.GONE);
        zhiZ.setVisibility(View.GONE);
        up.setVisibility(View.GONE);
        c4 = findViewById(R.id.constraintLayout5);
        progressBar=findViewById(R.id.progressBar);
        t_4 = findViewById(R.id.textView13);
        t_max = findViewById(R.id.textView14);
        t_4.setOnClickListener(this);
        t_max.setOnClickListener(this);
        qh=findViewById(R.id.imageView12);
        qh.setOnClickListener(this);
//        back_fct=findViewById(R.id.back_fct);
        l1=findViewById(R.id.linearLayout);
        xdj=findViewById(R.id.textView9);
        xdj.setVisibility(View.GONE);
        zs_syw=findViewById(R.id.imageView13);
        zs_syw.setVisibility(View.GONE);
        zs_qh=findViewById(R.id.textView15);
        zs_dj=findViewById(R.id.syw_dj);
        zs_syw.setVisibility(View.GONE);
        zs_qh.setVisibility(View.GONE);
        zs_back=findViewById(R.id.view2);
        zs_back.setVisibility(View.GONE);
        zs_dj.setVisibility(View.GONE);
        zs_back2=findViewById(R.id.view3);
        zs_back2.setVisibility(View.GONE);
        qhwc=findViewById(R.id.text_qhwc);
        qhwc.setVisibility(View.GONE);
        exit_qr=findViewById(R.id.imageView16);
        zs1=findViewById(R.id.imageView15);
        zs2=findViewById(R.id.imageView14);
        exit_qr.setOnClickListener(this);
        mj=findViewById(R.id.mj_max);
        mj.setVisibility(View.GONE);
        exit_qr.setVisibility(View.GONE);
        fct=findViewById(R.id.fct);
        fct.setVisibility(View.GONE);
        c1=findViewById(R.id.c2);
        c2=findViewById(R.id.c3);
        c3=findViewById(R.id.c4);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.syw_exit:
                fin();
                break;
            case R.id.textView13:
                t_mid.setVisibility(View.VISIBLE);
                zhiZ.setVisibility(View.VISIBLE);
                up.setVisibility(View.VISIBLE);
                mainviewModel.getMain_data(0);
                xdj.setVisibility(View.VISIBLE);
                progressBar.setProgress(100);
                break;
            case R.id.textView14:
                t_mid.setVisibility(View.VISIBLE);
                zhiZ.setVisibility(View.VISIBLE);
                xdj.setVisibility(View.VISIBLE);
                up.setVisibility(View.VISIBLE);
                progressBar.setProgress(100);
                mainviewModel.getMain_data(1);
                break;
            case R.id.imageView12:
                t_mid.setVisibility(View.GONE);
                zhiZ.setVisibility(View.GONE);
                up.setVisibility(View.GONE);
                xdj.setVisibility(View.GONE);
                progressBar.setProgress(0);
                if (mainviewModel.qh()==1){
                    exit.setClickable(false);
                    t_4.setClickable(false);
                    t_max.setClickable(false);
                    qh.setClickable(false);
                }

                break;
            case R.id.imageView16:
                exit_qr.setVisibility(View.GONE);
                qhwc.setVisibility(View.GONE);
                qhwc.clearAnimation();
                zs_back2.setVisibility(View.GONE);
                zs_back.clearAnimation();
                zs_back.setVisibility(View.GONE);
                zs_dj.clearAnimation();
                zs_dj.setVisibility(View.GONE);
                zs_syw.clearAnimation();
                zs_syw.setVisibility(View.GONE);
                zs_qh.clearAnimation();
                zs_qh.setVisibility(View.GONE);
                fct.clearAnimation();
                fct.setVisibility(View.GONE);
                exit.setClickable(true);
                t_4.setClickable(true);
                t_max.setClickable(true);
                qh.setClickable(true);

                mainviewModel.main_Sx.setValue(mainviewModel.main_newSx.getValue());
                break;
        }

    }
}