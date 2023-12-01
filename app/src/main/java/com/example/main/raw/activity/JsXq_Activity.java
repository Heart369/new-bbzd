package com.example.main.raw.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.Animator;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bm.library.PhotoView;
import com.example.main.R;
import com.example.main.raw.Adpter.Grid_jsxq_Adpter;
import com.example.main.raw.Class_Custom.Lucency;
import com.example.main.raw.Class_Custom.Share;
import com.example.main.raw.JsonPares.JxJs;
import com.yalantis.ucrop.UCrop;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dev.utils.app.CapturePictureUtils;

public class JsXq_Activity extends AppCompatActivity {
    static JxJs jxJs;
    GridView gridView;
    Toolbar toolbar;
    int s = 0;
    PhotoView cz;
    TextView qx;
    Bitmap bitmap;
    ImageView cc,bc,qq,wx;
    LinearLayout layout;
    public static Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            jxJs = (JxJs) msg.obj;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_xq);
        Lucency lucency = new Lucency();
        lucency.light(this);
        toolbar = findViewById(R.id.toolbar_js_zs);
        cc = findViewById(R.id.cc);
        cz=findViewById(R.id.image_cz);
        layout=findViewById(R.id.lin_cz);
        bc=findViewById(R.id.imageView19);
        qq=findViewById(R.id.bc);
        wx=findViewById(R.id.imageView20);
        layout.setVisibility(View.GONE);
        qx=findViewById(R.id.textView26);
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Share.sharedToQQ(JsXq_Activity.this,Share.shareImageToQQ(bitmap,JsXq_Activity.this),null);
            }
        });
        wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Share.shareImageToQQ(bitmap,JsXq_Activity.this);
                Share.sharedToWx(JsXq_Activity.this,uri,null);

            }
        });
        qx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.animate().alpha(0).setDuration(1000).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (layout.getAlpha()<0.1)
                        layout.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();


            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Share.getImageUri(bitmap,JsXq_Activity.this);
            }
        });
// 将 Matrix 对象应用到 ImageView 上
        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridView.setSelection(0);
                gridView.smoothScrollToPosition(gridView.getCount() - 1);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 在这里编写要执行的代码块
                        // 例如：更新 UI、弹出提示框等操作
                        gridView.setDrawingCacheEnabled(true);
                        gridView.buildDrawingCache();
                        CapturePictureUtils.setBackgroundColor(0xFFFFFFFF);
                        bitmap = CapturePictureUtils.snapshotByGridView(gridView);
                        cz.setImageBitmap(bitmap);
                        cz.enable();
                        layout.setAlpha(0);
                        layout.setVisibility(View.VISIBLE);
                        layout.animate().alpha(1).setDuration(1000).start();
                    }
                }, 1000); // 2000ms = 2s

            }
        });
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back, R.anim.closs);
                s = 1;
            }
        });

        setTitle(null);
        gridView = findViewById(R.id.grid_js);
        Grid_jsxq_Adpter adpter = new Grid_jsxq_Adpter(jxJs, this);
        gridView.setAdapter(adpter);
        Intent intent = getIntent();
        String uid = intent.getStringExtra("cuid");
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(JsXq_Activity.this, BottomArcActivity.class);
                intent.putExtra("page", position);
                if (uid.equals("0"))
                    intent.putExtra("cuid", "ss");
                else
                    intent.putExtra("cuid", uid);
                startActivity(intent);
            }
        });
    }




    @Override
    protected void onPause() {
        super.onPause();
        if (s == 0) {
            overridePendingTransition(R.anim.start, R.anim.back);
        }
        s = 0;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        s = 1;
        overridePendingTransition(R.anim.back, R.anim.closs);
    }


}