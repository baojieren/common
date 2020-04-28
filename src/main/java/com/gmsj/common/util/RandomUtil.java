package com.gmsj.common.util;

/**
 * 随机工具
 *
 * @author baojie
 */
public class RandomUtil {

    /**
     * 产生随机的n位数字字符串
     *
     * @param len 几位
     */
    public static String randomNumbers(int len) {
        String a = "0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int rand = (int) (Math.random() * a.length());
            sb.append(a.charAt(rand));
        }
        return sb.toString();
    }

    /**
     * 产生随机的n位数字加字母的字符串
     *
     * @param len 几位
     */
    public static String randomStr(int len) {
        String a = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int rand = (int) (Math.random() * a.length());
            sb.append(a.charAt(rand));
        }
        return sb.toString();
    }
}
