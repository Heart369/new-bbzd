package com.example.main.raw.Menu_Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.main.raw.Class_Custom.Lucency;
import com.example.main.R;

public class Notification_Activity extends AppCompatActivity {
Toolbar toolbar;
    int s=0;
    SwitchCompat switch_1,switch_zd,switch_tsy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        toolbar=findViewById(R.id.toolbar_not);
        setSupportActionBar(toolbar);
        setTitle(null);
        Lucency lucency=new Lucency();
        lucency.light(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                s=1;
                overridePendingTransition(R.anim.back,R.anim.closs);
            }
        });
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