package com.eyckwu.systemutil.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/**
 * Create by eyckwu on 2019/1/2.
 * 网络工具类
 */
public class NetworkUtils {
    /**
     * 网络类型 - 无连接
     */
    public static final int NETWORK_TYPE_NO_CONNECTION = -1231545315;

    /**
     * 获取当前网络状态
     * @param context
     * @return
     */
    public static NetworkInfo.State getCurrentNetworkState(Context context){
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return networkInfo != null ? networkInfo.getState() : null;
    }

    /**
     * 获取当前网络类型
     * @param context
     * @return
     */
    public static int getCurrentNetworkType(Context context){
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return networkInfo != null ? networkInfo.getType() : NETWORK_TYPE_NO_CONNECTION;
    }

    /**
     * 获取当前网络的具体类型
     * @param context
     * @return
     */
    public static int getCurrentNetworkSubtype(Context context){
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return networkInfo != null ? networkInfo.getSubtype() : NETWORK_TYPE_NO_CONNECTION;
    }

    /**
     * 判断当前网络是否已经连接
     * @param context
     * @return
     */
    public static boolean isConnectedByState(Context context){
        return getCurrentNetworkState(context) == NetworkInfo.State.CONNECTED;
    }

    /**
     * 判断当前网络是否正在连接
     * @param context
     * @return
     */
    public static boolean isConnectingByState(Context context){
        return getCurrentNetworkState(context) == NetworkInfo.State.CONNECTING;
    }

    /**
     * 判断当前网络是否已经断开
     * @param context
     * @return
     */
    public static boolean isDisconnectedByState(Context context){
        return getCurrentNetworkState(context) == NetworkInfo.State.DISCONNECTED;
    }

    /**
     * 判断当前网络是否正在断开
     * @param context
     * @return
     */
    public static boolean isDisconnectingByState(Context context){
        return getCurrentNetworkState(context) == NetworkInfo.State.DISCONNECTING;
    }

    /**
     * 是否被挂起
     * @param context
     * @return
     */
    public static boolean isSuspendedBuState(Context context){
        return NetworkInfo.State.SUSPENDED == getCurrentNetworkState(context);
    }

    /**
     * 未知网络类型
     * @param context
     * @return
     */
    public static boolean isUnknownByState(Context context){
        return NetworkInfo.State.UNKNOWN == getCurrentNetworkState(context);
    }

    /**
     * 是否是蓝牙
     * @param context
     * @return
     */
    public static boolean isBluetoothByType(Context context){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR2){
            return false;
        }else {
            return ConnectivityManager.TYPE_BLUETOOTH == getCurrentNetworkType(context)
        }
    }

    /**
     * 是否为虚拟网络
     * @param context
     * @return
     */
    public static boolean isDummyByState(Context context){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR2){
            return false;
        }else {
            return ConnectivityManager.TYPE_DUMMY == getCurrentNetworkType(context);
        }
    }

    /**
     * 以太网类型
     * @param context
     * @return
     */
    public static boolean isEthernetByType(Context context){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR2){
            return false;
        }else {
            return ConnectivityManager.TYPE_ETHERNET == getCurrentNetworkType(context);
        }
    }

    /**
     * 移动网络类型
     * @param context
     * @return
     */
    public static boolean isMobileByType(Context context){
        return ConnectivityManager.TYPE_MOBILE == getCurrentNetworkType(context);
    }

    /**
     * wifi类型
     * @param context
     * @return
     */
    public static boolean isWifiByType(Context context){
        return ConnectivityManager.TYPE_WIFI == getCurrentNetworkType(context);
    }

    /**
     * cdma
     * @param context
     * @return
     */
    public static boolean isCDMABySubtype(Context context){
        return TelephonyManager.NETWORK_TYPE_CDMA == getCurrentNetworkSubtype(context);
    }

    /**
     * gprs
     * @param context
     * @return
     */
    public static boolean isGPRSBySubtype(Context context){
        return TelephonyManager.NETWORK_TYPE_GPRS == getCurrentNetworkSubtype(context);
    }

    /**
     * lte
     * @param context
     * @return
     */
    public static boolean isLTEBySubtype(Context context){
        return TelephonyManager.NETWORK_TYPE_LTE == getCurrentNetworkSubtype(context);
    }

    /**
     * 未知网络类型
     * @param context
     * @return
     */
    public static boolean isUnknownBySubtype(Context context){
        return TelephonyManager.NETWORK_TYPE_UNKNOWN == getCurrentNetworkSubtype(context);
    }

    /**
     * 获取WiFi状态
     * @param context
     * @return
     * @throws Exception
     */
    public static int getWifiState(Context context) throws Exception {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager != null){
            return wifiManager.getWifiState();
        }else {
            throw new Exception("wifi device not found!");
        }
    }

    /**
     * wifi是否打开
     * @param context
     * @return
     * @throws Exception
     */
    public static boolean isWifiOpen(Context context) throws Exception {
        int wifiState = getWifiState(context);
        return WifiManager.WIFI_STATE_ENABLED == wifiState || WifiManager.WIFI_STATE_ENABLING == wifiState;
    }

    /**
     * 设置WiFi状态
     * @param context
     * @param enable
     * @return
     * @throws Exception
     */
    public static boolean setWifiEnabled(Context context, boolean enable) throws Exception {
        if (isWifiOpen(context) != enable){
            ((WifiManager)context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(enable);
        }
        return true;
    }

//    public static boolean isMobileNetworkOpen(Context context){
//        boolean result = false;
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//    }
}
