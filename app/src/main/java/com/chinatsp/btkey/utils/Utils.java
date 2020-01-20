package com.chinatsp.btkey.utils;

/**
 * Created by Administrator on 2020/1/16.
 */

public class Utils {
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }
}
