package com.example.main.mvvm.calculator;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.main.mvvm.calculator.role.Albedo;
import com.example.main.mvvm.calculator.role.Ambor;
import com.example.main.mvvm.calculator.role.Baizhuer;
import com.example.main.mvvm.calculator.role.Barbara;
import com.example.main.mvvm.calculator.role.Beidou;
import com.example.main.mvvm.calculator.role.Bennett;
import com.example.main.mvvm.calculator.role.Chongyun;
import com.example.main.mvvm.calculator.role.Collei;
import com.example.main.mvvm.calculator.role.Cyno;
import com.example.main.mvvm.calculator.role.Dehya;
import com.example.main.mvvm.calculator.role.Diona;
import com.example.main.mvvm.calculator.role.Dori;
import com.example.main.mvvm.calculator.role.Faruzan;
import com.example.main.mvvm.calculator.role.Fischl;
import com.example.main.mvvm.calculator.role.Gorou;
import com.example.main.mvvm.calculator.role.Heizo;
import com.example.main.mvvm.calculator.role.Itto;
import com.example.main.mvvm.calculator.role.Kaeya;
import com.example.main.mvvm.calculator.role.Layla;
import com.example.main.mvvm.calculator.role.Lisa;
import com.example.main.mvvm.calculator.role.Nilou;
import com.example.main.mvvm.calculator.role.Ningguang;
import com.example.main.mvvm.calculator.role.Noel;
import com.example.main.mvvm.calculator.role.Razor;
import com.example.main.mvvm.calculator.role.Rosaria;
import com.example.main.mvvm.calculator.role.Sara;
import com.example.main.mvvm.calculator.role.Sayu;
import com.example.main.mvvm.calculator.role.Shinobu;
import com.example.main.mvvm.calculator.role.Sucrose;
import com.example.main.mvvm.calculator.role.Tohma;
import com.example.main.mvvm.calculator.role.Wanderer;
import com.example.main.mvvm.calculator.role.Xiangling;
import com.example.main.mvvm.calculator.role.XinQiu;
import com.example.main.mvvm.calculator.role.Xinyan;
import com.example.main.mvvm.calculator.role.Yanfei;
import com.example.main.mvvm.calculator.role.Yaoyao;
import com.example.main.mvvm.calculator.role.YeLan;
import com.example.main.mvvm.calculator.role.Yunjin;
import com.example.main.mvvm.calculator.tool.FileReader;
import com.example.main.mvvm.calculator.role.Alhaitham;
import com.example.main.mvvm.calculator.role.Aloy;
import com.example.main.mvvm.calculator.role.Ayato;
import com.example.main.mvvm.calculator.role.Diluc;
import com.example.main.mvvm.calculator.role.Eula;
import com.example.main.mvvm.calculator.role.Ganyu;
import com.example.main.mvvm.calculator.role.Ht;
import com.example.main.mvvm.calculator.role.Kazuha;
import com.example.main.mvvm.calculator.role.KeQin;
import com.example.main.mvvm.calculator.role.Klee;
import com.example.main.mvvm.calculator.role.Kokomi;
import com.example.main.mvvm.calculator.role.Mona;
import com.example.main.mvvm.calculator.role.Nahida;
import com.example.main.mvvm.calculator.role.QIQI;
import com.example.main.mvvm.calculator.role.Qin;
import com.example.main.mvvm.calculator.role.ShenHe;
import com.example.main.mvvm.calculator.role.Tartaglia;
import com.example.main.mvvm.calculator.role.Tighnari;
import com.example.main.mvvm.calculator.role.Venti;
import com.example.main.mvvm.calculator.role.Xiao;
import com.example.main.mvvm.calculator.role.Yae;
import com.example.main.mvvm.calculator.role.Yoimiya;
import com.example.main.mvvm.calculator.role.ZW;
import com.example.main.mvvm.calculator.role.Shogun;
import com.example.main.mvvm.calculator.role.Sllh;
import com.example.main.mvvm.calculator.role.Obj_calculator;

import com.example.main.mvvm.calculator.role.ZhongLi;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.JsonPares.Jszsg;

import java.util.ArrayList;
import java.util.List;

public class Main_cl {
    Jszsg jszsg;
    List<Bl_cl> bl_cls;
    Context context;

