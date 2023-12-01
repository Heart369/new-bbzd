package com.example.main.raw.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.main.R;
import com.example.main.raw.Adpter.MyListViewAdpter;
import com.example.main.raw.Class_Custom.Bq_gson;
import com.example.main.raw.Class_Custom.Dp_Px;
import com.example.main.raw.Class_Custom.Th;
import com.example.main.raw.DataClass.Bqdata;
import com.example.main.raw.DataClass.CghData;
import com.example.main.raw.DataClass.MyListData;
import com.example.main.raw.DataClass.Userxx;
import com.example.main.raw.DataClass.WordData;
import com.example.main.raw.Menu_Activity.Set_Activity;
import com.example.main.raw.Zdyclass.MyListView;

import java.util.ArrayList;
import java.util.List;


public class view3_Activity extends AppCompatActivity {
    Context context;
    MyListView myListView;
    ImageView top_img;
    String uid;
    Handler mhandler;
    String[] jsxx;
    CghData cgh;
    Userxx user=null;
    Intent intent;
    LinearLayout layout1;
    List<WordData> word;
    int a3;
    Bq_gson bqdata=null;
    TextView textView,text_id,text_tkd,dl;
    LottieAnimationView lottie;

    List<MyListData> data1 =new ArrayList<>();
    ScrollView scrollView;
    RelativeLayout.LayoutParams lp =  new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

    int[] layout = new int[]{R.layout.mylist_jb,R.layout.mylist_myjs,R.layout.new_bq,R.layout.mylist_cgh,R.layout.word,R.layout.sy};

    public view3_Activity(Handler handler) {
        mhandler=handler;
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view3);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void csh(View view, Context context) {
        myListView=view.findViewById(R.id.mylist);
        cshlistview();
        dl=view.findViewById(R.id.dlname);
        lottie=view.findViewById(R.id.login);
        lottie.setVisibility(View.GONE);
        dl.setVisibility(View.GONE);
        scrollView =view.findViewById(R.id.scrollview);
        scrollView.setVisibility(View.VISIBLE);
       // top_img.setVisibility(View.VISIBLE);
        layout1=view.findViewById(R.id.layout_head);
        layout1.setVisibility(View.VISIBLE);
        textView =view.findViewById(R.id.view3_text_top);

        //拿取基本信息填入
        SharedPreferences preferences=context.getSharedPreferences("data",MODE_PRIVATE);
        String name=preferences.getString("name","");
        String server =preferences.getString("server","");
        String level = preferences.getString("level","");
        text_id.setText(name);
        if (server.equals("cn_gf01"))
            server="天空岛";
        text_tkd.setText(server+"  "+level+"级");

        Dp_Px dp_px =new Dp_Px();
        int a = dp_px.dip2px(context,90);//图片高度
        int a4=dp_px.dip2px(context,110);//文字距离顶部距离
        int a1=dp_px.dip2px(context,79);//最大位置高度
        int a2=dp_px.dip2px(context,130);//横向距离
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY <= 0) {
                    layout1.setBackgroundColor(Color.argb((int) 0, 91, 188, 253));
                    textView.setTextColor(Color.argb((int)0,255,255,255));
                    lp.setMargins(0, a4, 0, 0);
                    text_id.setLayoutParams(lp);
                } else if (scrollY > 0 && scrollY <= a) {
                    float scale = (float) scrollY / a;
                    float alpha = (255 * scale);

                    layout1.setBackgroundColor(Color.argb((int) alpha, 91, 188, 253));
                    textView.setTextColor(Color.argb((int)alpha,255,255,255));
                    if(scrollY<=a1){
                       float alpha1 =alpha;
                 //    Log.d("TAG",""+dp_px.px2dip(context,scrollY))  ;
                        float weight = ((float) a2/a1)*scrollY;
                        lp.setMargins((int) weight, a4-(int) scrollY, 0, 0);
                    }
                        else lp.setMargins( a2, a4-a1, 0, 0);
                        text_id.setLayoutParams(lp);
                } else {
                    lp.setMargins(a2, a4-a1, 0, 0);
                    text_id.setLayoutParams(lp);
                    layout1.setBackgroundColor(Color.argb((int) 255, 91, 188, 253));
                    text_id.setLayoutParams(lp);

                    textView.setTextColor(Color.argb((int)255,255,255,255));
                }
            }
        });
        top_img=view.findViewById(R.id.view3_top_img);
     // top_img.setVisibility(View.GONE);
        text_id=view.findViewById(R.id.text_id);
        text_id.setVisibility(View.VISIBLE);
        text_tkd=view.findViewById(R.id.text_tkd);
        text_tkd.setVisibility(View.VISIBLE);


        top_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,top_img);

                // menu布局
                popupMenu.getMenuInflater().inflate(R.menu.menu_top, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                       switch (item.getItemId()){
                           case R.id.remove:
                               //此处为退出后的初始化
                               @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor=context.getSharedPreferences("data",MODE_PRIVATE).edit();
                               editor.putString("uid",null);
                               editor.putString("server",null);
                               editor.putString("name",null);
                               editor.putString("level",null);
                               editor.putString("server_name",null);
                               editor.commit();
                               CookieManager.getInstance().removeAllCookies(null);
                               CookieManager.getInstance().flush();
                               nologincsh(view,context);
                               Th t = new Th(mhandler,"12334","https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/dailyNote?role_id="+"111"+"&server="+"cff","123","123",1);
                               t.start();
                               break;
                           case R.id.set:
                               //切换账号
                               intent=new Intent(context,LoginActivity.class);
                               context.startActivity(intent);
                               break;
                           case R.id.set3:
                               intent=new Intent(context, Set_Activity.class);
                               context.startActivity(intent);
                       }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
}


public void cshlistview(){

    MyListViewAdpter adpter = new MyListViewAdpter(context,layout,data1,bqdata,user,jsxx,cgh,word,"0");
    myListView.setAdapter(adpter);
    if (cgh!=null)
    myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 5:
                    Intent intent=new Intent(context,Sy_Activity.class);
                    context.startActivity(intent);
                    break;
            }
        }
    });
}

public void nologincsh(View view, Context context){
        this.context=context;
    text_id=view.findViewById(R.id.text_id);
    text_id.setVisibility(View.GONE);
    text_tkd=view.findViewById(R.id.text_tkd);
    text_tkd.setVisibility(View.GONE);
    scrollView =view.findViewById(R.id.scrollview);
    scrollView.setVisibility(View.GONE);
    top_img=view.findViewById(R.id.view3_top_img);

    lottie=view.findViewById(R.id.login);
    dl=view.findViewById(R.id.dlname);
    dl.setVisibility(View.VISIBLE);
    lottie.setVisibility(View.VISIBLE);
    layout1=view.findViewById(R.id.layout_head);
    layout1.setVisibility(View.GONE);
    lottie.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,LoginActivity.class);
            context.startActivity(intent);
        }
    });
    SharedPreferences preferences=context.getSharedPreferences("data",MODE_PRIVATE);
    String uid=preferences.getString("uid","");
    this.uid=uid;
    if(uid.length()!=0)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.d("TAG","进入主界面");
            csh(view,context);
        }

}

public void cshbq(Bq_gson bqdata){
        this.bqdata=bqdata;
        if (uid.length()!=0)
        cshlistview();
}
public  void  cshuser(Userxx userxx, String[] jsxx, CghData cgh, List<WordData> word){
        user=userxx;
        this.jsxx=jsxx;
        this.cgh=cgh;
        this.word=word;
        Log.d("TAG","ka" +
                "is");
        cshlistview();
}

}