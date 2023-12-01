package com.example.main.raw.Ck;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(
        mv = {1, 6, 0},
        k = 1,
        d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"},
        d2 = {"Lcom/example/main/Md5Util;", "", "()V", "getMD5", "", "str", "抽卡测试.app.main"}
)
public final class Md5 {
    @NotNull
    public static final Md5 INSTANCE;

    @Nullable
    public final String getMD5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            Charset var4 = Charsets.UTF_8;
            byte[] var10001 = str.getBytes(var4);
            Intrinsics.checkExpressionValueIsNotNull(var10001, "(this as java.lang.String).getBytes(charset)");
            md.update(var10001);

            String result;
            for(result = (new BigInteger(1, md.digest())).toString(16); result.length() < 32; result = '0' + result) {
            }

            return result;
        } catch (Exception var5) {
            System.out.println(var5);
            return null;
        }
    }

    private Md5() {
    }

    static {
        Md5 var0 = new Md5();
        INSTANCE = var0;
    }
}