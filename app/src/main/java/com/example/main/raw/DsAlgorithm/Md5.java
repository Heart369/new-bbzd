package com.example.main.raw.DsAlgorithm;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public class Md5 {
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
