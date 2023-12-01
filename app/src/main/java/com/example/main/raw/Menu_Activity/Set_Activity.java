package com.example.main.raw.Menu_Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.main.raw.Adpter.dialog_item1_adapter;
import com.example.main.raw.Adpter.recy_set;
import com.example.main.raw.Class_Custom.Lucency;
import com.example.main.R;
import com.example.main.raw.Class_Custom.gx;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class Set_Activity extends AppCompatActivity {
    Toolbar toolbar;
    AlertDialog dialoganim;
    RecyclerView recyclerView;
    AlertDialog.Builder dialog;
    int time=-1;
    int s=0;
    String[] data1=new String[]{"便签设置","通知设置","检查版本更新","自动签到"};
    String[] data2=new String[]{"在此设置便签的刷新间隔(建议大于7)","待完成","检查版本更新","每日第一次打开应用时自动签到"};
    boolean[] data3=new boolean[]{false,false,false,true};
    ImageView imageView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devlog);
        toolbar = findViewById(R.id.toolbar_dev);
        setSupportActionBar(toolbar);
        setTitle(null);
        Lucency lucency=new Lucency();
        lucency.light(this);
        context=this;
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                s=1;
                overridePendingTransition(R.anim.back,R.anim.closs);
            }
        });

        recyclerView=findViewById(R.id.recy_sz);
        recy_set adapter =new recy_set( this, new recy_set.OnRvItemClick() {
            @Override
            public void onItemClick(View v, int position) {

                switch (position){
                    case 0:
                        extracted();
                        break;
                    case 1:
                        Intent intent=new Intent(Set_Activity.this, Notification_Activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        DisplayMetrics metric = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(metric);
                         int  width = metric.widthPixels;     // 屏幕宽度（像素）
                        gx gx =new gx(Set_Activity.this,width,"10321");
                        gx.jcgx();
                        break;
                    case 3:
                        SwitchMaterial material=v.findViewById(R.id.switch_set);
                        material.setChecked(!material.isChecked());
                }
            }
        },data1,data2,data3);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void extracted() {
        dialog=new AlertDialog.Builder(Set_Activity.this);
        View view= LayoutInflater.from(context).inflate(R.layout.dialog_item,null,false);
        ListView listView=view.findViewById(R.id.list_dialog);
        SharedPreferences preferences=getSharedPreferences("userset",MODE_PRIVATE);
        int item=preferences.getInt("sxtime",0);
        dialog_item1_adapter adapter=new dialog_item1_adapter(context,item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.item=position;
               adapter.notifyDataSetChanged();
               time=position;
            }
        });
        Button b1,b2;
        b1=view.findViewById(R.id.button);
        b2=view.findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialoganim.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialoganim.dismiss();
                if (time!=-1){
                    SharedPreferences.Editor editor=getSharedPreferences("userset",MODE_PRIVATE).edit();
                    editor.putInt("sxtime", time);
                    editor.apply();
                    Toast.makeText(Set_Activity.this, "设置成功重启软件生效", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.setView(view);
        dialoganim=dialog.show();
        Window window = dialoganim.getWindow();
        window.setWindowAnimations(R.style.dialogWindowAnim3);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.dimAmount =0f;
        window.setAttributes(lp);
        window.setBackgroundDrawable(getDrawable(R.drawable.shape_19dp));
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (s==0){
            overridePendingTransition(R.anim.start,R.anim.back);
        }
        s=0;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        s=1;
        overridePendingTransition(R.anim.back,R.anim.closs);
    }
}