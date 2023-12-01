package com.example.main.mvvm.ys_bk;

import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.main.R;
import com.example.main.databinding.ActivityDetailPagesBinding;
import com.example.main.mvvm.base.BaseActivity;
import com.example.main.mvvm.json.Detail_mz;
import com.example.main.mvvm.json.Detail_role;
import com.example.main.mvvm.request.RequestVM;
import com.example.main.mvvm.zdyview.Mylist;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.Class_Custom.Dp_Px;
import com.example.main.raw.Class_Custom.Recy_item_jj;
import com.example.main.raw.JsonPares.Json_Jstf;
import com.google.android.material.appbar.AppBarLayout;

import java.util.HashMap;

@RequiresApi(api = Build.VERSION_CODES.M)
public class Detail_Pages_Activity extends BaseActivity {
    ActivityDetailPagesBinding binding;
    MainViewModel mainviewModel;
    RequestVM requestVM;
    TextView t1,t2,t3;
    Mylist listView;
    RecyclerView recyclerView;
    AppBarLayout appBarLayout;
    NestedScrollView nestedScrollView;

    int y=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_pages);
        mainviewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MainViewModel.class);
        binding.setVm(mainviewModel);
        binding.setLifecycleOwner(this);
        requestVM = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(RequestVM.class);
        mainviewModel.getHi().setValue(getStatusBarHeight());
        Intent intent=getIntent();
        setToolbar(R.id.toolbar_detail,R.id.title_detail,intent.getStringExtra("name"));
        binding.setOnClickListener(mainviewModel::onClickView);
        binding_id();
        requestVM.request("https://api.minigg.cn/",intent.getStringExtra("name"),requestVM.getData());
        requestVM.request_mz("https://api.minigg.cn/",intent.getStringExtra("name"),requestVM.getMz());
        requestVM.request_jstf("https://api.minigg.cn/",intent.getStringExtra("name"),requestVM.getJstf());
        Log.d("TAG",intent.getStringExtra("name"));
        mainviewModel.getAdapter_recy().getValue().setFragmentManager_x(getSupportFragmentManager());
        mainviewModel.getUsername().setValue(intent.getStringExtra("name"));

        requestVM.getData().observe(this, new Observer<Detail_role>() {
            @Override
            public void onChanged(Detail_role detail_role) {
                mainviewModel.getAdapter_recy().getValue().setRole(detail_role);

                mainviewModel.getAdapter_recy().getValue().notifyItemChanged(0);
                mainviewModel.getAdapter_recy().getValue().notifyItemChanged(1);
                Log.d("TAGSS","已经刷新1");
            }
        });
        requestVM.getMz().observe(this, new Observer<Detail_mz>() {
            @Override
            public void onChanged(Detail_mz detail_mz) {
                mainviewModel.getAdapter_recy().getValue().setMz(detail_mz);
                mainviewModel.getAdapter_recy().getValue().notifyItemChanged(2);
                Log.d("TAGSS","已经刷新2");
            }
        });
        requestVM.getJstf().observe(this, new Observer<Json_Jstf>() {
            @Override
            public void onChanged(Json_Jstf json_jstf) {
                mainviewModel.getAdapter_recy().getValue().setBl_cl(new Bl_cl(json_jstf));
                mainviewModel.getAdapter_recy().getValue().setJson_jstf(json_jstf);
                mainviewModel.getAdapter_recy().getValue().notifyItemChanged(3);
                Log.d("TAGTF","已经刷新3");
            }
        });

        mainviewModel.getRes().observe(this, new Observer<Integer[]>() {
            @Override
            public void onChanged(Integer[] integers) {
                t1.setBackground(getDrawable(integers[0]));
                t2.setBackground(getDrawable(integers[1]));
                t3.setBackground(getDrawable(integers[2]));

            }
        });


        mainviewModel.getPos().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Dp_Px dp_px=new Dp_Px();
                int s=dp_px.dip2px(Detail_Pages_Activity.this,25);
                if (integer==-1)
                    return;
                int a=0,b=0;
                View view = recyclerView.getLayoutManager().findViewByPosition(0);
                a = view.getHeight()+s; // 获取 View 的高度
                b=a+s;
                view = recyclerView.getLayoutManager().findViewByPosition(1);
                b+=view.getHeight();
                view = recyclerView.getLayoutManager().findViewByPosition(2);
                b+=view.getHeight();
                switch (integer){
                    case 0:
                        nestedScrollView.smoothScrollBy(0, -y);
                        break;
                    case 1:
                        nestedScrollView.smoothScrollBy(0,a-y);
                        break;
                    case 2:
                        nestedScrollView.smoothScrollBy(0,b-y);
                        break;

                }
            }
        });

        Dp_Px dp_px=new Dp_Px();
    nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
        @Override
        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
             y=scrollY;
            int s=dp_px.dip2px(Detail_Pages_Activity.this,25);
            int a=0,b=0;
            View view = recyclerView.getLayoutManager().findViewByPosition(0);
            a = view.getHeight()+s; // 获取 View 的高度
            b=a+s;
            view = recyclerView.getLayoutManager().findViewByPosition(1);
            b+=view.getHeight();
            view = recyclerView.getLayoutManager().findViewByPosition(2);
            b+=view.getHeight();
            if (y>=a&&y<b)
             mainviewModel.getRes().setValue(new Integer[]{R.drawable.shape_11dp_corners,R.drawable.shape_12dp, R.drawable.shape_11dp_corners});
            else if (y>=b)
                mainviewModel.getRes().setValue(new Integer[]{R.drawable.shape_11dp_corners,R.drawable.shape_11dp_corners, R.drawable.shape_12dp});
            else if (y<a)
            mainviewModel.getRes().setValue(new Integer[]{R.drawable.shape_12dp, R.drawable.shape_11dp_corners, R.drawable.shape_11dp_corners});
        }
    });

    }


    private void binding_id() {
        t1=findViewById(R.id.dj_1);
        t2=findViewById(R.id.dj_2);
        t3=findViewById(R.id.dj_3);
        nestedScrollView=findViewById(R.id.cs_nest);
        appBarLayout=findViewById(R.id.appbar);
        recyclerView=findViewById(R.id.recy_detail);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(Recy_item_jj.TOP_DECORATION,25);
        recyclerView.addItemDecoration(new Recy_item_jj(stringIntegerHashMap));
        recyclerView.setItemAnimator(null);

    }
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        listView=null;
        mainviewModel.getAdapter_recy().setValue(null);
        mainviewModel=null;
        requestVM=null;
    }
}