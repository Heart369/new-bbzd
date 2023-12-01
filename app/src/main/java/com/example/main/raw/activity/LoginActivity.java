package com.example.main.raw.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ScrollView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.main.R;
import com.example.main.raw.Class_Custom.Lucency;
import com.example.main.raw.JsonPares.Cookie_grxx;
import com.example.main.raw.JsonPares.grxx;
import com.example.main.raw.JsonPares.jsongrxx;
import com.example.main.raw.server.MyService;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
WebView webView;
Toolbar toolbar;
    LottieAnimationView lottie;
    TextView t1;
int flag_jz=0;
String cookie="123",newCookie,data,data2,tokens,aid,token_v2,mid,cookie_token,ltoken;
    boolean flag=false;
    CookieManager instan = CookieManager.getInstance();
Handler handler=new Handler(Looper.myLooper()){
    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        webView.setVisibility(View.GONE);
        t1.setVisibility(View.VISIBLE);
        lottie.setVisibility(View.VISIBLE);
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Lucency lucency=new Lucency();
        lucency.light(this);
        toolbar=findViewById(R.id.toolbar_login);
        setSupportActionBar(toolbar);
        setTitle(null);
        SharedPreferences preferences=getSharedPreferences("data", MODE_PRIVATE);
        String cookie_sq = preferences.getString("cookie_sq", "");
        if (cookie_sq.length()==0){
            AlertDialog.Builder dialog=new AlertDialog.Builder(LoginActivity.this).setTitle("Cookie授权").setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                finish();
                }
            }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    preferences.edit().putString("cookie_sq","已经同意").apply();
                }
            });
// 添加文本滚动视图
            ScrollView scrollView = new ScrollView(this);
            TextView textView = new TextView(this);
            textView.setText("您登录即表示您同意我们在本站上使用Cookies等技术收集信息，此Cookie将用于获取您的角色信息，便签等官方数据，Cookie将保存在本地不做其他任何形式的保存(同意后不再提示)");
            textView.setPadding(30,20,20,30);
            scrollView.addView(textView);

// 将文本滚动视图添加到对话框中
            dialog.setView(scrollView);
            AlertDialog show = dialog.show();
            Window window = show.getWindow();
            window.setWindowAnimations(R.style.dialogWindowAnim3);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.dimAmount =0f;
            window.setAttributes(lp);
            window.setBackgroundDrawable(getDrawable(R.drawable.shape_19dp));
