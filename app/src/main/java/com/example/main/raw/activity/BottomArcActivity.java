package com.example.main.raw.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.main.R;
import com.example.main.raw.Class_Custom.Lucency;
import com.example.main.raw.Class_Custom.Th_Post;
import com.example.main.raw.JsonPares.Js_Wq;
import com.example.main.raw.utils.CenterItemUtils;
import com.example.main.raw.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 横向滑动后自动选中居中的条目  类似 横向WheelView
 */
public class BottomArcActivity extends AppCompatActivity implements View.OnClickListener {
    Js_Wq js_wq;Intent intent;
    Context context;
    public int l=-3;
    ImageView jls;
    LinearLayout layout;
    int sp=0;
    Js_Wq.DataDTO.AvatarsDTO data_js;
    ImageView image_lh,image_ys,s1,s2,s3,s4,s5,image_wq,m1,m2,m3,m4,m5,m6,w1,w2,w3,w4,w5,w6,djimage,x1,x2,x3,x4,x5;
    TextView js_name,js_hg,wpname,name,dj,jl,zw,syw2jt,syw4jt;

    private final int CHILDVIEWSIZE = 180;
    private RecyclerView recyclerView;
    private MAdapter mAdapter;
    int sss=5;
    private int centerToLiftDistance; //RecyclerView款度的一半 ,也就是控件中间位置到左部的距离 ，
    private int childViewHalfCount = 0; //当前RecyclerView一半最多可以存在几个Item
    Handler handler=new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
           js_wq= (Js_Wq) msg.obj;
            Log.d("TAG","已经拿到角色and武器"+js_wq.getMessage());
                 init();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_arc);
        recyclerView = findViewById(R.id.rv);
        context=this;
        Lucency lucency=new Lucency();
        lucency.light(this);
        image_lh=findViewById(R.id.image_jslh);
        image_ys=findViewById(R.id.image_ys);
        js_name=findViewById(R.id.js_name);
        js_hg=findViewById(R.id.js_hg);
        image_wq=findViewById(R.id.image_wq);
        jls=image_wq;
        s1=findViewById(R.id.syw1);
        s2=findViewById(R.id.syw2);
        s3=findViewById(R.id.syw3);
        s4=findViewById(R.id.syw4);
        s5=findViewById(R.id.syw5);
        m1=findViewById(R.id.mz1);
        m2=findViewById(R.id.mz2);
        m3=findViewById(R.id.mz3);
        m4=findViewById(R.id.mz4);
        m5=findViewById(R.id.mz5);
        m6=findViewById(R.id.mz6);
        wpname=findViewById(R.id.wpname);
        djimage=findViewById(R.id.zsdj);
        name=findViewById(R.id.diname);
        syw2jt=findViewById(R.id.syw2jt);
        syw4jt=findViewById(R.id.syw4jt);
        dj=findViewById(R.id.didj);
        jl=findViewById(R.id.jldj);
        x1=findViewById(R.id.xx1);
        x2=findViewById(R.id.xx2);
        x3=findViewById(R.id.xx3);
        x4=findViewById(R.id.xx4);
        x5=findViewById(R.id.xx5);
        zw=findViewById(R.id.text_zw);
        image_wq.setOnClickListener(this);
        s1.setOnClickListener(this);
        s2.setOnClickListener(this);
        s3.setOnClickListener(this);
        s4.setOnClickListener(this);
        s5.setOnClickListener(this);
        m1.setOnClickListener(this);
        m2.setOnClickListener(this);
        m3.setOnClickListener(this);
        m4.setOnClickListener(this);
        m5.setOnClickListener(this);
        m6.setOnClickListener(this);
        m1.setOnClickListener(this);
        m2.setOnClickListener(this);
        m3.setOnClickListener(this);
        m4.setOnClickListener(this);
        m5.setOnClickListener(this);
        m6.setOnClickListener(this);
        w1=findViewById(R.id.mzw1);
        w2=findViewById(R.id.mzw2);
        w3=findViewById(R.id.mzw3);
        w4=findViewById(R.id.mzw4);
        w5=findViewById(R.id.mzw5);
        w6=findViewById(R.id.mzw6);
        SharedPreferences preferences=getSharedPreferences("data",MODE_PRIVATE);
        String uid=preferences.getString("uid","");
        String server =preferences.getString("server","");
        String cookie =preferences.getString("cookie","");
        intent=getIntent();
        String ls=intent.getStringExtra("cuid");
        if (!ls.equals("ss"))
            uid=ls;
        Log.d("TAG",uid);
        Th_Post th=new Th_Post("https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/character?role_id="+uid+"&server="+server,uid,server,cookie,handler);
        th.start();
    }

    private void init() {

        LinearLayoutManager manager= new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false);
        recyclerView.setLayoutManager(manager);
        sss=intent.getIntExtra("page",1);
        manager.scrollToPositionWithOffset(intent.getIntExtra("page",1),0);
        setMessage(intent.getIntExtra("page",1));
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                centerToLiftDistance = recyclerView.getWidth() / 2;

                int childViewHeight = UiUtils.dip2px(BottomArcActivity.this, CHILDVIEWSIZE); //43是当前已知的 Item的高度
                childViewHalfCount = (recyclerView.getWidth() / childViewHeight + 1) / 2;
                initData();
                findView();

            }
        });
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollToCenter(childViewHalfCount);
            }
        }, 100L);
    }

    private List<String> mDatas;

    private void initData() {
        if (mDatas == null) mDatas = new ArrayList<>();
        for (int i = 0; i < 55; i++) {
            mDatas.add("条目" + i);
        }
        for (int j = 0; j < childViewHalfCount; j++) { //头部的空布局
            mDatas.add(0, null);
        }
        for (int k = 0; k < childViewHalfCount; k++) {  //尾部的空布局
            mDatas.add(null);
        }
    }

    private boolean isTouch = false;

    private List<CenterItemUtils.CenterViewItem> centerViewItems = new ArrayList<>();
    private void findView() {
        mAdapter = new MAdapter();
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    int fi = linearLayoutManager.findFirstVisibleItemPosition();
                    int la = linearLayoutManager.findLastVisibleItemPosition();
//                    int fi = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
//                    int la = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                    Log.i("ccb", "onScrollStateChanged:首个item: " + fi + "  末尾item:" + la);
                    if (isTouch) {
                        isTouch = false;
                        //获取最中间的Item View
                        int centerPositionDiffer = (la - fi) / 2;
                        int centerChildViewPosition = fi + centerPositionDiffer; //获取当前所有条目中中间的一个条目索引
                        centerViewItems.clear();
                        //遍历循环，获取到和中线相差最小的条目索引(精准查找最居中的条目)
                        if (centerChildViewPosition != 0){
                            for (int i = centerChildViewPosition -1 ; i < centerChildViewPosition+2; i++) {
                                View cView = recyclerView.getLayoutManager().findViewByPosition(i);
                                int viewLeft = cView.getLeft()+(cView.getWidth()/2);
                                centerViewItems.add(new CenterItemUtils.CenterViewItem(i ,Math.abs(centerToLiftDistance - viewLeft)));
                            }

                            CenterItemUtils.CenterViewItem centerViewItem = CenterItemUtils.getMinDifferItem(centerViewItems);
                            centerChildViewPosition = centerViewItem.position;
                        }

                        scrollToCenter(centerChildViewPosition);
                    }
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                for (int i = 0; i < recyclerView.getChildCount(); i++) {
                    recyclerView.getChildAt(i).invalidate();
                }
            }
        });

        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isTouch = true;
                return false;
            }
        });
    }

    private DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
    /**
     * 移动指定索引到中心处 ， 只可以移动可见区域的内容
     * @param position
     */
    private void scrollToCenter(int position){
        position = position < childViewHalfCount ? childViewHalfCount : position;
        position = position < mAdapter.getItemCount() - childViewHalfCount -1 ? position : mAdapter.getItemCount() - childViewHalfCount -1;

        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        View childView = linearLayoutManager.findViewByPosition(position);
        Log.i("ccb", "滑动后中间View的索引: " + position);
        //把当前View移动到居中位置
        if (sss==1){
            sss=5;
            return;
        }
        if (childView == null) return;
        int childVhalf = childView.getWidth() / 2;
        int childViewLeft = childView.getLeft();
        int viewCTop = centerToLiftDistance;
        int smoothDistance = childViewLeft - viewCTop + childVhalf;
        Log.i("ccb", "\n居中位置距离左部距离: " + viewCTop
                + "\n当前居中控件距离左部距离: " + childViewLeft
                + "\n当前居中控件的一半高度: " + childVhalf
                + "\n滑动后再次移动距离: " + smoothDistance);
        recyclerView.smoothScrollBy(smoothDistance, 0,decelerateInterpolator);
        mAdapter.setSelectPosition(position);

//        tv.setText("当前选中:" + mDatas.get(position));
    }
