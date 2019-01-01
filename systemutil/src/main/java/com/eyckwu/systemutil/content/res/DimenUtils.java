package com.eyckwu.systemutil.content.res;

import android.content.Context;

/**
 * Create by eyckwu on 2019/1/1.
 * Android 尺寸相关工具类
 */
public class DimenUtils {
    /**
     * dp to px
     * @param context
     * @param dpValue
     * @return
     */
    public static int dp2px(Context context, float dpValue){
        return (int)(dpValue * (context.getResources().getDisplayMetrics().density) + 0.5);
    }

    /**
     * px to dp
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dp(Context context, float pxValue){
        return (int)(pxValue / (context.getResources().getDisplayMetrics().density) + 0.5);
    }
}
