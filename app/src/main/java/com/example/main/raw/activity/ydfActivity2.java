package com.example.main.raw.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.main.R;
import com.example.main.raw.Zdyclass.Csh;

//开屏起始页
public class ydfActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ydf2);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        this.getWindow().setAttributes(lp);
        //隐藏标题栏

        SharedPreferences preferences=getSharedPreferences("userdata",MODE_PRIVATE);
        String size;
         size=preferences.getString("size","");

        if (size.length()==0){
            Log.d("TAG666","789"+size);
            SharedPreferences.Editor editor=getSharedPreferences("userdata",MODE_PRIVATE).edit();
            editor.putString("size","1");
            editor.apply();
//            Csh csh=new Csh(this);
//            csh.csh();
            csh();
        }





        setContentView(R.layout.activity_ydf2);
        //创建子线程
        Thread mThread=new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(500);//使程序休眠?秒
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.start,R.anim.back);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        mThread.start();//启动线程
    }

    private void csh() {
            SharedPreferences.Editor editor=getSharedPreferences("userset",MODE_PRIVATE).edit();
            editor.putInt("sxtime",6);
            editor.apply();
            Log.d("TAG","已执行");
    }

}