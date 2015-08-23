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
     * ����Bitmap
     *
     * @param key
     * @param cacheObj
     */
    public static void putCacheBitMap(String key, Bitmap cacheObj) {
        aCache.put(key, cacheObj);
    }

    /**
     * ��������
     *
     * @param key
     * @param cacheObj
     */
    public static void putCacheSerializable(String key, Serializable cacheObj) {
        aCache.put(key, cacheObj);
    }

    /**
     * ��ȡ��������
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