// 显示对话框

        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back,R.anim.closs);

            }
        });
        webView=findViewById(R.id.web_3);
        lottie=findViewById(R.id.lottie_login);
        t1=findViewById(R.id.text_login);
        lottie.setVisibility(View.GONE);
        t1.setVisibility(View.GONE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("https://user.mihoyo.com");
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().flush();
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                if (flag_jz!=0)
                    return;
                flag_jz++;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (cookie.length()<180){
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            cookie=instan.getCookie("https://user.mihoyo.com");
                            Log.d("TAG",cookie);
                            Log.d("TAG","1");
                            if (flag){
                                finish();
                                overridePendingTransition(R.anim.back,R.anim.closs);
                                break;
                            }

                        }
                        Url();
                    }

                }).start();
            }
        });


    }

    private void Url() {
        Message message=new Message();
        handler.sendMessage(message);
        cookie=instan.getCookie("https://user.mihoyo.com");
        Log.d("TAG",cookie);
        Date date=new Date();
        date.getTime();
        OkHttpClient httpClient = new OkHttpClient();
        Request getRequest = new Request.Builder()
                .url("https://webapi.account.mihoyo.com/Api/login_by_cookie?t="+date.getTime())
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
                    Log.d("TAG55",""+data);
                    try {
                        JSONObject jsonObject=new JSONObject(data);
                        String dataa=jsonObject.getString("data");
                        JSONObject jsonObject1=new JSONObject(dataa);
                        String datab=jsonObject1.getString("account_info");
                        JSONObject jsonObject2= new JSONObject(datab);
                         aid=jsonObject2.getString("account_id");
                        String token=jsonObject2.getString("weblogin_token");
                        Log.d("TAG",aid);
                        Log.d("TAG",token);

                        OkHttpClient httpClient = new OkHttpClient();
                        Request getRequest = new Request.Builder()
                                .url("https://api-takumi.mihoyo.com/auth/api/getMultiTokenByLoginTicket?login_ticket="+token+"&token_types=3&uid="+aid)
                                .header("Cookie",cookie)
                                .get()
                                .build();
                        Call call = httpClient.newCall(getRequest);
                        String data_1 = call.toString();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    //同步请求，要放到子线程执行
                                    Response response = call.execute();
                                    String data_1 = response.body().string();
                                    Log.d("TAG",data_1);
                                    newCookie = "stuid="+aid+";";
                                    try {
                                        JSONObject jsonObject3=new JSONObject(data_1);
                                        String data_2=jsonObject3.getString("data");
                                        JSONObject jsonObject4=new JSONObject(data_2);
                                        JSONArray jsonArray=jsonObject4.getJSONArray("list");
                                        for(int a=0;a<jsonArray.length();a++){
                                            JSONObject jsonObject5=jsonArray.getJSONObject(a);
                                            newCookie+=jsonObject5.getString("name")+"="+jsonObject5.get("token")+";";
                                            if (a==0){
                                                tokens=jsonObject5.getString("token");
                                            }else {
                                                ltoken=jsonObject5.getString("token");
                                            }
                                        }
                                        newCookie+=cookie;
                                        Log.d("TAG",newCookie);
                                        xrdata();

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void xrdata() {
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
                    RequestBody formBody = new FormBody.Builder()
                            .build();
                    //同步请求，要放到子线程执行
                    Response response = call.execute();
                    data = response.body().string();
                    OkHttpClient httpClient = new OkHttpClient();
                    Request getRequest = new Request.Builder()
                            .url("https://passport-api.mihoyo.com/account/ma-cn-session/app/getTokenBySToken")
                            .header("User-Agent","Mozilla/5.0 (Linux; Android 12; V2055A Build/SP1A.210812.003 release-keys; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/107.0.5304.91 Mobile Safari/537.36 miHoYoBBS/2.42.1")
                            .header("x-rpc-app_id","bll8iq97cem8")
                            .header("Cookie","stuid="+aid+";stoken="+tokens)
                            .post(formBody)
                            .build();
                    Call call = httpClient.newCall(getRequest);
                    data2 = call.toString();
                     response = call.execute();
                    data2 = response.body().string();
                    Log.d("TAG",data2);
                    Gson gson=new Gson();
                    Cookie_grxx cookie_xx=gson.fromJson(data2, Cookie_grxx.class);
                    token_v2=cookie_xx.getData().getToken().getToken();
                    mid=cookie_xx.getData().getUser_info().getMid();
                    httpClient = new OkHttpClient();
                    getRequest = new Request.Builder()
                            .url("https://passport-api.mihoyo.com/account/auth/api/getCookieAccountInfoBySToken")
                            .header("User-Agent","Mozilla/5.0 (Linux; Android 12; V2055A Build/SP1A.210812.003 release-keys; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/107.0.5304.91 Mobile Safari/537.36 miHoYoBBS/2.42.1")
                            .header("x-rpc-app_id","bll8iq97cem8")
                            .header("Cookie","stoken="+token_v2+";stuid="+aid+";mid="+mid)
                            .get()
                            .build();
                    call = httpClient.newCall(getRequest);
                     response = call.execute();
                    String data3=response.body().string();
                    try {
                        JSONObject jsonObject=new JSONObject(data3);
                        String dataa=jsonObject.getString("data");
                        jsonObject=new JSONObject(dataa);
                        cookie_token=jsonObject.getString("cookie_token");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    xr();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void xr() {
        grxx grxx1=null;
        Log.d("cookie",cookie);
        SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
        String endcookie="cookie_token="+cookie_token+";mid="+mid+";account_id="+aid+";stoken="+token_v2+";ltuid="+aid+";ltoken="+ltoken+";stuid"+aid;
        editor.putString("cookie",endcookie);
        jsongrxx js = new jsongrxx(data);
        grxx1= js.jx();
        editor.putString("uid",grxx1.getGame_uid());
        editor.putString("server",grxx1.getRegion());
        editor.putString("name",grxx1.getNickname());
        editor.putString("level",""+grxx1.getLevel());
        editor.putString("server_name",""+grxx1.getRegion_name());
        Log.d("COOKIE",endcookie);
        editor.apply();
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().flush();
        Intent intent=new Intent(LoginActivity.this, MyService.class);
        startService(intent);
            finish();
        overridePendingTransition(R.anim.back,R.anim.closs);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag=true;
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back,R.anim.closs);
    }
}