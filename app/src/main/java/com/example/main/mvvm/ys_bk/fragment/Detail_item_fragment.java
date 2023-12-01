package com.example.main.mvvm.ys_bk.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.main.R;
import com.example.main.mvvm.adapter.detail_js.Fragmet_adapter;
import com.example.main.mvvm.json.Detail_role;

import java.util.List;

public class Detail_item_fragment extends Fragment {
    public Detail_item_fragment() {
    }
    Detail_role role;
    Context context;
    int flag=0;
    List<Detail_role.CostsDTO.Ascend1DTO> getone;
    Fragmet_adapter adapter = null;

    public Detail_item_fragment(Detail_role role, int flag,Context context) {
        this.role = role;
        this.flag = flag;
        this.context=context;
    }


    public Detail_item_fragment(Detail_role role, Context context, List<Detail_role.CostsDTO.Ascend1DTO> getone) {
        this.role = role;
        this.context=context;
        this.getone=getone;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detail,container,false);
        ListView listView=view.findViewById(R.id.list_framget);
        switch (flag){
            case 1: case 0:
                  adapter=new Fragmet_adapter(role.costs.ascend1,context);
                break;
            case 2:
                adapter=new Fragmet_adapter(role.costs.ascend1,context);
                break;
            case 3:
                adapter=new Fragmet_adapter(role.costs.ascend2,context);
                break;
            case 4:
                adapter=new Fragmet_adapter(role.costs.ascend3,context);
                break;
            case 5:
                adapter=new Fragmet_adapter(role.costs.ascend4,context);
                break;
            case 6:
                adapter=new Fragmet_adapter(role.costs.ascend5,context);
                break;
            case 7:
                adapter=new Fragmet_adapter(role.costs.ascend6,context);
                break;

        }
        if (getone!=null){
            adapter=new Fragmet_adapter(getone,context);
            getone=null;
        }
        listView.setAdapter(adapter);
        return view;


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        context=null;
        role=null;
        adapter.setnull();
        adapter=null;
        getone=null;

    }
}