int jlm=-1,jlmm=0;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_wq:
                gxzsk(0);
                jlmm=0;
                gbtb(image_wq);
                jlm=0;
                break;
            case R.id.syw1:
                jlmm=0;
                gbtb(s1);
                gxzsk(1);
                jlm=0;
                break;
            case R.id.syw2:
                jlmm=0;
                gbtb(s2);
                gxzsk(2);
                jlm=0;
                break;
            case R.id.syw3:
                jlmm=0;
                gbtb(s3);
                gxzsk(3);
                jlm=0;
                break;
            case R.id.syw4:
                jlmm=0;
                gbtb(s4);
                gxzsk(4);
                jlm=0;
                break;
            case R.id.syw5:
                jlmm=0;
                gbtb(s5);
                gxzsk(5);
                jlm=0;
                break;
            case R.id.mz1:
                jlmm=1;
                gbtb(m1);
                txmzdata(1);
                jlm=1;
                break;
            case R.id.mz2:
                jlmm=1;
                gbtb(m2);
                txmzdata(2);
                jlm=1;
                break;
            case R.id.mz3:
                jlmm=1;
                gbtb(m3);
                txmzdata(3);
                jlm=1;
                break;
            case R.id.mz4:
                jlmm=1;
                gbtb(m4);
                txmzdata(4);
                jlm=1;
                break;
            case R.id.mz5:
                jlmm=1;
                gbtb(m5);
                txmzdata(5);
                jlm=1;
                break;
            case R.id.mz6:
                jlmm=1;
                gbtb(m6);
                txmzdata(6);
                jlm=1;
                break;
        }
    }

    private void txmzdata(int i) {
        if (jlm!=1)
        layout.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right));
        List<Js_Wq.DataDTO.AvatarsDTO.ConstellationsDTO> mz=data_js.getConstellations();
        i=i-1;
        syw2jt.setVisibility(View.GONE);
        syw4jt.setVisibility(View.GONE);
        wpname.setText("命之座");
        dj.setVisibility(View.GONE);
        xx(0);
        Glide.with(context)
                .load(mz.get(i).getIcon())
                .fitCenter()
                .error(R.drawable.wdxq)
                .placeholder(null)
                .into(djimage);
        jl.setVisibility(View.VISIBLE);
        jl.setText("第"+mz.get(i).getPos()+"层");
        String e=mz.get(i).getEffect();
       e= e.replace('\\','\0');
        e=e.replace('n','\0');
        StringBuilder operatorStr = null;
        for (int a=0;a<5;a++){
            operatorStr=new StringBuilder(e);
            String te = "\0";  //字符串替换的内容
            String reg = "<(.*?)>";
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(operatorStr);
            if (m.find()){
                //使用分组进行替换
                operatorStr.replace(m.start(0),m.end(0),te);
                e=operatorStr.toString();
            }
    
        }
        zw.setText(operatorStr);
        name.setText(mz.get(i).getName());
    }

    private void gbtb(ImageView image) {
        Log.d("TAGSSS",""+jlmm+","+jlm);
        if (jlmm==0){
            image.setBackgroundResource(R.drawable.jszs_bj_fg);
            Log.d("TAGSSS","执行切换");
        }
        else image.setBackgroundResource(R.drawable.jsmzdj);
        if (jlm==2){
            image.setBackgroundResource(R.drawable.jszs_bj_fg);
        }

        if (jlm==0)
        jls.setBackgroundResource(R.drawable.jszs_bj);
        else if (jlm==1)
            jls.setBackgroundResource(R.drawable.jsmz);
        jls.setClickable(true);
        jls=image;
        jls.setClickable(false);

    }

    private void gxzsk(int s) {
        if (jlm!=0)
            layout.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left));
        if (s == 0) {
            syw2jt.setVisibility(View.GONE);
            syw4jt.setVisibility(View.GONE);
            wpname.setText("武器");
            name.setText(data_js.getWeapon().getName());
            dj.setText("Lv." + data_js.getWeapon().getLevel());
            dj.setVisibility(View.VISIBLE);
            jl.setVisibility(View.VISIBLE);
            jl.setText("精炼" + data_js.getWeapon().getAffix_level() + "阶");
            xx(data_js.getWeapon().getRarity());
            Glide.with(context)
                    .load(data_js.getWeapon().getIcon())
                    .fitCenter()
                    .error(R.drawable.wdxq)
                    .placeholder(null)
                    .into(djimage);
            zw.setText(data_js.getWeapon().getDesc());
        } else {
            wpname.setText("圣遗物");
            for (int x = 0; x < 5; x++) {
                if (data_js.getReliquaries().get(x).getPos() == s) {
                    Js_Wq.DataDTO.AvatarsDTO.ReliquariesDTO reliquariesDTO = data_js.getReliquaries().get(x);
                    name.setText(reliquariesDTO.getName());
                    xx(reliquariesDTO.getRarity());
                    dj.setText("+"+reliquariesDTO.getLevel());
                    jl.setVisibility(View.GONE);
                    zw.setText(reliquariesDTO.getSet().getName());
                    Glide.with(context)
                            .load(reliquariesDTO.getIcon())
                            .fitCenter()
                            .error(R.drawable.wdxq)
                            .placeholder(null)
                            .into(djimage);
                    syw2jt.setVisibility(View.VISIBLE);
                    syw4jt.setVisibility(View.VISIBLE);
                    syw2jt.setText("2件套："+reliquariesDTO.getSet().getAffixes().get(0).getEffect());
                    syw4jt.setText("4件套："+reliquariesDTO.getSet().getAffixes().get(1).getEffect());
                    break;
                }
            }
        }
    }

    private void xx(int rarity) {
        x1.setVisibility(View.VISIBLE);
        x2.setVisibility(View.VISIBLE);
        x3.setVisibility(View.VISIBLE);
        x4.setVisibility(View.VISIBLE);
        x5.setVisibility(View.VISIBLE);
        switch (rarity){
            case 0:
                x1.setVisibility(View.GONE);
            case 1:
                x2.setVisibility(View.GONE);
            case 2:
                x3.setVisibility(View.GONE);
            case 3:
                x4.setVisibility(View.GONE);
            case 4:
                x5.setVisibility(View.GONE);
        }
    }


    class MAdapter extends RecyclerView.Adapter {
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new VH(LayoutInflater.from(BottomArcActivity.this).inflate(R.layout.item_bottom_arc, parent, false));
        }
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            VH vh = (VH) holder;
            ((HMatrixTranslateLayout) vh.itemView).setParentWidth(recyclerView.getWidth());
            vh.tv.setVisibility(View.GONE);
            vh.bj.setVisibility(View.GONE);
            vh.dj.setVisibility(View.GONE);
            if (position==0){

            }else if (position==js_wq.getData().getAvatars().size()+1){

            }else{
                Glide.with(context)
                        .load(js_wq.getData().getAvatars().get(position-1).getIcon())
                        .fitCenter()
                        .error(R.drawable.md_zy_kl)
                        .placeholder(R.drawable.md_zy_kl)
                        .into(vh.tv);
                vh.tv.setVisibility(View.VISIBLE);
                vh.bj.setVisibility(View.VISIBLE);
                vh.dj.setVisibility(View.VISIBLE);
                vh.dj.setText("Lv_"+js_wq.getData().getAvatars().get(position-1).getLevel());
                if (js_wq.getData().getAvatars().get(position-1).getRarity()==4)
                vh.tv.setBackgroundResource(R.drawable.fuor_os_back);
                else
                    vh.tv.setBackgroundResource(R.drawable.five_back);
            }
            if (selectPosition == position) {
           //当前被选中的item

                setMessage(position-1);

            } else {

            }
            if (TextUtils.isEmpty(mDatas.get(position))){
                vh.itemView.setVisibility(View.INVISIBLE);
            }else {
                vh.itemView.setVisibility(View.VISIBLE);
           //     vh.tv.setText(mDatas.get(position));
            }
            final int fp = position;
            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scrollToCenter(fp);
                }
            });
        }

        private int selectPosition = -1;

        public void setSelectPosition(int cposition) {
            selectPosition = cposition;
//            notifyItemChanged(cposition);
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return js_wq.getData().getAvatars().size()+2;
        }

        class VH extends RecyclerView.ViewHolder {

            public ImageView tv,bj;
            public  TextView dj;

            public VH(@NonNull View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.js_tx);
                bj=itemView.findViewById(R.id.bj);
                dj=itemView.findViewById(R.id.lv_bo);
            }
        }
    }

    private void setMessage(int i) {
        if (i==l)
            return;
        l=i;
        RelativeLayout re_fct,re_fct2;
        layout=findViewById(R.id.lin);
        re_fct=findViewById(R.id.rela1);
        re_fct2=findViewById(R.id.rela2);
        re_fct.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sf));
        re_fct2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sf2));
        layout.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left));
        Js_Wq.DataDTO data=js_wq.getData();
        List<Js_Wq.DataDTO.AvatarsDTO> avatars=data.getAvatars();
        data_js=avatars.get(i);
        if (i!=sp){
            if (jlm==0)
                jls.setBackgroundResource(R.drawable.jszs_bj);
            else if (jlm==1)
                jls.setBackgroundResource(R.drawable.jsmz);
            jlm=2;
            Log.d("TAG","已经被点击");
            jlm=-1;
            image_wq.performClick();
        }
        sp=i;
        Glide.with(context)
                .load(data_js.getImage())
                .fitCenter()
                .error(R.drawable.wdxq)
                .placeholder(null)
                .into(image_lh);
        switch (data_js.getElement()){
            case "Geo":
                image_ys.setImageResource(R.drawable.ys_y);
                break;
            case "Hydro":
                image_ys.setImageResource(R.drawable.ys_s);
                break;
            case "Pyro":
                image_ys.setImageResource(R.drawable.ys_h);
                break;
            case "Cryo":
                image_ys.setImageResource(R.drawable.ys_b);
                break;
            case "Electro":
                image_ys.setImageResource(R.drawable.ys_l);
                break;
            case "Anemo":
                image_ys.setImageResource(R.drawable.ys_f);
                break;
            case "Dendro":
                image_ys.setImageResource(R.drawable.ys_c);
                break;
        }
        js_name.setText(data_js.getName());
        js_hg.setText("好感度:"+data_js.getFetter());
        Js_Wq.DataDTO.AvatarsDTO.WeaponDTO wq=data_js.getWeapon();//武器
        Glide.with(context)
                .load(wq.getIcon())
                .fitCenter()
                .error(R.drawable.wdxq)
                .placeholder(null)
                .into(image_wq);
        syw(data_js);
        mz(data_js);

    }

    private void mz(Js_Wq.DataDTO.AvatarsDTO data_js) {
        List<Js_Wq.DataDTO.AvatarsDTO.ConstellationsDTO> mz=data_js.getConstellations();
        ImageView imageView=m1,im=w1;
        for (int x=0;x<mz.size();x++){
            switch (x){
                case 0:
                    imageView=m1;
                    im=w1;
                    break;
                case 1:
                    imageView=m2;
                    im=w2;
                    break;
                case 2:
                    imageView=m3;
                    im=w3;
                    break;
                case 3:
                    imageView=m4;
                    im=w4;
                    break;
                case 4:
                    imageView=m5;
                    im=w5;
                    break;
                case 5:
                    imageView=m6;
                    im=w6;
                    break;
            }
            Glide.with(context)
                    .load(mz.get(x).getIcon())
                    .fitCenter()
                    .error(R.drawable.wdxq)
                    .placeholder(null)
                    .into(imageView);
            if (mz.get(x).isIs_actived()){
                im.setVisibility(View.GONE);
            }
            else {
                im.setVisibility(View.VISIBLE);
            }
        }
    }

    private void syw(Js_Wq.DataDTO.AvatarsDTO data_js) {
        cshsyw();
        List<Js_Wq.DataDTO.AvatarsDTO.ReliquariesDTO> syw=data_js.getReliquaries();//圣遗物
        for (int i=0;i<syw.size();i++){
            switch (syw.get(i).getPos()){
                case 1:
                    Glide.with(context)
                            .load(syw.get(i).getIcon())
                            .fitCenter()
                            .error(R.drawable.wdxq)
                            .placeholder(null)
                            .into(s1);
                        s1.setClickable(true);
                    break;
                case 2:
                    Glide.with(context)
                            .load(syw.get(i).getIcon())
                            .fitCenter()
                            .error(R.drawable.wdxq)
                            .placeholder(null)
                            .into(s2);
                        s2.setClickable(true);
                    break;
                case 3:
                    Glide.with(context)
                            .load(syw.get(i).getIcon())
                            .fitCenter()
                            .error(R.drawable.wdxq)
                            .placeholder(null)
                            .into(s3);
                        s3.setClickable(true);
                    break;
                case 4:
                    Glide.with(context)
                            .load(syw.get(i).getIcon())
                            .fitCenter()
                            .error(R.drawable.wdxq)
                            .placeholder(null)
                            .into(s4);
                        s4.setClickable(true);
                    break;
                case 5:
                    Glide.with(context)
                            .load(syw.get(i).getIcon())
                            .fitCenter()
                            .error(R.drawable.wdxq)
                            .placeholder(null)
                            .into(s5);
                        s5.setClickable(true);
                    break;
            }
        }

    }

    private void cshsyw() {
        s1.setImageResource(R.drawable.syw1);
        s2.setImageResource(R.drawable.syw2);
        s3.setImageResource(R.drawable.syw3);
        s4.setImageResource(R.drawable.syw4);
        s5.setImageResource(R.drawable.syw5);
        s1.setClickable(false);
        s2.setClickable(false);
        s3.setClickable(false);
        s4.setClickable(false);
        s5.setClickable(false);
        s1.getBackground().setAlpha(230);
        s2.getBackground().setAlpha(230);
        s3.getBackground().setAlpha(230);
        s4.getBackground().setAlpha(230);
        s5.getBackground().setAlpha(230);

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back,R.anim.closs);
    }
}
