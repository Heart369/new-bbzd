package com.example.main.raw.DsAlgorithm;



import org.jetbrains.annotations.NotNull;

import java.util.Date;
import kotlin.Metadata;

@Metadata(
        mv = {1, 6, 0},
        k = 1,
        d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\u0006"},
        d2 = {"Lcom/example/main/HttpUtil;", "", "()V", "getDs", "", "getStr", "蹦蹦炸弹.app.main"}
)
public class Okhttp {
    @NotNull
    public static final Okhttp INSTANCE;

    public final String getDs() {
        String salt = "ulInCDohgEs557j0VsPDYnQaaz6KJcv5";
        long time = (new Date()).getTime() / (long)1000;
        String str = this.getStr();
        String key = "salt=" + salt + "&t=" + time + "&r=" + str;
        String md5 = Md5.INSTANCE.getMD5(key);
        return "" + time + ',' + str + ',' + md5;
    }

    private final String getStr() {
        String chars = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678";
        int maxPos = chars.length();
        String code = "";
        int var4 = 0;

        for(byte var5 = 5; var4 <= var5; ++var4) {
            StringBuilder var10000 = (new StringBuilder()).append(code);
            double var6 = Math.random() * (double)maxPos;
            code = var10000.append(chars.charAt((int)Math.floor(var6))).toString();
        }

        return code;
    }

    public Okhttp() {
    }

    static {
        Okhttp var0 = new Okhttp();
        INSTANCE = var0;
    }
}
