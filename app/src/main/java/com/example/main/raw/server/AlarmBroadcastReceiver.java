package com.example.main.raw.server;

import static android.content.Context.NOTIFICATION_SERVICE;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.main.raw.activity.MainActivity;
import com.example.main.R;

public class AlarmBroadcastReceiver extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("TAG","123456");
        if (intent.getAction().equals("CLOCK_IN")) {
            Log.d("TAG","12345");

            String id ="channel_1";//channel的id
            String description = "123";//channel的描述信息
            int importance = NotificationManager.IMPORTANCE_HIGH;//channel的重要性
            NotificationChannel channel = new NotificationChannel(id, "123", importance);//生成channel
//为channel添加属性
//channel.enableVibration(true); 震动
//channel.enableLights(true);提示灯
            NotificationManager manager = (NotificationManager)context.getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);//添加channel
            Intent mIntent=new Intent(context, MainActivity.class);  //绑定intent，点击图标能够进入某activity
            PendingIntent mPendingIntent= PendingIntent.getActivity(context, 0, mIntent, PendingIntent.FLAG_IMMUTABLE);
            Notification notification = new Notification.Builder(context,id)
                    .setCategory(Notification.CATEGORY_MESSAGE)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("树脂溢出提示")
                    .setContentText("您的树脂已达到160请及时清理")
                    .setAutoCancel(true)
                    .setFullScreenIntent(mPendingIntent,true)
                    .setContentIntent(mPendingIntent)
                    .build();

            manager.notify(1,notification);

            Log.d("TAG","已经发送通知");



//            //获取状态通知栏管理
//            NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
//            NotificationCompat.Builder builder= new NotificationCompat.Builder(context);
//            //对builder进行配置
//            builder.setContentTitle("上班打卡") //设置通知栏标题
//                    .setContentText("上班打卡") //设置通知栏显示内容
//                    .setPriority(NotificationCompat.PRIORITY_MAX) //设置通知优先级
//                    .setDefaults(DEFAULT_ALL)
//                    .setSmallIcon(R.drawable.dbl)
//                    .setAutoCancel(true); //设置这个标志当用户单击面板就可以将通知取消
//            Intent mIntent=new Intent(context, MainActivity.class);  //绑定intent，点击图标能够进入某activity
//            PendingIntent mPendingIntent= PendingIntent.getActivity(context, 0, mIntent,PendingIntent.FLAG_UPDATE_CURRENT);
//            builder.setContentIntent(mPendingIntent);
//            manager.notify(0, builder.build());  //绑定Notification，发送通知请求



        }
    }
}
