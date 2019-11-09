package com.enjoy.util;

/**
 * @param :
 * @author :liqy
 * @version :1.0.0.1
 * @description :
 * @data :2019-11-06 21:20
 */
public class TimeUtil {

    public static void Sleep(long ms){
        try {
            Thread.sleep(ms);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
