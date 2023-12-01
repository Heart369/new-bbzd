package com.example.main.raw.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.example.main.R;
import com.example.main.raw.JsonPares.grxx;
import com.example.main.raw.JsonPares.jsongrxx;
import com.example.main.raw.server.MyService;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//登录页面
public class login_Activity extends AppCompatActivity {
      WebView webView;
      String cookie;

    String data=null;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button_fh=findViewById(R.id.btn_fh);
        button_fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int option = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            window.getDecorView().setSystemUiVisibility(option);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        webView=findViewById(R.id.web_1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });

        String a = "https://user.mihoyo.com/login-platform/mobile.html?game_biz=bbs_cn&app_id=bll8iq97cem8&token_type=4&app_version=2.40.1&environment=production&redirect_url=https%253A%252F%252Fm.bbs.mihoyo.com%252Fys%252F%2523%252Fhome%252F0&sync_login_status=1&platform=5&st=https%253A%252F%252Fm.bbs.mihoyo.com%252Fys%252F%2523%252Fhome%252F0#/login/password";
        webView.loadUrl(a);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                CookieManager instan = CookieManager.getInstance();
                cookie = instan.getCookie("https://user.mihoyo.com/login-platform/mobile.html?game_biz=bbs_cn&app_id=bll8iq97cem8&token_type=4&app_version=2.40.1&environment=production&redirect_url=https%253A%252F%252Fm.bbs.mihoyo.com%252Fys%252F%2523%252Fhome%252F0&sync_login_status=1&platform=5&st=https%253A%252F%252Fm.bbs.mihoyo.com%252Fys%252F%2523%252Fhome%252F0#/login/password");

                OkHttpClient httpClient = new OkHttpClient();
                Request getRequest = new Request.Builder()
                        .url("https://api-takumi.mihoyo.com/binding/api/getUserGameRolesByCookie?game_biz=hk4e_cn")
                        .header("User-Agent","Dalvik/2.1.0 (Linux; U; Android 12; V2055A Build/SP1A.210812.003)")
                        .header("Host","api-takumi.mihoyo.com")
                        .header("Cookie",cookie)
                        .get()
                        .build();
                Call call = httpClient.newCall(getRequest);
                data = call.toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //同步请求，要放到子线程执行
                            Response response = call.execute();
                            data = response.body().string();
                            flag=1;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                grxx grxx1=null;
                Log.d("cookie",cookie);
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("cookie",cookie);
                while (true){
                    if(flag==1){
                        jsongrxx js = new jsongrxx(data);
                        grxx grxx= js.jx();
                        grxx1=grxx;
                        break;
                    }
                }
                editor.putString("uid",grxx1.getGame_uid());
                editor.putString("server",grxx1.getRegion());
                editor.putString("name",grxx1.getNickname());
                editor.putString("level",""+grxx1.getLevel());
                editor.putString("server_name",""+grxx1.getRegion_name());
                editor.apply();
                CookieManager.getInstance().removeAllCookies(null);
                CookieManager.getInstance().flush();
                Toast.makeText(login_Activity.this, "写入成功", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(login_Activity.this, MyService.class);
                startService(intent);
                finish();


                return true;
            }
        });

    }

}