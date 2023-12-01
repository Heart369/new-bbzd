package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.main.raw.JsonPares.Sy;
import com.example.main.R;
import com.example.main.raw.Zdyclass.MyGridView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyList_Item2_Adpter extends BaseAdapter {
    Sy.DataDTO.FloorsDTO floorsDTO;
    Context context;

    public MyList_Item2_Adpter(Sy.DataDTO.FloorsDTO floorsDTO, Context context) {
        this.floorsDTO = floorsDTO;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            view view;

            convertView=null;
        switch (position) {
            case 0:
                if (convertView==null){
                convertView=LayoutInflater.from(context).inflate(R.layout.mylist_item2_item1, parent, false);
                view=new view();
                view.cs =convertView.findViewById(R.id.cs);
                view.xj = convertView.findViewById(R.id.xj);
                view.textcs = convertView.findViewById(R.id.text_cs);
                convertView.setTag(view);
            }else view= (MyList_Item2_Adpter.view) convertView.getTag();
                view.cs.setText("" + floorsDTO.getIndex());
                view.xj.setText(floorsDTO.getStar() + "/" + floorsDTO.getMax_star());
            switch (floorsDTO.getIndex()) {
                case 9:
                    view.textcs.setText("深境螺旋第九层");
                    break;
                case 10:
                    view.textcs.setText("深境螺旋第十层");
                    break;
                case 11:
                    view.textcs.setText("深境螺旋第十一层");
                    break;
                case 12:
                    view.textcs.setText("深境螺旋第十二层");
                    break;
            }
            break;
            case 1: case 2: case 3:
                if (convertView==null){
                    convertView=LayoutInflater.from(context).inflate(R.layout.mylist_item2_item2, parent, false);
                    view=new view();
                   view.gridView = convertView.findViewById(R.id.item2_mygrid);
                    view.js = convertView.findViewById(R.id.js_sy);
                    view.time = convertView.findViewById(R.id.mylist_time);
                    view.i1 = convertView.findViewById(R.id.xj_imag_1);
                    view.i2 = convertView.findViewById(R.id.xj_imag_2);
                    view.i3 = convertView.findViewById(R.id.xj_imag_3);
                    convertView.setTag(view);
                }else view= (MyList_Item2_Adpter.view) convertView.getTag();

                Sy.DataDTO.FloorsDTO.LevelsDTO levelsDTO = floorsDTO.getLevels().get(position - 1);
                view. js.setText("第" + levelsDTO.getIndex() + "间");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                String date1 = sdf.format(new Date(Long.parseLong(levelsDTO.getBattles().get(0).getTimestamp())* 1000L));
                view. time.setText(date1);
                view. i1.setImageResource(R.drawable.syxx);
                view. i2.setImageResource(R.drawable.ys_c);
                view. i3.setImageResource(R.drawable.ys_c);
            switch (levelsDTO.getStar()) {
                case 3:
                    view.     i1.setImageResource(R.drawable.ys_s);
                case 2:
                    view.   i2.setImageResource(R.drawable.ys_s);
                case 1:
                    view.    i3.setImageResource(R.drawable.ys_s);
            }
            Item2_Mygrid_Adpter adpter = new Item2_Mygrid_Adpter(levelsDTO.getBattles().get(0).getAvatars(), levelsDTO.getBattles().get(1).getAvatars(),context);
                view.   gridView.setAdapter(adpter);
    }
        return convertView;
    }
    static class view{
        TextView cs,xj,textcs,js,time;
        MyGridView gridView;
        ImageView i1,i2,i3;
    }

}
