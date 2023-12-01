package com.example.main.mvvm.adapter.calculator.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.main.R;
import com.example.main.mvvm.calculator.role.Obj_calculator;
import com.example.main.mvvm.calculator.tool.Syw_data;
import com.example.main.raw.SQLite.CalSQLite;

import java.text.DecimalFormat;

public class Grid_adapter extends BaseAdapter {
    Obj_calculator obj_calculator;
    Context context;
    int po = 0;
    SQLiteDatabase db;
    String[] sx = new String[]{"EQUIP_BRACER", "EQUIP_NECKLACE", "EQUIP_SHOES", "EQUIP_RING", "EQUIP_DRESS", "ss"};
double zpf=0;
    public void setObj_calculator(Obj_calculator obj_calculator) {
        this.obj_calculator = obj_calculator;
    }

    public Grid_adapter(Obj_calculator obj_calculator, Context context) {
        this.obj_calculator = obj_calculator;
        this.context = context;

        po = 0;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void SetText(TextView textView, float statValue, String key) {
        if (key.contains("PERCENT") || key.equals("FIGHT_PROP_CRITICAL") || key.equals("FIGHT_PROP_CRITICAL_HURT") || key.equals("FIGHT_PROP_CHARGE_EFFICIENCY") || key.contains("HURT")) {
            textView.setText(statValue + "%");
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("#");
            textView.setText(decimalFormat.format(statValue));
        }
    }

    public void SetName(TextView textView, String name) {
        if (name.contains("伤害")) {
            textView.setText(name.replace("加成", ""));
        } else if (name.contains("效率"))
            textView.setText(name.replace("效率", ""));
        else textView.setText(name);
    }

    @SuppressLint("Range")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Syw_data syw_data = obj_calculator.data.get(sx[position]);
        View view;
        ImageView tb = null, tb2 = null;
        TextView name1 = null, name2 = null, name3 = null, name4 = null, name0 = null, name_wq = null, name_jl = null;
        TextView exp_0 = null, exp_1 = null, exp_2 = null, exp_3 = null, exp_4 = null, cts1 = null, cts2 = null, cts3 = null, cts4 = null, zpt = null,syw_hz=null;
        if (position < 5) {
            view = LayoutInflater.from(context).inflate(R.layout.cal_grid, parent, false);
            name0 = view.findViewById(R.id.textView_syw_Zct);
            name1 = view.findViewById(R.id.sx_name_1);
            name2 = view.findViewById(R.id.sx_name_2);
            name3 = view.findViewById(R.id.sx_name_3);
            name4 = view.findViewById(R.id.sx_name_4);
            exp_1 = view.findViewById(R.id.ct_1);
            exp_2 = view.findViewById(R.id.ct_2);
            exp_3 = view.findViewById(R.id.ct_3);
            exp_4 = view.findViewById(R.id.ct_4);
            exp_0 = view.findViewById(R.id.textView22);
            cts1 = view.findViewById(R.id.cts_1);
            cts2 = view.findViewById(R.id.cts_2);
            cts3 = view.findViewById(R.id.cts_3);
            cts4 = view.findViewById(R.id.cts_4);
            tb = view.findViewById(R.id.image_syw);
            zpt = view.findViewById(R.id.zpf);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.cal_grid_item5, parent, false);
            tb2 = view.findViewById(R.id.imageView17);
            name_wq = view.findViewById(R.id.textView20);
            name_jl = view.findViewById(R.id.textView_jl);
            syw_hz=view.findViewById(R.id.pf_hz);
        }


