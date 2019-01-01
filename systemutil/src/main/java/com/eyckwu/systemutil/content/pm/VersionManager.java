package com.eyckwu.systemutil.content.pm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;

/**
 * Create by eyckwu on 2019/1/2.
 * 版本管理类
 */
public class VersionManager {

    /**
     * 旧的版本号
     */
    public static final String PREFERENCES_KEY_OLD_VERSION_CODE = "PREFERENCES_KEY_OLD_VERSION_CODE";

    /**
     * 旧的版本名称
     */
    public static final String PREFERENCES_KEY_OLD_VERSION_NAME = "PREFERENCES_KEY_OLD_VERSION_NAME";

    private PackageInfo packageInfo;
    private SharedPreferences sharedPreferences;

    public VersionManager(Context context){
        this(context, PreferenceManager.getDefaultSharedPreferences(context));
    }

    public VersionManager(Context context, SharedPreferences sharedPreferences){
        try {
            this.packageInfo = context.getPackageManager() != null ?
                    context.getPackageManager().getPackageInfo(context.getPackageName(), 0) : null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        this.sharedPreferences = sharedPreferences;
    }

    /**
     * 获取旧版本号
     * @return
     */
    public int getOldVersionCode(){
        return sharedPreferences.getInt(PREFERENCES_KEY_OLD_VERSION_CODE, -1);
    }

    /**
     * 获取旧版本名称
     * @return
     */
    public String getOldVersionName(){
        return sharedPreferences.getString(PREFERENCES_KEY_OLD_VERSION_NAME, null);
    }

    /**
     * 版本是否变更
     * @return
     */
    public boolean isChange(){
        int oldVersion = getOldVersionCode();
        return oldVersion != -1 || oldVersion != packageInfo.versionCode;
    }

    public void updateOldVersion(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PREFERENCES_KEY_OLD_VERSION_CODE, packageInfo.versionCode);
        editor.putString(PREFERENCES_KEY_OLD_VERSION_NAME, packageInfo.versionName);
        editor.commit();
    }
}
