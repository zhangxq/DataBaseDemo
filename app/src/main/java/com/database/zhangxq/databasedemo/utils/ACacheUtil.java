package com.database.zhangxq.databasedemo.utils;

import android.graphics.Bitmap;

import com.database.zhangxq.databasedemo.application.DemoApplication;

import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * Created by zhangq on 2015/8/23.
 */
public class ACacheUtil {
    private static ACache aCache = ACache.get(DemoApplication.applicationContext);

    /**
     * 缓存Bitmap
     *
     * @param key
     * @param cacheObj
     */
    public static void putCacheBitMap(String key, Bitmap cacheObj) {
        aCache.put(key, cacheObj);
    }

    /**
     * 缓存数据
     *
     * @param key
     * @param cacheObj
     */
    public static void putCacheSerializable(String key, Serializable cacheObj) {
        aCache.put(key, cacheObj);
    }

    /**
     * 获取缓存数据
     *
     * @param key
     * @return
     */
    public static Serializable getCache(String key) {
        Serializable cacheOjb = null;
        try {
            cacheOjb = (Serializable) aCache.get(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cacheOjb;
    }
}
