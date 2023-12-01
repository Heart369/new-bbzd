package com.example.main.raw.DataClass;

import com.example.main.R;

import java.util.List;

public class Wordcl {
    List<WordData> word;

    public Wordcl(List<WordData> word) {
        this.word = word;
    }

    public List<WordData> cl(){
        for (int i=0;i<word.size();i++){
            switch (word.get(i).getName()){
                case "蒙德":
                    word.get(i).setImg_bd(R.drawable.md_bj);
                    word.get(i).setImg_tb(R.drawable.md);
                break;
                case "璃月":
                    word.get(i).setImg_bd(R.drawable.ly_bj);
                    word.get(i).setImg_tb(R.drawable.liyue);
                    break;
                case "稻妻":
                    word.get(i).setImg_bd(R.drawable.dq_bj);
                    word.get(i).setImg_tb(R.drawable.jp);
                    break;
                case "须弥":
                    word.get(i).setImg_bd(R.drawable.xm_bj2);
                    word.get(i).setImg_tb(R.drawable.xmi);
                    break;
                case "层岩巨渊·地下矿区":
                case "层岩巨渊":
                    word.get(i).setImg_bd(R.drawable.cyjy_bj);
                    word.get(i).setImg_tb(R.drawable.cyjy);
                    break;
                case "龙脊雪山":
                    word.get(i).setImg_bd(R.drawable.xs_bj);
                    word.get(i).setImg_tb(R.drawable.xs);
                    break;
                case "渊下宫":
                    word.get(i).setImg_bd(R.drawable.yxg_bj);
                    word.get(i).setImg_tb(R.drawable.yxg);
                    break;
                case "枫丹":
                    word.get(i).setImg_bd(R.drawable.fd_bak);
                    word.get(i).setImg_tb(R.drawable.fd);
                    break;

            }
        }
        return  word;
    }
}
