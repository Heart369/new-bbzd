package com.example.main.mvvm.ys_bk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.main.R;
import com.example.main.mvvm.adapter.detail_js.Detail_recy_adapter;

@SuppressLint("StaticFieldLeak")
public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<Integer> pos;
    Context context;

    private MutableLiveData<Integer> hi = new MutableLiveData<>();
    private MutableLiveData<String> username = new MutableLiveData<>();


    public MutableLiveData<Integer> getHi() {
        return hi;
    }

    public MutableLiveData<String> getUsername() {
        return username;
    }

    public void setHi(MutableLiveData<Integer> hi) {
        this.hi = hi;
    }

    private MutableLiveData<Integer[]> res;

    public MutableLiveData<Integer> getPos() {
        if (pos==null){
            pos=new MutableLiveData<>();
            pos.setValue(-1);
        }

        return pos;
    }

    public MutableLiveData<Integer[]> getRes() {
        if (res == null) {
            res = new MutableLiveData<>();
            res.setValue(new Integer[]{R.drawable.shape_12dp, R.drawable.shape_11dp_corners, R.drawable.shape_11dp_corners});
        }
        return res;
    }

    public void setRes(MutableLiveData<Integer[]> res) {
        this.res = res;
    }

    private MutableLiveData<Detail_recy_adapter> adapter_recy;

    public MutableLiveData<Detail_recy_adapter> getAdapter_recy() {
        if (adapter_recy==null){
            adapter_recy=new MutableLiveData<>();
            adapter_recy.setValue(new Detail_recy_adapter(context));
        }
        return adapter_recy;
    }

    @BindingAdapter("layout_constraintHeight_percent")
    public static void setLayoutHeight(TextView view, MutableLiveData<Integer> height) {
        // 在这里获取MutableLiveData<Integer>对象中的值，并将其设置为view的高度
        Integer heightValue = height.getValue();
        view.setHeight(heightValue);
    }

    public MainViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public void onbasic() {
        Toast.makeText(context, "点击了基本信息", Toast.LENGTH_SHORT).show();
    }

    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.dj_1:
                pos.setValue(0);
                break;
            case R.id.dj_2:
                pos.setValue(1);
                break;
            case R.id.dj_3:
                pos.setValue(2);
                break;
        }
    }

}