    MutableLiveData<List<Obj_calculator>> js_one;
    public Main_cl(Jszsg jszsg, List<Bl_cl> bl_cls, Context context, MutableLiveData<List<Obj_calculator>> js_one) {
        this.jszsg = jszsg;
        this.bl_cls=bl_cls;
        this.context=context;
        this.js_one=js_one;
        main();
    }



    public void main(){
        FileReader reader=new FileReader(context);
        List<Obj_calculator> role=new ArrayList<>();
        for (int a=0;a<jszsg.avatarInfoList.size();a++){
            switch (jszsg.avatarInfoList.get(a).avatarId){
                case 10000002:
                    role.add(new Sllh(jszsg.avatarInfoList.get(a),bl_cls, reader.du("10000002"),context));
                    break;
                case 10000046:
                    role.add(new Ht(jszsg.avatarInfoList.get(a),bl_cls, reader.du("10000046"),context));
                    break;
                case 10000032:
                    role.add(new Bennett(jszsg.avatarInfoList.get(a),bl_cls, reader.du("10000032"),context));
                    break;
                case 10000033:
                    role.add(new Tartaglia(jszsg.avatarInfoList.get(a),bl_cls, reader.du("10000033"),context));
                    break;
                case 10000003:
                    role.add(new Qin(jszsg.avatarInfoList.get(a),bl_cls, reader.du("10000003"),context));
                    break;
                case 10000005:
                    role.add(new ZW(jszsg.avatarInfoList.get(a),bl_cls, reader.du("10000005"),context));
                    break;
                case 10000006:
                    role.add(new Lisa(jszsg.avatarInfoList.get(a),bl_cls, reader.du("10000006"),context));
                    break;
                case 10000007:
                    role.add(new ZW(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000014:
                    role.add(new Barbara(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000015:
                    role.add(new Kaeya(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000016:
                    role.add(new Diluc(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000020:
                    role.add(new Razor(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000021:
                    role.add(new Ambor(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000022:
                    role.add(new Venti(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000023:
                    role.add(new Xiangling(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000024:
                    role.add(new Beidou(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000025:
                    role.add(new XinQiu(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000026:
                    role.add(new Xiao(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000027:
                    role.add(new Ningguang(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000029:
                    role.add(new Klee(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000030:
                    role.add(new ZhongLi(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000031:
                    role.add(new Fischl(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000034:
                    role.add(new Noel(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000035:
                    role.add(new QIQI(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000036:
                    role.add(new Chongyun(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000037:
                    role.add(new Ganyu(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000038:
                    role.add(new Albedo(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000039:
                    role.add(new Diona(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000041:
                    role.add(new Mona(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000042:
                    role.add(new KeQin(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000043:
                    role.add(new Sucrose(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000044:
                    role.add(new Xinyan(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000045:
                    role.add(new Rosaria(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000047:
                    role.add(new Kazuha(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000048:
                    role.add(new Yanfei(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000049:
                    role.add(new Yoimiya(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000050:
                    role.add(new Tohma(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000051:
                    role.add(new Eula(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000052:
                    role.add(new Shogun(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000053:
                    role.add(new Sayu(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000054:
                    role.add(new Kokomi(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000055:
                    role.add(new Gorou(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000056:
                    role.add(new Sara(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000057:
                    role.add(new Itto(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000058:
                    role.add(new Yae(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000059:
                    role.add(new Heizo(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000060:
                    role.add(new YeLan(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000062:
                    role.add(new Aloy(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000063:
                    role.add(new ShenHe(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000064:
                    role.add(new Yunjin(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000065:
                    role.add(new Shinobu(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000066:
                    role.add(new Ayato(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000067:
                    role.add(new Collei(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000068:
                    role.add(new Dori(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000069:
                    role.add(new Tighnari(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000070:
                    role.add(new Nilou(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000071:
                    role.add(new Cyno(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000072:
                    role.add(new ZW(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000073:
                    role.add(new Nahida(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000074:
                    role.add(new Layla(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000075:
                    role.add(new Wanderer(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000076:
                    role.add(new Faruzan(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000077:
                    role.add(new Yaoyao(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000078:
                    role.add(new Alhaitham(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000079:
                    role.add(new Dehya(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000080:
                    role.add(new ZW(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000081:
                    role.add(new ZW(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
                case 10000082:
                    role.add(new Baizhuer(jszsg.avatarInfoList.get(a),bl_cls, reader.du(String.valueOf(jszsg.avatarInfoList.get(a).avatarId)),context));
                    break;
            }

        }

        js_one.setValue(role);
    }

}
