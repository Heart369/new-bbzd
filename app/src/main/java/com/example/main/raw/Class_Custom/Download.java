package com.example.main.raw.Class_Custom;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Download extends  Thread {
    Context context;

    public Download(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url("https://www.pgyer.com/app/installUpdate/6124c2513f2b91d3f892e311d81507a9?sig=PrsSL%2BfHOSxrkXzWL%2B4IyNNteSvcNVVSdcTRwKjrUtszSvQYBIvWX%2B2y24mId5V3&forceHttps=").build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("TAG","失败");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                File file = new File(context.getExternalFilesDir(null), "bbzd.apk");
                byte[] buffer = new byte[1024];
                int len;
                FileOutputStream fos = new FileOutputStream(file);
                InputStream is = response.body().byteStream();
                long lenm = 0;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                    lenm += len;
                }
                fos.close();
                is.close();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Log.d("TAG","进入安装0");
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    //注意第二个参数，要保持和manifest中android:authorities的值相同
                    Uri uri = FileProvider.getUriForFile(context,
                            context.getPackageName() + ".fileProvider", file);
                    intent.setDataAndType(uri, "application/vnd.android.package-archive");
                } else {
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                }
                try {
                    Log.d("TAG","进入安装1");
                    context.startActivity(intent);
                    Log.d("TAG","进入安装2");
                } catch (Exception e) {
                    Log.d("TAG","进入安装3");
                    Uri packageURI = Uri.parse("package:" + context.getPackageName());
                    intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageURI);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });

    }
}