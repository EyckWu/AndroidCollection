package com.eyckwu.systemutil.hardware;

import android.content.Context;
import android.graphics.Point;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;

/**
 * Create by eyckwu on 2019/1/2.
 * 设备硬件工具方法
 */
public class DeviceUtils {

    /**
     * 获取屏幕尺寸
     * @param context
     * @return
     */
    public static Point getScreenSize(Context context){
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR2){
            return new Point(display.getWidth(), display.getHeight());
        }else {
            Point point = new Point();
            display.getSize(point);
            return point;
        }
    }

    /**
     * 获取设备id
     * @param context
     * @return
     */
    public static String getId(Context context){
        return ((TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    /**
     * 获取mac地址
     * @param context
     * @return
     */
    public static String getMacAddress(Context context){
        return ((WifiManager)context.getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getMacAddress();
    }
}
