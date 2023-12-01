package com.example.main.mvvm.adapter.calculator.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.main.R;
import com.example.main.mvvm.calculator.role.Obj_calculator;
import com.example.main.raw.SQLite.CalSQLite;

import java.text.DecimalFormat;

public class List_Ty_Adapter extends BaseAdapter {
    Context context;
    Obj_calculator obj_calculator;

    public List_Ty_Adapter(Context context, Obj_calculator obj_calculator) {
        this.context = context;
        this.obj_calculator = obj_calculator;
    }

    @Override
    public int getCount() {
        return obj_calculator.getZyList().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @SuppressLint("Range")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CalSQLite sqLite = new CalSQLite(context, "cal.bd", null, 1);
        SQLiteDatabase db = sqLite.getWritableDatabase();
        Cursor cursor = db.query("cal", new String[]{"name"}, "id=?", new String[]{obj_calculator.getZyList().get(position).getKey()}, null, null, null);
       cursor.moveToFirst();
        String data = null;
       if (cursor.getCount()!=0)
       data=cursor.getString(cursor.getColumnIndex("name"));
        View view= LayoutInflater.from(context).inflate(R.layout.ty_item,parent,false);
        TextView name=view.findViewById(R.id.tet_name),exp=view.findViewById(R.id.tet_exp);
        name.setText(obj_calculator.getZyList().get(position).getName());
        DecimalFormat decimalFormat1 = new DecimalFormat("#");
        DecimalFormat decimalFormat2 = new DecimalFormat("0.#%");
        if (obj_calculator.getZyList().get(position).getDex()<10)
        exp.setText(decimalFormat2.format(obj_calculator.getZyList().get(position).getDex())+","+data);
        else    exp.setText(decimalFormat1.format(obj_calculator.getZyList().get(position).getDex())+","+data);
        cursor.close();
        db.close();

        return view;
    }
}
