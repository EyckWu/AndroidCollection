package com.eyckwu.systemutil.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

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


}
