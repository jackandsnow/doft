package com.doft.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jack at 15:11 2018/3/9
 * version 1.0
 */
public class SerialGenerator {

    private static SimpleDateFormat sdf1 = new SimpleDateFormat("MMddHHmmss");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("MMddss");
    private static volatile int sequence = 0;
    private static long preTimestamp = 0;

    /**
     * 获取12位数字类型的订单号
     * yyyyMMdd+4序列
     */
    public static String getOrderNoSerial() {
        StringBuffer buf = new StringBuffer();
        return commonGenerator(buf, sdf1);
    }

    /**
     * 获取8位数字类型的订单号
     * MMdd+4序列
     */
    public static String getRequisitionNoSerial() {
        StringBuffer buf = new StringBuffer();
        return commonGenerator(buf, sdf2);
    }

    private static String commonGenerator(StringBuffer buf, SimpleDateFormat sdf) {
        synchronized (SerialGenerator.class) {
            if (sequence > 99) {
                sequence = 0;
                if (System.currentTimeMillis() == preTimestamp) {
                    try {
                        Thread.sleep(5L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                preTimestamp = System.currentTimeMillis();
            }
        }
        String format = sdf.format(new Date(System.currentTimeMillis()));
        return buf.append(format)
                .append(String.format("%02d", sequence++))
                .toString();
    }
}
