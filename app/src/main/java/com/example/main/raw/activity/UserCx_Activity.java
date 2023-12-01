package com.example.main.raw.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.main.R;
import com.example.main.raw.Adpter.MyListViewAdpter;
import com.example.main.raw.Class_Custom.Bq_gson;
import com.example.main.raw.Class_Custom.Lucency;
import com.example.main.raw.Class_Custom.Th;
import com.example.main.raw.Class_Custom.Th_Sy;
import com.example.main.raw.DataClass.Bqdata;
import com.example.main.raw.DataClass.CghData;
import com.example.main.raw.DataClass.MyListData;
import com.example.main.raw.DataClass.Userxx;
import com.example.main.raw.DataClass.WordData;
import com.example.main.raw.JsonPares.jsongr;

import java.util.ArrayList;
import java.util.List;

public class UserCx_Activity extends AppCompatActivity {
    Toolbar toolbar;
    EditText editText;
    RelativeLayout layout;
   static ListView listView;
   static   Context context;
   static LottieAnimationView lottie;
   static String datas;
   int b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cx);
        Lucency lucency = new Lucency();
        lucency.light(this);
        toolbar = findViewById(R.id.toolbar_usercx);
        setSupportActionBar(toolbar);
        setTitle(null);
        context=this;
        lottie=findViewById(R.id.lottie_cx);
        lottie.setVisibility(View.GONE);
        listView = findViewById(R.id.list_user);
        listView.setVisibility(View.GONE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back,R.anim.closs);
                b=1;
            }
        });
        editText = findViewById(R.id.edit_user);
        layout = findViewById(R.id.user_r1);
        editText.requestFocus();
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    InputMethodManager manager = ((InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE));
                    if (manager != null)
                        manager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        });


        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datas = editText.getText().toString();
                if (datas.length() != 9)
                    Toast.makeText(UserCx_Activity.this, "请输入正确的uid", Toast.LENGTH_SHORT).show();
                else cx(datas);
            }
        });
    }

    private void cx(String uid) {
        listView.setAdapter(null);
        lottie.setAnimation(R.raw.bybick);
        lottie.playAnimation();
        lottie.setVisibility(View.VISIBLE);
        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
        String server = preferences.getString("server", "");
        String cookie = preferences.getString("cookie", "");
        if (cookie.length()==0){
            Toast.makeText(context, "请先登录哦", Toast.LENGTH_SHORT).show();
            lottie.setAnimation(R.raw.fouronrfour);
            return;
        }
        Th gr = new Th(handler, cookie, "https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/index?role_id=" + uid + "&server=" + server, uid, server, 2);
        gr.start();
        Th_Sy sy = new Th_Sy("https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/spiralAbyss?role_id=" + uid + "&schedule_type=" + 2 + "&server=" + server, uid, server, cookie, 2, 2);
        sy.start();
        Th_Sy sy1 = new Th_Sy("https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/spiralAbyss?role_id=" + uid + "&schedule_type=" + 1 + "&server=" + server, uid, server, cookie, 1, 2);
        sy1.start();
    }

    static public Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String data = (String) msg.obj;
            Userxx user = null;
            jsongr jsongrxx = new jsongr();
            user = jsongrxx.grxx(data);
           String[] jsxx;
            jsxx = jsongrxx.jsxx(data);
            CghData cgh;
            cgh = jsongrxx.cgh(data);
            List<WordData> word;
            word = jsongrxx.jxword(data);
            if (user.getMessage().equals("OK")) {
                List<MyListData> data1 =new ArrayList<>();
                Bq_gson bqdata=null;
                int[] layout2 = new int[]{R.layout.mylist_jb,R.layout.mylist_myjs,R.layout.mylist_cgh,R.layout.word,R.layout.sy};
                MyListViewAdpter adpter = new MyListViewAdpter(context,layout2,data1,bqdata,user,jsxx,cgh,word,datas);
                listView.setVisibility(View.VISIBLE);
                lottie.setVisibility(View.GONE);
                listView.setAdapter(adpter);

            }else{
                Toast.makeText(context, "该uid不存在或对方米游社已设置查询权限", Toast.LENGTH_SHORT).show();
                lottie.setAnimation(R.raw.fouronrfour);
                lottie.playAnimation();
            }
        }
    };
    @Override
    protected void onPause() {
        super.onPause();
        if (b==0){
            overridePendingTransition(R.anim.start,R.anim.back);
        }
        b=0;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        b=1;
        overridePendingTransition(R.anim.back,R.anim.closs);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences preferences=getSharedPreferences("data",MODE_PRIVATE);
         String uid=preferences.getString("uid","");
        String server =preferences.getString("server","");
        String cookie =preferences.getString("cookie","");
        Th_Sy sy = new Th_Sy("https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/spiralAbyss?role_id=" + uid + "&schedule_type=" + 2 + "&server=" + server, uid, server, cookie, 2, 2);
        sy.start();
        Th_Sy sy1 = new Th_Sy("https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/spiralAbyss?role_id=" + uid + "&schedule_type=" + 1 + "&server=" + server, uid, server, cookie, 1, 2);
        sy1.start();
        context=null;
        lottie=null;
        listView=null;
    }
}