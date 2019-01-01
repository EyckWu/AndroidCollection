package com.eyckwu.systemutil.os;

import android.os.Build;

import java.io.File;

/**
 * Create by eyckwu on 2019/1/2.
 * 系统工具类
 */
public class OSUtils {
    /**
     * 根据/system/bin/或/system/xbin目录下是否存在su文件判断是否已ROOT
     * @return
     */
    public static boolean isBoot(){
        try{
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        }catch (Exception e){
            return false;
        }
    }

    public static int getSdkVersion(){
        return Build.VERSION.SDK_INT;
    }
}
