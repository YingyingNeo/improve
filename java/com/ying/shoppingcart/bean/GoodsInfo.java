package com.ying.shoppingcart.bean;

import com.ying.shoppingcart.R;

import java.util.ArrayList;

public class GoodsInfo {
    public long rowid; // 行号
    public int xuhao; // 序号
    public String name; // 名称
    public String desc; // 描述
    public float price; // 价格
    public String thumb_path; // 小图的保存路径
    public String pic_path; // 大图的保存路径
    public int thumb; // 小图的资源编号
    public int pic; // 大图的资源编号

    public GoodsInfo() {
        rowid = 0L;
        xuhao = 0;
        name = "";
        desc = "";
        price = 0;
        thumb_path = "";
        pic_path = "";
        thumb = 0;
        pic = 0;
    }

    // 声明一个补水商品的名称数组
    private static String[] mNameArray = {
            "OLAY大红瓶", "SK-Ⅱ神仙水", "薏仁爽肤水", "理肤泉喷雾", "Lamer爽肤水", "GIVENCHY气泡凝露","haha","xixixi"
    };
    // 声明一个补水商品的描述数组
    private static String[] mDescArray = {
            "我是OLAY大红瓶",
            "我是SK-Ⅱ神仙水",
            "我是薏仁爽肤水",
            "我是理肤泉喷雾",
            "我是Lamer爽肤水",
            "我是GIVENCHY气泡凝露",
            "ahaha",
            "dsafe"
    };
    // 声明一个补水商品的价格数组
    private static float[] mPriceArray = {688, 399, 299, 289, 269, 298,000,908};
    // 声明一个补水商品的小图数组
    private static int[] mThumbArray = {
            R.drawable.olay_s, R.drawable.sk_2_s, R.drawable.yiren_s,
            R.drawable.lifuquan_s, R.drawable.lamer_s, R.drawable.givenchy_s,R.drawable.iphone_s,R.drawable.olay_s
    };
    // 声明一个手机商品的大图数组
    private static int[] mPicArray = {
            R.drawable.olay, R.drawable.sk_2, R.drawable.yiren,
            R.drawable.lifuquan, R.drawable.lamer, R.drawable.givenchy,R.drawable.iphone,R.drawable.olay
    };

    // 获取默认的手机信息列表
    public static ArrayList<GoodsInfo> getDefaultList() {
        ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
        for (int i = 0; i < mNameArray.length; i++) {
            GoodsInfo info = new GoodsInfo();
            info.name = mNameArray[i];
            info.desc = mDescArray[i];
            info.price = mPriceArray[i];
            info.thumb = mThumbArray[i];
            info.pic = mPicArray[i];
            goodsList.add(info);
        }
        return goodsList;
    }

}
