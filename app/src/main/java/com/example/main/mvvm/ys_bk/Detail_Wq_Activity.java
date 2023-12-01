package com.example.main.mvvm.ys_bk;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.example.main.R;

import com.example.main.databinding.ActivityDetailWqBinding;
import com.example.main.mvvm.base.BaseActivity;
import com.example.main.mvvm.json.Detail_Wq;
import com.example.main.mvvm.request.RequestVM;
import com.example.main.raw.Class_Custom.Recy_item_jj;

import java.util.HashMap;
import java.util.Map;

public class Detail_Wq_Activity extends BaseActivity {
    ActivityDetailWqBinding binding;
    Wq_ViewModel mainviewModel;
    RequestVM requestVM;
    RecyclerView recyclerView;
    int jsq=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_wq);
        mainviewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(Wq_ViewModel.class);
        binding.setVm(mainviewModel);
        binding.setLifecycleOwner(this);
        Intent intent=getIntent();
        setToolbar(R.id.toolbar_detail,R.id.title_detail,intent.getStringExtra("name"));
        bindingid();
        requestVM = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(RequestVM.class);
        mainviewModel.getWqname().setValue(intent.getStringExtra("name"));
        requestVM.request_wq("https://api.minigg.cn/",intent.getStringExtra("name"),requestVM.getGetwq(),null);
        requestVM.getGetwq().observe(this, new Observer<Detail_Wq>() {
            @Override
            public void onChanged(Detail_Wq detail_wq) {
                Log.d("TAG",detail_wq.name);
                mainviewModel.getAdapter().getValue().setWqdata(detail_wq);
                mainviewModel.getAdapter().getValue().setTitle(intent.getStringExtra("name"));
                mainviewModel.getAdapter().getValue().setFragmentManager(getSupportFragmentManager());
                mainviewModel.getAdapter().getValue().notifyItemChanged(0);
                mainviewModel.getAdapter().getValue().notifyItemChanged(1);
                mainviewModel.getAdapter().getValue().notifyItemChanged(3);
                mainviewModel.getAdapter().getValue().notifyItemChanged(4);
            }
        });
        String[] re=new String[]{"1","20","21","40","41","50","51","60","61","70","71","80","81","90"};
        for (String qq:re){
            requestVM.request_wq("https://api.minigg.cn/",intent.getStringExtra("name"),requestVM.Getwq(),qq);
        }
        Map<Integer,Detail_Wq> mb=new HashMap<>();
        requestVM.Getwq().observe(this, new Observer<Detail_Wq>() {
            @Override
            public void onChanged(Detail_Wq detail_wq) {

                mb.put(detail_wq.level,detail_wq);
                jsq++;
                if (jsq==re.length){
                    mainviewModel.getAdapter().getValue().setMb(mb);
                    mainviewModel.getAdapter().getValue().notifyItemChanged(2);
                }
            }
        });


    }

    private void bindingid() {
        recyclerView=findViewById(R.id.recy_detail_Wq);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(Recy_item_jj.BOTTOM_DECORATION,25);
        recyclerView.addItemDecoration(new Recy_item_jj(stringIntegerHashMap));
        recyclerView.setItemAnimator(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainviewModel.getAdapter().setValue(null);
    }
}