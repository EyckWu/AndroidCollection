package com.eyckwu.systemutil.lang.reflect;

import java.lang.reflect.Field;

/**
 * Create by eyckwu on 2019/1/6.
 * 反射工具类
 */
public class ReflectUtils {

    /**
     * 从指定类中获取指定字段
     * @param sourceClass
     * @param fieldName
     * @return
     */
    public static Field getField(Class<?> sourceClass, String fieldName){
        Field field = null;
        try {
            field = sourceClass.getField(fieldName);
        } catch (NoSuchFieldException e) {
            Class<?> superclass = sourceClass.getSuperclass();
            while (field == null && superclass != null){
                try {
                    field = sourceClass.getField(fieldName);
                } catch (NoSuchFieldException e1) {
                    superclass = superclass.getSuperclass();
                }
            }
        }finally {
            return field;
        }
    }
}
