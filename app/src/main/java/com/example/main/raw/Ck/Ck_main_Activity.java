package com.example.main.raw.Ck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.main.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Ck_main_Activity extends AppCompatActivity {
Button button,btn_lsjl,btn_cx;
Toolbar toolbar;
Button ok;
EditText editText;
String data2;
int s=0;
    String cookie,region,game_uid,game_biz,authkey;
    Handler handler=new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Toast.makeText(Ck_main_Activity.this, "请先前往登录", Toast.LENGTH_SHORT).show();
            button.setClickable(true);
            super.handleMessage(msg);

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ck_main);
        button=findViewById(R.id.btn_ck);
        toolbar=findViewById(R.id.toolbar_ck_main);
        setSupportActionBar(toolbar);
        setTitle(null);
        editText=findViewById(R.id.edit_ck);
        ok=findViewById(R.id.btn_ok);
        btn_cx=findViewById(R.id.btn_cxbd);
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
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                s=1;
                overridePendingTransition(R.anim.back,R.anim.closs);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Ck_main_Activity.this,Login_Url_Activity.class);
                startActivity(intent);
            }
        });
        btn_lsjl=findViewById(R.id.btn_lsjl);
        btn_lsjl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Ck_main_Activity.this,History_Activity.class);
                startActivity(intent);
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=editText.getText().toString();
                editText.setText(null);
                data2=data;
                if (data.length()<5){
                    Toast.makeText(Ck_main_Activity.this, "不合法的url", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                if ( !data.substring(0,6).equals("https:")){
                    Toast.makeText(Ck_main_Activity.this, "不合法的url"+data.substring(5), Toast.LENGTH_SHORT).show();
                    return;
                }
                OkHttpClient httpClient = new OkHttpClient();
                Request getRequest = new Request.Builder()
                        .url(data)
                        .get()
                        .build();
                Call call = httpClient.newCall(getRequest);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //同步请求，要放到子线程执行
                            Response response = call.execute();
                            String data = response.body().string();
                            try {
                                JSONObject jsonObject=new JSONObject(data);
                                String message=jsonObject.getString("message");
                                if (message.equals("OK")){
                                    Intent intent=new Intent(Ck_main_Activity.this,CkZs_Activity.class);
                                    intent.putExtra("url",data2);
                                    startActivity(intent);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();



            }
        });

        btn_cx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Ck_main_Activity.this, "请等待查询", Toast.LENGTH_SHORT).show();
                btn_cx.setClickable(false);
                button.setClickable(false);
                SharedPreferences preferences=getSharedPreferences("data",MODE_PRIVATE);
                cookie =preferences.getString("cookie","");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpClient httpClient = new OkHttpClient();
                        Request getRequest = new Request.Builder()
                                .url("https://api-takumi.mihoyo.com/binding/api/getUserGameRolesByCookie?game_biz=hk4e_cn")
                                .header("Cookie", cookie)
                                .get()
                                .build();
                        Call call = httpClient.newCall(getRequest);
                        Response response = null;
                        try {
                            response = call.execute();
                            String data_a = response.body().string();

                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(data_a);
                                String data = jsonObject.getString("data");
                                if (data.equals("null")){
                                    Message message=new Message();
                                    handler.sendMessage(message);
                                }

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
                                OkHttpClient httpClient1 = new OkHttpClient();
                                GetDs_cs getDs_cs=new GetDs_cs();
                                Log.d("TAG",""+createRequestBody);

                                Request getRequest1 = new Request.Builder()
                                        .url("https://api-takumi.mihoyo.com/binding/api/genAuthKey")
                                        .header("Content-Type", "application/json;charset=utf-8")
                                        .header("Host", "api-takumi.mihoyo.com")
                                        .header("Accept", "application/json, text/plain, */*")
                                        .header("x-rpc-app_version", "2.28.1")
                                        .header("x-rpc-client_type", "5")
                                        .header("x-rpc-device_id", "CBEC8312-AA77-489E-AE8A-8D498DE24E90")
                                        .header("DS",getDs_cs.getDs())
                                        .header("Cookie",cookie)
                                        .post(createRequestBody)
                                        .build();
                                Call call1 = httpClient1.newCall(getRequest1);
                                Response response1 = call1.execute();
                                String data_M = response1.body().string();
                                Log.d("TAG",data_M);
                                JSONObject jsonObject5=new JSONObject(data_M);
                                String data_N=jsonObject5.getString("data");
                                JSONObject jsonObject6=new JSONObject(data_N);
                                authkey=jsonObject6.getString("authkey");
                                authkey= URLEncoder.encode(authkey,"utf-8");
                                Log.d("TAGCS",authkey+","+game_biz+","+region);
                                String URL="https://hk4e-api.mihoyo.com/event/gacha_info/api/getGachaLog?win_mode=fullscreen&authkey_ver=1&sign_type=2&auth_appid=webview_gacha&init_type=301&gacha_id=b4ac24d133739b7b1d55173f30ccf980e0b73fc1&lang=zh-cn&device_type=mobile&game_version=CNRELiOS3.0.0_R10283122_S10446836_D10316937&plat_type=ios&game_biz="+game_biz+"&size=20&authkey="+authkey+"&region="+region+"&timestamp=1664481732&gacha_type=200&page=1&end_id=0";
                                Log.d("TAGSS",game_biz+","+authkey+","+region);
                                Intent intent=new Intent(Ck_main_Activity.this,CkZs_Activity.class);
                                intent.putExtra("url",URL);
                                intent.putExtra("uid",game_uid);
                                startActivity(intent);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        } catch (IOException e) {
                            e.printStackTrace();

                        }

                    }
                }).start();

            }
        });
    }

    @Override
    protected void onResume() {
        btn_cx.setClickable(true);
        button.setClickable(true);
        super.onResume();
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