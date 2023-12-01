package com.example.main.mvvm.calculator.tool;

import android.content.Context;


import com.example.main.R;
import com.example.main.mvvm.json.CharacterData;
import com.google.gson.Gson;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class FileReader {
    String text;
    public FileReader(Context context) {
        try {
        InputStream is = context.getResources().openRawResource(R.raw.haha);
// 将输入流转换成字节数组
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        is.close();
// 将字节数组转换成字符串
        text = new String(buffer);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public CharacterData du(String id) {
            try {
                JSONObject jsonObject = new JSONObject(text);
                String data = jsonObject.getString(id);
                Gson gson = new Gson();
                CharacterData c = gson.fromJson(data, CharacterData.class);
                return c;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        return null;
    }
}