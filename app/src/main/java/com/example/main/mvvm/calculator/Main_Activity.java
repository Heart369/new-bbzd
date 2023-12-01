package com.example.main.mvvm.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.main.R;
import com.example.main.mvvm.adapter.calculator.Main_listview_adapter;
import com.example.main.mvvm.base.BaseActivity;
import com.example.main.mvvm.sqlite.Js_SQLite;
import com.example.main.raw.JsonPares.Jszsg;
import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main_Activity extends BaseActivity {
    ListView listView;
    View view;
    EditText editText;
    TextView textview;
    List<String> uids;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setToolbar(R.id.toolbar_caMain, R.id.title_caMain, "原神计算器");
        uids = getStrings();
        View view = findViewById(R.id.view_zw);
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        lp.height = getStatusBarHeight();
        editText = findViewById(R.id.editText);
        textview = findViewById(R.id.textView_qr);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid = editText.getText().toString();
                if (uid.length() != 9)
                    Toast.makeText(Main_Activity.this, "uid不合法", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(Main_Activity.this, Calculator_Activity.class);
                    intent.putExtra("uid", uid);
                    startActivity(intent);
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Main_Activity.this, Calculator_Activity.class);
                intent.putExtra("uid", uids.get(position));
                startActivity(intent);
            }
        });

    }

    @SuppressLint("Range")
    @NonNull
    private List<String> getStrings() {
        Js_SQLite sqLite = new Js_SQLite(this, "enka.bd", null, 1);
        SQLiteDatabase database = sqLite.getWritableDatabase();
        Cursor cursor = database.query("js", new String[]{"uid", "json"}, null, null, null, null, null);
        cursor.moveToFirst();
        List<Jszsg> jszsgs = new ArrayList<>();
        List<String> uids = new ArrayList<>();
        Gson gson = new Gson();
        for (int a = 0; a < cursor.getCount(); a++) {
            byte[] jsonData = cursor.getBlob(cursor.getColumnIndex("json"));
            String jsonString = new String(jsonData, StandardCharsets.UTF_8);
            Jszsg jszsg = gson.fromJson(jsonString, Jszsg.class);
            jszsgs.add(jszsg);
            String uid = cursor.getString(cursor.getColumnIndex("uid"));
            uids.add(uid);
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        listView = findViewById(R.id.list_ca);
        Main_listview_adapter adapter = new Main_listview_adapter(jszsgs, this, uids, new Main_listview_adapter.Del() {
            @Override
            public void del(int po) {
                Js_SQLite sqLite = new Js_SQLite(Main_Activity.this, "enka.bd", null, 1);
                SQLiteDatabase database = sqLite.getWritableDatabase();
                database.delete("js","uid=?",new String[]{uids.get(po)});
                getStrings();
            }
        });
        listView.setAdapter(adapter);
        return uids;
    }

    @Override
    protected void onResume() {
        super.onResume();
        uids=getStrings();

    }
}