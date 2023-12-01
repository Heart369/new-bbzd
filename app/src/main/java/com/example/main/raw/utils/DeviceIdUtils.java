package com.example.main.raw.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;

import java.util.UUID;

public class DeviceIdUtils {

    @SuppressLint("HardwareIds")
    public static String getDeviceId(Context context) {
        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        UUID uuid = UUID.nameUUIDFromBytes(androidId.getBytes());
        return uuid.toString();
    }
}
