package com.example.main.mvvm.adapter.detail_js;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.main.R;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.JsonPares.Json_Jstf;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Recy_f4_adapter extends RecyclerView.Adapter<Recy_f4_adapter.viewholder> {
    Context context;
    Json_Jstf json_jstf;
    List<Bl_cl.name_bl> bl_cl;int a=0;
    List<Hi_text> fz=new ArrayList<>();
    gethi gethi;
    String[] name = new String[]{"详细属性", "一级伤害", "二级伤害", "三级伤害", "四级伤害", "五级伤害", "六级伤害", "七级伤害", "八级伤害", "九级伤害", "十级伤害", "十一级伤害", "十二级伤害", "十三级伤害"};

    public Recy_f4_adapter(Context context, Json_Jstf json_jstf, List<Bl_cl.name_bl> bl_cl,gethi gethi) {
        this.context = context;
        this.json_jstf = json_jstf;
        this.bl_cl = bl_cl;
        this.gethi=gethi;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.f4_item, parent, false);
        return new viewholder(view);
    }
    public class Hi_text{
        int hi;
        String text;

        public int getHi() {
            return hi;
        }

        public String getText() {
            return text;
        }

        public Hi_text(int hi, String text) {
            this.hi = hi;
            this.text = text;
        }


    }
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

      holder.itemView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
          @Override
          public void onGlobalLayout() {
              Hi_text hi_text=new Hi_text(holder.itemView.getHeight(),holder.t0.getText().toString());
              if (a<bl_cl.size()+1)
                  fz.add(hi_text);
              else if (a==bl_cl.size()+1)gethi.get_hi(fz);
              a++;
          }
      });

        if (position==0){
            holder.t0.setText("详细属性");
            holder.t1.setText("LV1");
            holder.t2.setText("LV2");
            holder.t3.setText("LV3");
            holder.t4.setText("LV4");
            holder.t5.setText("LV5");
            holder.t6.setText("LV6");
            holder.t7.setText("LV7");
            holder.t8.setText("LV8");
            holder.t9.setText("LV9");
            holder.t10.setText("LV10");
            holder.t11.setText("LV11");
            holder.t12.setText("LV12");
            holder.t13.setText("LV13");
        }else {
            List<String> data=new ArrayList<>();
            for (int a=0;a<13;a++){
                data.add(cl(bl_cl.get(position-1),a));
            }
            if (bl_cl.get(position-1).getName().length()>8){
                ViewGroup parent = (ViewGroup) holder.t13.getParent();
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );
                holder.t13.setLayoutParams(params);
            }

            holder.t0.setText(bl_cl.get(position-1).getName());
            holder.t1.setText(data.get(0));
            holder.t2.setText(data.get(1));
            holder.t3.setText(data.get(2));
            holder.t4.setText(data.get(3));
            holder.t5.setText(data.get(4));
            holder.t6.setText(data.get(5));
            holder.t7.setText(data.get(6));
            holder.t8.setText(data.get(7));
            holder.t9.setText(data.get(8));
            holder.t10.setText(data.get(9));
            holder.t11.setText(data.get(10));
            holder.t12.setText(data.get(11));
            holder.t13.setText(data.get(12));
        }
    }

    private String cl(Bl_cl.name_bl bl, int a) {

        DecimalFormat df = new DecimalFormat("###.#"); // 创建 DecimalFormat 对象，格式化输出保留两位小数
        double roundedNum = bl.getBl().get(a); // 将 double 类型的 num 格式化成字符串并保留两位小数，然后再转换成 double 类型
        if (bl.getBllx()<3){
           roundedNum=roundedNum*100;
        }
       roundedNum= Double.parseDouble(df.format(roundedNum));

        String  data= roundedNum +"%";
        if (bl.getBllx()>=3){
            data= String.valueOf(roundedNum);
        }
        switch (bl.getBllx()){
            case -1:
                data+="攻击力";
                break;
            case 0:
                data+="元素精通";
                break;
            case 1:
                data+="防御力";
                break;
            case 2:
                data+="生命值上限";
                break;
            case 3:
                data+="秒";
                break;
            case 4:
                data+="次";
                break;
            case 5:
                data+="元素能量";
                break;
            case 6:
                data+="点";
                break;
        }
        if (bl.getBl_kx().size()!=0){
            roundedNum=Double.parseDouble(df.format(bl.getBl_kx().get(a)));
            if (bl.getBl_lx2()<3){
                roundedNum=roundedNum*100;
            }
            roundedNum= Double.parseDouble(df.format(roundedNum));
            data+="+";
            data+=roundedNum;
            if (bl.getBl_lx2()<3)
                data+="%";
            switch (bl.getBl_lx2()){
                case -1:
                    data+="攻击力";
                    break;
                case 0:
                    data+="元素精通";
                    break;
                case 1:
                    data+="防御力";
                    break;
                case 2:
                    data+="生命值上限";
                    break;
                case 3:
                    data+="秒";
                    break;
                case 4:
                    data+="次";
                    break;
                case 5:
                    data+="";
                    break;
            }

        }

        return data;

    }

    @Override
    public int getItemCount() {
        return bl_cl.size()+1;
    }

    static class viewholder extends RecyclerView.ViewHolder {
        TextView t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            t0 = itemView.findViewById(R.id.t0);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            t3 = itemView.findViewById(R.id.t3);
            t4 = itemView.findViewById(R.id.t4);
            t5 = itemView.findViewById(R.id.t5);
            t6 = itemView.findViewById(R.id.t6);
            t7 = itemView.findViewById(R.id.t7);
            t8 = itemView.findViewById(R.id.t8);
            t9 = itemView.findViewById(R.id.t9);
            t10 = itemView.findViewById(R.id.t10);
            t11 = itemView.findViewById(R.id.t11);
            t12 = itemView.findViewById(R.id.t12);
            t13 = itemView.findViewById(R.id.t13);
        }
    }
    public  interface gethi{
        public void get_hi(List<Hi_text> hi_texts);
    }
}
