package com.example.main.raw.Ck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
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
import android.widget.TextView;

import com.example.main.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Login_Url_Activity extends AppCompatActivity {
    private Handler mhandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==2){
                webView.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
                textView.setText("正在获取url请稍后");
            }else {
                textView.setText("获取成功"+URL);
                Intent intent=new Intent(Login_Url_Activity.this,CkZs_Activity.class);
                intent.putExtra("url",URL);
                intent.putExtra("uid",game_uid);
                startActivity(intent);
            }
        }
    };
Toolbar toolbar;
    CookieManager instan = CookieManager.getInstance();
WebView webView;
String cookie="1";
String data;
int s=0;
    boolean flag_qd=true;
    String newCookie;
    String URL;
    String game_biz;
    String region;
    String game_uid;
    String authkey;
    boolean flag=false;
    boolean flag2=false;
    TextView textView;
    Date date=new Date();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_url);
        toolbar=findViewById(R.id.toolbar_ck_login);
        setSupportActionBar(toolbar);
        textView =findViewById(R.id.zsjz);
        textView.setVisibility(View.GONE);
        setTitle(null);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back,R.anim.closs);
                s=1;
                flag=true;
            }
        });
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int option = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            window.getDecorView().setSystemUiVisibility(option);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        webView=findViewById(R.id.web_2);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("https://user.mihoyo.com");
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().flush();

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                if (!flag_qd)
                    return;
                flag_qd=false;
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
                                s=1;
                                break;
                            }

                        }
                        Message message=new Message();
                        message.what=2;
                        mhandler.sendMessage(message);
                        Url();
                    }

                }).start();
            }
        });



    }

    private void Url() {
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
                        String aid=jsonObject2.getString("account_id");
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
                                        }
                                        newCookie+=cookie;
                                        Log.d("TAG",newCookie);
                                        OkHttpClient httpClient = new OkHttpClient();
                                        Request getRequest = new Request.Builder()
                                                .url("https://api-takumi.mihoyo.com/binding/api/getUserGameRolesByCookie?game_biz=hk4e_cn")
                                                .header("Cookie", newCookie)
                                                .get()
                                                .build();
                                        Call call = httpClient.newCall(getRequest);
                                        String data_a = call.toString();
                                        Log.d("NEWCOOKIE",newCookie);
                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                try {
                                                    //同步请求，要放到子线程执行
                                                    Response response = call.execute();
                                                    String data_a = response.body().string();
                                                    Log.d("TAG",data_a);
                                                    try {
                                                        JSONObject jsonObject =new JSONObject(data_a);
                                                        String data = jsonObject.getString("data");
                                                        JSONObject jsonObject1 = new JSONObject(data);
                                                        JSONArray jsonArray = jsonObject1.getJSONArray("list");
                                                        JSONObject jsonObject2 =jsonArray.getJSONObject(0);
                                                        region = jsonObject2.getString("region");
                                                        game_uid = jsonObject2.getString("game_uid");
                                                        game_biz = jsonObject2.getString("game_biz");
                                                        Gson gson = new Gson();
                                                        JsonData jsonData=new JsonData("webview_gacha",game_biz,game_uid,region);
                                                        String jsdata =gson.toJson(jsonData);
                                                        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
                                                        RequestBody createRequestBody = RequestBody.create(mediaType,jsdata);
                                                        OkHttpClient httpClient = new OkHttpClient();
                                                        GetDs_cs getDs_cs=new GetDs_cs();
                                                        Log.d("TAG",""+createRequestBody);
                                                        Request getRequest = new Request.Builder()
                                                                .url("https://api-takumi.mihoyo.com/binding/api/genAuthKey")
                                                                .header("Content-Type", "application/json;charset=utf-8")
                                                                .header("Host", "api-takumi.mihoyo.com")
                                                                .header("Accept", "application/json, text/plain, */*")
                                                                .header("x-rpc-app_version", "2.28.1")
                                                                .header("x-rpc-client_type", "5")
                                                                .header("x-rpc-device_id", "CBEC8312-AA77-489E-AE8A-8D498DE24E90")
                                                                .header("DS",getDs_cs.getDs())
                                                                .header("Cookie", newCookie)
                                                                .post(createRequestBody)
                                                                .build();
                                                        Call call = httpClient.newCall(getRequest);
                                                        String data_1 = call.toString();
                                                        new Thread(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                try {
                                                                    //同步请求，要放到子线程执行
                                                                    Response response = call.execute();
                                                                    String data_M = response.body().string();

                                                                    try {
                                                                        JSONObject jsonObject5=new JSONObject(data_M);
                                                                        String data_N=jsonObject5.getString("data");
                                                                        JSONObject jsonObject6=new JSONObject(data_N);
                                                                        authkey=jsonObject6.getString("authkey");
                                                                        authkey= URLEncoder.encode(authkey,"utf-8");


                                                                    } catch (JSONException e) {
                                                                        e.printStackTrace();
                                                                    }
                                                                    URL="https://hk4e-api.mihoyo.com/event/gacha_info/api/getGachaLog?win_mode=fullscreen&authkey_ver=1&sign_type=2&auth_appid=webview_gacha&init_type=301&gacha_id=b4ac24d133739b7b1d55173f30ccf980e0b73fc1&lang=zh-cn&device_type=mobile&game_version=CNRELiOS3.0.0_R10283122_S10446836_D10316937&plat_type=ios&game_biz="+game_biz+"&size=20&authkey="+authkey+"&region="+region+"&timestamp=1664481732&gacha_type=200&page=1&end_id=0";
                                                                    Log.d("TAG",URL);
                                                                    Message message= new Message();
                                                                    message.what = 1;
                                                                    response.close();
                                                                    mhandler.sendMessage(message);

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

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG","已经进入"+flag2);

            finish();
        overridePendingTransition(R.anim.back,R.anim.closs);
        s=1;
        flag=true;

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag=true;
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