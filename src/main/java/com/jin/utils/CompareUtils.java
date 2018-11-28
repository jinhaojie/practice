package com.jin.utils;

/**
 * @description 比较工具类
 * @author haojie.jin
 * @date 3:42 PM 2018/11/28
 * @since 1.2.0
 */
public class CompareUtils {

    /**
     * @description left是否大于right, big than
     * @param left,right 需要比较大小的参数
     * @return left > right, return true 否则 return false
     * @author haojie.jin
     * @date 3:59 PM 2018/11/28
     */
    public static <T extends Comparable<T>> boolean bt(T left, T right) {
        return left.compareTo(right) > 0;
    }

    /**
     * @description left是否大于right, big and equals than
     * @param left,right 需要比较大小的参数
     * @return left >= right, return true 否则 return false
     * @author haojie.jin
     * @date 3:59 PM 2018/11/28
     */
    public static <T extends Comparable<T>> boolean be(T left, T right) {
        return left.compareTo(right) >= 0;
    }

    /**
     * @description left是否小于right, less  than
     * @param left,right 需要比较大小的参数
     * @return left < right, return true 否则 return false
     * @author haojie.jin
     * @date 3:59 PM 2018/11/28
     */
    public static <T extends Comparable<T>> boolean lt(T left, T right) {
        return left.compareTo(right) < 0;
    }

    /**
     * @description left是否小于等于right, less and equals than
     * @param left,right 需要比较大小的参数
     * @return left <= right, return true 否则 return false
     * @author haojie.jin
     * @date 3:59 PM 2018/11/28
     */
    public static <T extends Comparable<T>> boolean le(T left, T right) {
        return left.compareTo(right) <= 0;
    }





    public static void main(String[] args) {
        Integer a = 2;
        Integer b = 2;
        Integer c = 1;

        System.out.println(CompareUtils.bt(a, c));
        System.out.println(CompareUtils.be(a, b));
        System.out.println(CompareUtils.lt(c, a));
        System.out.println(CompareUtils.le(a, b));

    }
}
