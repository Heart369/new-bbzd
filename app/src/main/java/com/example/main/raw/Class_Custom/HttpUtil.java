package com.example.main.raw.Class_Custom;

import static android.content.Context.NOTIFICATION_SERVICE;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;

import com.example.main.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class HttpUtil {
    Context context;
    String url;
    download jk;
    long len_new;
    Notification notification;
    private MediaPlayer mPlayer = null;
    File file_apk;
    AlertDialog dialoganim;
    AlertDialog.Builder dialog;
    TextView speed,bfb,size;
    ImageView tb;
    ProgressBar progressBar;
    long len_m, old=0;
    SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    int max=0,width,cs=0;
    Handler handler=new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    long s= (long) msg.obj;
                    DecimalFormat decimalFormat = new DecimalFormat( "#");
                    String formattedRandomNumber = decimalFormat.format((double)s/(max/1024/1024)*100);
                    double result =  Double.parseDouble(formattedRandomNumber);
                    size.setText(s+"/"+(max/1024/1024)+"MB");
                    bfb.setText((int)result+"%");
                    break;
                case 2:
                    speed.setText(msg.obj+"kb/s");
                    break;
            }

        }
    };

    public HttpUtil(Context context, String url, download jk, int width) {
        this.context = context;
        this.url = url;
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", url);
        clipboard.setPrimaryClip(clip);
        Log.d("TAGURL",url);
        this.jk = jk;
        this.width=width;
    }
    public void start_download(){
        file_apk=new File(context.getExternalFilesDir(null),"bbzd.apk");
        dialog=new AlertDialog.Builder(context);
        View view= LayoutInflater.from(context).inflate(R.layout.download,null,false);
        bfb=view.findViewById(R.id.bfb);
        size=view.findViewById(R.id.jtsj);
        speed=view.findViewById(R.id.speed);
        tb=view.findViewById(R.id.image_jdt);
        AnimationDrawable mAnimationDrawable = (AnimationDrawable) tb.getDrawable();
        mAnimationDrawable.start();
        progressBar=view.findViewById(R.id.jdt_down);
        surfaceView=view.findViewById(R.id.sur);
        surfaceView.setVisibility(View.GONE);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
//                mPlayer.setDisplay(surfaceHolder);
//                mPlayer.start();
//                mPlayer.setLooping(true);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });
        mPlayer = MediaPlayer.create(context, R.raw.kl_bp);
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        dialog.setView(view);
        dialoganim=dialog.show();
        Window window = dialoganim.getWindow();
        window.setWindowAnimations(R.style.dialogWindowAnim3);
        WindowManager.LayoutParams lp = window.getAttributes();
        RelativeLayout.LayoutParams ls= (RelativeLayout.LayoutParams) tb.getLayoutParams();
        lp.dimAmount =0f;
        Dp_Px dp_px=new Dp_Px();
        lp.height= dp_px.dip2px(context,200);
        window.setAttributes(lp);
        int ri=dp_px.dip2px(context,70);
        window.setBackgroundDrawable(context.getDrawable(R.drawable.shape_19dp));
        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void run() {
                try {
                    URL url1=new URL(url);
                    HttpURLConnection connection= (HttpURLConnection) url1.openConnection();
                    connection.setConnectTimeout(20000);
                    connection.setReadTimeout(20000);
                    connection.connect();
                    int code=connection.getResponseCode();
                    Log.d("TAGcode",""+code);
                    InputStream is=connection.getInputStream();
                    FileOutputStream fos=new FileOutputStream(file_apk);
                    max=connection.getContentLength();
                    progressBar.setMax(connection.getContentLength());
                    byte[] buffer=new byte[1024];
                    int len;
                     len_m=0;
                     int jl=0;
                     long zt=0;
                    jsq();
                    while ((len=is.read(buffer))!=-1){
                        fos.write(buffer,0,len);
                        len_m++;
                        zt+=len;
                        progressBar.incrementProgressBy(len);
                        ls.setMargins((int) ((double)(width-ri)/(connection.getContentLength()/1024)*(zt/1024)),0,0,0);
                        if (len_m%1024==0){
                            Message message=new Message();
                            message.what=1;
                            message.obj=len_m/1024;
                            jl+=len;
                            handler.sendMessage(message);
                            createtz(jl);

                        }
                    }
                    createtz(-3);
                    fos.close();
                    is.close();
                    connection.disconnect();
                    len_m=-5;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void jsq() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                old=len_m;
                try {
                    while (len_m!=-5){
                        Thread.sleep(1000);
                        len_new=len_m-old;
                        Message message=new Message();
                        message.what=2;
                        message.obj=len_new;
                        Log.d("TAG",""+len_new+"kb/s");
                        handler.sendMessage(message);
                        old=len_m;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createtz(int s) {
        String id ="channel_1";//channel的id
        String description = "123";//channel的描述信息
        int importance = NotificationManager.IMPORTANCE_DEFAULT;//channel的重要性
        NotificationChannel channel = new NotificationChannel(id, "123", importance);//生成channel
//为channel添加属性
        channel.enableVibration(false);// 震动
        channel.enableLights(false);//提示灯
        NotificationManager manager = (NotificationManager)context.getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);//添加channel
        if (s==-3){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                //注意第二个参数，要保持和manifest中android:authorities的值相同
                Uri uri = FileProvider.getUriForFile(context,
                        context.getPackageName() + ".fileProvider", file_apk);
                intent.setDataAndType(uri, "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file_apk), "application/vnd.android.package-archive");
            }

            PendingIntent mPendingIntent= PendingIntent.getActivity(context, 0,intent, PendingIntent.FLAG_IMMUTABLE);
            importance = NotificationManager.IMPORTANCE_HIGH ;
            channel = new NotificationChannel(id, "123", importance);
            channel.enableVibration(false);// 震动
            channel.enableLights(false);//提示灯
             manager = (NotificationManager)context.getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);//添加channel
            notification = new Notification.Builder(context,id)
                    .setCategory(Notification.CATEGORY_MESSAGE)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("下载完成")
                    .setContentText("点击进行安装")
                    .setAutoCancel(true)
                    .setContentIntent(mPendingIntent)
                    .build();
            manager.notify(2,notification);
            manager.cancel(1);
            Log.d("TAG","下载完毕");
            jk.download_ok(file_apk);
            return;
        }else {
            notification = new Notification.Builder(context,id)
                    .setCategory(Notification.CATEGORY_MESSAGE)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("正在下载")
                    .setContentText(""+len_new+"kb/s")
                    .setProgress(max,s*1024,false)
                    .setAutoCancel(true)
                    .build();
        }


             manager.notify(1,notification);

    }

    public void tz(){

    }

    public interface download{
        public void download_ok(File file);

        public void download_no();
    }
}
