package com.example.main.raw.Class_Custom;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;

import com.example.main.R;
import com.example.main.raw.JsonPares.gx_json;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class gx {
    String version2="0";
    String version;
    gx_json data;
    String flag;
    Handler handler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                AlertDialog.Builder dialog=new AlertDialog.Builder(context);
                View view= LayoutInflater.from(context).inflate(R.layout.gx,null);
                TextView textView=view.findViewById(R.id.version);
                textView.setText(version2+"--->"+version);
                Button button=view.findViewById(R.id.djgx);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialoganim.dismiss();
                        HttpUtil httpUtil=new HttpUtil(context, data.getData().getDownloadURL(), new HttpUtil.download() {
                            @Override
                            public void download_ok(File file) {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                    //注意第二个参数，要保持和manifest中android:authorities的值相同
                                    Uri uri = FileProvider.getUriForFile(context,
                                            context.getPackageName() + ".fileProvider", file);
                                    intent.setDataAndType(uri, "application/vnd.android.package-archive");
                                } else {
                                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                                }
                                try {
                                    context.startActivity(intent);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            @Override
                            public void download_no() {

                            }
                        },width);
                        httpUtil.start_download();
                    }
                });
                dialog.setView(view);
                dialoganim=dialog.show();
                Window window = dialoganim.getWindow();
                window.setWindowAnimations(R.style.dialogWindowAnim3);
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.dimAmount =0f;
                window.setAttributes(lp);
                window.setBackgroundDrawable(context.getDrawable(R.drawable.shape_19dp));
            }else if (flag!=null){
                Toast.makeText(context, "已经是最新版本"+version, Toast.LENGTH_SHORT).show();
            }
            }

    };
Context context;
    AlertDialog dialoganim;
    int width;
    public gx(Context context, int width, String data) {
        this.context = context;
        this.width = width;
        this.flag=data;
        Log.d("TAG1","进入3");
    }
    public gx(Context context, int width) {
        this.context = context;
        this.width = width;
        Log.d("TAG1","进入2");

    }
    public gx(Context context) {
        this.context = context;
        Log.d("TAG1","进入");
    }
    static public String getVersionName(Context context) throws Exception
    {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(),0);
        return packInfo.versionName;
    }
    public void jcgx(){
        OkHttpClient httpClient = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()//填入数据表单
                .add("_api_key", "2ae59d4cf798d54f2ebdd7bd9d44af0e")
                .add("appKey", "3891c3991c641e96648d0b0d412924b4")
                .build();
        Log.d("TAG","开始查询版本");
        Request getRequest = new Request.Builder()
                .url("https://www.pgyer.com/apiv2/app/check")
                .post(formBody)
                .build();
        Call call = httpClient.newCall(getRequest);
        new Thread(new Runnable() {
            @Override
            public void run() {
           call.enqueue(new Callback() {
               @Override
               public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.d("TAG","错误");
               }
               @Override
               public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                   String content=response.body().string();
                   Gson gson=new Gson();
                 data=gson.fromJson(content, gx_json.class);
                 version=data.getData().getBuildVersion();
                 Log.d("TAG",version);
                   Log.d("TAG",content);
                   try {
                       version2=getVersionName(context);
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   Log.d("TAG",version2);
                       if (version.equals(version2)){
                           Message message=new Message();
                           message.what=1;
                           handler.sendMessage(message);
                           Log.d("TAG","无更新");
                       }
                       else{
                           Log.d("TAG","有更新");
                           Message message=new Message();
                           message.what=0;
                            handler.sendMessage(message);
                       }


               }
           });
            }
        }).start();
    }
}
