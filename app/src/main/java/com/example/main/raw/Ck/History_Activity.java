package com.example.main.raw.Ck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.main.raw.Adpter.List_History_Adpter;
import com.example.main.R;
import com.example.main.raw.SQLite.CkSQLite;

import java.util.ArrayList;
import java.util.List;
@SuppressLint("Range")
public class History_Activity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    TextView textView;
    int s=0;
    List<String> uid_list=new ArrayList<>();
    List<String> size_list=new ArrayList<>();
    List<String> five_list=new ArrayList<>();
    List<String> sy_list=new ArrayList<>();
    List<String> jsq_list=new ArrayList<>();
    SQLiteDatabase database;
    CkSQLite sqLite = new CkSQLite(this,"ck.db",null,1);
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        toolbar=findViewById(R.id.toolbar_ck_history);
        setSupportActionBar(toolbar);
        setTitle(null);
        textView=findViewById(R.id.text_ck_ts);
        textView.setVisibility(View.GONE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back,R.anim.closs);
                s=1;
            }
        });
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
        listView=findViewById(R.id.list_history);

        database = sqLite.getWritableDatabase();
       sxlist();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(History_Activity.this,CkZs_Activity.class);
                intent.putExtra("post",uid_list.get(position));
                startActivity(intent);
            }
        });

        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add(Menu.NONE, 0, 0, "删除");

            }
        });






    }

    public void sxlist(){
        Cursor cursor = database.query("ck", new String[]{"uid","size","five","sy","jsq"}, null,
                null, null, null, null);
        if (cursor.getCount()==0)
            textView.setVisibility(View.VISIBLE);
        uid_list=new ArrayList<>();
        size_list=new ArrayList<>();
        five_list =new ArrayList<>();
        sy_list=new ArrayList<>();
        jsq_list=new ArrayList<>();
        while(cursor.moveToNext()) {
            Log.d("TAG", "已进入");
            String uid = cursor.getString(cursor.getColumnIndex("uid"));
            String size=cursor.getString(cursor.getColumnIndex("size"));
            String five=cursor.getString(cursor.getColumnIndex("five"));
            String sy=cursor.getString(cursor.getColumnIndex("sy"));
            String jsq=cursor.getString(cursor.getColumnIndex("jsq"));
            uid_list.add(uid);
            size_list.add(size);
            five_list.add(five);
            sy_list.add(sy);
            jsq_list.add(jsq);
        }

        if (uid_list.size()!=0){
            List_History_Adpter adpter=new List_History_Adpter(uid_list,size_list,this);
            listView.setAdapter(adpter);
        }else
            listView.setAdapter(null);
    }
    public boolean onContextItemSelected(MenuItem item){
        //关键代码在这里
        AdapterView.AdapterContextMenuInfo menuInfo;
        menuInfo =(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case 0:
                database.delete("ck","uid=?",new String[]{uid_list.get(menuInfo.position)});
                sxlist();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.close();
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