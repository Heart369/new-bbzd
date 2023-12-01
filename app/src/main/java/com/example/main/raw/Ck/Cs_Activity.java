package com.example.main.raw.Ck;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.main.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Cs_Activity extends AppCompatActivity {
    HorizontalBarChart barChart;
//    PieChart pieChart;
    List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs);
//        barChart=findViewById(R.id.bar);
        list.add("60");
        list.add("70");
        list.add("20");
        list.add("80");
        list.add("15");

//        pieChart=findViewById(R.id.pic);
        ArrayList<BarEntry> barEntries=new ArrayList<>();
        ArrayList<PieEntry> pieEntries=new ArrayList<>();
        for (int a=0;a<5;a++){
            float value=(float) ((a+1)*10.0);
            BarEntry barEntry=new BarEntry(a,value);
            PieEntry pieEntry=new PieEntry(a,value);
            barEntries.add(barEntry);
            pieEntries.add(pieEntry);
        }
        BarDataSet barDataSet=new BarDataSet(barEntries,null);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setDrawValues(true);//是否显示数值
        BarData barData=new BarData(barDataSet);
        barData.setBarWidth(0.4f);
        barChart.setData(barData);
        barChart.setScaleEnabled(false);//禁止缩放
        XAxis xAxis = barChart.getXAxis();//获取x轴
        xAxis.setEnabled(false);
        xAxis.setDrawGridLines(false);
        //获取左边Y轴
        YAxis leftYAxis = barChart.getAxisLeft();
        //取消Y轴网格线
        leftYAxis.setEnabled(false);
        leftYAxis.setDrawGridLines(false);
        //不显示左边Y轴的标签
        leftYAxis.setDrawLabels(false);
        //获取右边Y轴
        YAxis rightYAxis = barChart.getAxisRight();
        //隐藏右边Y轴
        rightYAxis.setEnabled(false);
        //隐藏图例
        barChart.getLegend().setEnabled(false);
        //取消缩放、点击、高亮效果
        barChart.setScaleEnabled(false);
        barChart.setClickable(false);
        barChart.setHighlightPerDragEnabled(false);
        barChart.setHighlightPerTapEnabled(false);
        barChart.animateY(2000);//？s的动画
        barChart.getDescription().setText("hello");
        barChart.getDescription().setTextColor(Color.YELLOW);

//initbar();

    }
//
//    private void initbar() {
//        //没有数据显示这里面的
//        mBarChart.setNoDataText("没有数据哦");
//        // 设置是否可以缩放
//        mBarChart.setScaleEnabled(false);
//        //设置双击不放大
//        mBarChart.setDoubleTapToZoomEnabled(false);
//        //设置控件之间的间距
//        mBarChart.setExtraOffsets(20,20,20,20);
//        //获取XAxis 获取XAxis  setDrawGridLines:设置绘图网格线
//        mBarChart.getXAxis().setDrawGridLines(false);
//        //获取描述,是否显示右下角描述
//        mBarChart.getDescription().setEnabled(false);
//        //获取图例,是否显示图例
//        mBarChart.getLegend().setEnabled(false);
//        // 设置执行的动画,XY轴
//        mBarChart.animateXY(2500,2500);
//        //设置倾斜角度  setLabelRotationAngle:设置旋转角度
////        mBarChart.getXAxis().setLabelRotationAngle(-30);
//        //获取X轴
//        XAxis xAxis = mBarChart.getXAxis();
//        //设置X轴的位置
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        //设置X轴min数值
//        xAxis.setAxisMinimum(0f);
//        //设置X轴Max数值
//        xAxis.setAxisMaximum(list.size()-1);
//        //设置可视范围,0-5,可以防止X轴数据过长导致遮挡其他X轴数据
//        mBarChart.setVisibleXRange(0,5);
//        //设置X轴最大范围
//        xAxis.setLabelCount(list.size());
//        //使得左边柱子完全显示
//        xAxis.setAxisMinimum(0.5f);
//        //不绘制格网线
////        xAxis.setDrawGridLines(false);
//        //设置与顶部的距离
////        mBarChart.setExtraTopOffset(30);
//        //设置最小间隔，防止当放大时，出现重复标签。
//        xAxis.setGranularity(1);
//        //设置x轴显示的值
//        xAxis.setValueFormatter(new ValueFormatter() {
//            @Override
//            public String getFormattedValue(float value) {
//                //判断value的值是否小于数组长度
//                if((int)value<list.size()){
//                    return list.get((int)value);
//                }else{
//                    return "";
//                }
//            }
//        });
//        //设置X轴标签与Y轴的间距
//        xAxis.setYOffset(10);
//        //设置y轴,y轴有两条,分别是左边和右边,右边一边不常用可以隐藏
//        //获取右边的y轴
//        YAxis axisRight = mBarChart.getAxisRight();
//        //将右边的y轴设置为不显示
//        axisRight.setEnabled(false);
//        //获取左边的y轴
//        YAxis axisLeft = mBarChart.getAxisLeft();
//        //设置y轴最大值
//        axisLeft.setAxisMaximum(90f);
//        //设置y轴最低值
//        axisLeft.setAxisMinimum(0f);
//        //设置y标签字体大小
//        axisLeft.setTextSize(15f);
//        //设置BarEntry集合,用来存放柱状图的数值
//        List<BarEntry> barEntries = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            barEntries.add(new BarEntry(i,Float.parseFloat(list.get(i))));
//        }
//        //将数据添加到BarDataSet中,
//        BarDataSet barDataSet1 = new BarDataSet(barEntries,"");
//        //柱状图数值颜色
//        barDataSet1.setValueTextColor(Color.RED);
//        //柱状图数值的大小(文字大小)
//        barDataSet1.setValueTextSize(15f);
//        //柱状图对应的颜色
//        barDataSet1.setColor(Color.parseColor("#03A9F4"));
//        BarData barData = new BarData(barDataSet1);
//        //设置柱子的宽度
//        barData.setBarWidth(0.3f);
//        //将数据添加到组件中
//        mBarChart.setData(barData);
//        //刷新图表,
//        mBarChart.invalidate();
//
//    }
}