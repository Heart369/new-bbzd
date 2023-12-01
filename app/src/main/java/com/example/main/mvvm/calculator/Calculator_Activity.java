package com.example.main.mvvm.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.main.R;
import com.example.main.databinding.ActivityCalculatorBinding;
import com.example.main.mvvm.adapter.calculator.Calculator_adapter;
import com.example.main.mvvm.adapter.calculator.fragment.viewpager_adapter;
import com.example.main.mvvm.base.BaseActivity;
import com.example.main.raw.Class_Custom.wh.Id_Name;
import com.example.main.mvvm.calculator.role.Obj_calculator;

import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.Class_Custom.Dp_Px;
import com.example.main.raw.Class_Custom.Recy_item_jj;
import com.example.main.raw.Class_Custom.Th_jstf;
import com.example.main.raw.JsonPares.Jszsg;
import com.example.main.raw.interface_.OnRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calculator_Activity extends BaseActivity {
    ActivityCalculatorBinding binding;
    Calculator_ViewModel mainviewModel;
    RecyclerView recyclerView;
    View view_back;
    Main_cl main_cl;
    int flag_fragment = 0;
    RelativeLayout re_back;
    List<Fragment_Calculator> calculators;
    ViewPager viewPager;
    TextView sx;
    viewpager_adapter pager;
    Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            viewPager.setCurrentItem(0);
            re_back.setVisibility(View.GONE);
            sx.setClickable(true);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calculator);
        mainviewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(Calculator_ViewModel.class);
        binding.setVm(mainviewModel);
        binding.setLifecycleOwner(this);
        setToolbar(R.id.toolbar_calculator, R.id.title_calculator, "综合计算器");
        mainviewModel.csh(getIntent().getStringExtra("uid"));
        bindid();
        click();
        ob();
    }

    private void click() {
        sx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainviewModel.gxData();
            }
        });
    }

    private void bindid() {
        recyclerView = findViewById(R.id.recy_cal);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(Recy_item_jj.LEFT_DECORATION, 15);
        recyclerView.addItemDecoration(new Recy_item_jj(stringIntegerHashMap));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        view_back = findViewById(R.id.back_cal);
        viewPager = findViewById(R.id.frameLayout);
        re_back = findViewById(R.id.re_back);
        sx = findViewById(R.id.text_gx);
        sx.setClickable(false);

    }

    private void ob() {
        mainviewModel.getCx().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (integer == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Calculator_Activity.this);
                    builder.setTitle("提示");
                    builder.setMessage("无法查询到指定用户或展示柜无角色");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // 在这里执行“确定”按钮的操作
                            fin();
                        }
                    });
                    builder.show();
                } else if (integer == 1) {
                    re_back.setVisibility(View.VISIBLE);
                    sx.setClickable(false);
                }
            }
        });
        mainviewModel.getJszsg().observe(this, new Observer<Jszsg>() {
            @Override
            public void onChanged(Jszsg jszsg) {
                Log.d("TAG", "成功拿取");
                Id_Name id_name = new Id_Name();
                List<Bl_cl> bl = new ArrayList<>();
                for (int a = 0; a < jszsg.avatarInfoList.size(); a++) {
                    Th_jstf jstf = new Th_jstf(jszsg.avatarInfoList.get(a).avatarId, id_name.getName(jszsg.avatarInfoList.get(a).avatarId), new Th_jstf.getbl() {
                        @Override
                        public void nq(Bl_cl bl_cl) {
                            bl.add(bl_cl);
                            if (bl.size() == jszsg.avatarInfoList.size())
                                mainviewModel.getBl_cl().postValue(bl);
                        }
                    });
                    jstf.start();
                }

            }
        });

        mainviewModel.getBl_cl().observe(this, new Observer<List<Bl_cl>>() {
            @Override
            public void onChanged(List<Bl_cl> bl_cls) {
                main_cl = new Main_cl(mainviewModel.getJszsg().getValue(), bl_cls, Calculator_Activity.this, mainviewModel.getJs_one());
            }
        });

        mainviewModel.getJs_one().observe(this, new Observer<List<Obj_calculator>>() {
            @Override
            public void onChanged(List<Obj_calculator> obj_calculators) {
                Log.d("YAG", obj_calculators.size() + "");
                if (calculators==null)
                calculators = new ArrayList<>();
                else {
                    for (int a=0;a<calculators.size();a++){
                        calculators.get(a).setObj_calculator(obj_calculators.get(a));
                        calculators.get(a).sx();
                    }
                }

                int width = getWidth();
                width = (int) (width * 0.47);
                for (int a = calculators.size(); a < obj_calculators.size(); a++) {
                    calculators.add(new Fragment_Calculator(obj_calculators.get(a), width));
                }
                Dp_Px dp_px = new Dp_Px();
                int s = dp_px.dip2px(Calculator_Activity.this, 55);
                mainviewModel.getAdapter().setValue(new Calculator_adapter(Calculator_Activity.this, obj_calculators, new OnRecyclerItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        viewPager.setOffscreenPageLimit(3);
                        viewPager.setCurrentItem(position);
                        view_back.setBackground(getDrawable(getback(calculators.get(position).getObj_calculator().getDu().getElement())));
                    }
                }));
                if (pager == null) {
                    pager = new viewpager_adapter(getSupportFragmentManager(), calculators);
                    viewPager.setAdapter(pager);
                } else {
                    pager.setFragments(calculators);
                    pager.notifyDataSetChanged();

                }
//                if (calculators.size() > 5)
//                    viewPager.setCurrentItem(5);
//                else viewPager.setCurrentItem(0);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            Message message = new Message();
                            handler.sendMessage(message);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                view_back.setBackground(getDrawable(getback(calculators.get(0).getObj_calculator().getDu().getElement())));
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        mainviewModel.getAdapter().getValue().setFlag(position);
                        view_back.setBackground(getDrawable(getback(calculators.get(position).getObj_calculator().getDu().getElement())));
                        recyclerView.scrollBy(s * -1 * (flag_fragment - position), 0);
                        flag_fragment = position;

                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }
        });

    }

    public int getback(String name) {
        switch (name) {
            case "Ice":
                return R.drawable.calcu_back;

            case "Grass":
                return R.drawable.back_c;

            case "Wind":
                return R.drawable.back_f;

            case "Electric":
                return R.drawable.back_l;

            case "Rock":
                return R.drawable.back_y;

            case "Water":
                return R.drawable.back_s;

            case "Fire":
                return R.drawable.back_h;

        }
        return R.id.back_cal;
    }

    @Override
    protected void onResume() {
        viewPager.setOffscreenPageLimit(5);
        super.onResume();

    }
}