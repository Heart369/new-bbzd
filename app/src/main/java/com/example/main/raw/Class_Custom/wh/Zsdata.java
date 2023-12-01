package com.example.main.raw.Class_Custom.wh;

import com.example.main.raw.DataClass.Jswqdata;
import com.example.main.raw.DataClass.Scdata;
import com.example.main.R;

import java.util.ArrayList;
import java.util.List;
//此为展示数据类
public class Zsdata {
    List<Jswqdata> data;
    List<Scdata> sc;
    Scdata s1;
    public List<Jswqdata> mdzy(){
        data=new ArrayList<>();
        String[] data1=new String[]{"Tartaglia","Aloy","Klee","Diona","Ambor","Barbara","Sucrose"};
        String[] data2= new String[]{"达达利亚","埃洛伊","可莉","迪奥娜","安柏","芭芭拉","砂糖"};
        int[] start=new int[]{5,5,5,4,4,4,4};
        for(int i=0;i<7;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }

        return data;
    }
    public List<Jswqdata> mdze(){
        data=new ArrayList<>();
        String[] data1=new String[]{"Diluc","Mona","Qin","Eula","Bennett","Noel","Razor"};
        String[] data2= new String[]{"迪卢克","莫娜","琴","优菈","班尼特","诺艾尔","雷泽"};
        int[] start=new int[]{5,5,5,5,4,4,4};
        for(int i=0;i<7;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> mdzs(){
        data=new ArrayList<>();
        String[] data1=new String[]{"Albedo","Venti","Fischl","Rosaria","Kaeya","Lisa"};
        String[] data2= new String[]{"阿贝多","温迪","菲谢尔","罗莎莉亚","凯亚","丽莎"};
        int[] start=new int[]{5,5,4,4,4,4};
        for(int i=0;i<6;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }


    public List<Jswqdata> lyzy(){
        data=new ArrayList<>();
        String[] data1=new String[]{"Keqing","Qiqi","Shenhe","Yelan","Xiao","Ningguang"};
        String[] data2= new String[]{"刻晴","七七","申鹤","夜兰","魈","凝光"};
        int[] start=new int[]{5,5,5,5,5,4};
        for(int i=0;i<6;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> lyze(){
        data=new ArrayList<>();
        String[] data1=new String[]{"Kazuha","Ganyu","Hutao","Chongyun","Xiangling","Yunjin","Yaoyao"};
        String[] data2= new String[]{"枫原万叶","甘雨","胡桃","重云","香菱","云堇","瑶瑶"};
        int[] start=new int[]{5,5,5,4,4,4,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> lyzs(){
        data=new ArrayList<>();
        String[] data1=new String[]{"Baizhuer","Zhongli","Xingqiu","Xinyan","Feiyan","Beidou"};
        String[] data2= new String[]{"白术","钟离","行秋","辛焱","烟绯","北斗"};
        int[] start=new int[]{5,5,4,4,4,4};
        for(int i=0;i<5;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }

        return data;
    }

    public List<Jswqdata> dqzy(){
        data=new ArrayList<>();
        String[] data1=new String[]{"Kokomi","Yoimiya","Tohma","Heizo","enkaMomoka"};
        String[] data2= new String[]{"珊瑚宫心海","宵宫","托马","鹿野院平藏","绮良良"};
        int[] start=new int[]{5,5,4,4,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> dqze(){
        data=new ArrayList<>();
        String[] data1=new String[]{"Itto","Ayaka","Ayato","Shinobu","Sara"};
        String[] data2= new String[]{"荒泷一斗","神里凌华","神里绫人","久岐忍","九条裟罗"};
        int[] start=new int[]{5,5,5,4,4};
        for(int i=0;i<5;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> dqzs(){
        data=new ArrayList<>();
        String[] data1=new String[]{"Yae","Shougun","Sayu","Gorou"};
        String[] data2= new String[]{"八重神子","雷电将军","早柚","五郎"};
        int[] start=new int[]{5,5,4,4};
        for(int i=0;i<4;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }

    public List<Jswqdata> xmzy(){
        data=new ArrayList<>();
        String[] data1=new String[]{"Cyno","Tighnari","Candace","Faruzan"};
        String[] data2= new String[]{"赛诺","提纳里","坎蒂斯","珐露珊"};
        int[] start=new int[]{5,5,4,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> xmze(){
        data=new ArrayList<>();
        String[] data1=new String[]{"Alhatham","Nahida","Dori","Kaveh"};
        String[] data2= new String[]{"艾尔海森","纳西妲","多莉","卡维"};
        int[] start=new int[]{5,5,4,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> xmzs(){
        data=new ArrayList<>();
        String[] data1=new String[]{"Wanderer","Nilou","Dehya","Collei"};
        String[] data2= new String[]{"流浪者","妮露","迪希亚","科莱"};
        int[] start=new int[]{5,5,5,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }
    public List<Scdata> zysc(){
        sc = new ArrayList<>();
        String[] data=new String[]{"自由的哲学","繁荣的哲学","浮世的哲学","净言的哲学","公平的哲学"};
        int[] data1 = new int[]{R.drawable.md_zy,R.drawable.ly_ft,R.drawable.jp_fs,R.drawable.xm_jy,R.drawable.fd_zy};
        for(int i=0;i<data1.length;i++){
            s1 = new Scdata(data1[i],data[i]);
            sc.add(s1);
        }
        return sc;
    }
    public List<Jswqdata> fdzy(){
        data=new ArrayList<>();
        String[] data1=new String[]{"enkaNeuvillette","enkaLiney"};
        String[] data2= new String[]{"那维莱特","林尼"};
        int[] start=new int[]{5,5};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> fdze(){
        data=new ArrayList<>();
        String[] data1=new String[]{"enkaFreminet","enkaFurina","enkaCharlotte"};
        String[] data2= new String[]{"菲米尼","芙宁娜","夏洛蒂"};
        int[] start=new int[]{4,5,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> fdzs(){
        data=new ArrayList<>();
        String[] data1=new String[]{"enkaWriothesley","enkaLinette"};
        String[] data2= new String[]{"莱欧斯利","琳妮特"};
        int[] start=new int[]{5,5,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],1);
            data.add(js);
        }
        return data;
    }

    public List<Scdata> zesc(){
        sc = new ArrayList<>();
        String[] data=new String[]{"抗争的哲学","勤劳的哲学","风雅的哲学","巧思的哲学","正义的哲学"};
        int[] data1 = new int[]{R.drawable.md_kz,R.drawable.ly_ql,R.drawable.jp_fr,R.drawable.xm_dx,R.drawable.fd_ze};
        for(int i=0;i<data1.length;i++){
            s1 = new Scdata(data1[i],data[i]);
            sc.add(s1);
        }
        return sc;
    }

    public List<Scdata> zssc(){
        sc = new ArrayList<>();
        String[] data=new String[]{"诗文的哲学","黄金的哲学","天光的哲学","笃行的哲学","秩序的哲学"};
        int[] data1 = new int[]{R.drawable.md_sw,R.drawable.ly_hj,R.drawable.dq_tg,R.drawable.xm_ddx,R.drawable.fd_zs};
        for(int i=0;i<data1.length;i++){
            s1 = new Scdata(data1[i],data[i]);
            sc.add(s1);
        }
        return sc;
    }
    public  List<Scdata> zmsc(){
        sc = new ArrayList<>();
        String[] data=new String[]{"自由的哲学","抗争的哲学","诗文的哲学","繁荣的哲学","勤劳的哲学","黄金的哲学","浮世的哲学","风雅的哲学","天光的哲学","净言的哲学","巧思的哲学","笃行的哲学","公平的哲学","正义的哲学","秩序的哲学"};
        int[] data1 = new int[]{R.drawable.md_zy,R.drawable.md_kz,R.drawable.md_sw,R.drawable.ly_ft,R.drawable.ly_ql,R.drawable.ly_hj,R.drawable.jp_fs,R.drawable.jp_fr,R.drawable.dq_tg,R.drawable.xm_jy,R.drawable.xm_dx,R.drawable.xm_ddx,R.drawable.fd_zy,R.drawable.fd_ze,R.drawable.fd_zs};
        for(int i=0;i<data1.length;i++){
            s1 = new Scdata(data1[i],data[i]);
            sc.add(s1);
        }
        return sc;
    }
    public List<Jswqdata> wqmdzy(){
        data=new ArrayList<>();
        String[] data1=new String[]{"_Sword_Falcon_Awaken","_Claymore_Widsith_Awaken","_Sword_Zephyrus_Awaken","_Sword_Theocrat_Awaken","_Sword_Outlaw_Awaken","_Sword_Opus","_Claymore_Troupe_Awaken","_Claymore_Dragonfell_Awaken","_Catalyst_Zephyrus_Awaken","_Catalyst_Theocrat_Awaken","_Bow_Troupe_Awaken","_Bow_Viridescent_Awaken","_Bow_Nachtblind_Awaken","_Sword_Steel_Awaken","_Claymore_Glaive_Awaken","_Catalyst_Intro_Awaken","_Bow_Crowfeather_Awaken","_Sword_Silver_Awaken","_Catalyst_Pocket_Awaken","_Sword_Blunt_Awaken","_Catalyst_Apprentice_Awaken"};
        String[] data2= new String[]{"风鹰剑","松籁响起之时","西风剑","宗室长剑","暗巷闪光","辰砂之纺锤","钟剑","雪葬的星银","西风秘典","宗室秘法录","绝弦","苍翠猎弓","幽夜华尔兹","冷刃","铁影阔剑","魔导绪论","鸦羽弓","银剑","口袋魔导书","无锋剑","学徒笔记"};
        int[] start=new int[]{5,5,4,4,4,4,4,4,4,4,4,4,4,3,3,3,3,2,2,1,1};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqmdze(){
        data=new ArrayList<>();
        String[] data1=new String[]{"_Sword_Dvalin_Awaken","_Claymore_Dvalin_Awaken","_Catalyst_Dvalin_Awaken","_Bow_Dvalin_Awaken","_Bow_Widsith_Awaken","_Sword_Troupe_Awaken","_Sword_Bloodstained_Awaken","_Sword_Psalmus_Awaken","_Claymore_Fossil","_Catalyst_Troupe_Awaken","_Catalyst_Outlaw_Awaken","_Catalyst_Ludiharpastum_Awaken","_Bow_Fossil_Awaken","_Pole_Gladiator_Awaken","_Pole_Everfrost","_Pole_Windvane","_Sword_Dawn_Awaken","_Claymore_Siegfry_Awaken","_Catalyst_Pulpfic_Awaken","_Bow_Arjuna_Awaken","_Claymore_Oyaji_Awaken","_Bow_Old_Awaken","_Bow_Hunters_Awaken"};
        String[] data2= new String[]{"天空之刃","天空之傲","天空之卷","天空之翼","终末嗟叹之诗","笛剑","黑剑","降临之剑","祭礼大剑","流浪乐章","暗巷的酒与诗","嘟嘟可故事集","祭礼弓","决斗之枪","龙脊长枪","风信之锋","黎明神剑","沐浴龙血的剑","讨龙英杰谭","神射手之誓","佣兵重剑","历练的猎弓","猎弓"};
        int[] start=new int[]{5,5,5,5,5,4,4,4,4,4,4,4,4,4,4,4,3,3,3,3,2,2,1};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqmdzs(){
        data=new ArrayList<>();
        String[] data1=new String[]{"_Sword_Widsith_Awaken","_Claymore_Wolfmound_Awaken","_Catalyst_Fourwinds_Awaken","_Bow_Amos_Awaken","_Pole_Dvalin_Awaken","_Sword_Fossil_Awaken","_Sword_Magnum","_Claymore_Zephyrus_Awaken","_Claymore_Theocrat_Awaken","_Catalyst_Fossil_Awaken","_Catalyst_Everfrost","_Bow_Zephyrus_Awaken","_Bow_Theocrat_Awaken","_Bow_Fleurfair_Awaken","_Bow_Outlaw_Awaken","_Pole_Zephyrus_Awaken","_Sword_Traveler_Awaken","_Claymore_Tin_Awaken","_Catalyst_Lightnov_Awaken","_Bow_Curve_Awaken","_Pole_Rod_Awaken","_Claymore_Aniki_Awaken","_Pole_Gewalt_Awaken"};
        String[] data2= new String[]{"苍古自由之誓","狼的末路","四风原典","阿莫斯之弓","天空之脊","祭礼剑","腐殖之剑","西风大剑","宗室大剑","祭礼残章","忍冬之果","西风猎弓","宗室长弓","风花之颂","暗巷猎手","西风长枪","旅行剑","白铁大剑","异世界行记","反曲弓","铁尖枪","训练大剑","新手长枪"};
        int[] start=new int[]{5,5,5,5,5,4,4,4,4,4,4,4,4,4,4,4,3,3,3,3,2,1,1};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqlyzy(){
        data=new ArrayList<>();
        String[] data1=new String[]{"_Catalyst_Morax_Awaken","_Sword_Kunwu_Awaken","_Bow_Kirin_Awaken","_Pole_Morax_Awaken","_Sword_Rockkiller_Awaken","_Pole_Blackrock","_Claymore_Exotic_Awaken","_Claymore_Lapis_Awaken","_Catalyst_Resurrection_Awaken","_Catalyst_Blackrock","_Bow_Recluse_Awaken","_Bow_Blackrock_Awaken","_Pole_Exotic_Awaken","_Sword_Darker_Awaken","_Catalyst_Jade_Awaken","_Bow_Sling_Awaken","_Pole_Ruby_Awaken"};
        String[] data2= new String[]{"碧落之珑","斫峰之刃","若水","和璞鸢","匣里龙吟","黑岩刺枪","白影剑","千岩古剑","匣里日月","黑岩绯玉","弓藏","黑岩战弓","流月针","暗铁剑","翡玉法球","弹弓","白缨枪"};
        int[] start=new int[]{5,5,5,5,4,4,4,4,4,4,4,4,4,3,3,3,3};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqlyze(){
        data=new ArrayList<>();
        String[] data1=new String[]{"_Sword_Morax_Awaken","_Claymore_Kunwu_Awaken","_Pole_Santika","_Claymore_Perdue_Awaken","_Sword_Proto_Awaken","_Claymore_Blackrock_Awaken","_Catalyst_Proto_Awaken","_Catalyst_Truelens_Awaken","_Bow_Proto_Awaken","_Pole_Stardust_Awaken","_Pole_Blackrock_Awaken","_Pole_Theocrat_Awaken","_Sword_Sashimi_Awaken","_Claymore_Reasoning_Awaken","_Catalyst_Phoney_Awaken","_Bow_Msg_Awaken","_Pole_Halberd_Awaken"};
        String[] data2= new String[]{"磐岩结绿","无工之剑","息灾","雨裁","试做斩岩","黑岩斩刀","试作金珀","昭心","试做澹月","匣里灭辰","黑岩刺枪","宗室猎枪","吃虎鱼刀","以理服人","甲级宝珏","信使","钺矛"};
        int[] start=new int[]{5,5,5,4,4,4,4};
        for(int i=0;i<7;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqlyzs(){
        data=new ArrayList<>();
        String[] data1=new String[]{"_Catalyst_Kunwu_Awaken","_Pole_Kunwu_Awaken","_Pole_Homa_Awaken","_Sword_Exotic_Awaken","_Claymore_Proto_Awaken","_Claymore_Kione_Awaken","_Claymore_MillenniaTuna","_Catalyst_Exotic_Awaken","_Bow_Exotic_Awaken","_Bow_Fallensun_Awaken","_Pole_Proto_Awaken","_Pole_Lapis_Awaken","_Sword_Mitsurugi_Awaken","_Claymore_Mitsurugi_Awaken","_Pole_Noire_Awaken"};
        String[] data2= new String[]{"尘世之锁","贯虹之槊","护摩之杖","铁蜂刺","试做古华","螭骨剑","衔珠海皇","万国诸海图谱","钢轮弓","落霞","试做星镰","千岩长枪","飞天御剑","飞天大御剑","黑缨枪"};
        int[] start=new int[]{5,5,5,4,4,4,4,4,4,4,4,4,3,3,3};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqdqzy(){
        data=new ArrayList<>();
        String[] data1=new String[]{"_Sword_Narukami_Awaken","_Catalyst_Kaleido_Awaken","_Sword_Bakufu_Awaken","_Claymore_Maria","_Catalyst_Jyanome","_Catalyst_Bakufu_Awaken"};
        String[] data2= new String[]{"雾切之回光","不灭月华","天目影打刀","恶王丸","证誓之明瞳","白辰之环"};
        int[] start=new int[]{5,5,4,4,4,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqdqze(){
        data=new ArrayList<>();
        String[] data1=new String[]{"_Sword_Amenoma","_Claymore_Itadorimaru","_Bow_Narukami_Awaken","_Claymore_Bakufu_Awaken","_Bow_Bakufu_Awaken","_Bow_Predator","_Bow_Maria"};
        String[] data2= new String[]{"波乱月白经津","赤角石溃杵","飞雷之弦振","桂木斩长正","破魔之弓","掠食者","曚云之月"};
        int[] start=new int[]{5,5,5,4,4,4,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqdqzs(){
        data=new ArrayList<>();
        String[] data1=new String[]{"_Catalyst_Narukami","_Bow_Worldbane","_Pole_Narukami","_Sword_Youtou_Awaken","_Pole_Bakufu_Awaken","_Pole_Mori","_Pole_Maria"};
        String[] data2= new String[]{"神乐之真意","冬极白星","薙草之稻光","笼钓瓶一心","喜多院十文字","渔获","断浪长鳍"};
        int[] start=new int[]{5,5,5,4,4,4,4};
        for(int i=0;i<7;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqxmzy(){
        data=new ArrayList<>();
        String[] data1=new String[]{"_Sword_Deshret_Awaken","_Sword_Ayus_Awaken","_Sword_Arakalari_Awaken","_Claymore_Arakalari_Awaken","_Sword_Pleroma_Awaken","enka_Bow_Ibis_Awaken"};
        String[] data2= new String[]{"圣显之钥","裁叶萃光","原木刀","森林王器","西福斯的月光","鹮穿之喙"};
        int[] start=new int[]{5,5,4,4,4,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqxmze(){
        data=new ArrayList<>();
        String[] data1=new String[]{"_Catalyst_Ayus_Awaken","_Pole_Deshret_Awaken","_Catalyst_Pleroma_Awaken","_Catalyst_Arakalari_Awaken","_Pole_Arakalari_Awaken","enka_Claymore_BeastTamer_Awaken"};
        String[] data2= new String[]{"千夜浮梦","赤沙之杖","流浪的晚星","盈满之实","贯月矢","聊聊棒"};
        int[] start=new int[]{5,5,4,4,4,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqxmzs(){
        data=new ArrayList<>();
        String[] data1=new String[]{"_Claymore_Deshret_Awaken","_Bow_Ayus_Awaken","_Catalyst_Alaya_Awaken","_Bow_Arakalari_Awaken","_Bow_Fin_Awaken","_Claymore_Pleroma_Awaken","enka_Bow_Gurabad_Awaken"};
        String[] data2= new String[]{"苇海信标","猎人之径","图莱杜拉的回忆","王下近侍","竭泽","玛海菈的水色","烈阳之嗣"};
        int[] start=new int[]{5,5,5,4,4,4,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqfdzy(){
        data=new ArrayList<>();
        String[] data1=new String[]{"enka_Bow_Pledge_Awaken","enka_Bow_Mechanic_Awaken","enka_Pole_Mechanic_Awaken","enka_Bow_Vorpal_Awaken","enka_Sword_Machination_Awaken"};
        String[] data2= new String[]{"最初的大魔术","测距规","勘探钻机","静谧之曲","灰河渡手"};
        int[] start=new int[]{5,4,4,4,4};
        for(int i=0;i<5;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqfdze(){
        data=new ArrayList<>();
        String[] data1=new String[]{"enka_Catalyst_Iudex_Awaken","enka_Sword_Mechanic_Awaken","enka_Catalyst_Vorpal_Awaken","enka_Sword_Vorpal_Awaken","enka_Sword_Regalis_Awaken"};
        String[] data2= new String[]{"万世流涌大典","船坞长剑","纯水流华","海渊终曲","静水流涌之辉"};
        int[] start=new int[]{5,4,4,4,5};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Jswqdata> wqfdzs(){
        data=new ArrayList<>();
        String[] data1=new String[]{"enka_Catalyst_Wheatley_Awaken","enka_Claymore_Mechanic_Awaken","enka_Pole_Vorpal_Awaken","enka_Claymore_Vorpal_Awaken","enka_Pole_Shanty_Awaken"};
        String[] data2= new String[]{"金流监督","便携动力锯","公义的酬报","浪影阔剑","峡湾长歌"};
        int[] start=new int[]{5,4,4,4,4};
        for(int i=0;i<data1.length;i++){
            Jswqdata js=new Jswqdata(data1[i],data2[i],start[i],0);
            data.add(js);
        }
        return data;
    }
    public List<Scdata> wqzysc(){
        sc = new ArrayList<>();
        String[] data=new String[]{"高塔孤王的碎梦","孤光寒林的神体","远海夷地的金枝","谧林涓露的金符","悠古弦音的回响"};
        int[] data1 = new int[]{R.drawable.md_sm,R.drawable.ly_st,R.drawable.jp_jz,R.drawable.xm_jf,R.drawable.fd_zy_wq};
        for(int i=0;i<5;i++){
            s1 = new Scdata(data1[i],data[i]);
            sc.add(s1);
        }
        return  sc;
    }
    public List<Scdata> wqzesc(){
        sc = new ArrayList<>();
        String[] data=new String[]{"凛风奔狼的怀乡","雾海云间的转还","鸣神御灵的勇武","绿洲花园的真谛","纯圣露滴的真粹"};
        int[] data1 = new int[]{R.drawable.md_hx,R.drawable.ly_zh,R.drawable.dq_yw,R.drawable.xm_zd,R.drawable.fd_ze_wq};
        for(int i=0;i<5;i++){
            s1 = new Scdata(data1[i],data[i]);
            sc.add(s1);
        }
        return  sc;
    }
    public List<Scdata> wqzssc(){
        sc = new ArrayList<>();
        String[] data=new String[]{"狮牙斗士的理想","漆黑陨铁的一块","今昔剧画之鬼人","烈日权威的旧日","无垢之海的金杯"};
        int[] data1 = new int[]{R.drawable.md_lx,R.drawable.ly_yt,R.drawable.dq_gr,R.drawable.xm_lr,R.drawable.fd_zs_wq,};
        for(int i=0;i<5;i++){
            s1 = new Scdata(data1[i],data[i]);
            sc.add(s1);
        }
        return  sc;
    }
    public List<Scdata> wqzmsc(){
        sc = new ArrayList<>();
        String[] data=new String[]{"高塔孤王的碎梦","凛风奔狼的怀乡","狮牙斗士的理想","孤光寒林的神体","雾海云间的转还","漆黑陨铁的一块","远海夷地的金枝","鸣神御灵的勇武","今昔剧画之鬼人","谧林涓露的金符","绿洲花园的真谛","烈日权威的旧日","悠古弦音的回响","纯圣露滴的真粹","无垢之海的金杯"};
        int[] data1 = new int[]{R.drawable.md_sm,R.drawable.md_hx,R.drawable.md_lx,R.drawable.ly_st,R.drawable.ly_zh,R.drawable.ly_yt,R.drawable.jp_jz,R.drawable.dq_yw,R.drawable.dq_gr,R.drawable.xm_jf,R.drawable.xm_zd,R.drawable.xm_lr,R.drawable.fd_zy_wq,R.drawable.fd_ze_wq,R.drawable.fd_zs_wq};
        for(int i=0;i<data1.length;i++){
            s1 = new Scdata(data1[i],data[i]);
            sc.add(s1);
        }
        return  sc;
    }
}
