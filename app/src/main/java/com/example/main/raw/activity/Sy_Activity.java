package com.example.main.raw.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.main.R;
import com.example.main.raw.Adpter.Sy_recy_Adpter;
import com.example.main.raw.Class_Custom.Lucency;
import com.example.main.raw.Class_Custom.Recy_item_jj;
import com.example.main.raw.JsonPares.Sy;
import com.example.main.raw.server.MyService;
import com.google.gson.Gson;

import java.util.HashMap;

public class Sy_Activity extends AppCompatActivity {
    Toolbar toolbar;
    static Sy sy, syy;
    static int flag = 0, flag2 = 1;
    static RecyclerView recyclerView;
    static Sy_recy_Adpter adpter1, adpter2;
    public static Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                String data = (String) msg.obj;
                Gson gson = new Gson();
                sy = gson.fromJson(data, Sy.class);
            } else {
                String data = (String) msg.obj;
                Gson gson = new Gson();
                syy = gson.fromJson(data, Sy.class);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sy);
        Lucency lucency = new Lucency();
        lucency.light(this);
        toolbar = findViewById(R.id.toolbar_js_sy);
        setSupportActionBar(toolbar);
        setTitle(null);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back, R.anim.closs);
            }
        });

        TextView textView = findViewById(R.id.zwsj);
        recyclerView = findViewById(R.id.list_recy_list);
        if (sy == null) {
            recyclerView.setVisibility(View.GONE);
        } else if (sy.getData().getMax_floor().equals("0-0")) {
            recyclerView.setVisibility(View.GONE);
        } else if (sy.getData().getFloors().get(0).getLevels().get(0).getBattles() == null) {
            recyclerView.setVisibility(View.GONE);
            flag = 2;
        } else {
            adpter1 = new Sy_recy_Adpter(sy, this, 1);
            adpter2 = new Sy_recy_Adpter(syy, this, 2);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
            stringIntegerHashMap.put(Recy_item_jj.TOP_DECORATION, 30);
            recyclerView.addItemDecoration(new Recy_item_jj(stringIntegerHashMap));
            recyclerView.setAdapter(adpter1);
            recyclerView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        }
    }

    public static void sx(int a) {
        if (a == 0) {
            recyclerView.setAdapter(adpter1);
        } else {
            recyclerView.setAdapter(adpter2);
        }
    }

    @Override
    protected void onDestroy() {
        adpter1=null;
        adpter2=null;
        recyclerView = null;
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back, R.anim.closs);
    }
}