        CalSQLite sqLite = new CalSQLite(context, "cal.bd", null, 1);
        db = sqLite.getWritableDatabase();
        if (position < po)
            po = position;
        if (obj_calculator.getJszsg_fb().equipList.get(po).flat.equipType != null)
            if (obj_calculator.getJszsg_fb().equipList.get(po).flat.equipType.equals(sx[position])) {
                Glide.with(context).load("https://enka.network/ui/" + obj_calculator.getJszsg_fb().equipList.get(po).getFlat().icon + ".png").into(tb);
                Cursor cursor = db.query("cal", new String[]{"name"}, "id=?", new String[]{obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquaryMainstat.mainPropId}, null, null, null);
                cursor.moveToFirst();
                SetName(name0, cursor.getString(cursor.getColumnIndex("name")));
                cursor.close();
                if (syw_data!=null){
                    zpt.setText(syw_data.getzpf() + "分");
                    zpf+=syw_data.getZpf();
                }

                SetText(exp_0, obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquaryMainstat.statValue, obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquaryMainstat.mainPropId);
                if (obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats != null)
                    switch (obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.size()) {
                        case 4:
                            cursor = db.query("cal", new String[]{"name"}, "id=?", new String[]{obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.get(3).appendPropId}, null, null, null);
                            cursor.moveToFirst();
                            SetName(name4, cursor.getString(cursor.getColumnIndex("name")));
                            cursor.close();
                            cts4.setText((int) syw_data.getCts()[3] + "");
                            color(syw_data.getColor()[3],name4,exp_4,cts4 );
                            SetText(exp_4, (float) obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.get(3).statValue, obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.get(3).appendPropId);
                        case 3:
                            cursor = db.query("cal", new String[]{"name"}, "id=?", new String[]{obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.get(2).appendPropId}, null, null, null);
                            cursor.moveToFirst();
                            SetName(name3, cursor.getString(cursor.getColumnIndex("name")));
                            cursor.close();
                            cts3.setText((int) syw_data.getCts()[2] + "");
                            color(syw_data.getColor()[2],name3,exp_3,cts3);
                            SetText(exp_3, (float) obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.get(2).statValue, obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.get(2).appendPropId);
                        case 2:
                            cursor = db.query("cal", new String[]{"name"}, "id=?", new String[]{obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.get(1).appendPropId}, null, null, null);
                            cursor.moveToFirst();
                            SetName(name2, cursor.getString(cursor.getColumnIndex("name")));
                            cursor.close();
                            cts2.setText((int) syw_data.getCts()[1] + "");
                            color(syw_data.getColor()[1],name2,exp_2,cts2);
                            SetText(exp_2, (float) obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.get(1).statValue, obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.get(1).appendPropId);
                        case 1:
                            cursor = db.query("cal", new String[]{"name"}, "id=?", new String[]{obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.get(0).appendPropId}, null, null, null);
                            cursor.moveToFirst();
                            SetName(name1, cursor.getString(cursor.getColumnIndex("name")));
                            SetText(exp_1, (float) obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.get(0).statValue, obj_calculator.getJszsg_fb().equipList.get(po).flat.reliquarySubstats.get(0).appendPropId);
                            cts1.setText((int) syw_data.getCts()[0] + "");
                            color(syw_data.getColor()[0],name1,exp_1,cts1);
                            cursor.close();
                            break;

                    }
                cursor.close();
                if (position >= po)
                    po++;
                cursor.close();
            } else {

            }
        else {
            if (position == 5) {
                Cursor cursor = db.query("cal", new String[]{"name"}, "id=?", new String[]{obj_calculator.getJszsg_fb().equipList.get(po).flat.nameTextMapHash}, null, null, null);
                cursor.moveToFirst();
                Glide.with(context).load("https://enka.network/ui/" + obj_calculator.getJszsg_fb().equipList.get(po).getFlat().icon + ".png").into(tb2);
                name_wq.setText(cursor.getString(cursor.getColumnIndex("name")));
                name_jl.setText("精炼" + obj_calculator.jl + "阶");
                cursor.close();
                double hzpf= obj_calculator.hzpf;
                DecimalFormat df = new DecimalFormat("#.#");
                syw_hz.setText(df.format(hzpf)+"分");
            }

        }
        db.close();
        return view;
    }

    private void color(int i, TextView name1, TextView exp_1, TextView cts1) {
        if (i==1){
            name1.setTextColor(0xFFFFC356);
            exp_1.setTextColor(0xFFFFC356);
            cts1.setTextColor(0xFFFFC356);
        }else if (i==2){
            name1.setTextColor(0xFFFFFFFF);
            exp_1.setTextColor(0xFFFFFFFF);
            cts1.setTextColor(0xFFFFFFFF);
        }
    }
}
