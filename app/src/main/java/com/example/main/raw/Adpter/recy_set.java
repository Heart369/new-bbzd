package com.example.main.raw.Adpter;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.main.R;
import com.example.main.raw.SQLite.ConfigSQLite;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class recy_set extends RecyclerView.Adapter<recy_set.ViewHolder> {
Context context;
int positions;
String[] data1,data2;
boolean[] data3;
private OnRvItemClick mOnRvItemClick;

    public recy_set(Context context, OnRvItemClick mOnRvItemClick,String[] data1,String[] data2,boolean[] data3) {
        this.context = context;
        this.mOnRvItemClick = mOnRvItemClick;
        this.data1=data1;
        this.data2=data2;
        this.data3=data3;
    }

    @Override
    public int getItemViewType(int position) {
        positions=position;
        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.set_item1,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("Range")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);
        if (data3[position]){
            ConfigSQLite sqLite=new ConfigSQLite(context,"Config.bd",null,1);
            SQLiteDatabase database=sqLite.getReadableDatabase();
            Cursor cursor=database.query("config",new String[]{"ischeck"},"id=?",new String[]{""+position},null,null,null);
            holder.material.setVisibility(View.VISIBLE);
            cursor.moveToFirst();
            if (cursor.getString(cursor.getColumnIndex("ischeck")).equals("0"))
                holder.material.setChecked(true);
            cursor.close();
            database.close();
            holder.material.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    ConfigSQLite sqLite=new ConfigSQLite(context,"Config.bd",null,1);
                    SQLiteDatabase db=sqLite.getReadableDatabase();
                      switch (holder.getAdapterPosition()){
                          case 3:
                                if (isChecked){
                                    String sql = "update config set ischeck='0' where id=3";
                                    db.execSQL(sql);
                                }else {
                                    String sql = "update config set ischeck='1' where id=3";
                                    db.execSQL(sql);
                                }
                      }
                    db.close();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView t1,t2;
        SwitchMaterial material;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            t1=itemView.findViewById(R.id.text_main);
            t2=itemView.findViewById(R.id.text_cyd);
            material=itemView.findViewById(R.id.switch_set);
        }

        @Override
        public void onClick(View v) {
            if (mOnRvItemClick != null)
                mOnRvItemClick.onItemClick(v, getAdapterPosition());
        }

}
    public interface OnRvItemClick {
        void onItemClick(View v, int position);
    }
}
