package com.example.main.raw.Simulator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.main.raw.Class_Custom.Lucency;
import com.example.main.raw.Class_Custom.Random;
import com.example.main.raw.DataClass.SywData;
import com.example.main.raw.DataClass.SywSxData;
import com.example.main.raw.DataClass.SywSxData2;
import com.example.main.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CywQh_Activity extends AppCompatActivity implements View.OnClickListener {
    Handler handler=new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            re_fct.setVisibility(View.VISIBLE);
            re_fct.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.cscs7));
        }
    };
    RelativeLayout fct1,fct2,fct3,fct4;
    SywData sywData;
    SywSxData sywSxData;
    List<SywSxData2> sywfct=new ArrayList<>();
    Toolbar toolbar;
    Button btn_qh,btn_f,btn_t,btn_qr;
    int flag=0,big,qhs=0,flag2=0;
    RelativeLayout re_sywzs,re_fct;
    RelativeLayout r0;
    TextView qhsl,qhsl2,mainname,mainexp,name1,name2,name3,name4,exp1,exp2,exp3,exp4;
    ImageView sywimage;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyw_qh);
        Intent intent=getIntent();
        String data1=intent.getStringExtra("zct");
        String data2=intent.getStringExtra("fct");
        String syw=intent.getStringExtra("jcdata");
        fct1=findViewById(R.id.re_fct1);
        fct2=findViewById(R.id.re_fct2);
        fct3=findViewById(R.id.re_fct3);
        fct4=findViewById(R.id.re_fct4);
        re_sywzs=findViewById(R.id.re_sywzs);
        re_sywzs.setVisibility(View.GONE);
        progressBar=findViewById(R.id.syw_jdt);
        btn_qr=findViewById(R.id.btn_qr);
        r0=findViewById(R.id.r0);
        btn_qr.setVisibility(View.GONE);
        btn_qr.setClickable(false);
        int age=intent.getIntExtra("age",1);
        toolbar=findViewById(R.id.toolbar_syw_sl);
        setSupportActionBar(toolbar);
        setTitle(null);
        btn_qr.setOnClickListener(this);
        Lucency lucency=new Lucency();
        lucency.light(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back,R.anim.closs);
            }
        });
        jx(data1,data2,syw,age);
        big=sywfct.get(0).getCts();
        cshsj();
        setzs();
    btn_f=findViewById(R.id.btn_f);
    btn_t=findViewById(R.id.btn_t);
    btn_f.setOnClickListener(this);
    btn_t.setOnClickListener(this);
    btn_qh=findViewById(R.id.btn_qh);
    btn_qh.setOnClickListener(this);
    }

    private void setzs() {
        ImageView syw_zs;
        syw_zs=findViewById(R.id.syw_zsl_img);
//        syw_zs.setImageResource(sywData.getImage());
    }

    private void cshsj() {

        sywimage=findViewById(R.id.img_syw);
//        sywimage.setImageResource(sywData.getImage());
        qhsl=findViewById(R.id.syw_qhsl);
        qhsl2=findViewById(R.id.qhsl2);
        qhsl2.setVisibility(View.GONE);
        mainname=findViewById(R.id.syw_mainct);
       Double zb=sywSxData.getExp();
        String zs2=new DecimalFormat("0.0").format(zb);
        mainexp=findViewById(R.id.syw_zct_exp);
        if (sywSxData.getB()==1)
        mainexp.setText(""+zs2);
        else
            mainexp.setText(""+zs2+"%");
        mainname.setText(sywSxData.getMainname());
        name1=findViewById(R.id.syw_fct_1);
        name2=findViewById(R.id.syw_fct_2);
        name3=findViewById(R.id.syw_fct_3);
        name4=findViewById(R.id.syw_fct_4);
        exp1=findViewById(R.id.syw_fct_5);
        exp2=findViewById(R.id.syw_fct_6);
        exp3=findViewById(R.id.syw_fct_7);
        exp4=findViewById(R.id.syw_fct_8);
        if (big==3){
            name4.setVisibility(View.GONE);
            exp4.setVisibility(View.GONE);
        }
        name1.setText(sywfct.get(0).getName());
        name2.setText(sywfct.get(1).getName());
        name3.setText(sywfct.get(2).getName());
        name4.setText(sywfct.get(3).getName());
        Double zz;

        if (sywfct.get(0).getB()==1){
            zz=sywfct.get(0).getExp();
            String zs=new DecimalFormat("0").format(zz);
            exp1.setText(""+zs);
        }
        else{
            zz=sywfct.get(0).getExp();
            String zs=new DecimalFormat("0.0").format(zz);
            exp1.setText(""+zs+"%");
        }
        if (sywfct.get(1).getB()==1){
            zz=sywfct.get(1).getExp();
            String zs=new DecimalFormat("0").format(zz);
            exp2.setText(""+zs);
        }
        else{
            zz=sywfct.get(1).getExp();
            String zs=new DecimalFormat("0.0").format(zz);
            exp2.setText(""+zs+"%");
        }
        if (sywfct.get(2).getB()==1){
            zz=sywfct.get(2).getExp();
            String zs=new DecimalFormat("0").format(zz);
            exp3.setText(""+zs);
        }
        else{
            zz=sywfct.get(2).getExp();
            String zs=new DecimalFormat("0.0").format(zz);
            exp3.setText(""+zs+"%");
        }
        if (sywfct.get(3).getB()==1){
            zz=sywfct.get(3).getExp();
            String zs=new DecimalFormat("0").format(zz);
            exp4.setText(""+zs);
        }
        else{
            zz=sywfct.get(3).getExp();
            String zs=new DecimalFormat("0.0").format(zz);
            exp4.setText(""+zs+"%");
        }

    }

    private void jx(String data1, String data2, String syw,int age) {
        try {
            JSONObject jsonObject=new JSONObject(syw);
            int aid=jsonObject.getInt("aid");
            int id=jsonObject.getInt("id");
            int image=jsonObject.getInt("image");
            String name=jsonObject.getString("name");
//             sywData=new SywData(image,name,id,aid);
            jsonObject=new JSONObject(data1);
            int b=jsonObject.getInt("b");
            Double exp=jsonObject.getDouble("exp");
            name=jsonObject.getString("mainname");
             sywSxData=new SywSxData(exp,name,b);
            JSONArray jsonArray=new JSONArray(data2);
            Log.d("TAG",""+jsonArray.length());
            Log.d("TAG",data2);
            JSONArray jsonArray1=jsonArray.getJSONArray(age);
            Log.d("TAG",""+jsonArray1.length());
            for(int s=0;s<jsonArray1.length();s++){
                jsonObject=jsonArray1.getJSONObject(s);
                b=jsonObject.getInt("b");
                int cts=jsonObject.getInt("cts");
                exp=jsonObject.getDouble("exp");
                name=jsonObject.getString("name");
                SywSxData2 sxData2=new SywSxData2(name,exp,cts,b);
                sywfct.add(sxData2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_f:
                flag=4;
                progressBar.setProgress(100);
                setQhsl2();
                break;
            case R.id.btn_t:
                flag=20-qhs;
                progressBar.setProgress(100);
                setQhsl2();
                break;
            case R.id.btn_qh:
                if (flag==0)
                    Toast.makeText(this, "请添加狗粮", Toast.LENGTH_SHORT).show();
                else if (flag==4){
                    qhsl2.setVisibility(View.GONE);
                    if (big==3){
                        name4.setVisibility(View.VISIBLE);
                        exp4.setVisibility(View.VISIBLE);
                        big++;
                        setQhsl();
                        getqh(0);
                        zsqh();
                        flag=0;
                    }
                    else{
                        getqh(1);
                        setQhsl();
                        zsqh();
                        flag=0;
                    }
                }
                else{
                    qhsl2.setVisibility(View.GONE);
                    if (big==3) {
                        name4.setVisibility(View.VISIBLE);
                        exp4.setVisibility(View.VISIBLE);
                        big++;
                      flag2=1;
                        int z=(16-qhs)/4;
                        getqh(z);
                        setQhsl();
                        zsqh();
                        flag=0;

                    }
                    else
                    {
                        flag2=0;
                        getqh((20-qhs)/4);
                        setQhsl();
                        zsqh();
                        flag=0;
                    }
                }
                break;
            case R.id.btn_qr:
                btn_qr.setClickable(false);
                btn_qr.setVisibility(View.GONE);
                re_sywzs.setVisibility(View.GONE);
                btn_qh.setClickable(true);
                btn_f.setClickable(true);
                btn_t.setClickable(true);
                setQhsl();
                break;
        }

    }

    public void setQhsl2(){
        qhsl2.setVisibility(View.VISIBLE);
        qhsl2.setText("+"+flag);
    }

    public void setQhsl(){
        qhs+=flag;
        qhsl.setText("+"+qhs);
        progressBar.setProgress(0);
        if (qhs==20){
            qhsl2.setVisibility(View.VISIBLE);
            qhsl2.setText("Max");
            progressBar.setProgress(0);
            btn_qh.setClickable(false);
            btn_f.setClickable(false);
            btn_t.setClickable(false);
        }
    }
    public void getqh(int i){
        Random random=new Random(this);
        Double exp = null;
        int j=i;
        if(flag2==1||i==0)
            i++;
      if (sywSxData.getB()==1){
          switch (sywSxData.getMainname()) {
              case "攻击力":
                  exp =13.2*4*i;
                  break;
              case "生命值":
                  exp = 203.15*4*i;
                  break;
              case "元素精通":
                  exp = 7.95*4*i;
                  break;
          }
      }else{
          switch (sywSxData.getMainname()){
              case "攻击力":
                  exp = 1.98*4*i;
                  break;
              case "防御力":
                  exp = 2.48*4*i;
                  break;
              case "生命值":
                  exp = 1.95*4*i;
                  break;
              case "暴击率":
                  exp = 1.32*4*i;
                  break;
              case "暴击伤害":
                  exp = 2.64*4*i;
                  break;
              case "元素充能效率":
                  exp = 2.155*4*i;
                  break;
              case "治疗加成":
                  exp = 1.525*4*i;
                  break;
              case "物理伤害":
                  exp = 2.48*4*i;
                  break;
              default:
                  exp = 1.98*4*i;
                  break;
          }
     
      }
      double old=sywSxData.getExp();
        exp+=sywSxData.getExp();
        sywSxData.setExp(exp);
        setzct(old);
        zsqh();
        if(flag2==1||j==0){
            i--;
            cshsj();
            settsfct();
        }

        int[] bj=new int[]{0,0,0,0};
        double[] ys=new double[4];
        for (int g=0;g<4;g++){
            ys[g]=sywfct.get(g).getExp();
        }
        for(int l=0;l<i;l++) {
            int x = random.getRandom();
            x = x % 4;
            String name = sywfct.get(x).getName();
            int b = sywfct.get(x).getB();
            exp = 0.0;
            if (b == 1) {
                switch (name) {
                    case "攻击力":
                        exp = random.getxgj();
                        break;
                    case "防御力":
                        exp = random.getxfy();
                        break;
                    case "生命值":
                        exp = random.getxsm();
                        break;
                    case "元素精通":
                        exp = random.getysjt();
                        break;
                }
            } else {
                switch (name) {
                    case "攻击力":
                        exp = random.getdgj();
                        break;
                    case "防御力":
                        exp = random.getdfy();
                        break;
                    case "生命值":
                        exp = random.getdsm();
                        break;
                    case "暴击率":
                        exp = random.getbjl();
                        break;
                    case "暴击伤害":
                        exp = random.getbj();
                        break;
                    case "元素充能效率":
                        exp = random.getcnxl();
                        break;
                }
            }
            exp += sywfct.get(x).getExp();
            sywfct.get(x).setExp(exp);
            cshsj();
            zsqh();
            bj[x]++;
            qhsztx(bj,ys,i);
        }

    }

    private void settsfct() {
        fct2.setVisibility(View.GONE);
        fct4.setVisibility(View.GONE);
        fct3.setVisibility(View.GONE);
        TextView fct1,old1,new1;
        fct1=findViewById(R.id.fct_1);
        old1=findViewById(R.id.old_sz1);
        new1=findViewById(R.id.new_fct1);
        fct1.setText(sywfct.get(3).getName());
        Double zz;
        if (sywfct.get(3).getB()==1){

            old1.setText(null);
            zz=sywfct.get(3).getExp();
            String zs=new DecimalFormat("0").format(zz);
            new1.setText(""+zs);
        }
        else{

            old1.setText(null);
            zz=sywfct.get(3).getExp();
            String  zs=new DecimalFormat("0.0").format(zz);
            new1.setText(""+zs+"%");
        }

    }

    private void setzct(double old) {
        TextView zct_name,zct_new,ztc_old;
        zct_name=findViewById(R.id.zct_name);
        zct_new=findViewById(R.id.zct_new);
        ztc_old=findViewById(R.id.zct_old);
        zct_name.setText(sywSxData.getMainname());
        Double zz;
        if (sywSxData.getB()==1){
            zz=sywSxData.getExp();
            String zs=new DecimalFormat("0").format(zz);
            zct_new.setText(""+zs);
            zz=old;
             zs=new DecimalFormat("0").format(zz);
             ztc_old.setText(""+zs);
        }else {
            zz=sywSxData.getExp();
            String zs=new DecimalFormat("0.0").format(zz);
            zct_new.setText(""+zs+"%");
            zz=old;
            zs=new DecimalFormat("0.0").format(zz);
            ztc_old.setText(""+zs+"%");
        }
    }

    private void qhsztx(int[] bj, double[] ys,int i) {


        fct1.setVisibility(View.VISIBLE);
        fct2.setVisibility(View.VISIBLE);
        fct3.setVisibility(View.VISIBLE);
        fct4.setVisibility(View.VISIBLE);
        int z=0;
        for (int x=0;x<4;x++){
            if (bj[x]!=0){
                trsz(bj,ys,x,z);
                z++;
            }

        }
        switch (z){
            case 1:
                fct2.setVisibility(View.GONE);
            case 2:
                fct3.setVisibility(View.GONE);
            case 3:
                fct4.setVisibility(View.GONE);
        }

    }

    private void trsz(int[] bj, double[] ys, int x, int z) {
        TextView fct1,fct2,fct3,fct4,old1,old2,old3,old4,new1,new2,new3,new4;
        fct1=findViewById(R.id.fct_1);
        fct2=findViewById(R.id.fct_2);
        fct3=findViewById(R.id.fct_3);
        fct4=findViewById(R.id.fct_4);
        old1=findViewById(R.id.old_sz1);
        old2=findViewById(R.id.old_sz2);
        old3=findViewById(R.id.old_sz3);
        old4=findViewById(R.id.old_sz4);
        new1=findViewById(R.id.new_fct1);
        new2=findViewById(R.id.new_fct2);
        new3=findViewById(R.id.new_fct3);
        new4=findViewById(R.id.new_fct4);
        switch (z){
            case 0:fct1.setText(sywfct.get(x).getName());
            Double zz=0.0;
            if (sywfct.get(x).getB()==1){
                zz=ys[x];
                String zs=new DecimalFormat("0").format(zz);
                old1.setText(""+zs);
                zz=sywfct.get(x).getExp();
                zs=new DecimalFormat("0").format(zz);
                new1.setText(""+zs);
            }
            else{
                zz=ys[x];
                String zs=new DecimalFormat("0.0").format(zz);
                old1.setText(""+zs+"%");
                zz=sywfct.get(x).getExp();
                zs=new DecimalFormat("0.0").format(zz);
                new1.setText(""+zs+"%");
            }
                        break;
            case 1:fct2.setText(sywfct.get(x).getName());
                if (sywfct.get(x).getB()==1){
                    zz=ys[x];
                    String zs=new DecimalFormat("0").format(zz);
                    old2.setText(""+zs);
                    zz=sywfct.get(x).getExp();
                    zs=new DecimalFormat("0").format(zz);
                    new2.setText(""+zs);
                }
                else{
                    zz=ys[x];
                    String zs=new DecimalFormat("0.0").format(zz);
                    old2.setText(""+zs+"%");
                    zz=sywfct.get(x).getExp();
                    zs=new DecimalFormat("0.0").format(zz);
                    new2.setText(""+zs+"%");
                }
                break;
            case 2:fct3.setText(sywfct.get(x).getName());
                if (sywfct.get(x).getB()==1){
                    zz=ys[x];
                    String zs=new DecimalFormat("0").format(zz);
                    old3.setText(""+zs);
                    zz=sywfct.get(x).getExp();
                    zs=new DecimalFormat("0").format(zz);
                    new3.setText(""+zs);
                }
                else{
                    zz=ys[x];
                    String zs=new DecimalFormat("0.0").format(zz);
                    old3.setText(""+zs+"%");
                    zz=sywfct.get(x).getExp();
                    zs=new DecimalFormat("0.0").format(zz);
                    new3.setText(""+zs+"%");
                }
                break;
            case 3:fct4.setText(sywfct.get(x).getName());
                if (sywfct.get(x).getB()==1){
                    zz=ys[x];
                    String zs=new DecimalFormat("0").format(zz);
                    old4.setText(""+zs);
                    zz=sywfct.get(x).getExp();
                    zs=new DecimalFormat("0").format(zz);
                    new4.setText(""+zs);
                }
                else{
                    zz=ys[x];
                    String zs=new DecimalFormat("0.0").format(zz);
                    old4.setText(""+zs+"%");
                    zz=sywfct.get(x).getExp();
                    zs=new DecimalFormat("0.0").format(zz);
                    new4.setText(""+zs+"%");
                }
                break;
        }

    }


    public void zsqh(){
        btn_qr.setVisibility(View.VISIBLE);
        btn_qr.setClickable(true);
        re_sywzs.setVisibility(View.VISIBLE);
        btn_qh.setClickable(false);
        btn_f.setClickable(false);
        btn_t.setClickable(false);
        re_fct=findViewById(R.id.re_fct);
        re_fct.setVisibility(View.GONE);
        TextView dj;
        dj=findViewById(R.id.text_dj);
        dj.setText("+"+qhs);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message=new Message();
                message.what=0;
                handler.sendMessage(message);
            }
        }).start();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back,R.anim.closs);
    }
}