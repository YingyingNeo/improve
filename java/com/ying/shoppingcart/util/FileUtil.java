package com.ying.shoppingcart.util;

import android.graphics.Bitmap;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class FileUtil {

    // 把位图数据保存到指定路径的图片文件
    public static void saveImage(String path, Bitmap bitmap) {
        try {
            // 根据指定文件路径构建缓存输出流对象
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
            // 把位图数据压缩到缓存输出流中
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);
            // 完成缓存输出流的写入动作
            bos.flush();
            // 关闭缓存输出流
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
